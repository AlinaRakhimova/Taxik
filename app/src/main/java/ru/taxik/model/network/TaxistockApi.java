package ru.taxik.model.network;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.taxik.App;
import ru.taxik.model.entity.CityList;

public class TaxistockApi {

    @Inject
    TaxistockService service;

    public TaxistockApi() {
        App.getApp().getAppComponent().inject(this);
    }

    public Single<CityList> requestServer() {
        return service.getCityList();
    }

}
