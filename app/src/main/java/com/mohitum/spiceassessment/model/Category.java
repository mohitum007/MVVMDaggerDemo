
package com.mohitum.spiceassessment.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("child_categories")
    @Expose
    private List<Integer> childCategories = null;
    public final static Creator<Category> CREATOR = new Creator<Category>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        public Category[] newArray(int size) {
            return (new Category[size]);
        }

    }
    ;

    protected Category(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.products, (Product.class.getClassLoader()));
        in.readList(this.childCategories, (Integer.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category() {
    }

    /**
     * 
     * @param childCategories
     * @param id
     * @param name
     * @param products
     */
    public Category(int id, String name, List<Product> products, List<Integer> childCategories) {
        super();
        this.id = id;
        this.name = name;
        this.products = products;
        this.childCategories = childCategories;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Integer> childCategories) {
        this.childCategories = childCategories;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeList(products);
        dest.writeList(childCategories);
    }

    public int describeContents() {
        return  0;
    }

}
