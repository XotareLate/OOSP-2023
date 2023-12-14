// Подсистема для работы с электронной почтой
class EmailSubsystem {
    public void sendEmail(String to, String subject, String body) {
        // Реализация отправки электронного письма
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("Email sent successfully.");
    }
}

// Фасад для унифицированного интерфейса отправки электронных писем
class EmailFacade {
    private EmailSubsystem emailSubsystem;

    public EmailFacade() {
        this.emailSubsystem = new EmailSubsystem();
    }

    public void sendNotification(String to, String message) {
        String subject = "Notification";
        String body = "Dear " + to + ",\n\n" + message;
        emailSubsystem.sendEmail(to, subject, body);
    }

    public void sendWelcomeEmail(String to) {
        String subject = "Welcome to Our System";
        String body = "Dear " + to + ",\n\n" +
                "Thank you for joining our system. We're excited to have you on board!";
        emailSubsystem.sendEmail(to, subject, body);
    }

    // Дополнительные методы для управления электронными письмами могут быть добавлены сюда
}

// Пример использования фасада
public class FacadePatternExample {
    public static void main(String[] args) {
        // Создаем фасад
        EmailFacade emailFacade = new EmailFacade();

        // Используем фасад для отправки уведомления и приветственного письма
        emailFacade.sendNotification("user@example.com", "Important notification!");
        emailFacade.sendWelcomeEmail("newuser@example.com");
    }
}
