package com.example.penjualan.activity.login

//class LoginPresenter {
//}

import android.net.Network
import com.example.penjualan.model.User
import com.example.penjualan.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView: LoginView) {
    fun login(user: User){
        NetworkConfig.service()
            .loginUser(user.username, user.password)
            .enqueue(object : Callback<ResultLogin>{
                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    val body = response.body()

                    if (body?.status == 200){
                        loginView.onSuccessLogin(body.user)
                    }else{
                        loginView.onErrorLogin(body?.message)
                    }
                }

                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorLogin(t.localizedMessage)
                }

            })
    }
}