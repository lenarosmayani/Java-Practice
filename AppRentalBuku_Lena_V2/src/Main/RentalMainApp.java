package Main;

public class RentalMainApp {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager(new ConsoleUser());
        libraryManager.start();
    }
}
