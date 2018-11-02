package com.mohitum.spiceassessment.network;

import com.mohitum.spiceassessment.model.JsonWrapper;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

import static com.mohitum.spiceassessment.network.Status.ERROR;
import static com.mohitum.spiceassessment.network.Status.LOADING;
import static com.mohitum.spiceassessment.network.Status.SUCCESS;

public class ApiResponse {

    public final Status status;

    @Nullable
    public final JsonWrapper data;

    @Nullable
    public final Throwable error;

    private ApiResponse(Status status, @Nullable JsonWrapper data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static ApiResponse success(@NonNull JsonWrapper data) {
        return new ApiResponse(SUCCESS, data, null);
    }

    public static ApiResponse error(@NonNull Throwable error) {
        return new ApiResponse(ERROR, null, error);
    }

}
