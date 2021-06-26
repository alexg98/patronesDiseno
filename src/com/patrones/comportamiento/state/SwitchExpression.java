package co.com.bancolombia.model.utils.switchexpression;

import java.util.function.Function;

public interface SwitchExpression <T, R> extends Function<T, R>{

  R resolve(T value);

  R resolve();
}
