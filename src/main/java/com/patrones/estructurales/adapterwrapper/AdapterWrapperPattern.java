package com.patrones.estructurales.adapterwrapper;
/**
 *  Arquitectura-> 
 *  
 *  patrones 
 *  
 *  soa
 *  
 *  20 preguntas abiertas
 *  
 *  caso de negocio -> ejemplos practicos
 *  -------------------------------------
 *  Abreviatura de aruitectura
 *  
 *  -------------------------------------
 *  patrones uml
 *  
 *  conceptos basico
 *  
 *  arquitecturas de referencia ***
 *  -- tres capas mvc
 *  -- soa
 *  -- bpm
 *  -- progrmacion rectiva
 *  -- single page   
 *   
 *  computacion en la nube
 *   
 *  Inteligencia artificial
 *   
 *  programacion reactiva
 *   
 *  uml 
 *   
 *  caso de negocio, pintar la aruitectura
 *       
 *  diagrama de componentes
 *   
 *  tipo de mensajeria
 *   
 *  arquitecturas
 *   
 *   
 *    
 *  expliue la arquitetura soa diagrama
 *    
 *  Ques es programacion reactiva
 *    
 *  Que es servlet
 *    
 *  Machine learnig
 *  
 *  pintar (*)  
 *  
 *  Lunes ->
 *  
 *  Carlos renteria :
 *  
 *  El patrón adaptador (adapter) se utiliza para transformar una interfaz en otra, de tal 
 *  modo que una clase que no pueda utilizar la primera haga uso de ella a través de la segunda.    
 *      
 */


public class AdapterWrapperPattern {

	public static void main(String args[]){
		Guitar eGuitar = new ElectricGuitar();
		eGuitar.onGuitar();
		eGuitar.offGuitar();
		
		Guitar eAGuitar = new ElectricAcousticGuitar();
		eAGuitar.onGuitar();
		eAGuitar.offGuitar();
	}
}	

// Target
abstract class Guitar{
	abstract public void onGuitar();
	abstract public void offGuitar();
}

class ElectricGuitar extends Guitar{

	public void onGuitar() {
		System.out.println("Playing Guitar");
	}

	public void offGuitar() {
		System.out.println("I'm tired to play the guitar");
	}
}

/**
 * Class to Adapter/Wrapper 
 */
class AcousticGuitar{

	public void play(){
		System.out.println("Playing Guitar");
	}
	public void leaveGuitar(){
		System.out.println("I'm tired to play the guitar");
	}
}
/**
 * we Adapter/Wrapper AcousticGuitar into 
 * ElectricAcousticGuitar to adapt into the GuitarModel
 */
class ElectricAcousticGuitar extends Guitar{
	AcousticGuitar acoustic = new AcousticGuitar();

	public void onGuitar() {
		acoustic.play();
	}

	public void offGuitar() {
		acoustic.leaveGuitar();
	}
}