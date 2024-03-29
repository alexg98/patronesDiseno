package com.patrones.comportamiento.state;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;

public class Switch<T, R> implements SwitchDefaultCase<T, R>, SwitchStep<T, R>, SwitchExpression<T, R>{

	private Function<T, R> defaultCase;

	private T value;

	private Map<T, Function<T, R>> singleValuefunctions = new LinkedHashMap<>();

	private List<Entry<Predicate<T>, Function<T, R>>> predicates = new LinkedList<>();

	private Switch(){}

	public static <T, R> SwitchDefaultCase<T, R> of(T value, Class<R> clazz){
		Switch<T, R> switchExpression = new Switch<>();
		switchExpression.value = value;
		return switchExpression;
	}

	public static <T, R> SwitchDefaultCase<T, R> start(){ //TODO eliminar
		return new Switch<>();
	}

	@Override
	public SwitchStep<T, R> defaultCase(Function<T, R> function){
		this.defaultCase = function;
		return this;
	}

	@Override
	public R resolve(){
		return singleValuefunctions.containsKey(value) ? singleValuefunctions.get(value).apply(value) : findAndApplyFirstPredicate();
	}

	@Override
	public R resolve(T value){
		this.value = value;
		return resolve();
	}

	@Override
	public R apply(T value){
		return resolve(value);
	}

	@Override
	public SwitchExpression<T, R> build(){
		return this;
	}	

	private R findAndApplyFirstPredicate(){
		for (Entry<Predicate<T>, Function<T, R>> e : predicates){
			if (e.getKey().test(value)){
				return e.getValue().apply(value);
			}
		}
		return this.defaultCase.apply(value);
	}

	@Override
	public SwitchStep<T, R> single(T value, Function<T, R> function){
		singleValuefunctions.put(value, function);
		return this;
	}

	@Override
	public SwitchStep<T, R> predicate(Predicate<T> predicate, Function<T, R> function){
		SimpleEntry<Predicate<T>, Function<T, R>> simpleEntry = new SimpleEntry<>(predicate, function);
		predicates.add(simpleEntry);
		return this;
	}
}
