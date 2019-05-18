package ru.taxik.view.maps;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ru.taxik.R;
import ru.taxik.presenter.maps.MapsPresenter;

import static ru.taxik.constant.Constant.CITY_NAME;
import static ru.taxik.constant.Constant.LATITUDE;
import static ru.taxik.constant.Constant.LONGITUDE;

public class MapsActivity extends MvpAppCompatActivity implements OnMapReadyCallback, MapsView {

    protected GoogleMap mMap;
    @InjectPresenter
    MapsPresenter presenter;
    private String cityName;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        cityName = getIntent().getStringExtra(CITY_NAME);
        latitude = getIntent().getDoubleExtra(LATITUDE, 0.0);
        longitude = getIntent().getDoubleExtra(LONGITUDE, 0.0);
        createMapView();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng city = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(city).title(cityName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(city));
    }

    @Override
    public void createMapView() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        if (mapFragment == null) return;
        mapFragment.getMapAsync(this);
    }

}
