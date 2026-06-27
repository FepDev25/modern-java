package app.fepdev.lambda_expressions.interfaces;

@FunctionalInterface
public interface Validator <T> {
    boolean esValido(T input);
}
