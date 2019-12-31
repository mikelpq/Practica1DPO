package ServerRequests;

import Environment.EnvironmentKeys;
import RequestResponse.*;
import okhttp3.*;

import com.google.gson.*;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServerRequest {

    private String postBody = "{\n" +
            "  \"debugOutput\": {\n" +
            "    \"pathCalculationTime\": 0,\n" +
            "    \"pathTimes\": [\n" +
            "      0\n" +
            "    ],\n" +
            "    \"precalculationTime\": 0,\n" +
            "    \"renderingTime\": 0,\n" +
            "    \"timedOut\": true,\n" +
            "    \"totalTime\": 0\n" +
            "  },\n" +
            "  \"error\": {\n" +
            "    \"id\": 0,\n" +
            "    \"message\": \"PLAN_OK\",\n" +
            "    \"missing\": [\n" +
            "      \"string\"\n" +
            "    ],\n" +
            "    \"msg\": \"string\",\n" +
            "    \"noPath\": true\n" +
            "  },\n" +
            "  \"plan\": {\n" +
            "    \"date\": 0,\n" +
            "    \"from\": {\n" +
            "      \"lat\": 0,\n" +
            "      \"lon\": 0,\n" +
            "      \"name\": \"string\",\n" +
            "      \"orig\": \"string\",\n" +
            "      \"stopCode\": \"string\",\n" +
            "      \"vertexType\": \"string\"\n" +
            "    },\n" +
            "    \"itineraries\": [\n" +
            "      {\n" +
            "        \"duration\": 0,\n" +
            "        \"elevationGained\": 0,\n" +
            "        \"elevationLost\": 0,\n" +
            "        \"endTime\": 0,\n" +
            "        \"fare\": {},\n" +
            "        \"legs\": [\n" +
            "          {\n" +
            "            \"agencyId\": \"string\",\n" +
            "            \"agencyName\": \"string\",\n" +
            "            \"agencyTimeZoneOffset\": 0,\n" +
            "            \"agencyUrl\": \"string\",\n" +
            "            \"alerts\": [\n" +
            "              {}\n" +
            "            ],\n" +
            "            \"alightRule\": \"string\",\n" +
            "            \"arrivalDelay\": 0,\n" +
            "            \"boardRule\": \"string\",\n" +
            "            \"departureDelay\": 0,\n" +
            "            \"distance\": 0,\n" +
            "            \"duration\": 0,\n" +
            "            \"endTime\": 0,\n" +
            "            \"from\": {\n" +
            "              \"lat\": 0,\n" +
            "              \"lon\": 0,\n" +
            "              \"name\": \"string\",\n" +
            "              \"orig\": \"string\",\n" +
            "              \"stopCode\": \"string\",\n" +
            "              \"vertexType\": \"string\"\n" +
            "            },\n" +
            "            \"headsign\": \"string\",\n" +
            "            \"headway\": 0,\n" +
            "            \"interlineWithPreviousLeg\": true,\n" +
            "            \"intermediateStops\": [\n" +
            "              {\n" +
            "                \"lat\": 0,\n" +
            "                \"lon\": 0,\n" +
            "                \"name\": \"string\",\n" +
            "                \"orig\": \"string\",\n" +
            "                \"stopCode\": \"string\",\n" +
            "                \"vertexType\": \"string\"\n" +
            "              }\n" +
            "            ],\n" +
            "            \"isNonExactFrequency\": true,\n" +
            "            \"legGeometry\": {\n" +
            "              \"length\": 0,\n" +
            "              \"points\": \"string\"\n" +
            "            },\n" +
            "            \"mode\": \"WALK\",\n" +
            "            \"pathway\": true,\n" +
            "            \"realTime\": true,\n" +
            "            \"rentedBike\": true,\n" +
            "            \"route\": \"string\",\n" +
            "            \"routeColor\": \"string\",\n" +
            "            \"routeId\": \"string\",\n" +
            "            \"routeLongName\": \"string\",\n" +
            "            \"routeShortName\": \"string\",\n" +
            "            \"routeTextColor\": \"string\",\n" +
            "            \"routeType\": 0,\n" +
            "            \"serviceDate\": \"string\",\n" +
            "            \"startTime\": 0,\n" +
            "            \"steps\": [\n" +
            "              {\n" +
            "                \"absoluteDirection\": \"NORTH\",\n" +
            "                \"alerts\": [\n" +
            "                  {}\n" +
            "                ],\n" +
            "                \"area\": true,\n" +
            "                \"bogusName\": true,\n" +
            "                \"distance\": 0,\n" +
            "                \"elevation\": [\n" +
            "                  \"string\"\n" +
            "                ],\n" +
            "                \"exit\": \"string\",\n" +
            "                \"lat\": 0,\n" +
            "                \"lon\": 0,\n" +
            "                \"relativeDirection\": \"DEPART\",\n" +
            "                \"stayOn\": true,\n" +
            "                \"streetName\": \"string\"\n" +
            "              }\n" +
            "            ],\n" +
            "            \"to\": {\n" +
            "              \"lat\": 0,\n" +
            "              \"lon\": 0,\n" +
            "              \"name\": \"string\",\n" +
            "              \"orig\": \"string\",\n" +
            "              \"stopCode\": \"string\",\n" +
            "              \"vertexType\": \"string\"\n" +
            "            },\n" +
            "            \"transitLeg\": true,\n" +
            "            \"tripBlockId\": \"string\",\n" +
            "            \"tripId\": \"string\",\n" +
            "            \"tripShortName\": \"string\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"startTime\": 0,\n" +
            "        \"tooSloped\": true,\n" +
            "        \"transfers\": 0,\n" +
            "        \"transitTime\": 0,\n" +
            "        \"waitingTime\": 0,\n" +
            "        \"walkDistance\": 0,\n" +
            "        \"walkLimitExceeded\": true,\n" +
            "        \"walkTime\": 0\n" +
            "      }\n" +
            "    ],\n" +
            "    \"to\": {\n" +
            "      \"lat\": 0,\n" +
            "      \"lon\": 0,\n" +
            "      \"name\": \"string\",\n" +
            "      \"orig\": \"string\",\n" +
            "      \"stopCode\": \"string\",\n" +
            "      \"vertexType\": \"string\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"requestParameters\": {\n" +
            "    \"app_id\": \"string\",\n" +
            "    \"app_key\": \"string\",\n" +
            "    \"arriveBy\": \"string\",\n" +
            "    \"date\": \"string\",\n" +
            "    \"fromPlace\": \"string\",\n" +
            "    \"maxWalkDistance\": \"string\",\n" +
            "    \"mode\": \"string\",\n" +
            "    \"time\": \"string\",\n" +
            "    \"toPlace\": \"string\"\n" +
            "  }\n" +
            "}";

    public static void createLocationRequest(String name_src, String name_dst, String arrive, String dateString, String timeString, String distancia) {
        OkHttpClient client = new OkHttpClient();

        System.out.println("src" + name_src);
        System.out.println("dst" + name_dst);

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

        System.out.println(url);
        Response response;
        try{
            response = client.newCall(request).execute();

            if (response.body() == null) {
                throw new IOException(String.valueOf(response));
            }else{
                String jsonData = response.body().string();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json =gson.toJson(jsonData, );
                System.out.println(json);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    public void onResponse(Call call, Response response) throws IOException {

        final String myResponse = response.body().string();

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {

                    JsonObject json = new JsonObject(myResponse);
                    txtString.setText(json.getJSONObject("data").getString("first_name")+ " "+json.getJSONObject("data").getString("last_name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }*/

}
