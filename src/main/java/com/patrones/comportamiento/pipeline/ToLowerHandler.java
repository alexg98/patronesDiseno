package com.patrones.comportamiento.pipeline;

public class ToLowerHandler implements Handler<String,String>{
    @Override
    public String process(String input) {
        return input.toLowerCase();
    }
}
