package crypto.com.cryptoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import crypto.com.cryptoview.network.ApiRequestHelper;
import crypto.com.cryptoview.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mCoinRecyclerView;
    private CoinsRecyclerAdapter mCoinAdapter;
    private ApiRequestHelper apiRequestHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiRequestHelper = ApiService.getApiService();
        initView();
        loadCoins();
    }


    void initView() {
        mCoinRecyclerView = (RecyclerView) findViewById(R.id.coin_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mCoinRecyclerView.setLayoutManager(layoutManager);
        mCoinRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mCoinRecyclerView.addItemDecoration(itemDecoration);
    }

    void loadCoins() {
        apiRequestHelper.getCoins().enqueue(new Callback<CoinListResponse>() {
            @Override
            public void onResponse(Call<CoinListResponse> call, Response<CoinListResponse> response) {
                if (response.isSuccessful()) {
                    mCoinAdapter = new CoinsRecyclerAdapter();
                    mCoinRecyclerView.setAdapter(mCoinAdapter);
                }
            }

            @Override
            public void onFailure(Call<CoinListResponse> call, Throwable t) {

            }
        });
    }


}
