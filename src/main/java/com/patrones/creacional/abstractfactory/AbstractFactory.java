package com.patrones.creacional.abstractfactory;

/**
 * 
 * Contexto: Debemos crear diferentes objetos, todos pertenecientes a la misma familia. 
 * Por ejemplo: las bibliotecas para crear interfaces gráficas suelen utilizar este patrón y 
 * cada familia sería un sistema operativo distinto. Así pues, el usuario declara un Botón, 
 * pero de forma más interna lo que está creando es un BotónWindows o un BotónLinux, por ejemplo.
 * El problema que intenta solucionar este patrón es el de crear diferentes familias de objetos.
 * El patrón Abstract Factory está aconsejado cuando se prevé la inclusión de nuevas familias de 
 * productos, pero puede resultar contraproducente cuando se añaden nuevos productos o cambian 
 * los existentes, puesto que afectaría a todas las familias creadas.
 * https://es.wikipedia.org/wiki/Abstract_Factory
 * @author alexg
 *
 */

//Interfaz ProductoA
abstract class CPU {}

//ProductoA1 Concreto
class EmberCPU extends CPU {}

//ProductoA2 Concreto
class EnginolaCPU extends CPU {}

//Interfaz ProductoB
abstract class MMU {}

//ProductoB1 Concreto
class EmberMMU extends MMU {}

////ProductoA1 Concreto
class EnginolaMMU extends MMU {}

//Factoria concreta 1
class EmberToolkit extends AbstractFactory {
	@Override
	public CPU createCPU() {
		return new EmberCPU();
	}

	@Override
	public MMU createMMU() {
		return new EmberMMU();
	}
}

//Factoria concreta 2
class EnginolaToolkit extends AbstractFactory {
	@Override
	public CPU createCPU() {
		return new EnginolaCPU();
	}

	@Override
	public MMU createMMU() {
		return new EnginolaMMU();
	}
}

enum Architecture {
	ENGINOLA, EMBER
}

//Abstract Factory
abstract class AbstractFactory {
	
	private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
	private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

	// Returns a concrete factory object that is an instance of the
	// concrete factory class appropriate for the given architecture.
	static AbstractFactory getFactory(Architecture architecture) {
		AbstractFactory factory = null;
		switch (architecture) {
		case ENGINOLA:
			factory = ENGINOLA_TOOLKIT;
			break;
		case EMBER:
			factory = EMBER_TOOLKIT;
			break;
		}
		return factory;
	}

	public abstract CPU createCPU();
	public abstract MMU createMMU();
}