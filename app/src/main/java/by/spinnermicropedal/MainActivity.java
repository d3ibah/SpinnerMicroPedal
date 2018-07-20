package by.spinnermicropedal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import by.spinnermicropedal.internet.RestService;
import by.spinnermicropedal.internet.get.Manufacture;
import by.spinnermicropedal.internet.get.ModelsByManufacture;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Disposable disposable;
    private RestService restService;
    private Spinner spinner, spinner2;
    private List<Manufacture> manufactureList;
    private List<ModelsByManufacture> modelsByManufacturesList;
    private ArrayAdapter<String> arrayAdapter, arrayAdapter2;
    private ImageView imageView;
    private TextView textView, textViewSpinner1, textViewSpinner2;
    private Button button;
    private int stateFilter;
    Intent intent;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this, PartsActivity.class);

        restService = RestService.getInstanse();
        //restService.getRestApi().getManufactures();

        spinner = findViewById(R.id.spinner);
        //spinner.setVisibility(View.GONE);
        spinner2 = findViewById(R.id.spinner2);
        //spinner2.setVisibility(View.GONE);
        textView = findViewById(R.id.textView);
        textViewSpinner1 = findViewById(R.id.textSpinner1);
        textViewSpinner2 = findViewById(R.id.textSpinner2);
        imageView = findViewById(R.id.imageView);
        imageView.setVisibility(View.GONE);

        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("stateFilter", stateFilter);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        textViewSpinner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewSpinner1.setVisibility(View.INVISIBLE);
                spinner.performClick();
                imageView.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);
            }
        });

        textViewSpinner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewSpinner2.setVisibility(View.INVISIBLE);
                spinner2.performClick();
                spinner2.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
            }
        });

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setPrompt("Выбери производителя");

        arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setPrompt("Выбери модель");

        disposable = restService.getRestApi().getManufactures()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Manufacture>>() {
                    @Override
                    public void onNext(List<Manufacture> manufactures) {
                        manufactureList = manufactures;
                        setSpinnerData();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText("Теперь выбери модель");
                Glide.with(MainActivity.this)
                        .load(manufactureList.get(i).getImage())
                        .into(imageView);
                id = manufactureList.get(i).getId();
                //Log.e("ID", " - " + id.toString());
                stateFilter = 1;
                disposable = restService.getRestApi().getModelsByManufacture(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<List<ModelsByManufacture>>() {
                            @Override
                            public void onNext(List<ModelsByManufacture> modelsByManufactures) {
                                modelsByManufacturesList = modelsByManufactures;
                                for(ModelsByManufacture model : modelsByManufactures){
                                    setSpinner2Data();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(modelsByManufacturesList.get(i).getYears());
                stateFilter = 2;
                id = modelsByManufacturesList.get(i).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setSpinnerData() {
        List<String> namesManufacture = new ArrayList<>();
        for (Manufacture manufacture : manufactureList){
            namesManufacture.add(manufacture.getName());
        }
        arrayAdapter.clear();
        arrayAdapter.addAll(namesManufacture);
    }

    private void setSpinner2Data() {
        List<String> namesModel = new ArrayList<>();
        for (ModelsByManufacture modelsByManufacture : modelsByManufacturesList){
            namesModel.add(modelsByManufacture.getName());
        }
        arrayAdapter2.clear();
        arrayAdapter2.addAll(namesModel);
    }
}
