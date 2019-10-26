package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    public String getPath() {

        return scanner.next();
    }

    public int getChose() {

        return scanner.nextInt();
    }

    public String getAnswer() {
        return scanner.next();
    }

}
