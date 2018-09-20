package com.booisajerk.typewritersamples

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_machines.view.*

class MachineListAdapter(private var context: Context) : RecyclerView.Adapter<MachineListAdapter.ViewHolder>() {

    override fun getItemCount() = MachineData.machineList().size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_machines, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val machine = MachineData.machineList()[position]
        holder.itemView.machineName.text = machine.name

        Picasso.with(context).load(machine.getImageResourceId(context)).into(holder.itemView.machineImage)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}