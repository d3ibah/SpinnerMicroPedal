package by.spinnermicropedal.internet;

import java.util.List;

import by.spinnermicropedal.internet.get.Categories;
import by.spinnermicropedal.internet.get.ChildByCategory;
import by.spinnermicropedal.internet.get.Filter;
import by.spinnermicropedal.internet.get.Manufacture;
import by.spinnermicropedal.internet.get.ModelsByManufacture;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Home911 on 09.12.2017.
 */

public interface RestApi {

    @GET("cars/manufactures")
    Observable<List<Manufacture>> getManufactures();

    @GET("cars/manufacture/{id}/models")
    Observable<List<ModelsByManufacture>> getModelsByManufacture(@Path("id") String manufactureId);

    @GET("categories")
    Observable<List<Categories>> getCategories();

    @GET("category/{id}/child")
    Observable<List<ChildByCategory>> getChildByCategogy(@Path("id") String categoryId);

    @GET("adverts/part/filter")
    Observable<List<Filter>> getFilterByManufactureId(@Query("manufacture_id") String manufactureId);

    @GET("adverts/part/filter")
    Observable<List<Filter>> getFilterByModelId(@Query("model_id") String modelId);

}
