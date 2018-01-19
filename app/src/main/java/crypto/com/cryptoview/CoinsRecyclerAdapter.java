package crypto.com.cryptoview;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.util.List;

/**
 * Created by vishal on 18/01/18.
 */

public class CoinsRecyclerAdapter extends RecyclerView.Adapter {

    private List<Coin> mCoins;
    private Context mContext;


    public CoinsRecyclerAdapter(List<Coin> coins) {
        this.mCoins = coins;
    }

    @Override
    public CoinItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoinItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Coin coin = mCoins.get(position);
        CoinItemViewHolder coinItemViewHolder = (CoinItemViewHolder) holder;
        coinItemViewHolder.mlogoImg.setImageURI(Uri.parse(coin.getImageUrl()));
        coinItemViewHolder.mName.setText(coin.getName());
        coinItemViewHolder.mSymbol.setText(coin.getSymbol());
    }

    @Override
    public int getItemCount() {
        return mCoins.size() ;
    }


    public class CoinItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView mlogoImg;
        public TextView mSymbol;
        public TextView mName;


        public CoinItemViewHolder(View itemView) {
            super(itemView);
            mlogoImg = (ImageView) itemView.findViewById(R.id.coin_image_view);
            mSymbol = (TextView) itemView.findViewById(R.id.coin_abbre_view);
            mName = (TextView) itemView.findViewById(R.id.coin_name);
        }
    }
}
