import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class GroupsManager{
    Map<String , List<String>> grupos = new ConcurrentHashMap<>();

    boolean addUserToGroup(String user, String group){
        grupos.putIfAbsent(group,new ArrayList<>());
        for (var u : grupos.get(group)) {
            if (u.equals(user)){
                return false;
            }
        }
        grupos.get(group).add(user);
        return false;
    }
    boolean removeUserFromGroup(String user, String group){
        for (var u : grupos.get(group)){
            if (u.equals(user)){
                grupos.remove(u);
            }
        }
        return false;
    }
    boolean deleteGroup(String group){
        for (var g : grupos.get(group)){
            if (g.equals(group)){
                grupos.remove(g);
            }
        }
        return false;
    }
}

public class Ej3 {
    public static void main(String[] args) {

        var users = List.of("usera", "userb", "userc", "userd", "usere", "userf", "userg", "userf");
        var groups = List.of("group1", "group2", "group3", "group4");


        // anyade y quita usuarios random de los grupos en diversos threads
    }
}
