package com.booisajerk.typewritersamples

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import java.util.concurrent.TimeUnit


class SearchActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val TAG = "Parker" + SearchActivity::class.qualifiedName

    protected lateinit var typewriterSearchEngine: TypewriterSearchEngine
    private val typewriterAdapter = TypewriterAdapter()
    private lateinit var disposable: Disposable


    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        Log.d(TAG, "onCreate called")

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = typewriterAdapter
        typewriterSearchEngine = TypewriterSearchEngine(resources.getStringArray(R.array.typewriters))

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "onNavigationItemSelected called")

        val typewriterDetailActivityIntent = Intent(this, TypewriterDetailActivity::class.java)
        typewriterDetailActivityIntent.putExtra(Constants.NAVIGATION_ID, item.itemId)
        startActivity(typewriterDetailActivityIntent)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    @Override
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")

        val buttonClickStream = createButtonClickObservable()
        val textChangeStream = createTextChangeObservable()

        val searchTextObservable = Observable.merge<String>(buttonClickStream, textChangeStream)
        disposable = searchTextObservable
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    showProgress()
                }
                .observeOn(Schedulers.io())
                .map { typewriterSearchEngine.search(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    hideProgress()
                    showResult(it)
                    Log.d(TAG, "Result: $it")
                }
    }

    @Override
    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop called")

        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    private fun createButtonClickObservable(): Observable<String> {
        Log.d(TAG, "createButtonClickObservable called ")

        return Observable.create { emitter ->
            searchButton.setOnClickListener {
                emitter.onNext(queryEditText.text.toString())
                Log.d(TAG, "Emitter text: " + queryEditText.text.toString())
            }

            emitter.setCancellable {
                searchButton.setOnClickListener(null)
            }
        }
    }

    private fun createTextChangeObservable(): Observable<String> {
        Log.d(TAG, "createTextChangeObservable called ")

        val textChangeObservable = Observable.create<String> { emitter ->
            val textWatcher = object : TextWatcher {

                override fun afterTextChanged(s: Editable?) = Unit

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

                override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    s?.toString()?.let { emitter.onNext(it) }
                }

            }

            queryEditText.addTextChangedListener(textWatcher)
            emitter.setCancellable {
                queryEditText.removeTextChangedListener(textWatcher)
            }
        }

        return textChangeObservable
                .filter { it.length >= 2 }
                .debounce(1000, TimeUnit.MILLISECONDS)
    }

    protected fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    protected fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    protected fun showResult(result: List<String>) {
        if (result.isEmpty()) {
            Toast.makeText(this, R.string.nothing_found, Toast.LENGTH_SHORT).show()
        }
        typewriterAdapter.typewriters = result
    }
}

