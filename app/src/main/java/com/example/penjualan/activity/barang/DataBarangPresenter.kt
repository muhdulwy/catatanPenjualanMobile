package com.example.penjualan.activity.barang

import com.example.penjualan.model.Barang
import com.example.penjualan.model.ResultSimple
import com.example.penjualan.model.User
import com.example.penjualan.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DataBarangPresenter(val dataBarangView: DataBarangView) {
    fun getDataBarang(user: User?) {
        NetworkConfig.service()
            .getDataBarang(user?.id_user).enqueue(object : Callback<ResultDataBarang> {
                override fun onResponse(
                    call: Call<ResultDataBarang>,
                    response: Response<ResultDataBarang>
                ) {
                    val body = response.body()
                    dataBarangView.onSuccessDataBarang(body?.barang)
                }

                override fun onFailure(call: Call<ResultDataBarang>, t: Throwable) {
                    dataBarangView.onErrorDataBarang(t.localizedMessage)
                }

            }
            )
    }

    fun deleteBarang(barangItem: Barang?) {
        NetworkConfig.service()
            .deleteBarang(barangItem?.idBarang)
            .enqueue(object : Callback<ResultSimple> {
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    dataBarangView.onErrorDataBarang(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    if (body?.status == "200") {
                        dataBarangView.onSuccessDeleteBarang(body.pesan)
                    } else {
                        dataBarangView.onErrorDeleteBarang(body?.pesan)
                    }
                }
            })
    }
}