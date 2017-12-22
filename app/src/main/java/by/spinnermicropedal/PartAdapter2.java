package by.spinnermicropedal;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import by.spinnermicropedal.internet.get.Filter;

/**
 * Created by Home911 on 18.12.2017.
 */

public class PartAdapter2 extends RecyclerView.Adapter<PartAdapter2.PartViewHolder> {

    private List<Filter> filters = new ArrayList<>();

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public PartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("sdf", "onCreateViewHolder()");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parts, parent, false);
        return new PartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PartViewHolder holder, int position) {
        Filter filter = filters.get(position);
        Log.e("ID", "oBVH " + String.valueOf(filter));
        holder.textTitleDescriptionName.setText(filter.getDescription().getName());
        Glide.with(holder.itemView.getContext())
                .load(filter.getImage())
                .into(holder.imagePart);
        //holder.textPriceAmountValue.setText(filter.getPrice().getAmount());
        //holder.textPriceCurrencyValue.setText(filter.getPrice().getCurrency());
        //holder.textPriceAmount.setText("Стоимость");
        //holder.textPriceCurrency.setText("Валюта");
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    static class PartViewHolder extends RecyclerView.ViewHolder{

        private TextView textTitleDescriptionName, textPriceAmount,
                textPriceCurrency, textPriceAmountValue, textPriceCurrencyValue;
        private ImageView imagePart;

        public PartViewHolder(View itemView) {
            super(itemView);
            imagePart = itemView.findViewById(R.id.imagePart);
            textTitleDescriptionName = itemView.findViewById(R.id.textTitleDescriptionName);
            //textPriceAmount = itemView.findViewById(R.id.textPriceAmount);
            //textPriceCurrency = itemView.findViewById(R.id.textPriceCurrency);
            //textPriceAmountValue = itemView.findViewById(R.id.textPriceAmountValue);
            //textPriceCurrencyValue = itemView.findViewById(R.id.textPriceCurrencyValue);
        }
    }

}
