package com.example.obvioustest.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.obvioustest.R
import com.example.obvioustest.databinding.FragmentDetailBinding
import com.example.obvioustest.utils.Constants
import com.example.obvioustest.viewbinding.viewBinding
import com.example.obvioustest.viewmodel.ImageViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val _binding: FragmentDetailBinding by viewBinding()
    private val _imageViewModel: ImageViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt(Constants.POSITION) ?: 0
        _imageViewModel.imageListData.observe(viewLifecycleOwner, {
            _binding.date.text = it[position].date
            _binding.title.text = it[position].title
            Picasso.get().load(it[position].hdurl)
                .placeholder(R.drawable.progress_animation)
                .transform(RoundedCornersTransformation(25, 25))
                .into(_binding.image)
        })
    }
}