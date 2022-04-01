package com.example.mylibrary.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

abstract class BaseFloorAdapter<ITEM, VH : AbstractFloorViewHolder<ITEM>>
    : RecyclerView.Adapter<VH>() {

    private var data: ITEM? = null

    open fun setData(data: ITEM?) {
        this.data = data
        notifyItemChanged(0)
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        data?.let {
            holder.bindData(it, position)
        }
        if (holder.fullSpan()) {
            (holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams).isFullSpan =
                holder.fullSpan()
        }
    }

    override fun getItemCount(): Int {
        return 1
    }
}

abstract class AbstractFloorViewHolder<ITEM>(private val v: View) : RecyclerView.ViewHolder(v) {

    abstract fun initView(parent: ViewGroup)

    abstract fun bindData(item: ITEM, position: Int)

    open fun fullSpan(): Boolean {
        return false
    }
}