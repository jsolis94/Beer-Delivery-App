package com.chinelaegancho.beerdelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_pago_tona.*

class MoropotentePagoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moropotente_pago)

        mapButton.setOnClickListener {

            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        efectivoButton.setOnClickListener {

            val view = View.inflate(this, R.layout.pay_view, null)

            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            paypalButton.setOnClickListener {

                val intent = Intent(this, PaypalActivity::class.java)
                startActivity(intent)
            }

            tarjetaCreditoButton.setOnClickListener {

                val intent = Intent(this, TarjetaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}