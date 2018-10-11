package com.icash.provider;

public interface ProviderHandler<T> {
    void handle(T data);
}
