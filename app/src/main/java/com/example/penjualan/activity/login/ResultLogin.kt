package com.example.penjualan.activity.login

import com.example.penjualan.model.User
import com.google.gson.annotations.SerializedName

data class ResultLogin(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: Int? = null
)