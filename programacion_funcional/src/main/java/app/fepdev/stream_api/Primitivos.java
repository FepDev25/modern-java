package app.fepdev.stream_api;

import java.util.List;
import java.util.stream.IntStream;

public class Primitivos {
    public static void main(String[] args) {
        
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int suma = IntStream.of(numeros).sum();
        double average = IntStream.of(numeros).average().getAsDouble();
        int max = IntStream.of(numeros).max().getAsInt();
        System.out.println(suma + " " + average + " " + max);
        System.out.println();

        // rangos
        int[] rango = IntStream.range(0, 5).toArray();
        for (int i = 0; i < rango.length; i++) {
            System.out.println(rango[i]);
        }

        int[] rango2 = IntStream.rangeClosed(1, 5).toArray(); 
        for (int i = 0; i < rango2.length; i++) {
            System.out.println(rango2[i]);
        }
        System.out.println();

        // conversion
        List<Integer> boxed = IntStream.range(1, 4)
            .boxed()
            .toList();
        boxed.forEach(System.out::println);

    }
}
