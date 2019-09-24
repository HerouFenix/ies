package com.weatherradar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Response;

public class Main {
    private static int CITY_ID_AVEIRO = 1010500;
    protected static final Logger logger = LogManager.getLogger();

    public static void main( String[] args )
    {
        int cityCode = CITY_ID_AVEIRO;
        if(args.length!=0){
            cityCode=Integer.parseInt(args[0]);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory. create ())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
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
