package com.mohitum.spiceassessment.dagger;

import com.mohitum.spiceassessment.model.JsonWrapper;
import com.mohitum.spiceassessment.model.Product;
import com.mohitum.spiceassessment.network.IApiInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class Repository {

    public static List<Product> PRODUCTS = new ArrayList<>();

    private IApiInterface apiInterface;

    public Repository(IApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    /*
     * method to call login api
     * */
    public Observable<JsonWrapper> executeFetchJson() {
        return apiInterface.fetchJsonData();
    }

    public static Product getFullProduct(Product product) {
        for (Product p : PRODUCTS) {
            if (p.getId() == product.getId()) {
                return p;
            }
        }
        return product;
    }
}
