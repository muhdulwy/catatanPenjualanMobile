package com.example.penjualan.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.penjualan.R
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.penjualan.MainActivity
import com.example.penjualan.base.BaseActivity
import com.example.penjualan.model.User

class LoginActivity : AppCompatActivity(), LoginView {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Login")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById<EditText>(R.id.etLoginUsername)
        etPassword = findViewById<EditText>(R.id.etLoginPassword)
        btnLogin = findViewById<Button>(R.id.btnlogin)

        initActionButton()
    }

    private fun initActionButton() {
        btnLogin.setOnClickListener {
            val user = User()
            user.username = etUsername.text.toString().trim()
            user.password = etPassword.text.toString().trim()

            LoginPresenter(this@LoginActivity).login(user)
        }
    }

    override fun onSuccessLogin(user: User?) {
        Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
//
//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(BaseActivity.TAGS.USER, user)
        }
        finish()
        startActivity(intent)

    }
        override fun onErrorLogin(msg: String?) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }