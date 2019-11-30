package com.luxoft.it.emailservice.services.producers;

public interface IProducer<T> {
    void produce(T message);
}
