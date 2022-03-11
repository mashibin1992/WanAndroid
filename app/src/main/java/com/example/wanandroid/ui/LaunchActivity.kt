package com.example.wanandroid.ui

import com.example.mylibrary.base.BaseActivity
import com.example.mylibrary.extensions.go
import com.example.wanandroid.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LaunchActivity : BaseActivity() {

    override fun setLayout(): Int = R.layout.activity_launch

    override fun initView() {
        GlobalScope.launch {
            delay(5000)
            go<MainActivity>()
            finish()
        }
    }

    override fun initData() {
    }

}