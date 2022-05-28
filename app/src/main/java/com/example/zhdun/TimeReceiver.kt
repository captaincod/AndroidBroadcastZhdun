package com.example.zhdun

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class TimeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        (context as MainActivity).timeUpdate()
    }
}