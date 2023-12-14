import java.util.Scanner;
// Абстрактный класс для отчетов
interface Report {
    void generate();
}

// Конкретные классы отчетов
class GraphReport implements Report {
    private String title;

    public GraphReport(String title) {
        this.title = title;
    }

    @Override
    public void generate() {
        System.out.println("Генерация отчета с графиками. Заголовок: " + title);
    }
}

class TableReport implements Report {
    private String title;

    public TableReport(String title) {
        this.title = title;
    }

    @Override
    public void generate() {
        System.out.println("Генерация отчета с таблицами. Заголовок: " + title);
    }
}

class TextReport implements Report {
    private String title;

    public TextReport(String title) {
        this.title = title;
    }

    @Override
    public void generate() {
        System.out.println("Генерация текстового отчета. Заголовок: " + title);
    }
}

// Абстрактная фабрика отчетов
interface ReportFactory {
    Report createReport(String title);
}

// Конкретные фабрики отчетов
class GraphReportFactory implements ReportFactory {
    @Override
    public Report createReport(String title) {
        return new GraphReport(title);
    }
}

class TableReportFactory implements ReportFactory {
    @Override
    public Report createReport(String title) {
        return new TableReport(title);
    }
}

class TextReportFactory implements ReportFactory {
    @Override
    public Report createReport(String title) {
        return new TextReport(title);
    }
}

public class ReportGenerator {
    public static void generateReport(ReportFactory factory, String title) {
        Report report = factory.createReport(title);
        report.generate();
    }

    public static void main(String[] args) {
        // Создаем Scanner для ввода с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем заголовок отчета с клавиатуры
        System.out.print("Введите заголовок отчета: ");
        String title = scanner.nextLine();

        // Создаем разные типы отчетов с использованием фабричного метода и введенным заголовком
        ReportFactory graphFactory = new GraphReportFactory();
        ReportFactory tableFactory = new TableReportFactory();
        ReportFactory textFactory = new TextReportFactory();

        generateReport(graphFactory, title);  // Генерация отчета с графиками. Заголовок: [введенный заголовок]
        generateReport(tableFactory, title);  // Генерация отчета с таблицами. Заголовок: [введенный заголовок]
        generateReport(textFactory, title);   // Генерация текстового отчета. Заголовок: [введенный заголовок]

        // Закрываем Scanner после использования
        scanner.close();
    }
}