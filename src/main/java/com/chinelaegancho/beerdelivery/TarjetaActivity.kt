package com.chinelaegancho.beerdelivery

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_pago_tona.*
import kotlinx.android.synthetic.main.activity_tarjeta.*
import android.widget.ArrayAdapter as ArrayAdapter1

class TarjetaActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarjeta)

        //BOTON DE PAGO

        buttontarjetapago.setOnClickListener {

            val view = View.inflate(this, R.layout.tarjeta_view, null)

            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }
}
