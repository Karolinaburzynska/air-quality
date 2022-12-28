package airQuality;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GUI {

    public static void showMenu() {
        System.out.println("Witaj użytkowniku! Poniżej dostępne opcje");
        System.out.println("1 - pokaż związki chemiczne znajdujące się aktualnie w powietrzu dla miasta [wpisz miasto]");
        System.out.println("2 - pokaż jakość powietrza dla miasta [wpisz miasto]");
        System.out.println("3 - ZAKOŃCZ PROGRAM");
    }

    public static int getUserChoice() {
        System.out.println("Zaznacz wybraną opcję");
        int choice = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Zły wybór, podaj liczbę od 1 do 3.");
        }
        return choice;
    }
}
