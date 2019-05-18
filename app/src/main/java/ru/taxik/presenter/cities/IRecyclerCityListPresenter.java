package ru.taxik.presenter.cities;

import ru.taxik.view.cities.IViewHolder;

public interface IRecyclerCityListPresenter {

    void bindView(IViewHolder iViewHolder);

    int getItemCount();

    void onSelectedItem(IViewHolder holder);

}
