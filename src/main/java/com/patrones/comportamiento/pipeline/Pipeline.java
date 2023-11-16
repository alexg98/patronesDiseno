package com.patrones.comportamiento.pipeline;

public class Pipeline<I,O> {

    private final Handler<I,O> currentHandler;

    public Pipeline(Handler<I, O> handler) {
        this.currentHandler = handler;
    }

    <K> Pipeline<I,K> addHandler(Handler<O,K> newHandler){
        return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    public O execute(I input){
        return currentHandler.process(input);
    }
}