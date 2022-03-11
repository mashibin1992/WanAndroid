package com.example.wanandroid.ui

import android.view.KeyEvent
import com.example.mylibrary.base.BaseActivity
import com.example.mylibrary.extensions.toast
import com.example.wanandroid.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun setLayout() = R.layout.activity_main

    override fun initView() {

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