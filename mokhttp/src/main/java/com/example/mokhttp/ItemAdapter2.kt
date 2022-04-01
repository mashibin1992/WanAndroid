package com.example.mokhttp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylibrary.ui.adapter.AbstractFloorViewHolder
import com.example.mylibrary.ui.adapter.AbstractViewHolder
import com.example.mylibrary.ui.adapter.BaseFloorAdapter
import com.example.mylibrary.ui.adapter.ListAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_text.view.*

class ItemAdapter2 : ListAdapter<String, ItemAdapter2.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_text, null, false)
        )
    }

    class VH(override val containerView: View) : AbstractViewHolder<String>(containerView),
        LayoutContainer {

        override fun bindData(item: String, position: Int) {
            containerView.tv.text = item
        }
    }
}
