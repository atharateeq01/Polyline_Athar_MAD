package com.example.polyline_athar_ateeq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.polyline_athar_ateeq.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnPolylineClickListener, GoogleMap.OnPolygonClickListener {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // Retrieve the content view that renders the map.
            setContentView(R.layout.activity_maps)

            // Get the SupportMapFragment and request notification when the map is ready to be used.
            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment?.getMapAsync(this)
        }

        /**
         * Manipulates the map when it's available.
         * The API invokes this callback when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this tutorial, we add polylines and polygons to represent routes and areas on the map.
         */
        override fun onMapReady(googleMap: GoogleMap) {

            val Riphah_r = LatLng(31.37750631431543, 74.23007051048174)

            val Riphah_q= LatLng(31.455396080310827, 74.32558453697389)
            googleMap.addMarker(MarkerOptions().position(Riphah_r).title("Marker in Riphah Raiwind campus"))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Riphah_r, 18F), 5000, null);
            googleMap.addMarker(MarkerOptions().position(Riphah_q).title("Marker in QIE Campus"))
            //googleMap.moveCamera(CameraUpdateFactory.newLatLng(Riphah_q))
            // Add polylines to the map.
            // Polylines are useful to show a route or some other connection between points.
            val polyline1 = googleMap.addPolyline(PolylineOptions()
                .clickable(true)
                .add(
                    LatLng(31.37750631431543, 74.23007051048174),
                    LatLng(31.397137464944183, 74.22835825719126),
                    LatLng(31.39244440755377, 74.24963821298937),
                    LatLng(31.388329566718685, 74.27812588297503),
                    LatLng(31.388618040684932, 74.28567793440745),
                    LatLng(31.39476290113911, 74.29804147021152),
                    LatLng(31.444844568797, 74.32831890690069),
                    LatLng(31.447781729020456, 74.3200775483349),
                    LatLng(31.455396080310827, 74.32558453697389)))

            // Position the map's camera near Alice Springs in the center of Australia,
            // and set the zoom factor so most of Australia shows on the screen.
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(31.3805985788069, 74.23174568347031), 4f))

            // Set listeners for click events.
            googleMap.setOnPolylineClickListener(this)
            googleMap.setOnPolygonClickListener(this)
        }

    override fun onPolygonClick(p0: Polygon) {
        TODO("Not yet implemented")
    }

    override fun onPolylineClick(p0: Polyline) {
        TODO("Not yet implemented")
    }


}