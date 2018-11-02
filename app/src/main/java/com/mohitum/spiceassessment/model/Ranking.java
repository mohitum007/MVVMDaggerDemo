
package com.mohitum.spiceassessment.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ranking implements Parcelable
{

    @SerializedName("ranking")
    @Expose
    private String ranking;
    @SerializedName("products")
    @Expose
    private List<Product_> products = null;
    public final static Creator<Ranking> CREATOR = new Creator<Ranking>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Ranking createFromParcel(Parcel in) {
            return new Ranking(in);
        }

        public Ranking[] newArray(int size) {
            return (new Ranking[size]);
        }

    }
    ;

    protected Ranking(Parcel in) {
        this.ranking = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.products, (com.mohitum.spiceassessment.model.Product_.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ranking() {
    }

    /**
     * 
     * @param products
     * @param ranking
     */
    public Ranking(String ranking, List<Product_> products) {
        super();
        this.ranking = ranking;
        this.products = products;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<Product_> getProducts() {
        return products;
    }

    public void setProducts(List<Product_> products) {
        this.products = products;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ranking);
        dest.writeList(products);
    }

    public int describeContents() {
        return  0;
    }

}
