package Environment;

import java.util.Map;

public final class EnvironmentKeys {
    private final static String app_id = "0f0f156a";
    private final static String app_key = "34a92cf3fe9ae7bcd7a421f442a02d1c";
    private final static String url = "https://api.tmb.cat/v1/planner/plan?";



    /** metodes per encapsular la clau i l'id per accedir a la API **/
    public static String getApp_id() {
        return app_id;
    }

    public static String getApp_key() {
        return app_key;
    }

    /** metode per mantenir format d'encapsulació i no haver de escriure la URL manualment **/
    public static String getUrl() {
        return url;
    }
}
