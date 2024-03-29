package com.patrones.comportamiento.state;

import java.util.function.Function;

public interface SwitchDefaultCase <T,R>{
  SwitchStep<T, R> defaultCase(Function<T, R> function);
}