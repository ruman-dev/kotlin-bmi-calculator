package com.rumanweb.first_class

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.newSingleThreadContext

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.hire).setOnClickListener {

            Toast.makeText(this, "I am hired for your project, 20$ has been deducted from your account.",Toast.LENGTH_LONG).show()


        }
        findViewById<Button>(R.id.contact_me).setOnClickListener {
            startActivity(Intent(this, another_activity:: class.java))

        }

    }
}