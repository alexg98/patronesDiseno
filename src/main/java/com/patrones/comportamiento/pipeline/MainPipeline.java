package com.patrones.comportamiento.pipeline;

import java.util.Objects;
import java.util.function.Function;

public class MainPipeline {

    static Function<String,String> addPostFix = str -> str.concat("___");

    static class Area {
        Area(Double area){
            this.area = area;
        }
        Double area;
    }


    public static void main(String[] args) {

        var value = new Pipeline<String, Integer>(Integer::valueOf)
                .addHandler(Integer::doubleValue)
                .addHandler(doble -> doble * 3.14)
                .addHandler(Area::new)
                .execute("1");


       new Pipeline<>(new RemoveNumericHandler())
                .addHandler(new ToLowerHandler())
                .addHandler("____"::concat)
                .addHandler(str -> addPostFix.apply(str))
                .addHandler(MainPipeline::addCharacter)
                .addHandler(new StringToListHandler())
                .execute("Pooo1234jutPor3455")
               .forEach(System.out::print);

    }

    public static String addCharacter(String input){
        return input.concat("@");
    }
}
