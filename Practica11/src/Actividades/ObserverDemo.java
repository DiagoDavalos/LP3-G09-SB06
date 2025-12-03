package Actividades;
import java.util.ArrayList;
import java.util.List;

// Subject
class NotificationCenter {
    private List<Observer> observers = new ArrayList<>();
    public void attach(Observer o) { observers.add(o); }
    public void detach(Observer o) { observers.remove(o); }
    public void notifyAllUsers(String message) {
        for (Observer o : new ArrayList<>(observers)) o.update(message);
    }
}
// Observer interface
interface Observer {
    void update(String message);
}
// Concrete Observer
class User implements Observer {
    private String name;
    public User(String name) { this.name = name; }
    @Override
    public void update(String message) {
        System.out.println("[" + name + "] recibió notificación: " + message);
    }
}
public class ObserverDemo {
    public static void main(String[] args) {
        NotificationCenter center = new NotificationCenter();

        User alice = new User("Alice");
        User bob = new User("Bob");
        User carla = new User("Carla");

        center.attach(alice);
        center.attach(bob);

        center.notifyAllUsers("¡Nueva promoción de productos!");
        System.out.println("-- Bob se desuscribe --");
        center.detach(bob);

        center.attach(carla);
        center.notifyAllUsers("Actualización: nuevo canal disponible.");
    }
}
