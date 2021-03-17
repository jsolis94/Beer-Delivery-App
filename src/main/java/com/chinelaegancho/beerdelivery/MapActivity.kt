package com.chinelaegancho.beerdelivery

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private lateinit var map: GoogleMap

    companion object{
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        createFragment()

    }

    private fun createFragment(){

        val mapFragment =  supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        createMarker()
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableLocation()


    }

    private fun createMarker(){

        val coordenadas = LatLng(11.8441887,-86.2051728)

        val marker = MarkerOptions().position(coordenadas).title("Universidad Central de Nicaragua")
        //map.addMarker(marker)
        map.animateCamera(
           CameraUpdateFactory.newLatLngZoom(coordenadas, 7f), 4000, null
        )
    }

    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun enableLocation(){

        if (!::map.isInitialized) return
        if (isLocationPermissionGranted()){

            map.isMyLocationEnabled = true
        }

        else{
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){

            Toast.makeText(this, "ACEPTAR LOS PERMISOS DE LA API", Toast.LENGTH_SHORT).show()
        }

        else{

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_CODE_LOCATION)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
       when(requestCode){
           REQUEST_CODE_LOCATION  -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
               map.isMyLocationEnabled = true
           }
           else{
               Toast.makeText(this, "ACEPTAR LOS PERMISOS DE LA API", Toast.LENGTH_SHORT).show()
           }
           else -> {}
       }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::map.isInitialized) return
        if (!isLocationPermissionGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(this, "ACEPTAR LOS PERMISOS DE LA API", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "REDIRECCIONANDO A TU LOCALIZACION", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "LOCALIZACION GUARDADA PARA EL SERVICIO DELIVERY \n \n" + "${p0.latitude}, ${p0.longitude}", Toast.LENGTH_LONG).show()
    }
}