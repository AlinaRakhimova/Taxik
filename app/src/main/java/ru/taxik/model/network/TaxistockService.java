package ru.taxik.model.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import ru.taxik.model.entity.CityList;

public interface TaxistockService {

    @GET("/taxik/api/test/")
    Single<CityList> getCityList();

}
