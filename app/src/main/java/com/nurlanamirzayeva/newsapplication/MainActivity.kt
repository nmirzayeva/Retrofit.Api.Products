package com.nurlanamirzayeva.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nurlanamirzayeva.newsapplication.api.models.DTO
import com.nurlanamirzayeva.newsapplication.api.models.Results
import com.nurlanamirzayeva.newsapplication.network.MyAdapter
import com.nurlanamirzayeva.newsapplication.network.RetrofitClient
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerview).layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, true)

        getInfo()
    }

    private fun getInfo() {
        val call: retrofit2.Call<Results?>? = RetrofitClient.RetrofitInstance?.getMyApi()?.getInfo()
        call?.enqueue(object : Callback<Results?> {
            override fun onResponse(call: retrofit2.Call<Results?>?, response: Response<Results?>?) {
                val list: Results = response?.body() as Results
                findViewById<RecyclerView>(R.id.recyclerview).adapter = MyAdapter(this@MainActivity,list.products)

            }

            override fun onFailure(call: retrofit2.Call<Results?>?, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occurred", Toast.LENGTH_LONG).show()
            }
        })
    }
}