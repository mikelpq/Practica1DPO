package ServerRequests;

import Environment.EnvironmentKeys;
import RouteResponse.*;
import okhttp3.*;

import com.google.gson.*;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServerRequest {

    public static ResponseJson createLocationRequest(String name_src, String name_dst, String arrive, String dateString, String timeString, String distancia) {
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

        HttpUrl.Builder urlBuilder = HttpUrl.parse(EnvironmentKeys.getUrl()).newBuilder();

        urlBuilder.addQueryParameter("app_id", EnvironmentKeys.getApp_id());
        urlBuilder.addQueryParameter("app_key", EnvironmentKeys.getApp_key());
        urlBuilder.addQueryParameter("arriveBy", arrive);
        urlBuilder.addQueryParameter("date", dateString);
        urlBuilder.addQueryParameter("fromPlace", name_src);
        urlBuilder.addQueryParameter("maxWalkDistance", distancia);
        urlBuilder.addQueryParameter("mode", "BUS, WALK, TRANSIT");
        urlBuilder.addQueryParameter("time", timeString);
        urlBuilder.addQueryParameter("toPlace", name_dst);
        urlBuilder.addQueryParameter("showIntermediateStops", "true");

        String url = urlBuilder.build().toString();

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
                responseJson = gson.fromJson(jsonData, ResponseJson.class);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseJson;
    }

    public static ResponseJson createBusTimeRequest(String parada){
        OkHttpClient client = new OkHttpClient();
        BusResponse responseJson = null;
        Response response;

        HttpUrl.Builder urlBuilder = HttpUrl.parse(EnvironmentKeys.getUrl()).newBuilder();

        urlBuilder.addQueryParameter("app_id", EnvironmentKeys.getApp_id());
        urlBuilder.addQueryParameter("app_key", EnvironmentKeys.getApp_key());
        urlBuilder.addQueryParameter("codi_parada", parada);

        String url = urlBuilder.build().toString();

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
                responseJson = gson.fromJson(jsonData, ResponseJson.class);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseJson;
    }
}
