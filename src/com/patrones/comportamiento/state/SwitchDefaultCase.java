package co.com.bancolombia.model.utils.switchexpression;

import java.util.function.Function;

public interface SwitchDefaultCase <T,R>{
  SwitchStep<T, R> defaultCase(Function<T, R> function);
}