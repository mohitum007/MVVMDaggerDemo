
package com.mohitum.spiceassessment.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("size")
    @Expose
    private Object size;
    @SerializedName("price")
    @Expose
    private double price;
    public final static Creator<Variant> CREATOR = new Creator<Variant>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Variant createFromParcel(Parcel in) {
            return new Variant(in);
        }

        public Variant[] newArray(int size) {
            return (new Variant[size]);
        }

    }
    ;

    protected Variant(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.size = ((Object) in.readValue((Object.class.getClassLoader())));
        this.price = ((double) in.readValue((int.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Variant() {
    }

    /**
     * 
     * @param id
     * @param price
     * @param color
     * @param size
     */
    public Variant(int id, String color, Object size, double price) {
        super();
        this.id = id;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(color);
        dest.writeValue(size);
        dest.writeValue(price);
    }

    public int describeContents() {
        return  0;
    }

}
