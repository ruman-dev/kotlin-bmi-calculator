package com.rumanweb.first_class

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class another_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        findViewById<Button>(R.id.visit_my_website).setOnClickListener {

            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://rumanweb.com")))

        }
        findViewById<Button>(R.id.call_me).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("tel:+8801994385596")))

        }

        findViewById<Button>(R.id.send_message).setOnClickListener {

            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("sms:+8801994385596")))


        }


    }
}