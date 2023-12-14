import java.util.Scanner;
// Абстракция - Устройство
abstract class Device {
    protected Network network;

    public Device(Network network) {
        this.network = network;
    }

    abstract void connect();
    abstract void sendData(String data);
    abstract void receiveData(String data);
}

// Реализация - Беспроводная сеть
interface Network {
    void connect();
    void sendData(String data);
    void receiveData(String data);
}

// Конкретные реализации - Wi-Fi, Bluetooth, Zigbee
class WiFi implements Network {
    @Override
    public void connect() {
        System.out.println("Подключение к Wi-Fi сети");
    }

    @Override
    public void sendData(String data) {
        System.out.println("Отправка данных по Wi-Fi: " + data);
    }

    @Override
    public void receiveData(String data) {
        System.out.println("Получение данных по Wi-Fi: " + data);
    }
}

class Bluetooth implements Network {
    @Override
    public void connect() {
        System.out.println("Подключение к Bluetooth сети");
    }

    @Override
    public void sendData(String data) {
        System.out.println("Отправка данных по Bluetooth: " + data);
    }

    @Override
    public void receiveData(String data) {
        System.out.println("Получение данных по Bluetooth: " + data);
    }
}

class Zigbee implements Network {
    @Override
    public void connect() {
        System.out.println("Подключение к Zigbee сети");
    }

    @Override
    public void sendData(String data) {
        System.out.println("Отправка данных по Zigbee: " + data);
    }

    @Override
    public void receiveData(String data) {
        System.out.println("Получение данных по Zigbee: " + data);
    }
}

// Расширенная абстракция - Устройство с беспроводной сетью
class WirelessDevice extends Device {
    public WirelessDevice(Network network) {
        super(network);
    }

    @Override
    void connect() {
        System.out.println("Устройство подключается к беспроводной сети");
        network.connect();
    }

    @Override
    void sendData(String data) {
        System.out.println("Устройство отправляет данные");
        network.sendData(data);
    }

    @Override
    void receiveData(String data) {
        System.out.println("Устройство принимает данные");
        network.receiveData(data);
    }
}

// Клиентский код
public class BridgePatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Выбираем тип сети
        System.out.println("Выберите тип беспроводной сети:");
        System.out.println("1. Wi-Fi");
        System.out.println("2. Bluetooth");
        System.out.println("3. Zigbee");

        // Создаем объект Scanner и считываем выбор пользователя
        int networkType = scanner.nextInt();
        Network network;

        switch (networkType) {
            case 1:
                network = new WiFi();
                break;
            case 2:
                network = new Bluetooth();
                break;
            case 3:
                network = new Zigbee();
                break;
            default:
                System.out.println("Неверный выбор. Выбран Wi-Fi по умолчанию.");
                network = new WiFi();
                break;
        }

        // Создаем устройство с выбранной сетью
        Device wirelessDevice = new WirelessDevice(network);

        // Подключаем устройство к сети и отправляем/принимаем данные
        wirelessDevice.connect();

        // Вводим данные для отправки
        System.out.print("Введите данные для отправки: ");
        scanner.nextLine();  // Очищаем буфер после ввода числа
        String dataToSend = scanner.nextLine();

        wirelessDevice.sendData(dataToSend);
        wirelessDevice.receiveData("Mock response");

        // Закрываем Scanner после использования
        scanner.close();
    }
}
