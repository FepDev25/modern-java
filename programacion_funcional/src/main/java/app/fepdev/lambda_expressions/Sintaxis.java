package app.fepdev.lambda_expressions;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Sintaxis {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hola Mundo");
        r.run();

        // sin parámetros
        Runnable saludo = () -> System.out.println("Hola desde lambda");
        saludo.run();

        // parámetro
        Consumer<String> imprimir = nombre -> System.out.println("Hola, " + nombre);
        imprimir.accept("Felipe");
        imprimir.accept("Pedrito");

        // múltiples parámetros
        BinaryOperator<Integer> sumar = (a, b) -> a + b;
        System.out.println(sumar.apply(3, 4));

        // con cuerpo
        BinaryOperator<Integer> maxValor = (a, b) -> {
            if (a >= b) {
                return a;
            }
            return b;
        };
        System.out.println(maxValor.apply(10, 7));
        System.out.println(maxValor.apply(10, 700));
    }

}
