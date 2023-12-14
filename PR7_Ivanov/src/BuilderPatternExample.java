// Интерфейс строителя компьютера
interface ComputerBuilder {
    void buildProcessor(String processor);
    void buildMemory(String memory);
    void buildHardDisk(String hardDisk);
    void buildGraphicsCard(String graphicsCard);
    Computer getResult();
}

// Класс компьютера
class Computer {
    private String processor;
    private String memory;
    private String hardDisk;
    private String graphicsCard;

    public Computer(String processor, String memory, String hardDisk, String graphicsCard) {
        this.processor = processor;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }
}

// Конкретный строитель компьютера
class ConcreteComputerBuilder implements ComputerBuilder {
    private String processor;
    private String memory;
    private String hardDisk;
    private String graphicsCard;

    @Override
    public void buildProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public void buildMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public void buildHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    @Override
    public void buildGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public Computer getResult() {
        return new Computer(processor, memory, hardDisk, graphicsCard);
    }
}

// Руководитель (директор) строительства компьютеров
class ComputerDirector {
    public Computer constructGamingComputer(ComputerBuilder builder) {
        builder.buildProcessor("Intel i9");
        builder.buildMemory("32GB RAM");
        builder.buildHardDisk("1TB SSD");
        builder.buildGraphicsCard("NVIDIA RTX 3080");
        return builder.getResult();
    }

    public Computer constructOfficeComputer(ComputerBuilder builder) {
        builder.buildProcessor("Intel i5");
        builder.buildMemory("8GB RAM");
        builder.buildHardDisk("500GB HDD");
        builder.buildGraphicsCard("Integrated Graphics");
        return builder.getResult();
    }
}

// Клиентский код
public class BuilderPatternExample {
    public static void main(String[] args) {
        ComputerBuilder builder = new ConcreteComputerBuilder();
        ComputerDirector director = new ComputerDirector();

        // Строим игровой компьютер
        Computer gamingComputer = director.constructGamingComputer(builder);
        System.out.println("Gaming Computer: " + gamingComputer);

        // Строим офисный компьютер
        Computer officeComputer = director.constructOfficeComputer(builder);
        System.out.println("Office Computer: " + officeComputer);
    }
}
