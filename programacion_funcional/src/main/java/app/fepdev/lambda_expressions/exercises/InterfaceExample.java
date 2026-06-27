package app.fepdev.lambda_expressions.exercises;

import app.fepdev.lambda_expressions.interfaces.Validator;

public class InterfaceExample {
    public static void main(String[] args) {

        Validator<String> noNullNoEmpty = s -> s != null && !s.isEmpty();
        System.out.println(noNullNoEmpty.esValido(""));
        System.out.println(noNullNoEmpty.esValido(null));
        System.out.println(noNullNoEmpty.esValido("Hola"));

        Validator<Integer> esPositivo = i -> i > 0;
        System.out.println(esPositivo.esValido(-1));
        System.out.println(esPositivo.esValido(0));
        System.out.println(esPositivo.esValido(1));

        Validator<String> containsChar = s -> s.contains("@");
        System.out.println(containsChar.esValido("felipe.com"));
        System.out.println(containsChar.esValido("felipe@gmail.com"));

    }
}
