//package com.example.penjualan
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}

package com.example.penjualan

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.penjualan.activity.barang.BarangActivity
import com.example.penjualan.activity.login.LoginActivity
import com.example.penjualan.activity.penjualan.PenjualanActivity
import com.example.penjualan.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActionButton()
        findViewById<TextView>(R.id.tvWelcome).text = "Welcome ${user?.username}"
    }

    fun initActionButton()
    {
        findViewById<RecyclerView>(R.id.mainMenu).adapter =
            MenuAdapter(object : MenuAdapter.OnMenuClick{
                override fun onClick(image: Int) {
                    when(image){
                        R.drawable.ic_goods -> openDataBarang()
                        R.drawable.ic_shopping_cart -> openDataPenjualan()
                    }
                }
            })
    }

    private fun openDataBarang()
    {
        val intent = Intent(this,BarangActivity::class.java)
        intent.putExtra(TAGS.USER, user)
        startActivity(intent)
    }

    private fun openDataPenjualan()
    {
        val intent = Intent(this,PenjualanActivity::class.java)
        intent.putExtra(TAGS.USER, user)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        return super.onOptionsItemSelected(item)
    }
}
