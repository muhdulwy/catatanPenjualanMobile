package com.example.penjualan.activity.barang

//import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.penjualan.R
import com.example.penjualan.activity.barang.addBarang.AddBarangActivity
import com.example.penjualan.base.BaseActivity
import com.example.penjualan.model.Barang
import com.google.android.material.floatingactionbutton.FloatingActionButton

//class BarangActivity : AppCompatActivity() {
class  BarangActivity : BaseActivity(), DataBarangView {
    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)

        refreshBarang()

        findViewById<FloatingActionButton>(R.id.btAddDataBarang).setOnClickListener {
            val intent = Intent(this, AddBarangActivity::class.java)
            intent.putExtra(TAGS.USER, user)
            startActivity(intent)
        }
    }


    private fun refreshBarang() {
        DataBarangPresenter(this).getDataBarang(user)
    }


    override fun onSuccessDataBarang(data: List<Barang?>?) {
        findViewById<RecyclerView>(R.id.rvDataBarang).adapter = DataBarangAdapter(data, object : DataBarangAdapter.OnMenuClicked {
            override fun click (menuItem: MenuItem, barang: Barang?) {
                when(menuItem.itemId) {
                    R.id.editBarang -> editBarang(barang)
                    R.id.hapusBarang -> hapusBarang(barang)
                }
            }
        })
    }

    override fun onErrorDataBarang(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun editBarang(barang: Barang?) {
        val intent = Intent (this, AddBarangActivity::class.java)
        intent.putExtra(TAGS.USER, user)
        intent.putExtra(TAGS.BARANG, barang)
        startActivityForResult(intent, 1)

    }

    override fun onSuccessDeleteBarang(msg: String?){
        Toast.makeText(this,"Berhasil menghapus barang", Toast.LENGTH_SHORT).show()
        refreshBarang()
    }

    override fun onErrorDeleteBarang(msg: String?){
        Toast.makeText(this,"Berhasil menghapus barang", Toast.LENGTH_SHORT).show()
        refreshBarang()
    }

    private fun hapusBarang(barang: Barang?) {
        val  builder = AlertDialog.Builder(this)
        builder.setTitle("Anda Yakin Untuk Menghapus Data")
        builder.setMessage("Anda akan menghapus data ${barang?.namaBarang}! apakah anda yakin?")
        builder.setNegativeButton("No") {dialog, which -> Toast.makeText(applicationContext,"Batal", Toast.LENGTH_SHORT).show()
        }
        builder.setPositiveButton("Yes"){dialog, which -> DataBarangPresenter(this).deleteBarang(barang)
        }

        builder.show()
    }

    override fun onResume() {
        super.onResume()
        refreshBarang()
    }
}