package com.example.covidtutorialfragment;

import com.example.covidtutorialfragment.CountryDataModelClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {



    @GET("covid-19/countries")
    Call <ArrayList<CountryDataModelClass>> getCountryData();

}
