package com.example.wanandroid

import android.app.Application
import android.content.Context
import com.example.mylibrary.net.constants.BaseConfig

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        init(this)
        initConfigInfo()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        init(this)
        initConfigInfo()
    }

    private fun initConfigInfo() {
        BaseConfig.versionName = BuildConfig.VERSION_NAME
        BaseConfig.versionCode = BuildConfig.VERSION_CODE
        BaseConfig.applicationId = BuildConfig.APPLICATION_ID
//        BaseConfig.channel = BuildConfig.CHANNEL
//        BaseConfig.appId = BuildConfig.APP_ID
//        BaseConfig.appSecret = BuildConfig.APP_SECRET
//        BaseConfig.mPassAppKey = BuildConfig.MPASS_APP_KEY
//        BaseConfig.mPassAppSecret = BuildConfig.MPASS_APP_SECRET
//        BaseConfig.analyticsId = BuildConfig.ANALYTICS_ID
//        BaseConfig.privacyVersionCode = BuildConfig.PRIVACY_VERSION_CODE
//        BaseConfig.guideVersionCode = BuildConfig.GUIDE_VERSION_CODE
//        BaseConfig.buildVersion = BuildConfig.BUILD_VERSION
        BaseConfig.baseUrl=BuildConfig.BASE_URL
    }
}