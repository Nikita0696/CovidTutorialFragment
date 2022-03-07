package com.example.covidtutorialfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtutorialfragment.ui.home.HomeFragment;

import java.text.NumberFormat;
import java.util.List;

public class CovidDataAdapter extends RecyclerView.Adapter<CovidDataAdapter.ViewHolder> {

    int n = 1;
    List<CountryDataModelClass> modelClassList;
    Context context;

    public CovidDataAdapter(List<CountryDataModelClass> modelClassList, HomeFragment homeFragment) {
        this.modelClassList = modelClassList;

    }
    public CovidDataAdapter(List<CountryDataModelClass> modelClassList, Context context) {
        this.modelClassList = modelClassList;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CountryDataModelClass countryDataModelClass = modelClassList.get(position);
        if (n == 1) {
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(countryDataModelClass.getCases())));
        } else if (n == 2) {
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(countryDataModelClass.getRecovered())));
        } else if (n == 3) {
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(countryDataModelClass.getDeaths())));
        } else {
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(countryDataModelClass.getActive())));
        }

        holder.country.setText(countryDataModelClass.getCountry());

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cases, country;

        public ViewHolder(View itemView) {
            super(itemView);

            cases = itemView.findViewById(R.id.countrycase);
            country = itemView.findViewById(R.id.countryname);
        }
    }


    public void filter(String item) {
        if (item.equals("Cases")) {
            n = 1;
        } else if (item.equals("Recovered")) {
            n = 2;
        } else if (item.equals("Deaths")) {
            n = 3;
        } else {
            n = 4;
        }

        notifyDataSetChanged();
    }
}
