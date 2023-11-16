package com.patrones.estructurales.facade;

class Impresora {

	private String tipoDocumento;
	private String hoja;
	private boolean color;
	private String texto;

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setHoja(String hoja) {
		this.hoja = hoja;
	}

	public String getHoja() {
		return hoja;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public boolean getColor() {
		return color;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void imprimir() {
		//impresora.imprimirDocumento();
	}
}

class FachadaImpresoraNormal {

	Impresora impresora;

	public FachadaImpresoraNormal(String texto) {
		super();
		impresora= new Impresora();
		impresora.setColor(true);
		impresora.setHoja("A4");
		impresora.setTipoDocumento("PDF");
		impresora.setTexto(texto);
	}

	public void imprimir() {
		//impresora.imprimirDocumento();
	}
}

public class Facade {

}
