package crypto.com.cryptoview.network;

/**
 * Created by vishal on 18/01/18.
 */

import java.util.List;

import crypto.com.cryptoview.CoinListResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequestHelper {
    @GET("listCoins")
    Call<CoinListResponse> getCoins();
}
