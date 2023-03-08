package com.example.penjualan.activity.login

import com.example.penjualan.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg:String?)
}