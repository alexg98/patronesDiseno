package com.patrones.comportamiento.pipeline;

public interface Handler<R,T> {
    T process(R input);
}
