package com.example.covidtutorialfragment;

import android.app.Activity;

import com.example.covidtutorialfragment.ui.home.HomeFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidDataController {

    HomeFragment mainActivity;
    Activity activity;
    ArrayList<CountryDataModelClass> modelClassList = new ArrayList<>();

    public CovidDataController(HomeFragment mainActivity) {
        this.mainActivity = mainActivity;
     //   this.activity = mainActivity;
    }

    public void callAPIRecyclerviewData() {
        try {
          APIInterface apiInterface = RetroFit_APIClient.getInstance().getClient("https://disease.sh/v3/").create(APIInterface.class);
            Call<ArrayList<CountryDataModelClass>> listCall = apiInterface.getCountryData();
            listCall.enqueue(new Callback<ArrayList<CountryDataModelClass>>() {
                @Override
                public void onResponse(Call<ArrayList<CountryDataModelClass>> call, Response<ArrayList<CountryDataModelClass>> response) {
                    if (response.body() != null && response.isSuccessful()) {

                        modelClassList = response.body();
                        mainActivity.getResponse(modelClassList);
                        /*modelClassList2.addAll(response.body());

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(covidDataAdapter);*/
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<CountryDataModelClass>> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*private void sendResponsetorecycler(List<CountryDataModelClass> modelClassList) {

        mainActivity.getResonse(modelClassList);
    }*/
}
