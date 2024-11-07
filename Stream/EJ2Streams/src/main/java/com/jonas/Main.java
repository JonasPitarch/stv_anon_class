package com.jonas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

record Student(String name, double nota){
    public Student( double i){
        this("Student" +Double.toString(i).chars().mapToObj(c->Character.toString(c)).collect(Collectors.joining()),i);
    }

    @Override
    public String toString() {
        return name + String.format("%.1f",nota);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        var lines= ThreadLocalRandom.current()
                .doubles(100,0,10)
                .mapToObj(Student::new)
                .map(Student::toString).toList();
        Files.write(Path.of("megastudents"),lines);
        var mayus=Files.lines(Path.of("megastudents")).distinct().map(l->l.toUpperCase()).toList();
        Files.write(Path.of("megastudents"),mayus);
    }
}