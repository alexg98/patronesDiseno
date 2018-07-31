package com.patrones.creacional.factorymethod;

public class FactoryPatternWithJava8 {
	
	public static void main(String...s) {
		double importe = 10000.0;
		TipoIva iva = FactoriaIVA.getInstance("Iva");
		iva.calcular(importe);
	}
}

@FunctionalInterface
interface TipoIva {
    
    public double calcular(double importe);
 
    public static double IVANormal(double importe) { 
        return importe * 1.21; 
    }
 
    public static double IVAReducido(double importe) { 
        return importe * 1.07; 
    }
}

class FactoriaIVA {	 
    public static  TipoIva getInstance(String tipo) {
        if (tipo.equals("IvaReducido")) {             
            return TipoIva::IVAReducido;
        }else {
            return TipoIva::IVANormal;
        }
    }     
}