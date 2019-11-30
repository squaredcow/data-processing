package com.luxoft.it.emailservice.services.consumers;

public interface IConsumer<T> {
    void consume(T message);
}
