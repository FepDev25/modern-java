package app.fepdev.stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {

        record Empleado(String nombre, String departamento, double salario) {}

        List<Empleado> empleados = List.of(
            new Empleado("Ana",     "IT",      2500),
            new Empleado("Carlos",  "RRHH",    1800),
            new Empleado("Diana",   "IT",      3200),
            new Empleado("Eduardo", "Finanzas", 2100),
            new Empleado("Bea",     "IT",      1500)
        );

        // ¿Cuánto gana en promedio el departamento IT?
        double gananciaIt = empleados.stream()
            .filter(e -> e.departamento().equals("IT"))
            .mapToDouble(Empleado::salario)
            .average()
            .getAsDouble();
        System.out.println("Ganancia promedio de departamente de IT: " + gananciaIt);

        // Nombres de los que ganan más de 2000, ordenados
        List<String> nombres = empleados.stream()
            .filter(e -> e.salario > 2000)
            .sorted(Comparator.comparing(Empleado::nombre))
            .map(Empleado::nombre)
            .toList();
        System.out.println("Nombres de los que ganan más de 2000, ordenados: ");
        nombres.forEach(System.out::println);

        // Agrupar por departamento con el salario total de cada uno
        Map<String, Double> salariosDep = empleados.stream()
            .collect(Collectors.groupingBy(
                    Empleado::departamento, 
                    Collectors.summingDouble(Empleado::salario)
        ));
        salariosDep.forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
