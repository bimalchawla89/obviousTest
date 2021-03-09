package com.example.obvioustest.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.obvioustest.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation


@BindingAdapter("image")
fun ImageView.setImage(
    url: String?
) {
    url?.let {
        Picasso.get().load(it)
            .placeholder(R.drawable.progress_animation)
            .resize(250, 250).transform(RoundedCornersTransformation(12, 12)).into(this)
    }
}