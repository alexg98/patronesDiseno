package com.patrones.estructurales.decorator;

public class App {
	public static void main(String[] args) {
		Cuenta x = new Cuenta(1, "cliente");
		ICuentaBancaria cuenta = new CuentaAhorros();
		ICuentaBancaria cuentaBlindada = new BlindajeDecorador(cuenta);
		cuentaBlindada.abrirCuenta(x);
	}	
}

class Cuenta{
	int id;
	String cliente;
	public Cuenta(int id, String cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
	}
}

interface ICuentaBancaria {
	void abrirCuenta(Cuenta cuenta);
}

class CuentaAhorros implements ICuentaBancaria{
	@Override
	public void abrirCuenta(Cuenta cuenta) {
		System.out.println("Abrir cuenta ahorros "+cuenta.cliente);
	}	
}

class cuentaCorriente implements ICuentaBancaria{
	@Override
	public void abrirCuenta(Cuenta cuenta) {
		System.out.println("Abrir cuenta corriente "+cuenta.cliente);
	}	
}

abstract class CuentaDecorador implements ICuentaBancaria{
	protected ICuentaBancaria cuentaDecorador;

	public CuentaDecorador(ICuentaBancaria cuentaDecorador) {
		super();
		this.cuentaDecorador = cuentaDecorador;
	}
	public void abrirCuenta(Cuenta cuenta) {
		this.cuentaDecorador.abrirCuenta(cuenta);
	}	
}
class BlindajeDecorador extends CuentaDecorador{

	public BlindajeDecorador(ICuentaBancaria cuentaDecorador) {
		super(cuentaDecorador);
	}
	
	public void abrirCuenta(Cuenta cuenta) {
		cuentaDecorador.abrirCuenta(cuenta);
		metodoExtendido(cuenta);
	}
	
	public void metodoExtendido(Cuenta cuenta) {
		System.out.println("Extension de cuenta");
	}
	
}