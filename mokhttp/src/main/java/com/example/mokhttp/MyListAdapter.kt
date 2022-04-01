package com.example.mokhttp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylibrary.ui.adapter.AbstractFloorViewHolder
import com.example.mylibrary.ui.adapter.BaseFloorAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.view.*

class MyListAdapter : BaseFloorAdapter<List<String>, MyListAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_list, null, false))
            .apply {
                initView(parent)
            }
    }

    class VH(override val containerView: View) :
        AbstractFloorViewHolder<List<String>>(containerView),
        LayoutContainer {
        override fun initView(parent: ViewGroup) {
        }

        override fun bindData(item: List<String>, position: Int) {
            val linearLayoutManager = LinearLayoutManager(containerView.context)
            val itemAdapter = ItemAdapter2()
            itemAdapter.submitList(item)
            containerView.list.layoutManager = linearLayoutManager
            containerView.list.adapter = itemAdapter

        }

    }

}
