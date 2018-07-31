package com.patrones.estructurales.decorator;

interface Automovil {
	void aceel();
	void stop();
	void start();
}

class CarroEstandar implements Automovil{

	private String nombre;
	
	public CarroEstandar(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void aceel() {
		System.out.println("acelerar");
	}

	@Override
	public void stop() {
		System.out.println("stop");		
	}

	@Override
	public void start() {
		System.out.println("start");		
	}	
}

abstract class AutomovilDecorador implements Automovil{
	private Automovil auto;

	public AutomovilDecorador(Automovil auto) {
		this.auto = auto;
	}
	
	protected Automovil getAuto() {
		return auto;
	}	
}

class AutoElectricoFeature extends AutomovilDecorador{

	public AutoElectricoFeature(Automovil auto) {
		super(auto);
	}

	@Override
	public void aceel() {
		getAuto().aceel();
		System.out.println("Extension Aceel");
	}

	@Override
	public void stop() {
		getAuto().stop();
		System.out.println("Extension stop");
	}

	@Override
	public void start() {
		getAuto().start();
		System.out.println("Extension start");
	}
	
}

public class DecoratorPattern {
	
	public static void main(String...s) {
		Automovil carro = new CarroEstandar("chevy");
		carro = new AutoElectricoFeature(carro);
		carro.start();
		carro.aceel();
		carro.stop();
	}
	
}
