package ServerRequests;

import Environment.EnvironmentKeys;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ServerRequest {

    public static void createLocationRequest(String name_dst, String name_src, String arrive, String dateString, String distancia){
        OkHttpClient client = new OkHttpClient();

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

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.github.help").newBuilder();
        urlBuilder.addQueryParameter("arriveBy",  arrive);
        urlBuilder.addQueryParameter("date",  arrive);
        urlBuilder.addQueryParameter("fromPlace",  name_src);
        urlBuilder.addQueryParameter("maxWalkDistance",  distancia);
        urlBuilder.addQueryParameter("mode",  "BUS, WALK, TRANSIT");
        urlBuilder.addQueryParameter("time",  dateString);
        urlBuilder.addQueryParameter("toPlace",  name_dst);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("app_id", EnvironmentKeys.getApp_id())
                .header("app_key", EnvironmentKeys.getApp_key())
                .url(url).build();

        try {
            Response response = client.newCall(request).execute();

            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
