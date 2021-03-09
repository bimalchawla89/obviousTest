package com.example.obvioustest.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.obvioustest.databinding.ImageItemBinding
import com.example.obvioustest.extensions.onTouch
import com.example.obvioustest.listener.ImageClickListener
import com.example.obvioustest.models.ImageData
import com.example.obvioustest.viewbinding.BindingViewHolder
import com.example.obvioustest.viewbinding.createBindingViewHolder

typealias ImageViewHolder = BindingViewHolder<ImageItemBinding>

class ImageAdapter(private val imageClickListener: ImageClickListener) :
    ListAdapter<ImageData, ImageViewHolder>(ImageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return createBindingViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.binding.image = getItem(position)
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener {
            imageClickListener.imageClicked(position)
        }
    }
}

class ImageDiffCallback : DiffUtil.ItemCallback<ImageData>() {
    override fun areItemsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
        return oldItem == newItem
    }
}