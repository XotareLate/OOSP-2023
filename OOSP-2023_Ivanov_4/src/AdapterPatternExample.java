import java.util.Scanner;
// Интерфейс для сетевых протоколов
interface NetworkProtocol {
    void openConnection();

    void sendData(String data);

    String receiveData();

    void closeConnection();
}

// HTTP протокол
class HttpProtocol implements NetworkProtocol {
    @Override
    public void openConnection() {
        System.out.println("Открываем HTTP-соединение");
    }

    @Override
    public void sendData(String data) {
        System.out.println("Отправляем данные по протоколу HTTP: " + data);
    }

    @Override
    public String receiveData() {
        return "Получены данные по протоколу HTTP";
    }

    @Override
    public void closeConnection() {
        System.out.println("Закрываем HTTP-соединение");
    }
}

// FTP протокол
class FtpProtocol implements NetworkProtocol {
    @Override
    public void openConnection() {
        System.out.println("Открываем FTP-соединение");
    }

    @Override
    public void sendData(String data) {
        System.out.println("Отправляем данные по протоколу FTP: " + data);
    }

    @Override
    public String receiveData() {
        return "Получены данные по протоколу FTP";
    }

    @Override
    public void closeConnection() {
        System.out.println("Закрываем FTP-соединение");
    }
}

// SMTP протокол
class SmtpProtocol implements NetworkProtocol {
    @Override
    public void openConnection() {
        System.out.println("Открываем SMTP-соединение");
    }

    @Override
    public void sendData(String data) {
        System.out.println("Отправляем данные по протоколу SMTP: " + data);
    }

    @Override
    public String receiveData() {
        return "Получены данные по протоколу SMTP";
    }

    @Override
    public void closeConnection() {
        System.out.println("Закрываем SMTP-соединение");
    }
}

// Адаптер для работы с сетевыми протоколами через общий интерфейс
class ProtocolAdapter implements NetworkProtocol {
    private NetworkProtocol adaptee;

    public ProtocolAdapter(NetworkProtocol adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void openConnection() {
        adaptee.openConnection();
    }

    @Override
    public void sendData(String data) {
        adaptee.sendData(data);
    }

    @Override
    public String receiveData() {
        return adaptee.receiveData();
    }

    @Override
    public void closeConnection() {
        adaptee.closeConnection();
    }
}

// Клиентский код
public class AdapterPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример использования адаптера для работы с HTTP протоколом
        NetworkProtocol httpProtocol = new HttpProtocol();
        NetworkProtocol adaptedHttpProtocol = new ProtocolAdapter(httpProtocol);

        useProtocol(scanner, adaptedHttpProtocol);

        // Пример использования адаптера для работы с FTP протоколом
        NetworkProtocol ftpProtocol = new FtpProtocol();
        NetworkProtocol adaptedFtpProtocol = new ProtocolAdapter(ftpProtocol);

        useProtocol(scanner, adaptedFtpProtocol);

        // Пример использования адаптера для работы с SMTP протоколом
        NetworkProtocol smtpProtocol = new SmtpProtocol();
        NetworkProtocol adaptedSmtpProtocol = new ProtocolAdapter(smtpProtocol);

        useProtocol(scanner, adaptedSmtpProtocol);

        // Закрываем Scanner после использования
        scanner.close();
    }

    private static void useProtocol(Scanner scanner, NetworkProtocol protocol) {
        protocol.openConnection();

        System.out.print("Введите данные для отправки: ");
        String dataToSend = scanner.nextLine();
        protocol.sendData(dataToSend);

        System.out.println("Received: " + protocol.receiveData());

        protocol.closeConnection();
        System.out.println();
    }
}