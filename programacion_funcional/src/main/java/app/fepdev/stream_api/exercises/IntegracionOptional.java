package app.fepdev.stream_api.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class IntegracionOptional {

    /*
    Tarea 5 — Integración con Optional:
    Escribe un método buscarEmpleadoMasBienPagado(String departamento, List<Empleado> empleados) que retorne Optional<Empleado>. 
    Internamente debe usar un stream. Si el departamento no existe o está vacío, el Optional debe estar vacío.
     */
    public record Empleado(String nombre, String departamento, double salario) {
    }

    public static void main(String[] args) {

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

        Optional<Empleado> b1 = buscarEmpleadoMasBienPagado("IT", empleados);
        Optional<Empleado> b2 = buscarEmpleadoMasBienPagado("", empleados);
        Optional<Empleado> b3 = buscarEmpleadoMasBienPagado("Legal", empleados);

        eval(b1);
        eval(b2);
        eval(b3);
        

    }

    public static Optional<Empleado> buscarEmpleadoMasBienPagado(String departamento, List<Empleado> empleados) {
        if (departamento == null || departamento.isBlank()) return Optional.empty();
        return empleados.stream()
            .filter(e -> e.departamento().equals(departamento))
            .max(Comparator.comparingDouble(Empleado::salario))
        ;
    }

    public static void eval(Optional<Empleado> op) {
    op.ifPresentOrElse(
        e -> System.out.println(e),
        () -> System.out.println("No encontrado")
    );
}
}
