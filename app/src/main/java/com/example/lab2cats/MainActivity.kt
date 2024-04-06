package com.example.lab2cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.lab2cats.adapter.CatsListAdapter
import com.example.lab2cats.databinding.ActivityMainBinding
import com.example.lab2cats.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: CatsListAdapter by lazy {
        CatsListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.catList.adapter = adapter

        binding.searchView.clearFocus()
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                binding.searchView.clearFocus()
                fetchCats(query)
                return false
            }
        })


    }

    private fun fetchCats(name: String) {
        val client = ApiClient.instance
        val response = client.fetchCatsList(name)

        response.enqueue(object : Callback<List<Cat>> {
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                println("HttpResponse: ${response.body()}")
                val cats = response.body() ?: emptyList()
                adapter.submitList(cats)
            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                println("HttpResponse: ${t.message}")
                adapter.submitList(emptyList())
            }
        })
    }

}