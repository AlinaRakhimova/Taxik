package ru.taxik.view.cities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.taxik.R;
import ru.taxik.presenter.cities.CityListPresenter;
import ru.taxik.view.maps.MapsActivity;

import static ru.taxik.constant.Constant.CITY_NAME;
import static ru.taxik.constant.Constant.LATITUDE;
import static ru.taxik.constant.Constant.LONGITUDE;

public class CityListActivity extends MvpAppCompatActivity implements CityListView {

    @InjectPresenter
    CityListPresenter presenter;

    @BindView(R.id.cityListRecycler)
    RecyclerView flightTypeRecycler;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private CityListAdapter cityListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        ButterKnife.bind(this);
        initUi();
    }

    private void initUi() {
        showTypeFlightsRecycler();
    }

    private void showTypeFlightsRecycler() {
        cityListAdapter = new CityListAdapter(presenter.getRecyclerCityListPresenter());
        flightTypeRecycler.setLayoutManager(new LinearLayoutManager(this));
        flightTypeRecycler.setAdapter(cityListAdapter);
    }

    @Override
    public void openMapScreen(String name, double latitude, double longitude) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra(CITY_NAME, name);
        intent.putExtra(LATITUDE, latitude);
        intent.putExtra(LONGITUDE, longitude);
        startActivity(intent);
    }

    @Override
    public void updateRecycler() {
        cityListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

}
