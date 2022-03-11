package com.example.mylibrary.net

import com.example.mylibrary.net.bean.ArticleListBean
import com.example.mylibrary.net.responce.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Apis {
    // 和协程联用
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): BaseResponse<ArticleListBean>
}