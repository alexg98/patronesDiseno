package com.patrones.comportamiento.pipeline;

public class RemoveNumericHandler implements Handler<String,String>{

    @Override
    public String process(String input) {
        return input.replaceAll("\\d","");
    }
}
