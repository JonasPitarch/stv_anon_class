import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
//// a
//        for (int i = 0; i < 5; i++) {
//            System.out.println(i);
//        }
//
//// b
//        for (int i = 0; i <= 5; i++) {
//            System.out.println(i);
//        }
//
//// c
//        for (int i = 0; i < 15; i = i + 3) {
//            System.out.println(i);
//        }
//
//// d
//        for (int i = 0; ; i = i + 3) {
//            if (i > 20) {
//                break;
//            }
//
//            System.out.println(i);
//        }
//
//// e
//        for (String name : List.of("Joan", "Paula", "Kate", "Pedro")) {
//            System.out.println(name);
//        }
//
//// f
//        for (String name : List.of("Joan", "Paula", "Kate", "Pedro")) {
//            if (name.length() == 4) {
//                System.out.println(name);
//            }
//        }
//
//// g
//        for (String name : List.of("Joan", "Paula", "Kate", "Pedro")) {
//            String upperCaseName = name.toUpperCase();
//            System.out.println(upperCaseName);
//        }
//
//// h
//        for (String name : List.of("Joan", "Paula", "Kate", "Pedro")) {
//            if (name.length() == 4) {
//                String upperCaseName = name.toUpperCase();
//                System.out.println(upperCaseName);
//            }
//        }
//
//// i
//        List<Integer> iNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> iNumerosPares = new ArrayList<>();
//
//        for (Integer numero : iNumeros) {
//            if (numero % 2 == 0) {
//                iNumerosPares.add(numero);
//            }
//        }
//
//        System.out.println(iNumerosPares);
//
//// j
//// usa el método reduce()
//        List<Integer> jNumeros = List.of(1, 2, 3, 4, 5);
//        int jSuma = 0;
//
//        for (Integer number : jNumeros) {
//            jSuma += number;
//        }
//
//        System.out.println(jSuma);
//
//// k
//        List<String> kNombres = List.of("Joan", "Paula", "Kate", "Maricarmen", "Pedro", "Antonio");
//        String kNombreLargo = null;
//
//        for (String nombre : kNombres) {
//            if (nombre.length() > 5) {
//                kNombreLargo = nombre;
//                break;
//            }
//        }
//
//        System.out.println(kNombreLargo);
//
//// l
//        List<Integer> lNumeros = new ArrayList<>(List.of(5, 3, 8, 1, 2));
//        Collections.sort(lNumeros);
//        System.out.println(lNumeros);
//
//// m
//        List<String> mWords = List.of("poma", "platan", "poma", "taronja", "platan");
//        int mCount = 0;
//
//        for (String word : mWords) {
//            if (word.equals("poma")) {
//                mCount++;
//            }
//        }
//
//        System.out.println(mCount);
//
//// n
//        List<String> nWords = List.of("Hello", "World", "Java");
//        String nResult = "";
//
//        for (String word : nWords) {
//            nResult += word + " ";
//        }
//
//        System.out.println(nResult.trim());
//
//// o
//        List<Integer> numbers = List.of(10, 25, 3, 5, 50, 15);
//        int max = Integer.MIN_VALUE;
//
//        for (Integer number : numbers) {
//            if (number > max) {
//                max = number;
//            }
//        }
//
//        System.out.println(max);
//
//// p
//        List<Integer> pNumbers = List.of(1, 2, 3, -4, 5);
//        boolean pAllPositive = true;
//
//        for (Integer number : pNumbers) {
//            if (number <= 0) {
//                pAllPositive = false;
//                break;
//            }
//        }
//
//        System.out.println(pAllPositive);
//
//// q
//        List<Integer> qNumeros = List.of(1, 2, 3, 4, 2, 5, 1);
//        Set<Integer> qNumerosNoDuplicados = new HashSet<>();
//        List<Integer> qResult = new ArrayList<>();
//
//        for (Integer numero : qNumeros) {
//            if (qNumerosNoDuplicados.add(numero)) {
//                qResult.add(numero);
//            }
//        }
//
//        System.out.println(qResult);
//
//// r
//// utilitza reduce() o max()
//        List<String> rWords = List.of("poma", "platan", "cirera", "pera");
//        String rLongest = "";
//
//        for (String word : rWords) {
//            if (word.length() > rLongest.length()) {
//                rLongest = word;
//            }
//        }
//
//        System.out.println(rLongest);
//
//// s
//        record sEstudiante(String nombre, int edad) {
//        }
//
//        List<sEstudiante> sEstudiantes = List.of(new sEstudiante("Roberto", 30), new sEstudiante("Alicia", 25));
//        List<String> sNombres = new ArrayList<>();
//
//        for (sEstudiante estudiante : sEstudiantes) {
//            sNombres.add(estudiante.nombre);
//        }
//
//        System.out.println(sNombres);
//
//// t
//        record tEstudiante(String nombre, String ciclo) {
//            tEstudiante(String... values) {
//                this(values[0], values[1]);
//            }
//
//            static tEstudiante of(String string) {
//                return new tEstudiante(string.split(":"));
//            }
//        }
//
//        List<String> tStrings = List.of("Ana:DAW", "Roberto:DAM", "Alicia:SMX");
//        List<tEstudiante> tEstudiantes = new ArrayList<>();
//
//        for (String string : tStrings) {
//            if (string.startsWith("A")) {
//                tEstudiantes.add(tEstudiante.of(string));
//            }
//        }
//
//        System.out.println(tEstudiantes);
//
//// u
//// warning: este programa añade un "-|-" indebido
//        String uWords = "Hello:World:Of:Streams";
//
//        String uResult = "|-";
//        for (String word : uWords.split(":")) {
//            uResult += word + "-|-";
//        }
//        uResult += "-|";
//        System.out.println(uResult);

