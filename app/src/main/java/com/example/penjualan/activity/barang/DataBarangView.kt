package com.example.penjualan.activity.barang

import com.example.penjualan.model.Barang
import com.example.penjualan.model.User

interface DataBarangView {
    fun onSuccessDataBarang(data: List<Barang?>?)
    fun onErrorDataBarang(msg:String?)

    fun onSuccessDeleteBarang(msg: String?)
    fun onErrorDeleteBarang(msg: String?)
}