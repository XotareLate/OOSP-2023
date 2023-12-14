// Абстрактный класс, представляющий объект в городе
abstract class CityObject {
    // Шаблонный метод для отрисовки объекта
    public final void draw() {
        drawBase();
        drawSpecific();
        drawOverlay();
    }

    // Отрисовка базовой части
    private void drawBase() {
        System.out.println("Отрисовка базовой части");
    }

    // Отрисовка конкретной части (переопределяется в подклассах)
    protected abstract void drawSpecific();

    // Отрисовка наложенной части
    private void drawOverlay() {
        System.out.println("Отрисовка наложенной части");
    }
}

// Класс для отрисовки дома
class House extends CityObject {
    @Override
    protected void drawSpecific() {
        System.out.println("Отрисовка дома");
    }
}

// Класс для отрисовки дороги
class Road extends CityObject {
    @Override
    protected void drawSpecific() {
        System.out.println("Отрисовка дороги");
    }
}

// Класс для отрисовки магазина
class Shop extends CityObject {
    @Override
    protected void drawSpecific() {
        System.out.println("Отрисовка магазина");
    }
}

// Клиентский код
public class CitySimulator {
    public static void main(String[] args) {
        // Создаем объекты в городе
        CityObject house = new House();
        CityObject road = new Road();
        CityObject shop = new Shop();

        // Отрисовываем объекты
        house.draw();
        road.draw();
        shop.draw();
    }
}
