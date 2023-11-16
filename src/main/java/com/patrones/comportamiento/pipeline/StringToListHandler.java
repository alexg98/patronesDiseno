package com.patrones.comportamiento.pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToListHandler implements Handler<String, List<Character>> {
    @Override
    public List<Character> process(String input) {
        return Arrays.stream(input.split(""))
                .map(str -> str.charAt(0))
                .collect(Collectors.toList());
    }
}
