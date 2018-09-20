package com.booisajerk.typewritersamples

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_machines.view.*

class MachineListAdapter(private var context: Context) : RecyclerView.Adapter<MachineListAdapter.ViewHolder>() {

    lateinit var itemClickListener: OnItemClickListener

    override fun getItemCount() = MachineData.machineList().size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_machines, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val machine = MachineData.machineList()[position]
        holder.itemView.machineName.text = machine.name

        Picasso.with(context).load(machine.getImageResourceId(context)).into(holder.itemView.machineImage)

        val photo = BitmapFactory.decodeResource(context.resources, machine.getImageResourceId(context))
        Palette.from(photo).generate { palette ->
            val bgColor = palette?.getDarkMutedColor(ContextCompat.getColor(context, android.R.color.black))
            bgColor?.let { holder.itemView.machineNameHolder.setBackgroundColor(it) }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.machineHolder.setOnClickListener(this)
        }

        override fun onClick(view: View) = itemClickListener.onItemClick(itemView, adapterPosition)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}