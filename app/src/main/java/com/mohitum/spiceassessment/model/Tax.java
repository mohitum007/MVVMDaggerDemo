
package com.mohitum.spiceassessment.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private double value;
    public final static Creator<Tax> CREATOR = new Creator<Tax>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Tax createFromParcel(Parcel in) {
            return new Tax(in);
        }

        public Tax[] newArray(int size) {
            return (new Tax[size]);
        }

    }
    ;

    protected Tax(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.value = ((int) in.readValue((int.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tax() {
    }

    /**
     * 
     * @param name
     * @param value
     */
    public Tax(String name, int value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(value);
    }

    public int describeContents() {
        return  0;
    }

}
