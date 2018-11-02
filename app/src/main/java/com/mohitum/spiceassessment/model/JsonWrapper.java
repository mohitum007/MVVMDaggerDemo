
package com.mohitum.spiceassessment.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonWrapper implements Parcelable
{

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("rankings")
    @Expose
    private List<Ranking> rankings = null;
    public final static Creator<JsonWrapper> CREATOR = new Creator<JsonWrapper>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JsonWrapper createFromParcel(Parcel in) {
            return new JsonWrapper(in);
        }

        public JsonWrapper[] newArray(int size) {
            return (new JsonWrapper[size]);
        }

    }
    ;

    protected JsonWrapper(Parcel in) {
        in.readList(this.categories, (Category.class.getClassLoader()));
        in.readList(this.rankings, (Ranking.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public JsonWrapper() {
    }

    /**
     * 
     * @param rankings
     * @param categories
     */
    public JsonWrapper(List<Category> categories, List<Ranking> rankings) {
        super();
        this.categories = categories;
        this.rankings = rankings;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(categories);
        dest.writeList(rankings);
    }

    public int describeContents() {
        return  0;
    }

}
