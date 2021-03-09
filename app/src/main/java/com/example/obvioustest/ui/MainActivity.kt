package com.example.obvioustest.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.obvioustest.R
import com.example.obvioustest.adapter.ImageAdapter
import com.example.obvioustest.base.BaseActivity
import com.example.obvioustest.databinding.ActivityMainBinding
import com.example.obvioustest.listener.ImageClickListener
import com.example.obvioustest.utils.CommonFunctions
import com.example.obvioustest.utils.Constants
import com.example.obvioustest.viewbinding.viewBinding
import com.example.obvioustest.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.hypot

@AndroidEntryPoint
class MainActivity : BaseActivity(), ImageClickListener {

    override val binding: ActivityMainBinding by viewBinding()
    private val _imageViewModel: ImageViewModel by viewModels()
    private val _imageAdapter by lazy { ImageAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rvImage.adapter = _imageAdapter
        binding.imageViewPager.adapter = ImageDetailAdapter(this)

        _imageViewModel.imageListData.observe(this, {
            if (it.isEmpty()) {
                _imageViewModel.insertData()
            } else {
                _imageAdapter.submitList(ArrayList(it))
            }
        })
    }

    override fun imageClicked(position: Int) {
        binding.imageViewPager.currentItem = position
        showDetail()
    }

    private inner class ImageDetailAdapter(frag: FragmentActivity) : FragmentStateAdapter(frag) {
        override fun getItemCount(): Int = _imageAdapter.itemCount

        override fun createFragment(position: Int): Fragment {
            val fragInfo = DetailFragment()
            fragInfo.arguments = Bundle().apply {
                putInt(Constants.POSITION, position)
            }
            return fragInfo
        }
    }

    override fun onBackPressed() {
        if (binding.imageViewPager.visibility == View.VISIBLE) {
            hideDetail()
        } else {
            super.onBackPressed()
        }
    }

    private fun showDetail() {
        // get the center for the clipping circle
        val cx = CommonFunctions.getScreenWidth(this) / 2
        val cy = CommonFunctions.getScreenHeight(this) / 2

        // get the final radius for the clipping circle
        val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()

        // create the animator for this view (the start radius is zero)
        val anim = ViewAnimationUtils.createCircularReveal(binding.imageViewPager, cx, cy, 0f, finalRadius)
        // make the view visible and start the animation
        binding.imageViewPager.visibility = View.VISIBLE
        anim.duration = 200L
        anim.start()
    }

    private fun hideDetail() {
        // get the center for the clipping circle
        val cx = binding.imageViewPager.width / 2
        val cy = binding.imageViewPager.height / 2

        // get the initial radius for the clipping circle
        val initialRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()

        // create the animation (the final radius is zero)
        val anim = ViewAnimationUtils.createCircularReveal(binding.imageViewPager, cx, cy, initialRadius, 0f)

        // make the view invisible when the animation is done
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                binding.imageViewPager.visibility = View.GONE
            }
        })
        anim.duration = 200L
        // start the animation
        anim.start()
    }

}