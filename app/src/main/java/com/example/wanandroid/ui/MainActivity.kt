package com.example.wanandroid.ui

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import com.example.mylibrary.base.BaseActivity
import com.example.mylibrary.extensions.toast
import com.example.wanandroid.QaData
import com.example.wanandroid.R


class MainActivity : BaseActivity() {


    // 创建一个Handler


    override fun setLayout() = R.layout.activity_main

    override fun initView() {

//        val mutableListOf = mutableListOf<String>()
//        val mutableListOf1 = mutableListOf<String>()
//        for (i in 0..5) {
//            mutableListOf.add("测试$i")
//            mutableListOf1.add("测试数据$i")
//        }
//        val qaData = QaData(mutableListOf, mutableListOf1)
//
//        mHandler.sendEmptyMessage(1)
//        val obtainMessage = mHandler.obtainMessage()
//        obtainMessage.obj = qaData
//        mHandler.sendMessage(obtainMessage)


    }

    override fun initData() {
    }


    /**
     * 第一次点击时间
     */
    private var mExitTime = 0L

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event?.action == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                getString(R.string.exit_twice).toast(this)
                mExitTime = System.currentTimeMillis()
            } else {
                finish()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}