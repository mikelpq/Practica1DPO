package ServerRequests;

import Environment.EnvironmentKeys;
import okhttp3.*;

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

        //parametres de la request
        FormBody formBody = new FormBody.Builder()
                .add("arriveBy",  arrive)
                .add("date",  arrive)
                .add("fromPlace",  name_src)
                .add("maxWalkDistance",  distancia)
                .add("mode",  "BUS, WALK, TRANSIT")
                .add("time",  dateString)
                .add("toPlace",  name_dst)
                .build();

        Request request = new Request.Builder()
                .url(EnvironmentKeys.getUrl())
                .addHeader("app_id", EnvironmentKeys.getApp_id())
                .addHeader("app_key", EnvironmentKeys.getApp_key())
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()){

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code" + response);
            }

            System.out.println(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
