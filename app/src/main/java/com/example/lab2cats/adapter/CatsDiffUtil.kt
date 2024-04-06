package com.example.lab2cats.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lab2cats.Cat

class CatsDiffUtil : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }
}