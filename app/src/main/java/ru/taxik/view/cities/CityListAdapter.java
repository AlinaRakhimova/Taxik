package ru.taxik.view.cities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.taxik.R;
import ru.taxik.model.entity.City;
import ru.taxik.presenter.cities.IRecyclerCityListPresenter;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ViewHolder> {

    private IRecyclerCityListPresenter presenter;

    CityListAdapter(IRecyclerCityListPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.position = position;
        presenter.bindView(holder);
        holder.cityName.setOnClickListener(v -> presenter.onSelectedItem(holder));
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements IViewHolder {

        @BindView(R.id.city)
        TextView cityName;

        private int position = 0;

        private ViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + cityName.getText() + "'";
        }

        @Override
        public void setCity(City city) {
            cityName.setText(city.getName());
        }

        @Override
        public int getPos() {
            return position;
        }
    }

}
