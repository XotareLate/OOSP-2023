import java.util.ArrayList;
import java.util.List;

// Снимок состояния редактора
class EditorSnapshot {
    private List<String> openFiles;
    private String windowLayout;

    public EditorSnapshot(List<String> openFiles, String windowLayout) {
        this.openFiles = new ArrayList<>(openFiles);
        this.windowLayout = windowLayout;
    }

    public List<String> getOpenFiles() {
        return new ArrayList<>(openFiles);
    }

    public String getWindowLayout() {
        return windowLayout;
    }
}

// Оригинальный объект (текстовый редактор)
class TextEditor {
    private List<String> openFiles;
    private String windowLayout;

    public TextEditor() {
        this.openFiles = new ArrayList<>();
        this.windowLayout = "Default layout";
    }

    public void openFile(String fileName) {
        openFiles.add(fileName);
    }

    public void closeFile(String fileName) {
        openFiles.remove(fileName);
    }

    public void setWindowLayout(String layout) {
        windowLayout = layout;
    }

    public EditorSnapshot createSnapshot() {
        return new EditorSnapshot(openFiles, windowLayout);
    }

    public void restoreSnapshot(EditorSnapshot snapshot) {
        openFiles = snapshot.getOpenFiles();
        windowLayout = snapshot.getWindowLayout();
    }

    public void printEditorState() {
        System.out.println("Open files: " + openFiles);
        System.out.println("Window layout: " + windowLayout);
    }
}

// Опекун (CareTaker) - сохраняет и восстанавливает снимки
class EditorHistory {
    private List<EditorSnapshot> snapshots = new ArrayList<>();

    public void saveSnapshot(EditorSnapshot snapshot) {
        snapshots.add(snapshot);
    }

    public EditorSnapshot getLastSnapshot() {
        if (!snapshots.isEmpty()) {
            return snapshots.get(snapshots.size() - 1);
        }
        return null;
    }
}

// Клиентский код
public class MementoPatternExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        // Работаем с редактором, создаем снимки
        editor.openFile("Document1.txt");
        editor.setWindowLayout("Split layout");
        history.saveSnapshot(editor.createSnapshot());

        editor.openFile("Document2.txt");
        history.saveSnapshot(editor.createSnapshot());

        editor.closeFile("Document1.txt");
        editor.setWindowLayout("Single layout");
        history.saveSnapshot(editor.createSnapshot());

        // Восстанавливаем предыдущее состояние
        EditorSnapshot lastSnapshot = history.getLastSnapshot();
        if (lastSnapshot != null) {
            editor.restoreSnapshot(lastSnapshot);
        }

        // Выводим текущее состояние
        editor.printEditorState();
    }
}
