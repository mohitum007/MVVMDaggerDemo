
package com.mohitum.spiceassessment.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product_ implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("view_count")
    @Expose
    private int viewCount;
    @SerializedName("order_count")
    @Expose
    private int orderCount;
    @SerializedName("shares")
    @Expose
    private int shares;
    public final static Creator<Product_> CREATOR = new Creator<Product_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product_ createFromParcel(Parcel in) {
            return new Product_(in);
        }

        public Product_[] newArray(int size) {
            return (new Product_[size]);
        }

    }
    ;

    protected Product_(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.viewCount = ((int) in.readValue((int.class.getClassLoader())));
        this.orderCount = ((int) in.readValue((int.class.getClassLoader())));
        this.shares = ((int) in.readValue((int.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product_() {
    }

    /**
     * 
     * @param shares
     * @param id
     * @param orderCount
     * @param viewCount
     */
    public Product_(int id, int viewCount, int orderCount, int shares) {
        super();
        this.id = id;
        this.viewCount = viewCount;
        this.orderCount = orderCount;
        this.shares = shares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(viewCount);
        dest.writeValue(orderCount);
        dest.writeValue(shares);
    }

    public int describeContents() {
        return  0;
    }

}
