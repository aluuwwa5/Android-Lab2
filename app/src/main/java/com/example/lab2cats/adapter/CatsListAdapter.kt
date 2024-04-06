package com.example.lab2cats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2cats.Cat
import com.example.lab2cats.databinding.ItemCatBinding
import com.squareup.picasso.Picasso

class CatsListAdapter : ListAdapter<Cat, CatsListAdapter.ViewHolder>(CatsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCatBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(cat: Cat) {
            with(binding) {
                name.text = cat.name
                origin.text = cat.origin
                Picasso.get().load(cat.imageUrl).into(binding.catImage)
                familyFriendlyRate.text = cat.familyFriendlyRate.toString()
                healthRate.text=cat.healthRate.toString()
                length.text = cat.length
                intelligenceRate.text=cat.intelligenceRate.toString()
                playfulnessRate.text=cat.playfulnessRate.toString()
            }
        }



    }
}