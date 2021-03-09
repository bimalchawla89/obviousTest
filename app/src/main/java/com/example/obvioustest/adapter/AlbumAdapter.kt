package com.example.obvioustest.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.obvioustest.models.ImageData
import com.example.obvioustest.viewbinding.BindingViewHolder
import com.example.obvioustest.viewbinding.createBindingViewHolder

// Instead of creating all the ViewHolder classes and increasing our code size, we are now going
// to use generics. typealias allows this to be very clean
typealias ImageViewHolder = BindingViewHolder<ImageItemBinding>

class AlbumAdapter(private val albumCLickListener: AlbumCLickListener) :
    ListAdapter<ImageData, ImageViewHolder>(ImageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return createBindingViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val album = getItem(position)
//        holder.binding.tvTitle.text = album.name
//        holder.binding.tvDescription.text = album.artist.name
//        holder.binding.ivIcon.load(album.image[2].text)
//        holder.itemView.setOnClickListener {
//            albumCLickListener.albumClicked(album.name, album.artist.name)
//        }
    }
}

class ImageDiffCallback : DiffUtil.ItemCallback<ImageData>() {
    override fun areItemsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
        return oldItem == newItem
    }
}