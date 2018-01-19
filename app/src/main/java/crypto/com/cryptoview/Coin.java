package crypto.com.cryptoview;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.util.StringUtil;

/**
 * Created by vishal on 19/01/18.
 */

@Entity(tableName = "coin")
public class Coin {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "Url")
    private String url;

    @ColumnInfo(name = "ImageUrl")
    private String imageUrl;

    @ColumnInfo(name = "Symbol")
    private String symbol;

    @ColumnInfo(name = "CoinName")
    private String name;

    @ColumnInfo(name = "Algorithm")
    private String algo;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }
}
