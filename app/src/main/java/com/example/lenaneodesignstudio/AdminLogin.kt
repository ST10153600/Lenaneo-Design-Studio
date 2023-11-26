package com.example.lenaneodesignstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class AdminLogin : AppCompatActivity() {

    lateinit var etUser: EditText
    private lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var ivBack: ImageView

    //Creation of the Firebase object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminlogin)

        //The following information was taken from Geeks for Geeks
        //Author: ayushpandey3july
        //Link: https://www.geeksforgeeks.org/login-and-registration-in-android-using-firebase-in-kotlin/


        //View Binding values
        etUser = findViewById(R.id.etUser)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        ivBack = findViewById(R.id.ivBack)

        //Initialising Firebase authentication object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
        }

        ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun login() {
        val username = etUser.text.toString()
        val password = etPassword.text.toString()

        // calling signInWithEmailAndPassword(email, pass)
        // method utilising the Firebase authentication object
        // On successful response Showcase a Toast
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Login has failed", Toast.LENGTH_SHORT).show()
                }
            }

    }

}
