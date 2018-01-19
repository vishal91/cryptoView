package crypto.com.cryptoview;

/**
 * Created by vishal on 18/01/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoinListResponse {

    @SerializedName("id")
    @Expose
    private String id = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price_btc")
    @Expose
    private String price;


    public String getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
