package com.patrones.creacional.abstractfactory;

public class Main {
	public static void main(String[] args) {
		AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
		CPU cpu = factory.createCPU();
		MMU mmu = factory.createMMU();
	}
}
