package com.example.penjualan.activity.barang.addBarang

import android.util.Log
import android.widget.Toast
import com.example.penjualan.model.Barang
import com.example.penjualan.model.ResultSimple
import com.example.penjualan.network.NetworkConfig

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddBarangPresenter(val addBarangView: AddBarangView) {
    fun addBarang(dataBarang: Barang) {
        NetworkConfig.service()
            .addBarang(
                Integer.parseInt(dataBarang.idUser.toString()),
                dataBarang.barcode,
                dataBarang.namaBarang,
                dataBarang.kategori,
                dataBarang.hargaBeli,
                dataBarang.hargaJual
            )
            .enqueue(object : Callback<ResultSimple> {
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    addBarangView.onErrorAddBarang(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    if (body?.status == "200") {

                        addBarangView.onSuccessAddBarang(body?.pesan)
                    } else {
                        addBarangView.onErrorAddBarang(body?.pesan)
                    }
                }
            })
    }

    fun updateBarang(dataBarang: Barang) {
        NetworkConfig.service()
            .updateBarang(
                dataBarang.idUser?.toInt(),
                dataBarang.idBarang,
                dataBarang.barcode,
                dataBarang.namaBarang,
                dataBarang.kategori,
                dataBarang.hargaBeli,
                dataBarang.hargaJual
            )
            .enqueue(object : Callback<ResultSimple> {
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    addBarangView.onErrorAddBarang(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    if (body?.status == "200") {
                        addBarangView.onSuccessAddBarang(body?.pesan)
                    } else {
                        addBarangView.onErrorAddBarang(body?.pesan)
                    }
                }
            })
    }
}
