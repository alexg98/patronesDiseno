package com.patrones.comportamiento.strategy;

public class StrategyPatternWithJava8 {
	public static void main() {
		
		double price = 100;
        PaymentStrategy paymentStratgy = PaymentStrategy.cashPayment();
        System.out.println("Cash Price: - " + paymentStratgy.pay(price));

        paymentStratgy = PaymentStrategy.creditCardPayment();
        System.out.println("Credit Card Price: - " + paymentStratgy.pay(price));
	}
}

/**
 * Patron estrategia usando programacion funcional Lambdas Java 8
 * @author alexg
 *
 */
@FunctionalInterface
interface PaymentStrategy {

    double pay(double amount);

    static PaymentStrategy cashPayment(){
        double serviceCharge = 5.00;
        return amount -> amount + serviceCharge;
    }

    static PaymentStrategy creditCardPayment(){
        double serviceCharge = 5.00;
        double creditCardFee = 10.00;
        return amount -> amount + serviceCharge + creditCardFee;
    }    
}
