package com.example.lab2cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab2cats.databinding.ActivityMainBinding
import com.example.lab2cats.fragment.CatsListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, CatsListFragment.newInstance())
            .commit()

    }
}