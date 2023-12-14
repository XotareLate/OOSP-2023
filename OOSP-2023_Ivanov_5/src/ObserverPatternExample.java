import java.util.ArrayList;
import java.util.List;

// Интерфейс для наблюдателя
interface Observer {
    void update(String event);
}

// Интерфейс для субъекта (событийного источника)
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String event);
}

// Реализация субъекта - календарь
class Calendar implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String upcomingEvent;

    public void addEvent(String event) {
        this.upcomingEvent = event;
        notifyObservers(event);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}

// Реализация наблюдателя - пользователь
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + ": Уведомление - Предстоящее мероприятие: " + event);
    }
}

// Клиентский код
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Создаем календарь
        Calendar calendar = new Calendar();

        // Создаем пользователей
        User user1 = new User("Пользователь 1");
        User user2 = new User("Пользователь 2");

        // Подписываем пользователей на уведомления
        calendar.addObserver(user1);
        calendar.addObserver(user2);

        // Добавляем мероприятие в календарь
        calendar.addEvent("Встреча с друзьями");

        // Убираем одного пользователя из списка подписчиков
        calendar.removeObserver(user1);

        // Добавляем еще одно мероприятие
        calendar.addEvent("Презентация проекта");
    }
}
