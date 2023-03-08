package com.example.penjualan.base

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import com.example.penjualan.model.User

@Suppress("DEPRECATION")
@SuppressLint("Registered")

open class BaseActivity {
    object TAGS{
        val BARANG = "barang"
        val USER = "user"
    }

    var user : User?=null

    fun cekSeksi(activity: Activity){
        val intent = activity.intent.getSerializableExtra("user")

        if (intent == null){

            Toast.makeText(activity,"Anda Belum Login", Toast.LENGTH_LONG).show()
            activity.finish()
        }else{
            user = intent as User
        }
    }
}