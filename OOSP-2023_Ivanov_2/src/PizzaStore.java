
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Абстрактные продукты
interface Pizza {
    void prepare();

    void bake();

    void cut();

    void box();
}

// Конкретные продукты
class MeatPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Готовим мясную пиццу");
    }

    @Override
    public void bake() {
        System.out.println("Выпекаем мясную пиццу");
    }

    @Override
    public void cut() {
        System.out.println("Режем мясную пиццу");
    }

    @Override
    public void box() {
        System.out.println("Упаковываем мясную пиццу");
    }
}

class VegetarianPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Готовим вегетарианскую пиццу");
    }

    @Override
    public void bake() {
        System.out.println("Выпекаем вегетарианскую пиццу");
    }

    @Override
    public void cut() {
        System.out.println("Режем вегетарианскую пиццу");
    }

    @Override
    public void box() {
        System.out.println("Упаковываем вегетарианскую пиццу");
    }
}

class SeafoodPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Готовим морскую пиццу");
    }

    @Override
    public void bake() {
        System.out.println("Выпекаем морскую пиццу");
    }

    @Override
    public void cut() {
        System.out.println("Режем морскую пиццу");
    }

    @Override
    public void box() {
        System.out.println("Упаковываем морскую пиццу");
    }
}

// Абстрактная фабрика
interface PizzaFactory {
    Pizza createPizza();
}

// Конкретные фабрики
class MeatPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new MeatPizza();
    }
}

class VegetarianPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new VegetarianPizza();
    }
}

class SeafoodPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new SeafoodPizza();
    }
}

// Клиентский код
public class PizzaStore {
    public static void orderPizza(PizzaFactory factory) {
        Pizza pizza = factory.createPizza();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    public static void main(String[] args) {
        PizzaFactory meatPizzaFactory = new MeatPizzaFactory();
        PizzaFactory vegetarianPizzaFactory = new VegetarianPizzaFactory();
        PizzaFactory seafoodPizzaFactory = new SeafoodPizzaFactory();

        orderPizza(meatPizzaFactory);
        orderPizza(vegetarianPizzaFactory);
        orderPizza(seafoodPizzaFactory);
    }
}
