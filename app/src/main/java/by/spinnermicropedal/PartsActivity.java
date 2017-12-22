package by.spinnermicropedal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import by.spinnermicropedal.internet.RestService;
import by.spinnermicropedal.internet.get.Filter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PartsActivity extends AppCompatActivity {

    private ImageView imageView;
    private String idMain;
    private int stateFilter;
    private TextView textStateFilter;
    private Disposable disposable;
    private RestService restService;
    private List<Filter> filtersList;
    private RecyclerView recyclerView;
    private PartAdapter2 partAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);
        Intent intent = getIntent();

        recyclerView = findViewById(R.id.recyclerViewParts);
        restService = RestService.getInstanse();
        textStateFilter = findViewById(R.id.textStateFilter);
        imageView = findViewById(R.id.imageLogo);
        Glide.with(PartsActivity.this)
                .load(R.drawable.logosite)
                .into(imageView);

        stateFilter = intent.getExtras().getInt("stateFilter");
        Log.e("stateFilter = ", String.valueOf(stateFilter));
        idMain = intent.getStringExtra("id");

        if (stateFilter <= 0){
            textStateFilter.setText("Что-то пошло не так. Проблема с передачей ID");
        } else {
            switch (stateFilter){
                case 1: filterByManufacture();
                textStateFilter.setText("Выбор по производителю");
                break;
                case 2: filterByModel();
                    textStateFilter.setText("Выбор по модели");
                break;
                default: textStateFilter.setText("Чудеса с передачей ID. Программа работает не правильно");
                break;
            }
        }

    }
    private void filterByManufacture(){
        disposable = restService.getRestApi().getFilterByManufactureId(idMain)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Filter>>() {
                    @Override
                    public void onNext(List<Filter> filters) {
                        partAdapter = new PartAdapter2();
                        partAdapter.setFilters(filters);
                        for (Filter filter : filters){
                            //Log.e("ID", filter.getDescription().getName());
                            Log.e("ID", filter.getCategory().getName());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("Tag", "onComlete");
                        recyclerView.setLayoutManager(new LinearLayoutManager(PartsActivity.this));
                        recyclerView.setAdapter(partAdapter);
                    }
                });
    }

    private void filterByModel(){
        disposable = restService.getRestApi().getFilterByModelId(idMain)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Filter>>() {
                    @Override
                    public void onNext(List<Filter> filters) {
                        partAdapter = new PartAdapter2();
                        partAdapter.setFilters(filters);
                        for (Filter filter : filters){
                            //Log.e("id model", filter.getCarModel().getName());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error filterByModel", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("Tag filterByModel", "onComlete");
                        recyclerView.setLayoutManager(new LinearLayoutManager(PartsActivity.this));
                        recyclerView.setAdapter(partAdapter);
                    }
                });
    }
}
