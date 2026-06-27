package app.fepdev.lambda_expressions.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Composicion {
    public static void main(String[] args) {

        List<String> lista = Arrays.asList("Pedrito", "pedrito", "", "Computer", "a", "uruguat", "ecuador", "m", "MARIA");
        Predicate<String> noEmpty = s -> !s.isEmpty();
        Predicate<String> sizePlusThree = s -> s.length() > 3;
        Predicate<String> firstMayus = s -> Character.isUpperCase(s.charAt(0));

        filtrar(lista, noEmpty, sizePlusThree, firstMayus);
    }

    @SafeVarargs
    public static void filtrar(List<String> lista, Predicate<String>...predicados){
        Predicate<String> combinado = Arrays.stream(predicados)
            .reduce(x -> true, Predicate::and);

        lista.stream()
            .filter(combinado)
            .forEach(System.out::println);
    }
}
