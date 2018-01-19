package crypto.com.cryptoview;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by vishal on 19/01/18.
 */

@Dao
public interface CoinDao {

    @Query("SELECT * FROM coin")
    List<Coin> getAllCoin();

    @Query("SELECT COUNT(*) from coin")
    int countCoins();

    @Insert
    void insertAll(Coin... coins);

    @Delete
    void delete(Coin coin);
}
