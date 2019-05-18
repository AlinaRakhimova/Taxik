package ru.taxik.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.taxik.model.network.TaxistockApi;
import ru.taxik.presenter.cities.CityListPresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(TaxistockApi authPresenter);

    void inject(CityListPresenter cityListPresenter);

}
