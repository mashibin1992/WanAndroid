package com.example.mylibrary.ui.adapter

/**
 * 预测 item 宽高的优化类
 */
interface ItemWidthHeightProphet {

    /**
     * 返回预测的宽度
     */
    fun predictWidth(parentWidth: Int, parentHeight: Int): Int

    /**
     * 返回预测的高度
     */
    fun predictHeight(parentWidth: Int, parentHeight: Int): Int
}
