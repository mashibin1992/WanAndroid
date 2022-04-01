package com.example.mokhttp.weidget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChildRecyclerView2 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : RecyclerView(context, attrs, defStyleAttr) {

    //记录上次手指位置
    private var mLastY = 0f

    //是否已经滑到了底部
    private var isToBottom = false

    //是否已经滑到了顶部
    private var isToTop = true

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //记录按下位置
                mLastY = event.y
                //如果手指按下触摸区域在自身，先不允许父View拦截事件
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                checkPosition(event.y)
                if (isToBottom || isToTop) {
                    //已经滑动到顶部或者底部时，不需要自己处理手势，无需下发
                    parent.requestDisallowInterceptTouchEvent(false)
                    return false
                } else {
                    parent.requestDisallowInterceptTouchEvent(true)
                }
                mLastY = event.y
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> parent.requestDisallowInterceptTouchEvent(
                false
            )
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {

        return super.onTouchEvent(e)
    }


    /**
     * 判断item的位置情况，确认是否需要滑动
     */
    private fun checkPosition(nowY: Float) {
        //暂时仅处理LinearLayoutManager情况
        val manager = layoutManager as LinearLayoutManager

        isToTop = false
        isToBottom = false
        //获取可见的item位置
        val firstVisiblePosition = manager.findFirstCompletelyVisibleItemPosition()
        val lastVisiblePosition = manager.findLastCompletelyVisibleItemPosition()

        //如果当前有item显示
        if (layoutManager!!.childCount > 0) {
            if (lastVisiblePosition == manager.itemCount - 1) {
                //检查是否能向上滑，且滑动方向是向上
                if (canScrollVertically(-1) && nowY < mLastY) {
                    //标记已经滑动到了底部，不能再向上滑动了
                    isToBottom = true
                }
            } else if (firstVisiblePosition == 0) {
                //检查是否能向下滑，且滑动方向是向下
                if (canScrollVertically(1) && nowY > mLastY) {
                    //标记已经滑动到了顶部，不能再向下滑动了
                    isToTop = true
                }
            }
        }
    }
}