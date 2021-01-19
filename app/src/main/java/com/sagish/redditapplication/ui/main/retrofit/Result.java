package com.sagish.redditapplication.ui.main.retrofit;

import androidx.annotation.Nullable;

public class Result<T> {

    public enum Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    private T data;

    private String message;

    private Status status;

    public Result(@Nullable T data, @Nullable String message, Status status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public static class Success<T> extends Result<T> {

        public Success(T data) {
            super(data, null, Status.SUCCESS);
        }
    }

    public static class Loading extends Result {

        public Loading() {
            super(null, null, Status.LOADING);
        }
    }

    public static class Error extends Result {

        public Error(@Nullable String message) {
            super(null, message, Status.ERROR);
        }
    }
}
