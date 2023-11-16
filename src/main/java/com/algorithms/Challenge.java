package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Challenge {

    static void sumaParesEImpares(){
        int par = 0, impar = 0;
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0)
                par+=i;
            else
                impar+=i;
        }
        System.out.println("Par " + par);
        System.out.println("Impar " + impar);
    }

    static void contarVocale(){
        var lineas = List.of( "AssoEmfsdfkjdsfdsiryyteefsfljkdsf",
                "asdkljsauyriweuotietret",
                "dsadoioppierwmrtpñasjksf");
        List<String> vocales = List.of("a","e","i","o","u");

        lineas.stream()
                .map(str -> str.split(""))
                .map(arr ->
                    Arrays.stream(arr)
                            .filter( letter -> vocales.contains(letter.toLowerCase()))
                            .count()
                ).forEach(System.out::println);

    }

    static void llenarMatrizEnCaracol(){
        int n = 5;
        String[][] matriz = new String[n][n];
        int a = 0;
        int b = n - 1;
        int valor = 0;

        for(int j = 0; j <= matriz.length; j++){
            for(int i = a; i <= b; i++){
                matriz[a][i] = valor++ + " ";
            }

            for(int i = a + 1; i <= b; i++){
                matriz[i][b] = valor++ + " ";
            }

            for(int i = b - 1; i >= a; i--){
                matriz[b][i] = valor++ + " ";
            }

            for(int i = b - 1; i >= a + 1; i--){
                matriz[i][a] = valor++ + " ";
            }
            a++;
            b--;
        }


        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static void llenarDiagonal(){
        int n = 5;
        int[][] matriz = new int[n][n];
        int valor = 1;

        for(int j = 0; j < matriz.length; j++){
            matriz[j][j] = valor++;
        }


        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static void llenarDiagonalXY(){
        int n = 5;
        int[][] matriz = new int[n][n];
        int valorX = 1;
        int valorY = 1;

        for(int j = 0,k = matriz.length -1; j < matriz.length; j++, k--){
            matriz[j][j] = valorX++;
            matriz[k][j] = valorY++;
        }


        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static void palabraCruzadaImpar(){
        String word = "MICROSOFT";
        var letters = String.format("%1$" + word.length() + "s", "-").replaceAll(" ","-");

        for(int j = 0,k = letters.length() -1; j < letters.length(); j++, k--){
            var arr = letters.toCharArray();
            var letter = word.charAt(j);
            arr[j] = letter;
            arr[k] = letter;
            System.out.println(new String(arr));
        }
    }

    static void numerosParesImparesTotal(){
        int number = 123677;

        int par=0,impar=0;

        for (String s : String.valueOf(number).split("")) {
            if(Integer.valueOf(s) % 2 == 0){
                par++;
            }else {
                impar++;
            }
        }
        System.out.println("Total " + String.valueOf(number).length());
        System.out.println("Nro pares " + par);
        System.out.println("Nro impares " + impar);
    }

    static void ordenarBiarios(){
        List<Integer> numeros = List.of(234,54656,789,12,6788,233);

        System.out.println(numeros);

        var ordenados = numeros.stream()
                .map(Integer::toBinaryString)
                .sorted()
                .peek(System.out::println)
                .map(num -> Integer.parseInt(num,2))
                        .toList();


        System.out.println(ordenados);
    }


    static void existsMaxRowMinCol(){
        int k = 4, n = 5;
        int[][] matriz = new int[k][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                matriz[j][i] = ThreadLocalRandom.current().nextInt(0, (k*n) + 1);
            }
            System.out.println();
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        //sumaParesEImpares();
        //contarVocale();
        //llenarMatrizEnCaracol();
        //llenarDiagonal();
        //llenarDiagonalXY();
        //palabraCruzadaImpar();
        //numerosParesImparesTotal();
        //ordenarBiarios();
        //existsMaxRowMinCol();
        System.out.println(maaaa(List.of(15,3,6,10)));
        //System.out.println(maaaa(List.of(5,5,4,3,2,1)));
        List<Integer> left = new ArrayList<>();
        left.add(1);
        left.add(5);
        left.add(7);
        left.add(7);

        List<Integer> right = new ArrayList<>();
        right.add(0);
        right.add(1);
        right.add(2);
        right.add(3);


        System.out.println(merge(left, right));

    }

    static int maaaa(List<Integer> s){
        int mayor = 0;
        for(int i = 0; i < s.size(); i++){
            for(int j = 1; j < s.size(); j++){
                int left = s.get(i);
                int right = s.get(j);
                if( left < right && i < j){
                    int res = right - left;
                    if(res > mayor){
                        mayor = res;
                    }
                }
            }
        }
        return mayor;
    }

    static List<Integer> merge(List<Integer> a, List<Integer> b){
        a.addAll(b);
        return a.stream().sorted().toList();
    }





}
