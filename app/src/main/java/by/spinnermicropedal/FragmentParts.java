package by.spinnermicropedal;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Home911 on 04.01.2018.
 */

public class FragmentParts extends Fragment {

    private ImageView imagePart, imageManufacture;
    private TextView textViewManunufacture, textViewModel, textViewYears, textViewDescriprionName, textViewDescriptionManufacture, textViewAuctionPlusPrice, textViewLocation;
    private String urlImagePart, urlImageManufacture,textManunufacture, textModel, textYears, textDescriprionName, textDescriptionManufacture, textAuctionPlusPrice, textLocation;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_part, container, false);
        Log.e("---------", "1 onCreateView");

        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imagePart = view.findViewById(R.id.imageFragmentPart);
        imageManufacture = view.findViewById(R.id.imageFragmentManufacture);

        textViewManunufacture = view.findViewById(R.id.textViewFragmentManufacture);
        textViewModel = view.findViewById(R.id.textViewFragmentModel);
        textViewYears = view.findViewById(R.id.textViewFragmentYears);
        textViewDescriprionName = view.findViewById(R.id.textViewFragmentDescriptionName);
        textViewDescriptionManufacture = view.findViewById(R.id.textViewFragmentDescriptionManufacture);
        textViewAuctionPlusPrice = view.findViewById(R.id.textViewFragmentAuctionPlusPrice);
        textViewLocation = view.findViewById(R.id.textViewFragmentLocation);

        Glide.with(this)
                .load(urlImagePart)
                .centerCrop()
                .error(R.drawable.ic_visibility_off_black_48dp)
                .into(imagePart);

        Glide.with(this)
                .load(urlImageManufacture)
                .centerCrop()
                .error(R.drawable.ic_visibility_off_black_48dp)
                .into(imageManufacture);

        textViewManunufacture.setText(textManunufacture);
        textViewModel.setText(textModel);
        textViewYears.setText(textYears);
        textViewDescriprionName.setText(textDescriprionName);
        textViewDescriptionManufacture.setText(textDescriptionManufacture);
        textViewAuctionPlusPrice.setText(textAuctionPlusPrice);
        textViewLocation.setText(textLocation);

        //Bundle bundle = getArguments();
        //textManunufacture.setText(bundle.getString("nameManufacture"));
        //textLocation.setText("Text location");
        //huj();
        //textManunufacture.setText(urlImagePart);

        Log.e("---------", "2 onViewCreated");
    }

    public void setUrlImagePart(String urlImagePart) {
        this.urlImagePart = urlImagePart;
    }

    public void setUrlImageManufacture(String urlImageManufacture) {
        this.urlImageManufacture = urlImageManufacture;
    }

    public void setTextManunufacture(String textManunufacture) {
        this.textManunufacture = textManunufacture;
    }

    public void setTextModel(String textModel) {
        this.textModel = textModel;
    }

    public void setTextYears(String textYears) {
        this.textYears = textYears;
    }

    public void setTextDescriprionName(String textDescriprionName) {
        this.textDescriprionName = textDescriprionName;
    }

    public void setTextDescriptionManufacture(String textDescriptionManufacture) {
        this.textDescriptionManufacture = textDescriptionManufacture;
    }

    public void setTextAuctionPlusPrice(String textAuctionPlusPrice) {
        this.textAuctionPlusPrice = textAuctionPlusPrice;
    }

    public void setTextLocation(String textLocation) {
        this.textLocation = textLocation;
    }

    /*    public String addImagePart(String textImagePart){
        this.urlImagePart = textImagePart;
        Log.e("addImagePart", textImagePart);
        Log.e("---------", "3 addImagePart");
//        textManunufacture.setText("Sss");
//        textManunufacture.setText(textImagePart);
*//*        Glide.with(this)
                .load(textImagePart)
                .into(imagePart);*//*
        return textImagePart;
    }

    public void addImageManufacture(String textImageManufacture){
        textManunufacture.setText(textImageManufacture);
*//*        Glide.with(this)
                .load(textImageManufacture)
                .into(imageManufacture);*//*
    }

    private void huj(){
        textYears.setText("Text YEAR HUJJJJ!!!");
    }*/
}
