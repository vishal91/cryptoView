package crypto.com.cryptoview;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;

/**
 * Created by vishal on 19/01/18.
 */

@Database(entities = {Coin.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract CoinDao coinDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "coin-database").allowMainThreadQueries().build();
        }

        return INSTANCE;
    }


    public static void destroyInstance() {
        INSTANCE = null;
    }

    private static Coin addCoin(final AppDatabase db, Coin coin) {
        db.coinDao().insertAll(coin);
        return coin;
    }

    private static List<Coin> getAllCoin(final AppDatabase db) {
        return  db.coinDao().getAllCoin();
    }

    private static void populateWithTestData(AppDatabase db) {
        Coin coin = new Coin();
        coin.setName("Bitcoin");
        coin.setUrl("Saini");
        coin.setSymbol("BTC");
        coin.setImageUrl("/media/19633/btc.png");
        addCoin(db, coin);
    }

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
