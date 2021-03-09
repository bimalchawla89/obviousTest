package com.example.obvioustest.extensions

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.example.obvioustest.AppClass
import com.example.obvioustest.R


@SuppressLint("ClickableViewAccessibility")
fun View.onTouch() {
    this.setOnTouchListener { v, event ->
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                this.foreground.setTint(
                    ContextCompat.getColor(
                        AppClass.appInstance.applicationContext,
                        R.color.system_gray_5
                    )
                )
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                this.foreground.setTint(
                    ContextCompat.getColor(
                        AppClass.appInstance.applicationContext,
                        android.R.color.transparent
                    )
                )
            }
        }
        v?.onTouchEvent(event) ?: true
    }
}