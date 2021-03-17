package com.chinelaegancho.beerdelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_beer_main.*
import kotlinx.android.synthetic.main.activity_beer_main.*

class BeerMainActivity() : AppCompatActivity(), ItemsAdapter.ClickListener {

    lateinit var auth: FirebaseAuth

    val imagesName = arrayOf(
        ItemsModal(
            producto = "Toña 12 oz Retornable", descripcion = "4.6 % de Alcohol por Volumen",
            R.drawable.tona1
        ),
        ItemsModal(
            producto = "Victoria Clasica 12 Oz Retornable",
            descripcion = "4.9 % de Alcohol por Volumen",
            R.drawable.victoria_logo
        ),
        ItemsModal(
            producto = "Victoria Frost 12 Oz Retornable",
            descripcion = "4.9 % de Alcohol por Volumen",
            R.drawable.victoria_frost_logo
        ),
        ItemsModal(
            producto = "Seleccion Maestro 12 Oz Retornable",
            descripcion = "5.1 % de Alcohol por Volumen",
            R.drawable.victoria_maestro_logo
        ),
        ItemsModal(
            producto = "Moropotente 12 Oz Retornable",
            descripcion = "7.0 % de Alcohol por Volumen",
            R.drawable.moropotente_logo
        ),
        ItemsModal(
            producto = "Corona Extra 12 Oz Retornable",
            descripcion = "4.7 % de Alcohol por Volumen",
            R.drawable.corona_extra_logo),

            ItemsModal(
                producto = "Miller 12 Oz Retornable",
                descripcion = "4.7 % de Alcohol por Volumen",
                R.drawable.miller_logo
        ),

        ItemsModal(
            producto = "Heineken 12 Oz Retornable",
            descripcion = "4.7 % de Alcohol por Volumen",
            R.drawable.heineken_logo
        )
    )

    val itemModalList = ArrayList<ItemsModal>()

    var itemsAdapter: ItemsAdapter? = null;

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer_main)


        for (items in imagesName) {
            itemModalList.add(items)
        }

        itemsAdapter = ItemsAdapter(this);
        itemsAdapter!!.setData(itemModalList);

        recycler_view_home.layoutManager = LinearLayoutManager(this)
        recycler_view_home.setHasFixedSize(true)
        recycler_view_home.adapter = itemsAdapter
    }

    override fun ClickedItem(itemsModal: ItemsModal) {
        Log.e("TAG", itemsModal.producto)

        when (itemsModal.producto) {
            "Toña 12 oz Retornable" ->
                startActivity(Intent(this@BeerMainActivity, TonaActivity::class.java))

            "Victoria Clasica 12 Oz Retornable" ->
                startActivity(Intent(this@BeerMainActivity, ClasicaActivity::class.java))

            "Victoria Frost 12 Oz Retornable" ->
                startActivity(Intent(this@BeerMainActivity, FrostActivity::class.java))

            "Seleccion Maestro 12 Oz Retornable" ->
                startActivity(Intent(this@BeerMainActivity, MaestroActivity::class.java))

            "Moropotente 12 Oz Retornable" ->
                startActivity(Intent(this@BeerMainActivity, MoropotenteActivity::class.java))

            "Corona Extra 12 Oz Retornable" ->
                startActivity(Intent(this@BeerMainActivity, CoronaActivity::class.java))

            "Miller 12 Oz Retornable" ->
                startActivity(Intent(this@BeerMainActivity, MillerActivity::class.java))

            "Heineken 12 Oz Retornable" ->
                startActivity(Intent(this@BeerMainActivity, HeinekenActivity::class.java))

            else -> {
                Toast.makeText(this, "Por Favor Agregar Activity", Toast.LENGTH_SHORT).show()
            }
        }
    }
}






