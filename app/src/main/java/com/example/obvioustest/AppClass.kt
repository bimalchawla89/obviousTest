package com.example.obvioustest

import android.app.Application
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppClass:Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        const val TAG = "Obvious"
        lateinit var appInstance: AppClass
            private set
    }
}