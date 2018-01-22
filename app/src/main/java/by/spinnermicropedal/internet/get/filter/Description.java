package by.spinnermicropedal.internet.get.filter;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Home911 on 14.12.2017.
 */

public class Description {

    private String name;
    @SerializedName("is_news")
    private Boolean isNews;
    private String manufacture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNews() {
        return isNews;
    }

    public void setNews(Boolean news) {
        isNews = news;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
