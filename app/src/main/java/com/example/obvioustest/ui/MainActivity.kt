package com.example.obvioustest.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.obvioustest.R
import com.example.obvioustest.base.BaseActivity
import com.example.obvioustest.utils.Constants
import com.example.obvioustest.viewbinding.viewBinding

class MainActivity : BaseActivity() {

//    override val binding: ActivityMainBi by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref: SharedPreferences = getSharedPreferences(Constants.PREF_NAME, 0)
        if (sharedPref.getBoolean(Constants.PREF_NAME, false)) {

        } else {

        }
    }
}