package com.example.drinksapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.drinksapp.databinding.GridViewItemBinding
import com.example.drinksapp.network.DrinkView

class DrinkGridAdapter(val onImageClick: (id:String) -> Unit): ListAdapter<DrinkView, DrinkGridAdapter.DrinkViewHolder>(DiffCallback) {
    companion object DiffCallback: DiffUtil.ItemCallback<DrinkView>() {
        override fun areItemsTheSame(oldItem: DrinkView, newItem: DrinkView): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DrinkView, newItem: DrinkView): Boolean {
            return oldItem == newItem;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        return DrinkViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = getItem(position)
        holder.image.load(drink.img.toUri().buildUpon().scheme("https").build())
        holder.name.text = drink.name
        holder.image.setOnClickListener {onImageClick(drink.id)}
    }

    class DrinkViewHolder(binding: GridViewItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        val image = binding.drinkImage
        val name = binding.drinkName
    }
}