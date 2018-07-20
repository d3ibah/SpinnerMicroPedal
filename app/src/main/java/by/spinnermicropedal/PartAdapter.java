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
 * Created by Home911 on 15.12.2017.
 */

public class PartAdapter extends RecyclerView.Adapter<PartAdapter.PartViewHolder> {

    private List<Filter> filters = new ArrayList<>();
    /*private ClickListenner listennerInteface;

    public PartAdapter(ClickListenner listennerInteface) {
        this.listennerInteface = listennerInteface;
    }*/

    // Создаём интерфейс для дальнейшей реализации клика
    interface ClickListenner {
        void onClick(Filter filter);
    }

    // Вызываем этот метод чтобы подать Лист в Адаптер
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    // Вызываем этот метод для определения КЛИКнутой позиции в ресайклед вью
    /*public Filter getFilterByPosition(int position) {
        return filters.get(position);
    }*/

    @Override
    public PartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
               /* .override(147, 25)
                .fitCenter()
                .centerCrop()
                .placeholder(R.drawable.ic_wallpaper_black_48dp)
                .error(R.drawable.ic_visibility_off_black_48dp)*/
                .into(holder.imagePart);
        holder.textCategory.setText(filter.getCategory().getName());
        holder.textPrice.setText(filter.getPrice().getAmount());
        holder.textLocation.setText(filter.getLocation().getCity());
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    static class PartViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitleDescriptionName;
        private TextView textCategory;
        private TextView textPrice;
        private TextView textLocation;
        private ImageView imagePart;

        public PartViewHolder(View itemView) {
            super(itemView);
            imagePart = itemView.findViewById(R.id.imagePart);
            textTitleDescriptionName = itemView.findViewById(R.id.textTitleDescriptionName);
            textCategory = itemView.findViewById(R.id.textCategory);
            textPrice = itemView.findViewById(R.id.textPrice);
            textLocation = itemView.findViewById(R.id.textLocation);
        }
    }
}
