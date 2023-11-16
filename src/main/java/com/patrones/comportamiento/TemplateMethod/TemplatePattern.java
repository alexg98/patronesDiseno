package com.patrones.comportamiento.TemplateMethod;

abstract class CrearProteccion {
	public Proteccion proteccion;
	
	abstract void validacionAuditoria();
	abstract void registrarProteccion();
	abstract void generarFlujo();
	abstract void notificarRegistro();

	public final void crear(){
		validacionAuditoria();
		registrarProteccion();
		generarFlujo();
		notificarRegistro();
	}
}

class Proteccion{ }

class VidaClasica extends CrearProteccion {

	@Override
	void validacionAuditoria() {
		System.out.println("Ejecutar validacion propias de Vida clasico");
	}

	@Override
	void registrarProteccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void generarFlujo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void notificarRegistro() {
		// TODO Auto-generated method stub
		
	}

	
}

class AccidentesPersonales extends CrearProteccion {

	@Override
	void validacionAuditoria() {
		System.out.println("Ejecutar validacion propias de accidentes personales");		
	}

	@Override
	void registrarProteccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void generarFlujo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void notificarRegistro() {
		// TODO Auto-generated method stub
		
	}

	
}

class TemplatePattern {
	public static void main(String[] args) {

		VidaClasica vc = new VidaClasica();
		vc.crear();
		
		AccidentesPersonales ap = new AccidentesPersonales();
		ap.crear();
	}
}
