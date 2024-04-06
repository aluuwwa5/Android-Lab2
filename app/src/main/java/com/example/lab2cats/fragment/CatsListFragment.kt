package com.example.lab2cats.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab2cats.Cat
import com.example.lab2cats.adapter.CatsListAdapter
import com.example.lab2cats.databinding.FragmentCatsListBinding
import com.example.lab2cats.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatsListFragment : Fragment() {

    companion object {
        fun newInstance() = CatsListFragment()
    }

    private var _binding: FragmentCatsListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: CatsListAdapter by lazy {
        CatsListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatsListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        ApiClient.instance.fetchCatsList().enqueue(object : Callback<List<Cat>> {
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                response.body()?.let {
                    adapter.submitList(it)
                }
            }
            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}