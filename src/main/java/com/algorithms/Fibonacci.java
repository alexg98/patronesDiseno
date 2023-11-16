package com.algorithms;

public class Fibonacci {

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            fibonacciIter(i);
        }
    }

    private static void fibonacciIter(int num){
        int n1 = 0, n2 = 1, n = 0;
        for (int i = 2; i < num; i++){
            n = n1 + n2;
            n1 = n2;
            n2 = n;
        }
        System.out.printf("Fibonnacci de %d ", n);
    }

    private static void fibonacciRecursive(int num){
        int n1 = 0, n2 = 1, n = 0;
        for (int i = 2; i < num; i++){
            n = n1 + n2;
            n1 = n2;
            n2 = n;
        }
        System.out.printf("Fibonnacci de %d ", n);
    }
}