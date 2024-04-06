package com.example.lab2cats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.lab2cats.Cat
import com.example.lab2cats.R
import com.example.lab2cats.databinding.ItemCatBinding


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
                Glide.with(root.context)
                    .load(cat.imageUrl)
                    .into(catImage)
                name.text = cat.name
                origin.text = "Origin: ${cat.origin}"
                familyFriendlyRate.text = "Family-friendly: 5/${cat.familyFriendlyRate}"
                healthRate.text = "Health: 5/${cat.healthRate}"
                length.text = "Length: ${cat.length}"
                intelligenceRate.text = "Intelligence: 5/${cat.intelligenceRate}"
                playfulnessRate.text = "Playfulness: 5/${cat.playfulnessRate}"


            }
        }
    }


    }