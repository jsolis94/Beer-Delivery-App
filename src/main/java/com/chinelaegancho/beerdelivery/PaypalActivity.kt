package com.chinelaegancho.beerdelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_pago_tona.*
import kotlinx.android.synthetic.main.activity_paypal.*

class PaypalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paypal)

        buttonpaypalpago.setOnClickListener {

            val view = View.inflate(this, R.layout.paypal_view, null)

            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)


        }
    }
}