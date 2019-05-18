package ru.taxik.presenter.cities;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import ru.taxik.App;
import ru.taxik.model.entity.City;
import ru.taxik.model.entity.CityList;
import ru.taxik.model.network.TaxistockApi;
import ru.taxik.view.cities.CityListView;
import ru.taxik.view.cities.IViewHolder;

import static ru.taxik.constant.Constant.TAG;

@InjectViewState
public class CityListPresenter extends MvpPresenter<CityListView> {

    private final RecyclerCityListPresenter recyclerCityListPresenter;
    @Inject
    TaxistockApi taxistockApi;
    private List<City> cityList;

    public CityListPresenter() {
        App.getApp().getAppComponent().inject(this);
        recyclerCityListPresenter = new RecyclerCityListPresenter();
        cityList = new ArrayList<>();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getCityList();
    }

    private void getCityList() {
        getViewState().showProgressBar();
        taxistockApi.requestServer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<CityList>() {
                    @Override
                    public void onSuccess(CityList cities) {
                        List<City> list = cities.getCities();
                        if (list == null) {
                            Log.d(TAG, "Список городов пуст ");
                            return;
                        }
                        cityList.addAll(list);
                        getViewState().updateRecycler();
                        Log.d(TAG, "Загрузка прошла успешно ");
                        getViewState().hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Ошибка получения городов: " + e.getMessage());
                    }
                });
    }

    public IRecyclerCityListPresenter getRecyclerCityListPresenter() {
        return recyclerCityListPresenter;
    }

    private class RecyclerCityListPresenter implements IRecyclerCityListPresenter {

        @Override
        public void bindView(IViewHolder holder) {
            holder.setCity(cityList.get(holder.getPos()));
        }

        @Override
        public int getItemCount() {
            if (cityList == null) return 0;
            else return cityList.size();
        }

        @Override
        public void onSelectedItem(IViewHolder holder) {
            City city = cityList.get(holder.getPos());
            getViewState().openMapScreen(city.getName(), city.getLatitude(), city.getLongitude());
        }
    }

}
