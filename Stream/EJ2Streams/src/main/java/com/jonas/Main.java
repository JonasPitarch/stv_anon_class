package com.jonas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;
record Student(String name, double nota){
    public Student( double i){
        this("Student" + i,i);
    }

    @Override
    public String toString() {
        return name + nota;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        var lines= ThreadLocalRandom.current()
                .doubles(100,0,10)
                .mapToObj(Student::new)
                .map(Student::toString).toList();
        Files.write(Path.of("megastudents"),lines);
    }
}