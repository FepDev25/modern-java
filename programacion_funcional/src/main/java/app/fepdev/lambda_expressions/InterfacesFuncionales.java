package app.fepdev.lambda_expressions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import app.fepdev.lambda_expressions.models.Book;

public class InterfacesFuncionales {

    public static void main(String[] args) {

        // Function<T, R> transforma T en R
        Function<Integer, String> fraseNumero = num -> "Tu número es: " + num;
        System.out.println(fraseNumero.apply(25));

        Function<Book, String> fraseBookActual
                = book -> "Estás leyendo '" + book.getName() + "' y estás en la página " + book.getCurrent() + " de " + book.getPages();
        System.out.println(fraseBookActual.apply(new Book("El Conde de Montecristo", 1110, 30)));

        // Predicate<T> evalúa una condición y retorna boolean
        Predicate<String> lengthOverTen = s -> s.length() > 10;
        System.out.println(lengthOverTen.test("Felipe"));
        System.out.println(lengthOverTen.test("Computadoras"));

        Predicate<String> validatorOne = s -> s.contains("@");
        Predicate<String> validatorTwo = s -> s.contains(".com");
        Predicate<String> validatorThree = s -> s.endsWith(".ec");
        Predicate<String> validator = validatorOne.and(validatorTwo).and(validatorThree);
        System.out.println(validator.test("felipe.com.ec"));
        System.out.println(validator.test("felipe@gmail.com"));
        System.out.println(validator.test("felipe@gmail.com.ec"));

        // Consumer<T> consume T sin retornar nada
        Consumer<String> log = msg -> System.out.println("[LOG] " + msg);
        log.accept("iniciando proceso");

        Consumer<String> logYGuardar = log.andThen(msg -> System.out.println("[DB] guardando: " + msg));
        logYGuardar.accept("evento");

        // Supplier<T> produce un T sin recibir nada
        Supplier<String> timestamp = () -> LocalDateTime.now().toString();
        System.out.println(timestamp.get());

        Supplier<Integer> random = () -> (int) Math.ceil((Math.random() * 100));
        System.out.println(random.get());

        // ----------------- Method references ---------------
        Function<String, Integer> stringToInteger = Integer::parseInt;
        System.out.println(stringToInteger.apply("25"));
        
        Function<String, String> stringToUpperCase = String::toUpperCase;
        System.out.println(stringToUpperCase.apply("felipe"));

        String mensaje = "Hola desde method reference";
        Supplier<String> mensajeSupplier = mensaje::toUpperCase;
        System.out.println(mensajeSupplier.get());

        Supplier<ArrayList<Book>> booksSupplier = ArrayList<Book>::new;
        ArrayList<Book> books = booksSupplier.get();
        books.add(new Book("El Conde de Montecristo", 1110, 30));
        books.forEach(System.out::println);

    }
}
