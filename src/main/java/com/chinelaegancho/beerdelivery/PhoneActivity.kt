package com.chinelaegancho.beerdelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phone.*
import kotlinx.android.synthetic.main.activity_verify.*

class PhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        codeBtn.setOnClickListener {

            val intent = Intent(this, VerifyActivity::class.java)
            startActivity(intent)
        }
    }
}