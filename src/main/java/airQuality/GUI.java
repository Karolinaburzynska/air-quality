package airQuality;

import java.util.Scanner;

public class GUI {

    public static void showMenu (){
        System.out.println("Witaj użytkowniku! Poniżej dostępne opcje");
        System.out.println("1 - pokaż związki chemiczne znajdujące się aktualnie w powietrzu dla miasta [wpisz miasto]");
        System.out.println("2 - pokaż jakość powietrza dla miasta [wpisz miasto]");
        System.out.println("3 - pokaż jakość powietrza dla województwa [wpisz województwo]");
        System.out.println("4 - pokaż indeks jakości powietrza dla [wpisz miasto]");
        System.out.println("5 - wyświetl dane pomiarowe dla miasta [wpisz miasto] ");
        System.out.println("6 - wyświetl Indeks jakości powietrza dla mista [wpisz miasto] ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("10 - ZAKOŃCZ PROGRAM");

    }

    public static int getUserChoice (){
        System.out.println("Zaznacz wybraną opcję");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }




}
