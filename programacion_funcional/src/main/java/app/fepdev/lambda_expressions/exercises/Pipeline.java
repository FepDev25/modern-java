package app.fepdev.lambda_expressions.exercises;

import java.util.function.Function;

public class Pipeline {
    public static void main(String[] args) {

        Function<String, String> pipeTrim = s -> s.trim();
        Function<String, String> pipeMinus = s -> s.toLowerCase();
        Function<String, String> pipeReplace = s -> s.replace(" ", "_");

        Function<String, String> pipeline = s -> pipeTrim.andThen(pipeMinus).andThen(pipeReplace).apply(s);
        System.out.println(pipeline.apply("  Hola Mundo  ")); // hola_mundo

        Function<String, String> pipelineV2 = s -> pipeMinus.andThen(pipeReplace).andThen(pipeTrim).apply(s);
        System.out.println(pipelineV2.apply("  Hola Mundo  "));// __hola_mundo__

        // El orden de las ejecuciones afecta el resulto final

    }
}
