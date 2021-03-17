package com.chinelaegancho.beerdelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_tona.*
import kotlinx.android.synthetic.main.alert_view.view.*

class FrostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frost)

        beer_picker.maxValue = 10
        beer_picker.minValue = 0

        add_icon.setOnClickListener {
            Toast.makeText(this,"Pedido agregado satisfactoriamente a la cuenta".toString(), Toast.LENGTH_SHORT).show()

            shoppingButton.setOnClickListener {

                val view = View.inflate(this, R.layout.alert_view, null)

                val builder = AlertDialog.Builder(this)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)


                view.alertButton.setOnClickListener {

                    val intent = Intent(this, FrostPagoActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}