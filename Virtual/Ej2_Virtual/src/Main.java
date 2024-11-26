import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            var weather = executor.submit(() -> fetch("https://apipa.vercel.app/api/w/weather"));
            var temperature = executor.submit(() -> fetch("https://apipa.vercel.app/api/temperature"));
            var wind = executor.submit(() -> fetch("https://apipa.vercel.app/api/wind"));
            var moon = executor.submit(() -> fetch("https://apipa.vercel.app/api/moon"));

            System.out.println(weather.get());
            System.out.println(temperature.get());
            System.out.println(wind.get());
            System.out.println(moon.get());
        }
        catch ( InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static String fetch(String url) {
        try(var inputStream = new URI(url).toURL().openStream()) {
            return new String(inputStream.readAllBytes());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}