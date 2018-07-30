package com.patrones.comportamiento.strategy;
/*
 * El patrón Estrategia (Strategy) es un patrón de diseño para el desarrollo de software. 
 * Se clasifica como patrón de comportamiento porque determina cómo se debe realizar el 
 * intercambio de mensajes entre diferentes objetos para resolver una tarea. El patrón 
 * estrategia permite mantener un conjunto de algoritmos de entre los cuales el objeto cliente 
 * puede elegir aquel que le conviene e intercambiarlo dinámicamente según sus necesidades.
 * https://es.wikipedia.org/wiki/Strategy_(patr%C3%B3n_de_dise%C3%B1o)
 */
public class StrategyPattern {

	public static void main(String args[]){
		//Usamos la estrategia A
		Strategy estrategia_inicial = new StrategyA();
		Context context = new Context(estrategia_inicial);
		context.some_method();

		//Decidimos usar la estrategia B
		Strategy estrategia2 = new StrategyB();
		context.setStrategy(estrategia2);
		context.some_method();

		//Finalmente,usamos de nuevo la estrategia A
		context.setStrategy(estrategia_inicial);
		context.some_method();

		/** Salida:
		 * Estrategia A
		 * Estrategia B
		 * Estrategia A
		 **/
	}
}

class Context {
	Strategy c;

	public Context( Strategy c )
	{
		this.c = c;
	}

	public void setStrategy(Strategy c) {
		this.c = c;
	}
	
	//Método de estrategia 'c'
	public void some_method()
	{
		c.behaviour();
	}
}

interface Strategy{
       public void behaviour();
} 

class StrategyA implements Strategy{
	@Override
	public void behaviour() {
		System.out.println("Estrategia A");
	}
}

class StrategyB implements Strategy{
	@Override
	public void behaviour() {
		System.out.println("Estrategia B");
	}
}