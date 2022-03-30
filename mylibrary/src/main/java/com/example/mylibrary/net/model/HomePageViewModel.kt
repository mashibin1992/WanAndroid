package com.example.mylibrary.net.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibrary.net.RetrofitManger
import com.example.mylibrary.net.bean.DataX
import com.example.mylibrary.util.LogUtil
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty

class HomePageViewModel : ViewModel() {
    private val TAG: String = this.javaClass.simpleName
    private val api by lazy { RetrofitManger.getApiService() }

    private var _homePageInfo: MutableLiveData<List<DataX>> = MutableLiveData()
    var apiError: MutableLiveData<Throwable> = MutableLiveData()

    fun getArticles(page: Int): LiveData<List<DataX>> {
        val homePageInfo: MutableLiveData<List<DataX>> = MutableLiveData()
        val exception = CoroutineExceptionHandler { _, throwable ->
            apiError.postValue(throwable)
            Log.i(TAG, throwable.message!!)
        }
        viewModelScope.launch(exception) {
            val response = api.getArticleList(page)
            if (response.errorCode == 0) {
                homePageInfo.postValue(response.data?.datas)
            } else {
                homePageInfo.postValue(mutableListOf())
            }
        }
        return homePageInfo
    }
}