package com.example.lenaneodesignstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ClientRegistration : AppCompatActivity() {

    //The following information was taken from Geeks for Geeks
    //Author: ayushpandey3july
    //Link: https://www.geeksforgeeks.org/login-and-registration-in-android-using-firebase-in-kotlin/

    lateinit var etFullName: EditText
    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var etRePass: EditText
    private lateinit var btnSignUp: Button
    lateinit var tvReLogin: TextView
    lateinit var ivBack: ImageView

    // Creation of Firebase authentication object
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_registration)

        //These are the view bindings to be used for the code
        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        etPass = findViewById(R.id.etPass)
        etRePass = findViewById(R.id.etRePass)
        btnSignUp = findViewById(R.id.btnSignUp)
        tvReLogin = findViewById(R.id.tvReLogin)
        ivBack = findViewById(R.id.ivBack)

        //Initialising the authentication object
        auth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            signUpUser()
        }

        // switching from signUp Activity to Login Activity
        tvReLogin.setOnClickListener {
            val intent = Intent(this, ClientLogin::class.java)
            startActivity(intent)
        }

        ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun signUpUser() {
        val fullName = etFullName.text.toString()
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        val rePass = etRePass.text.toString()

        //Check all the EditText is they are not blank
        if(fullName.isBlank() || email.isBlank() || pass.isBlank() || rePass.isBlank())
        {
            Toast.makeText(this, "Please fill in all the information to continue", Toast.LENGTH_SHORT)
                .show()
            return
        }
        if(pass != rePass){
            Toast.makeText(this, "The passwords do not match please match the passwords", Toast.LENGTH_SHORT)
                .show()
            return
        }
        // If all credentials are valid
        // We use the function createUserWithEmailAndPassword.
        // Using the auth object, pass in the email address.
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if(it.isSuccessful) {
                Toast.makeText(this, "The user has Successfully Signed In", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
            else{
                Toast.makeText(this, "The users Signed Up has failed!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}