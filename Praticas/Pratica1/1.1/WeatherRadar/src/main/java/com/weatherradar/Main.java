package com.weatherradar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Iterator;

public class Main {
    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        String city = "Aveiro";
        if (args.length != 0) {
            city = args[0];
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<Cities> callSyncCities = service.getCitiesCodes();
        Integer cityCode = null;
        try {
            Response<Cities> apiResponse = callSyncCities.execute();
            Cities cities = apiResponse.body();
            Iterator<City> iter = cities.getData().listIterator();
            while (iter.hasNext()) {
                City cityObj = iter.next();
                if (cityObj.getLocal().equals(city))
                    cityCode = cityObj.getGlobalIdLocal();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (cityCode == null) {
            logger.info("Specified city does not exist!");
            System.exit(1);
        }

        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityCode);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();
            logger.info("Max temp for today: " + forecast.getData().listIterator().next().getTMax() + "Cº");
            //System.out.println( "Max temp for today: " + forecast.getData().listIterator().next().getTMax());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.exit(1);
    }
}
