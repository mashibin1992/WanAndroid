//package com.example.mylibrary.ui.adapter
//
//import android.view.View
//import androidx.lifecycle.LifecycleOwner
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.Observer
//
//class ListAdapterMediator<ITEM, VH : AbstractViewHolder<ITEM>>(
//    private val refreshLayout: SmartRefreshLayout,
//    private val emptyLayout: View?,
//    private val lifecycleOwner: LifecycleOwner,
//    private val adapter: ListAdapter<ITEM, VH>,
//    private val refresh: () -> (LiveData<out ListInterface<ITEM>?>),
//    private val loadMore: (next: Int) -> (LiveData<out ListInterface<ITEM>?>),
//    private val finish: () -> (Unit)
//) {
//    init {
////        emptyLayout?.visibility = View.GONE
//        refreshLayout.setOnRefreshListener {
//            refresh()
//        }
//        refreshLayout.setOnLoadMoreListener {
//            loadMore.invoke(adapter.next).observe(lifecycleOwner, Observer { resp ->
//                resp?.let { data ->
//                    adapter.addList(data.getRespList())
////                    adapter.next = data.getNextIndex()
//                }
////                doUiSetup()
//                refreshLayout.finishLoadMore(true)
//                finish.invoke()
//            })
//        }
//    }
//
//    fun refresh() {
//        refresh.invoke().observe(lifecycleOwner, Observer { resp ->
//            resp?.let {
//                adapter.submitList(it.getRespList())
////                adapter.next = it.getNextIndex()
//            }
////            doUiSetup()
//            refreshLayout.finishRefresh()
//            finish.invoke()
//        })
//    }
//
//    private fun doUiSetup() {
////        refreshLayout.setEnableLoadMore(adapter.next > 0)
////        emptyLayout?.visibility = if (adapter.itemCount > 0) {
////            View.GONE
////        } else {
////            View.VISIBLE
////        }
//    }
//}