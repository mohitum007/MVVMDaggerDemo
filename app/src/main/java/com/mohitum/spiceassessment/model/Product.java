
package com.mohitum.spiceassessment.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("variants")
    @Expose
    private List<Variant> variants = null;
    @SerializedName("tax")
    @Expose
    private Tax tax;
    public final static Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    }
    ;

    protected Product(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.dateAdded = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.variants, (com.mohitum.spiceassessment.model.Variant.class.getClassLoader()));
        this.tax = ((Tax) in.readValue((Tax.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product() {
    }

    /**
     * 
     * @param id
     * @param tax
     * @param name
     * @param variants
     * @param dateAdded
     */
    public Product(int id, String name, String dateAdded, List<Variant> variants, Tax tax) {
        super();
        this.id = id;
        this.name = name;
        this.dateAdded = dateAdded;
        this.variants = variants;
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(dateAdded);
        dest.writeList(variants);
        dest.writeValue(tax);
    }

    public int describeContents() {
        return  0;
    }

}
