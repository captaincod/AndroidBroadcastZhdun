package com.example.zhdun

import android.content.BroadcastReceiver
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var timeReceiver: BroadcastReceiver
    lateinit var batteryReceiver: BatteryReceiver
    lateinit var cancelWait: Button
    lateinit var textView: TextView
    var minutesLeft: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeReceiver = TimeReceiver()
        registerReceiver(timeReceiver, IntentFilter("android.intent.action.TIME_TICK"))
        batteryReceiver = BatteryReceiver()
        registerReceiver(batteryReceiver, IntentFilter("android.intent.action.BATTERY_LOW"))

        textView = findViewById(R.id.print)
        cancelWait = findViewById(R.id.cancel_wait)

    }

    override fun onStart() {
        super.onStart()

        cancelWait.setOnClickListener{
            Toast.makeText(this, resources.getString(R.string.toast_text), Toast.LENGTH_LONG).show()
            unregisterReceiver(timeReceiver)
        }

    }

    fun timeUpdate() {
        minutesLeft += 1
        textView.text = getString(R.string.reflection_time, minutesLeft)
    }

    fun batteryUpdate() {
        textView.text = getString(R.string.battery_low)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeReceiver)
        unregisterReceiver(batteryReceiver)
    }

}