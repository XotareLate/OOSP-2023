import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Прототип уровня
class MapPrototype implements Cloneable {
    private List<String> terrain;

    public MapPrototype() {
        this.terrain = new ArrayList<>();
    }

    public void addTerrain(String terrainType) {
        terrain.add(terrainType);
    }

    public void printMap() {
        System.out.println("Map:");
        for (String terrainType : terrain) {
            System.out.println("- " + terrainType);
        }
    }

    @Override
    public MapPrototype clone() throws CloneNotSupportedException {
        MapPrototype clonedMap = (MapPrototype) super.clone();
        clonedMap.terrain = new ArrayList<>(this.terrain);
        return clonedMap;
    }
}

// Генератор случайных карт мира
class WorldMapGenerator {
    private MapPrototype baseMap;

    public WorldMapGenerator(MapPrototype baseMap) {
        this.baseMap = baseMap;
    }

    public MapPrototype generateRandomMap() {
        try {
            // Клонируем базовую карту
            MapPrototype newMap = baseMap.clone();

            // Добавляем случайные элементы к новой карте
            Random random = new Random();
            int numberOfNewElements = random.nextInt(5) + 1; // Генерируем от 1 до 5 новых элементов
            for (int i = 0; i < numberOfNewElements; i++) {
                newMap.addTerrain("New Terrain " + (i + 1));
            }

            return newMap;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Пример использования
public class PrototypePatternExample {
    public static void main(String[] args) {
        // Создаем базовую карту
        MapPrototype baseMap = new MapPrototype();
        baseMap.addTerrain("Grass");
        baseMap.addTerrain("Mountains");
        baseMap.addTerrain("Water");

        // Создаем генератор карт мира с базовой картой
        WorldMapGenerator mapGenerator = new WorldMapGenerator(baseMap);

        // Генерируем случайные карты
        MapPrototype randomMap1 = mapGenerator.generateRandomMap();
        MapPrototype randomMap2 = mapGenerator.generateRandomMap();

        // Выводим сгенерированные карты
        System.out.println("Base Map:");
        baseMap.printMap();

        System.out.println("\nRandom Map 1:");
        randomMap1.printMap();

        System.out.println("\nRandom Map 2:");
        randomMap2.printMap();
    }
}
