package com.example.mokhttp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylibrary.ui.adapter.AbstractFloorViewHolder
import com.example.mylibrary.ui.adapter.BaseFloorAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_text.view.*

class ItemAdapter : BaseFloorAdapter<String, ItemAdapter.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_text, null, false)
        ).apply {
            initView(parent)
        }
    }

    class VH(override val containerView: View) : AbstractFloorViewHolder<String>(containerView),
        LayoutContainer {
        override fun initView(parent: ViewGroup) {

        }

        override fun bindData(item: String, position: Int) {
            containerView.tv.text = item
        }
    }
}
