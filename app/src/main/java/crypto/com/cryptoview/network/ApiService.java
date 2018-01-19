package crypto.com.cryptoview.network;

import crypto.com.cryptoview.RetrofitClient;

/**
 * Created by vishal on 18/01/18.
 */

public class ApiService {

    public static final String BASE_URL = "http://api.cryptocoincharts.info/";

    public static ApiRequestHelper getApiService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiRequestHelper.class);
    }
}
