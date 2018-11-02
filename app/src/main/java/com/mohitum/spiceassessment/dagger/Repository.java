package com.mohitum.spiceassessment.dagger;

import com.mohitum.spiceassessment.model.JsonWrapper;
import com.mohitum.spiceassessment.network.IApiInterface;

import io.reactivex.Observable;

public class Repository {

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

}
