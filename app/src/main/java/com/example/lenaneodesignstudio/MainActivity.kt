package com.example.lenaneodesignstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_main)

            // Find your buttons by their IDs
            val btnClient = findViewById<Button>(R.id.btnClient)
            val btnAdmin = findViewById<Button>(R.id.btnAdmin)

            // Set click listeners for the buttons
            btnClient.setOnClickListener {
                // Handle the click for the Client button
                val intent = Intent(this, ClientLogin::class.java)
                startActivity(intent)
            }

            btnAdmin.setOnClickListener {
                // Handle the click for the Admin button
                val intent = Intent(this, AdminLogin::class.java)
                startActivity(intent)
            }
        }

    }
}






