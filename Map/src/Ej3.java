import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

class GroupsManager{
    Map<String , List<String>> grupos = new ConcurrentHashMap<>();

    boolean addUserToGroup(String user, String group){
        grupos.putIfAbsent(group,new ArrayList<>());
        grupos.compute(group, (grupo, usuarios) -> {
            usuarios.removeIf(u->u.equals(user));
            usuarios.add(user);
            return usuarios;
        });
        return true;
    }
    boolean removeUserFromGroup(String user, String group){
        for (var u : grupos.get(group)){
            if (u.equals(user)){
                grupos.get(group).remove(user);
                return true;
            }
        }
        return false;
    }
    boolean deleteGroup(String group){
        if (grupos.containsKey(group)){
            grupos.remove(group);
            return true;
        }
        return false;
    }
}

public class Ej3 {
    public static void main(String[] args) {

        var users = List.of("usera", "userb", "userc", "userd", "usere", "userf", "userg", "userf");
        var group = List.of("group1", "group2", "group3", "group4");

        for (int j = 0; j < 1000; j++) {
            GroupsManager groupsManager = new GroupsManager();
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
                for (int  i =0; i<100; i++){
                    executor.submit(()->{
                        groupsManager.addUserToGroup("Pepe","Lan2");
                    });
                }

                for (int  i =0; i<100; i++){
                    executor.submit(()->{
                        groupsManager.addUserToGroup("Jonas","Lan2");
                    });
                }

            }
            if (groupsManager.grupos.get("Lan2").size() != 2)
                System.out.println("Mierda");
        }
        // anyade y quita usuarios random de los grupos en diversos threads
    }
}
