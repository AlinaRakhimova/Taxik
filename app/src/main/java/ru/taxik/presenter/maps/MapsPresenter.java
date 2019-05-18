package ru.taxik.presenter.maps;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.taxik.view.maps.MapsView;

@InjectViewState
public class MapsPresenter extends MvpPresenter<MapsView> {

    public void createMapView() {
        getViewState().createMapView();
    }

}
