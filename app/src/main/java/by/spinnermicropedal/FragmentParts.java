package by.spinnermicropedal;


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
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Home911 on 04.01.2018.
 */

public class FragmentParts extends Fragment {

    private ImageView imagePart, imageManufacture;
    private TextView textViewManunufacture, textViewModel, textViewYears, textViewDescriprionName,
            textViewDescriptionManufacture, textViewAuctionPlusPrice, textViewLocation;
    private String urlImagePart, urlImageManufacture,textManunufacture, textModel, textYears,
            textDescriprionName, textDescriptionManufacture, textAuctionPlusPrice, textLocation;


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

        MultiTransformation multiTransformation = new MultiTransformation(
                new CropTransformation(360, 270, CropTransformation.CropType.CENTER),
                new RoundedCornersTransformation(5, 0));



        Glide.with(this)
                .load(urlImagePart)
                //.centerCrop()
                //.error(R.drawable.ic_visibility_off_black_48dp)
                .apply(RequestOptions.bitmapTransform(multiTransformation))
                .into(imagePart);

        MultiTransformation multiTransformation1 = new MultiTransformation(
                new CropTransformation(50, 50, CropTransformation.CropType.CENTER),
                new RoundedCornersTransformation(5, 0));

        Glide.with(this)
                .load(urlImageManufacture)
                //.centerCrop()
                //.error(R.drawable.ic_visibility_off_black_48dp)
                .apply(RequestOptions.bitmapTransform(multiTransformation1))
                .into(imageManufacture);

        textViewManunufacture.setText(textManunufacture);
        textViewModel.setText(textModel);
        textViewYears.setText(textYears);
        textViewDescriprionName.setText(textDescriprionName);
        textViewDescriptionManufacture.setText(textDescriptionManufacture);
        textViewAuctionPlusPrice.setText(textAuctionPlusPrice);
        textViewLocation.setText(textLocation);

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


}
