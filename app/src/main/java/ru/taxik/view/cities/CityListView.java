package ru.taxik.view.cities;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
public interface CityListView extends MvpView {

    void openMapScreen(String name, double latitude, double longitude);

    void updateRecycler();

    void showProgressBar();

    void hideProgressBar();

}
