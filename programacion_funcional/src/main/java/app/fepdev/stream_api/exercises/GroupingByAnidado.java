package app.fepdev.stream_api.exercises;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByAnidado {

    /*
    Tarea 2 — groupingBy anidado:
        Tienes la clase Empleado del ejemplo integrador. Usando un solo collect, genera un Map<String, Map<String, Long>> que 
        agrupe por departamento y dentro de cada departamento cuente cuántos empleados hay por rango salarial: "BAJO" (< 2000),
        "MEDIO" (2000-2999), "ALTO" (≥ 3000). Pista: necesitarás Collectors.groupingBy dentro de otro groupingBy.
     */
    public static void main(String[] args) {
        record Empleado(String nombre, String departamento, double salario) {

        }

        List<Empleado> empleados = List.of(
                new Empleado("Ana", "IT", 2500),
                new Empleado("Carlos", "RRHH", 1800),
                new Empleado("Diana", "IT", 3200),
                new Empleado("Eduardo", "Finanzas", 2100),
                new Empleado("Bea", "IT", 1500),
                new Empleado("Felipe", "IT", 3500),
                new Empleado("Gabriela", "RRHH", 2800),
                new Empleado("Héctor", "Finanzas", 1200),
                new Empleado("Inés", "Legal", 4100),
                new Empleado("Jorge", "IT", 1900),
                new Empleado("Karen", "Legal", 3800),
                new Empleado("Luis", "RRHH", 1600),
                new Empleado("Marta", "Finanzas", 3100),
                new Empleado("Nicolás", "IT", 2200),
                new Empleado("Olivia", "Legal", 2700),
                new Empleado("Pablo", "RRHH", 3300),
                new Empleado("Quirina", "Finanzas", 1750),
                new Empleado("Rodrigo", "IT", 2900),
                new Empleado("Sofía", "Legal", 1400),
                new Empleado("Tomás", "RRHH", 2400)
        );

        Map<String, Map<String, Long>> result = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::departamento,
                        Collectors.groupingBy(e -> {
                            if (e.salario() < 2000) {
                                return "BAJO";
                            } else if (e.salario() < 3000) {
                                return "MEDIO";
                            }
                            return "ALTO";
                        }, Collectors.counting())
                ));
        result.forEach((k, v) -> System.out.println(k + ": " + v));

    }

}
