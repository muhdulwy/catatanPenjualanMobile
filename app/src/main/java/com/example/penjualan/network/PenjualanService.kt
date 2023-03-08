package com.example.penjualan.network

import com.example.penjualan.activity.login.ResultLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PenjualanService {
    @FormUrlEncoded
    @POST("user/getUser.php")
    fun loginUser(@Field("username") username:String?,
                  @Field("password") password:String?)
            : Call<ResultLogin>

}