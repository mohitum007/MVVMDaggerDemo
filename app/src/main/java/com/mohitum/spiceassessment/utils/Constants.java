package com.mohitum.spiceassessment.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static com.mohitum.spiceassessment.utils.Constants.ProductSortBy.ID;
import static com.mohitum.spiceassessment.utils.Constants.ProductSortBy.ORDERS;
import static com.mohitum.spiceassessment.utils.Constants.ProductSortBy.SHARES;
import static com.mohitum.spiceassessment.utils.Constants.ProductSortBy.VIEWS;
import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Constants {

    public static final String INTENT_DATA = "intent_data";

    @Retention(SOURCE)
    @StringDef({ID, VIEWS, ORDERS, SHARES})
    public @interface ProductSortBy {
        String ID = "ID";
        String VIEWS = "Most Viewed Products";
        String ORDERS = "Most OrdeRed Products";
        String SHARES = "Most ShaRed Products";
    }
}
