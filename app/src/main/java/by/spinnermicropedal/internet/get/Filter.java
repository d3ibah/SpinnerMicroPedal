package by.spinnermicropedal.internet.get;



import com.google.gson.annotations.SerializedName;

import by.spinnermicropedal.internet.get.filter.CarManufacture;
import by.spinnermicropedal.internet.get.filter.CarModel;
import by.spinnermicropedal.internet.get.filter.Category;
import by.spinnermicropedal.internet.get.filter.Description;
import by.spinnermicropedal.internet.get.filter.Location;
import by.spinnermicropedal.internet.get.filter.ParentCategory;
import by.spinnermicropedal.internet.get.filter.Price;


/**
 * Created by Home911 on 14.12.2017.
 */

public class Filter {

    private String id;
    private String image;
    private String slug;
    private Location location;
    private Boolean auction;
    private String createdAt;
    private Description description;
    private Price price;
    private Integer carCompCount;
    @SerializedName("parent_category")
    private ParentCategory parentCategory;
    private Category category;
    private CarManufacture carManufacture;
    private CarModel carModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getAuction() {
        return auction;
    }

    public void setAuction(Boolean auction) {
        this.auction = auction;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Integer getCarCompCount() {
        return carCompCount;
    }

    public void setCarCompCount(Integer carCompCount) {
        this.carCompCount = carCompCount;
    }

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CarManufacture getCarManufacture() {
        return carManufacture;
    }

    public void setCarManufacture(CarManufacture carManufacture) {
        this.carManufacture = carManufacture;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }
}