// v
//        record vMarcas(List<String> coches, List<String> motos) {
//        }
//
//        var vMarcasList = List.of(
//                new vMarcas(List.of("Ferrari", "Koenigsegg"), List.of("Ducati", "Yamaha", "Harley")),
//                new vMarcas(List.of("Lamborghini", "Bugatti"), List.of("Kawasaki")),
//                new vMarcas(List.of("McLaren", "Aston Martin"), List.of())
//        );
//
//
//        var vMarcasCombined = vMarcasList.stream().parallel().collect(()->new vMarcas(new ArrayList<>(),new ArrayList<>()),(c,e)->{
//            c.coches.addAll(e.coches);
//            c.motos.addAll(e.motos);},
//                (c1,c2)->{
//            c1.coches.addAll(c2.coches);
//            c1.motos.addAll(c2.motos);
//                }
//        );
//        System.out.println(vMarcasCombined.coches);
//        System.out.println(vMarcasCombined.motos);

// w
//        String[] wDirectories = {"/tmp", "/root"};
//        Arrays.stream(wDirectories).map(s->Path.of(s)).forEach(p-> {
//            try (var files = Files.list(p)){
//                files.filter(f->Files.isRegularFile(f)).forEach(System.out::println);
//            } catch (IOException e) {
//                System.out.println("error");
//            }
//        });
//        for (String directory : wDirectories) {
//            try {
//                for (File file : new File(directory).listFiles()) {
//                    if (file.isFile()) {
//                        System.out.println(file);
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("An error ocurred: " + e.getMessage());
//            }
//        }
//
//// x
//        long c =Files.lines(Path.of("/usr/share/dict/spanish")).filter(l->l.endsWith("tona")).peek(System.out::println).count();
//        System.out.println("He encontrado " + c + " palabras con tona");
//        try {
//            final var filePath = "/usr/share/dict/spanish";
//            final var wordOfInterest = "tona";
//
//            try (var reader = Files.newBufferedReader(Path.of(filePath))) {
//                String line = "";
//                long count = 0;
//
//                while ((line = reader.readLine()) != null) {
//                    if (line.endsWith(wordOfInterest)) {
//                        System.out.println(line);
//                        count++;
//                    }
//                }
//
//                System.out.printf("Found %d words that end with '%s'%n", count, wordOfInterest);
//            }
//        } catch (Exception ex) {
//            System.out.println("ERROR: " + ex.getMessage());
//        }

//// y
//
//        record Button(int x, int y) {
//        }
//
//
//        List<Button> buttons = new ArrayList<>();
//        IntStream.range(0,5)
//                .forEach(i->IntStream.range(0,3).forEach(j->buttons.add(new Button(i,j))));
//
//        for (Button button : buttons) {
//            System.out.println(button);
//        }

// z

//        Stream.generate(()->new String(new URI("https://apipa.vercel.app/api/string").toURL().openStream().readAllBytes())).forEach(s->Arrays.stream(s.toCharArray()));

    }
}