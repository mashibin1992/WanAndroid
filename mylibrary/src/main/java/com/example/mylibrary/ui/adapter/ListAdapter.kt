package com.example.mylibrary.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class ListAdapter<ITEM, VH : AbstractViewHolder<ITEM>>
    : RecyclerView.Adapter<VH>() {

    private val data: MutableList<ITEM> = ArrayList()

    var next = 0

    open fun submitList(list: List<ITEM>) {
        val beforeCount = this.data.count()
        this.data.clear()
        notifyItemRangeRemoved(0, beforeCount)
        this.data.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }

    open fun addList(list: List<ITEM>) {
        val position = this.data.size
        this.data.addAll(list)
        notifyItemRangeInserted(position, list.size)
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindData(data[position], position)
    }

    fun getAllData() = data
}

abstract class AbstractViewHolder<ITEM>(private val v: View) : RecyclerView.ViewHolder(v) {

    abstract fun bindData(item: ITEM, position: Int)
}
