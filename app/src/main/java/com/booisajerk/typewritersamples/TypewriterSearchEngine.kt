package com.booisajerk.typewritersamples

import android.util.Log

class TypewriterSearchEngine(private val typewriters: Array<String>) {
    private val TAG = "Parker" + TypewriterSearchEngine::class.qualifiedName

    fun search(query: String): List<String> {
        Thread.sleep(2000)
        Log.d(TAG, "search called" )
        return typewriters.filter { it.toLowerCase().contains(query.toLowerCase()) }
    }
}
