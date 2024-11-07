import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Evento {
    private String nombre;
    private LocalDate fecha;

    public Evento(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + fecha + ")";
    }
}
public class e {
    public static void main(String[] args) {
        List<Evento> eventos = Arrays.asList(
                new Evento("Conferencia de Tecnología", LocalDate.of(2024, 5, 20)),
                new Evento("Fiesta de Fin de Año", LocalDate.of(2023, 12, 31)),
                new Evento("Torneo de Ajedrez", LocalDate.of(2024, 8, 15)),
                new Evento("Hackathon", LocalDate.of(2024, 3, 10)),
                new Evento("Reunión Anual", LocalDate.of(2023, 11, 5)),
                new Evento("Concierto de Verano", LocalDate.of(2025, 7, 22))
        );

        Map<Integer, Map<Integer, List<Evento>>> eventosAgrupados = eventos.stream()
                .filter(e -> e.getFecha().isAfter(LocalDate.now()))
                .collect(Collectors.groupingBy(
                        e -> e.getFecha().getYear(),
                        Collectors.groupingBy(e -> e.getFecha().getMonthValue())
                ));

        eventosAgrupados.forEach((year, eventosPorMes) -> {
            System.out.println("Año: " + year);
            eventosPorMes.forEach((mes, eventosDelMes) -> {
                System.out.println("  Mes: " + mes);
                eventosDelMes.forEach(evento -> System.out.println("    - " + evento));
            });
        });
    }
}

