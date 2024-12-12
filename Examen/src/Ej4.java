import java.util.concurrent.Executors;

public class Ej4 {
    public static void main(String[] args) {
        try (var executor= Executors.newVirtualThreadPerTaskExecutor()){
            var token = executor.submit(()->fetch("https://some.api/getToken"));
            var email = executor.submit(()->fetch("https://some.api/johndoe/email"));
            var photoUrl= executor.submit(()-> fetch("https://some.api/johndoe/photoUrl?token=" + token.get()));
            var realName = executor.submit(()->fetch("https://some.api/johndoe/email?token=" + token.get()));
            System.out.println(photoUrl.get());
            System.out.println(realName.get());
            System.out.println(email.get());
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
    static String fetch(String url) {
        try (var inputStream = new java.net.URI(url).toURL().openStream()) {
            return new String(inputStream.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

