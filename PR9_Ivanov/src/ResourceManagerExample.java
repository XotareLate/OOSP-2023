import java.util.HashMap;
import java.util.Map;

// Одиночка - Менеджер ресурсов
class ResourceManager {
    private static ResourceManager instance;

    // Карта для хранения загруженных ресурсов
    private Map<String, Object> resources;

    private ResourceManager() {
        resources = new HashMap<>();
    }

    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }

    public void loadResource(String key, Object resource) {
        resources.put(key, resource);
    }

    public Object getResource(String key) {
        return resources.get(key);
    }
}

// Пример использования менеджера ресурсов
public class ResourceManagerExample {
    public static void main(String[] args) {
        // Получаем экземпляр менеджера ресурсов
        ResourceManager resourceManager = ResourceManager.getInstance();

        // Загружаем ресурсы
        resourceManager.loadResource("image1", "image1.jpg");
        resourceManager.loadResource("font1", "font1.ttf");
        resourceManager.loadResource("sound1", "sound1.mp3");

        // Получаем ресурсы
        Object image1 = resourceManager.getResource("image1");
        Object font1 = resourceManager.getResource("font1");
        Object sound1 = resourceManager.getResource("sound1");

        // Используем ресурсы
        System.out.println("Image: " + image1);
        System.out.println("Font: " + font1);
        System.out.println("Sound: " + sound1);
    }
}
