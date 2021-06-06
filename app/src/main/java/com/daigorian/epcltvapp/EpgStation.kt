package com.daigorian.epcltvapp

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

object EpgStation {
    interface ApiInterface {
        @GET("recorded")
        fun getRecorded(
            @Query("limit") limit: Int = default_limit,
            @Query("offset") offset: Int = 0,
            @Query("reverse") reverse: Boolean = false,
            @Query("rule") rule: Long? = null,
            @Query("genre1") genre1: Int? = null,
            @Query("channel") channel: Int? = null,
            @Query("keyword") keyword: String? = null,
            @Query("hasTs") hasTs: Boolean? = null,
            @Query("recording") recording: Boolean? = null
        ): Call<GetRecordedResponse>

        @GET("rules/list")
        fun getRulesList(): Call<Array<RuleList>>
    }

    private var ip:String = "192.168.0.0"
    private var port:Int = 8888
    private var default_limit:Int = 24

    private fun getBaseURL():String{
        return "http://$ip:$port/api/"
    }
    fun getThumbnailURL(id:String):String{
        return getBaseURL() + "recorded/" + id + "/thumbnail"
    }
    fun getTsVideoURL(id:String):String{
        return getBaseURL() + "recorded/" + id + "/file"
    }
    fun getEncodedVideoURL(id:String,encid:String):String{
        return getBaseURL() + "recorded/" + id +"/file?encodedId=" + encid
    }

    private var okHttpClient: OkHttpClient? = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .build()

    var api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(getBaseURL())
        .client(okHttpClient)
        .build().create(ApiInterface::class.java)

    fun initAPI(_ip:String,_port:Int,_default_limit:Int ){
        ip = _ip
        port = _port
        default_limit = _default_limit
        api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(getBaseURL())
            .client(okHttpClient)
            .build().create(ApiInterface::class.java)
    }
}