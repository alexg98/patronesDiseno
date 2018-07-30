package com.patrones.comportamiento.ChainOfResponsibility;
/**
 * El patrón de diseño Chain of Responsability es un patrón de comportamiento que evita acoplar el 
 * emisor de una petición a su receptor dando a más de un objeto la posibilidad de responder a una 
 * petición. Para ello, se encadenan los receptores y pasa la petición a través de la cadena hasta 
 * que es procesada por algún objeto. Este patrón es utilizado a menudo en el contexto de las interfaces 
 * gráficas de usuario donde un objeto puede estar compuesto de varios objetos (que generalmente 
 * heredan de una super clase "vista"). No se debe confundir con el patrón Composite (patrón de diseño) 
 * que se basa en un concepto similar. 
 */
class ChainOfResponsibilityPattern {

	public static void main(String argv[]) {
		ChainOfResponsibility smith  = new Coronel("Smith", null);
		ChainOfResponsibility truman = new Coronel("Truman", "Tomar posición enemiga");
		ChainOfResponsibility ryan   = new Soldado("Ryan");
		ChainOfResponsibility rambo  = new Soldado("Rambo");
		System.out.println(rambo.orden());  
		rambo.establecerMando(truman);		
		System.out.println(rambo.orden());		
		ryan.establecerMando(rambo);
		System.out.println(ryan.orden());
	}
}

class ChainOfResponsibility {

	private ChainOfResponsibility _mando;
	private String _nombre;

	public ChainOfResponsibility(String nombre) { 
		_mando = null; 
		_nombre = nombre;
	}

	public String toString() { return _nombre; }

	public void establecerMando(ChainOfResponsibility mando){ 
		_mando = mando; 
	}

	public String orden() {
		return _mando != null ? _mando.orden() : "(sin orden)"; 
	}
}

class Coronel extends ChainOfResponsibility {

	public Coronel(String nombre, String orden) {
		super(nombre);
		_orden = orden;
	}

	public String orden(){ 
		return _orden != null ? _orden : super.orden(); 
	}

	public String toString() { 
		return ("Coronel " + super.toString()); 
	}

	private String _orden;
}

class Soldado extends ChainOfResponsibility {

	public Soldado(String nombre) {
		super(nombre);
	}    
	public String toString() { 
		return ("Soldado " + super.toString()); 
	}
}
