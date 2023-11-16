package com.patrones.comportamiento.state;

import java.util.function.Function;
import java.util.function.Predicate;


public interface SwitchStep <T,R>{

  SwitchStep<T, R> single(T value, Function<T, R> function);
  
  SwitchStep<T, R> predicate(Predicate<T> predicate, Function<T, R> function);

  SwitchExpression<T, R> build();
}