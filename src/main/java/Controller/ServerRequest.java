package Controller;

import Model.Settings.EnvironmentKeys;
import Model.BusTime.BusTime;
import Model.RouteResponse.ResponseJson;
import Model.Stop.Stop;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ServerRequest {
    /** REQUEST OPCIO 1-D i 4 **/
    public static Stop createStationsRequest(boolean bus) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Stop responseJson = null;
        Response response;
        HttpUrl.Builder urlBuilder;

        if (bus){
            urlBuilder = HttpUrl.parse(EnvironmentKeys.getUrlTransitBusStops()).newBuilder();

        }else {
            urlBuilder = HttpUrl.parse(EnvironmentKeys.getUrlTransitMetroStops()).newBuilder();
        }

        urlBuilder.addQueryParameter("app_id", EnvironmentKeys.getApp_id());
        urlBuilder.addQueryParameter("app_key", EnvironmentKeys.getApp_key());

        String url = urlBuilder.build().toString();
        System.out.println(url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            System.out.println(" Error, hi ha algun paràmetre erroni\n");
            responseJson = null;
        }else{
            String jsonData = response.body().string();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            responseJson = gson.fromJson(jsonData, Stop.class);
        }

        return responseJson;
    }

    /** REQUEST OPCIO 1-E **/
    public static Stop createSameYearRequest(int year) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Stop responseJson = null;
        Response response;
        HttpUrl.Builder urlBuilder = HttpUrl.parse(EnvironmentKeys.getUrlTransitStopsUSerYear()).newBuilder();
        String jsonData;

        urlBuilder.addQueryParameter("app_id", EnvironmentKeys.getApp_id());
        urlBuilder.addQueryParameter("app_key", EnvironmentKeys.getApp_key());
        //urlBuilder.addQueryParameter("filter=DATA_INICI", String.valueOf(year));

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            System.out.println(" Error, hi ha algun paràmetre erroni\n");
            responseJson = null;
        }else{
            jsonData = response.body().string();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            responseJson = gson.fromJson(jsonData, Stop.class);
        }

        return responseJson;
    }

    /** REQUEST OPCIO 3 **/
    public static ResponseJson createLocationRequest(String name_src, String name_dst, String arrive, String date, String time, String distancia) {
        OkHttpClient client = new OkHttpClient();
        ResponseJson responseJson = null;
        Response response;

        /** SERVER REQUEST FORMAT
         * "requestParameters": {
         * "app_id": "string",
         * "app_key": "string",
         * "arriveBy": "string",
         * "date": "string",
         * "fromPlace": "string",
         * "maxWalkDistance": "string",
         * "mode": "string",
         * "time": "string",
         * "toPlace": "string"
         * }
         */

        HttpUrl.Builder urlBuilder = HttpUrl.parse(EnvironmentKeys.getUrlPlanner()).newBuilder();

        urlBuilder.addQueryParameter("app_id", EnvironmentKeys.getApp_id());
        urlBuilder.addQueryParameter("app_key", EnvironmentKeys.getApp_key());
        urlBuilder.addQueryParameter("fromPlace", name_src);
        urlBuilder.addQueryParameter("toPlace", name_dst);
        urlBuilder.addQueryParameter("date", date);
        urlBuilder.addQueryParameter("time", time);
        urlBuilder.addQueryParameter("arriveBy", arrive);
        urlBuilder.addQueryParameter("mode", "WALK, TRANSIT, BUS");
        urlBuilder.addQueryParameter("maxWalkDistance", distancia);
        urlBuilder.addQueryParameter("showIntermediateStops", "true");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try{
            response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.out.println("Error, hi ha algun paràmetre erroni");
                responseJson.setOk(false);
            }else{
                String jsonData = response.body().string();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                responseJson = gson.fromJson(jsonData, ResponseJson.class);
                responseJson.setOk(true);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseJson;
    }

    /** REQUEST OPCIO 4 **/
    public static BusTime createBusTimeRequest(String parada){
        OkHttpClient client = new OkHttpClient();
        BusTime responseJson = null;
        Response response;

        HttpUrl.Builder urlBuilder = HttpUrl.parse(EnvironmentKeys.getUrlBus() + parada).newBuilder();

        //urlBuilder.addQueryParameter("codi_parada", parada);
        urlBuilder.addQueryParameter("app_id", EnvironmentKeys.getApp_id());
        urlBuilder.addQueryParameter("app_key", EnvironmentKeys.getApp_key());

        String url = urlBuilder.build().toString();

        System.out.println("build url " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try{
            response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.out.println("Error, hi ha algun paràmetre erroni");
            }else{
                String jsonData = response.body().string();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                responseJson = gson.fromJson(jsonData, BusTime.class);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseJson;
    }
}
