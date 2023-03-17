package com.example.penjualan.activity.barang

import com.example.penjualan.model.Barang
import com.google.gson.annotations.SerializedName

data class ResultDataBarang(

	@field:SerializedName("barang")
	val barang: List<Barang?>? = null
)