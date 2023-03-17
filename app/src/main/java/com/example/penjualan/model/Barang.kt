package com.example.penjualan.model

import com.google.gson.annotations.SerializedName

data class Barang(

	@field:SerializedName("id_barang")
	var idBarang: Int? = null,

	@field:SerializedName("harga_beli")
	var hargaBeli: Double? = null,

	@field:SerializedName("nama_barang")
	var namaBarang: String? = null,

	@field:SerializedName("kategori")
	var kategori: String? = null,

	@field:SerializedName("id_user")
	var idUser: Int? = null,

	@field:SerializedName("harga_jual")
	var hargaJual: Double? = null,

	@field:SerializedName("barcode")
	var barcode: String? = null
):java.io.Serializable