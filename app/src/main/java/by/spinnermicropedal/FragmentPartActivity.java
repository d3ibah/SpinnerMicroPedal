package by.spinnermicropedal;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * Created by Home911 on 08.01.2018.
 */

public class FragmentPartActivity extends FragmentActivity {

    String urlPart, urlManufacture, nameManufacture, nameModel, stringYears, namePart, namePartManufacture, stringPrice, stringLocation;
    boolean isAuction;
    Intent intent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_part);



        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentParts fragmentParts = new FragmentParts();
        fragmentTransaction.add(R.id.containerFragment, fragmentParts);
        getIntentFromPartsActivity();
        addDataAtFragment(fragmentParts);
//        fragmentParts.addImagePart(urlPart);
//        fragmentParts.addImageManufacture(urlManufacture);
        fragmentTransaction.commit();

/*        if(fragmentParts != null && fragmentParts.isInLayout()){
            fragmentParts.addImagePart(urlPart);
        }*/


    }

    private void getIntentFromPartsActivity(){
        intent = getIntent();
        urlPart = intent.getStringExtra("urlPart");
        urlManufacture = intent.getStringExtra("urlManufacture");
        nameManufacture = intent.getStringExtra("nameManufacture");
        nameModel = intent.getStringExtra("nameModel");
        stringYears = intent.getStringExtra("stringYears");
        namePart = intent.getStringExtra("namePart");
        namePartManufacture = intent.getStringExtra("namePartManufacture");
        isAuction = intent.getBooleanExtra("isAuction", false);
        stringPrice = intent.getStringExtra("stringPrice");
        stringLocation = intent.getStringExtra("stringLocation");
    }

    private void addDataAtFragment(FragmentParts fragmentParts){
        fragmentParts.setUrlImagePart(urlPart);
        fragmentParts.setUrlImageManufacture(urlManufacture);
        fragmentParts.setTextManunufacture(nameManufacture);
        fragmentParts.setTextModel(nameModel);
        fragmentParts.setTextYears(stringYears);
        fragmentParts.setTextDescriprionName(namePart);
        fragmentParts.setTextDescriptionManufacture(namePartManufacture);

        fragmentParts.setTextAuctionPlusPrice(stringPrice);
        fragmentParts.setTextLocation(stringLocation);
    }
}















