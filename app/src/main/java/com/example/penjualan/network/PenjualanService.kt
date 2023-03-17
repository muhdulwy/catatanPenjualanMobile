package com.example.penjualan.network

import com.example.penjualan.activity.barang.ResultDataBarang
import com.example.penjualan.activity.login.ResultLogin
import com.example.penjualan.model.ResultSimple
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

    @FormUrlEncoded
    @POST("barang/getBarang.php")
    fun getDataBarang(@Field("id_user") id_user: Int?)
            :Call<ResultDataBarang>

    @FormUrlEncoded
    @POST("barang/addBarang.php")
    fun addBarang(@Field("id_user") id_user: Int?,
                  @Field("barcode") barcode: String?,
                  @Field("nama_barang") nama_barang: String?,
                  @Field("kategori") kategori: String?,
                  @Field("harga_beli") harga_beli: Double?,
                  @Field("harga_jual") harga_jual: Double?,
    ):Call<ResultSimple>


    @FormUrlEncoded
    @POST("barang/editBarang.php")
    fun updateBarang(@Field("id_user") id_user: Int?,
                   @Field("id_barang") id_barang: Int?,
                  @Field("barcode") barcode: String?,
                  @Field("nama_barang") nama_barang: String?,
                  @Field("kategori") kategori: String?,
                  @Field("harga_beli") harga_beli: Double?,
                  @Field("harga_jual") harga_jual: Double?
    ):Call<ResultSimple>

    @FormUrlEncoded
    @POST("barang/deleteBarang.php")
    fun deleteBarang(
//                  @Field("id_user") id_user: Int?,
                     @Field("id_barang") id_barang: Int?,
//                     @Field("nama_barang") nama_barang: String?,
    ):Call<ResultSimple>


}