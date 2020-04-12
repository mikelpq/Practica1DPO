package Model.Settings;

public final class EnvironmentKeys {
    private final static String app_id = "0f0f156a";
    private final static String app_key = "34a92cf3fe9ae7bcd7a421f442a02d1c";
    private final static String urlPlanner = "https://api.tmb.cat/v1/planner/plan?";
    private final static String urlBus = "https://api.tmb.cat/v1/ibus/stops/";
    private final static String urlTransitMetroStops = "https://api.tmb.cat/v1/transit/estacions";
    private final static String urlTransitBusStops = "https://api.tmb.cat/v1/transit/parades";
    private final static String urlTransitStopsUSerYear = "https://api.tmb.cat/v1/transit/linies/metro/estacions";


    /** metodes per encapsular la clau i l'id per accedir a la API **/
    public static String getApp_id() {
        return app_id;
    }

    public static String getApp_key() {
        return app_key;
    }

    /** metodes per mantenir format d'encapsulació i no haver de escriure la URL manualment **/
    public static String getUrlPlanner() {
        return urlPlanner;
    }

    public static String getUrlBus(){ return urlBus; }

    public static String getUrlTransitMetroStops() {
        return urlTransitMetroStops;
    }

    public static String getUrlTransitBusStops() {
        return urlTransitBusStops;
    }

    public static String getUrlTransitStopsUSerYear() {
        return urlTransitStopsUSerYear;
    }
}
