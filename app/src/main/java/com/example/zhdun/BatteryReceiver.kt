package com.example.zhdun

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BatteryReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        (context as MainActivity).batteryUpdate()
    }
}