package app.fepdev.lambda_expressions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import app.fepdev.lambda_expressions.models.Book;

public class Practice {
    public static void main(String[] args) {

        // Dado un String, retorna su longitud como Integer
        Function<String, Integer> longitud = String::length;
        System.out.println(longitud.apply("Hola"));
        System.out.println(longitud.apply("") + "\n");

        // Imprime en consola cualquier String que recibas, sin retornar nada
        Consumer<String> imp = System.out::println;
        imp.accept("Hola desde Java");
        imp.accept("Pedrito el gato");
        System.out.println();

        // Genera y retorna el número 42 sin recibir ningún parámetro
        Supplier<Integer> miNum = () -> 42;
        System.out.println(miNum.get() + "\n");

        // Dado un Integer, retorna true si es par
        Predicate<Integer> par = n -> n % 2 == 0;
        System.out.println(par.test(24));
        System.out.println(par.test(33) + "\n");

        // Dados dos Integer, retorna su producto
        BinaryOperator<Integer> multi = (a, b) -> a * b;
        System.out.println(multi.apply(3, 5));
        System.out.println(multi.apply(12, 900) + "\n");

        // Dado un String, retorna el mismo String en mayúsculas. Usa method reference
        Function<String, String> mayus = String::toUpperCase;
        System.out.println(mayus.apply("felipe"));
        System.out.println(mayus.apply("Bruno") + "\n");

        // Dado un Double, retorna true si es mayor que 100.0
        Predicate<Double> mayorCien = d -> d > 100.0;
        System.out.println(mayorCien.test(120.0));
        System.out.println(mayorCien.test(100.99999999999999999999999999999999999) + "\n"); // true porque almacena 101

        // Genera un UUID aleatorio como String sin recibir nada. Usa method reference.
        Supplier<UUID> generarUUID = UUID::randomUUID;
        System.out.println(generarUUID.get());
        System.out.println(generarUUID.get() + "\n");
        
        // Dado un String, imprime su longitud. No retornas el String ni la longitud por separado — solo el efecto
        Consumer<String> printLength = s -> System.out.println(s.length());
        printLength.accept("Cartón");
        printLength.accept("");
        System.out.println();

        // Dado un Integer, retorna su representación como String. Usa method reference
        Function<Integer, String> numString = String::valueOf;
        String x = numString.apply(12);
        System.out.println(x instanceof String); // true
        System.out.println();

        // Tienes esta lista:
            // Filtra solo las que empiezan con mayúscula, conviértelas a minúscula y coléctalas en una lista. Sin bucles.
        List<String> palabras = List.of("casa", "Auto", "mesa", "Libro", "silla");
        List<String> newList = palabras.stream()
            .filter(word -> Character.isUpperCase(word.charAt(0)))
            .map(String::toLowerCase)
            .toList();
        newList.forEach(System.out::println);
        System.out.println();

        // Tienes esta lista:
            // Filtra los pares, multiplica cada uno por 3 y retorna la suma total como int.
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int suma = numeros.stream()
            .filter(num -> num % 2 == 0)
            .mapToInt(num -> num * 3)
            .sum();
        System.out.println(suma);
        System.out.println();

        // Crea un método que reciba un String y retorne una función que agregue ese String como prefijo a cualquier otro String. 
        // Es decir, la función retorna una función
        var prefijoFelipe = prefijoString("Felipe");
        System.out.println(prefijoFelipe.apply(" tiene 21 años"));
        System.out.println(prefijoFelipe.apply(" estudia Java"));

        var prefijoPedrito = prefijoString("Pedrito");
        System.out.println(prefijoPedrito.apply(" maulla en la mañana"));
        System.out.println(prefijoPedrito.apply(" es un gato naranja"));
        System.out.println();

        // Crea un método que reciba un Predicate<String> y retorne su negación, sin usar .negate() directamente en el 
        // llamador — encapsula esa lógica dentro del método
        Predicate<String> myPredicate = myWord -> myWord.charAt(0) == 'A';
        System.out.println(myPredicate.test("Avion")); // true
        System.out.println(negar(myPredicate).test("Avion")); // false
        System.out.println();

        // Tienes esta lista:
            // Filtra los válidos (contienen @ y tienen al menos un . después del @), y coléctalos en una lista
        List<String> emails = List.of("felipe@gmail.com", "noesvalido", "otro@correo.ec", "tampoco", "x@y.z", "novale@com", "no.com");
        var filtrados = emails.stream()
            .filter(mail -> mail.contains("@"))
            .filter(mail -> mail.substring(mail.indexOf('@')).contains("."))
            .toList();
        filtrados.forEach(System.out::println);
        System.out.println();

        // Dado un List<String>, retorna un Map<Integer, List<String>> agrupando los strings por su longitud. Sin bucles
        List<String> words = List.of("sol", "mar", "casa", "luna", "río", "perro");
        Map<Integer, List<String>> mapa = words.stream()
            .collect(Collectors.groupingBy(String::length));
        mapa.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        // variante con conteo de palabras, counting sobreescribe el toList() por defecto
        Map<Integer, Long> mapa2 = words.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        mapa2.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        System.out.println();

        // Crea un método componerDos que reciba dos Function<String, String> y retorne una sola función que las aplique en orden. 
        // No uses andThen directamente en el llamador — esa composición ocurre dentro del método.
        Function<String, String> trim = String::trim;
        Function<String, String> toUpper = String::toUpperCase;
        var miTransform = componerDos(trim, toUpper);
        System.out.println(miTransform.apply("    Felipe    "));
        System.out.println(miTransform.apply("    Pedrito"));
        System.out.println();

        // Tienes esta lista:
           // Encuentra el nombre más largo usando streams. Si hay empate, cualquiera de los más largos está bien.
        List<String> nombres = List.of("Ana", "Bob", "Felipe", "Emi", "Alexandra");
        String nombreLargo = nombres.stream()
            .max(Comparator.comparingInt(String::length)) // puede ser reduce tambien
            .orElseGet(() -> "");
        System.out.println(nombreLargo);
        System.out.println();

        // Crea un método que reciba un List<T> y un Function<T, R> y retorne un List<R> con la transformación aplicada. 
        // Genérico, sin asumir tipos concretos
        List<Book> books = Arrays.asList(new Book("Mujercitas", 550, 123), 
        new Book("El Conde de Montecristo", 1100, 23), new Book("El Principito", 451, 309));
        Function<Book, Double> porcentajeLeido = b -> (double) b.getCurrent() / b.getPages();
        var listaPorcentajes = aplicar(books, porcentajeLeido);
        listaPorcentajes.forEach(System.out::println);
        System.out.println();

        // Tienes este record
            // Agrupa por categoría y para cada categoría calcula el precio promedio. Retorna Map<String, Double>. Sin bucles.
        record Producto(String nombre, String categoria, double precio) {}
        List<Producto> productos = List.of(
            new Producto("Laptop", "Tech", 1200.0),
            new Producto("Mouse", "Tech", 25.0),
            new Producto("Silla", "Muebles", 300.0),
            new Producto("Monitor", "Tech", 400.0),
            new Producto("Escritorio", "Muebles", 500.0)
        );
        Map<String, Double> agrupado = productos.stream()
            .collect(Collectors.groupingBy(Producto::categoria, Collectors.averagingDouble(Producto::precio)));
        agrupado.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

    }

    public static Function<String, String> prefijoString(String word){
        return word::concat; // lo mismo que return other -> word.concat(other);
    }

    public static Predicate<String> negar(Predicate<String> predicador){
        return predicador.negate();
    }

    public static Function<String, String> componerDos(Function<String, String> f1, Function<String, String> f2){
        return f1.andThen(f2);
    }

    public static <T, R> List<R> aplicar(List<T> lista, Function<T, R> function){
        return lista.stream()
            .map(function)
            .toList();
    }

}