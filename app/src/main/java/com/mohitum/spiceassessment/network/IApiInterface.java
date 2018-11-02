package com.mohitum.spiceassessment.network;

import com.mohitum.spiceassessment.model.JsonWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IApiInterface {

    @GET(Urls.FETCH_JSON)
    Observable<JsonWrapper> fetchJsonData();
}
