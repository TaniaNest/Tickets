package util;

public class Info {

    public void getInfo() {

        System.out.print("Input path to file: ");
    }

    public void fileError() {
        System.out.println("File don`t exist");
    }

    public void emptyFile() {
        System.out.println("File is empty");
    }

    public void getCount(String param, int num) {

        System.out.print("Amount of lucky tickets by method " + param + ": " + num);
    }

    public void getChoose() {

        System.out.print("Choose action: ");
    }

    public void getRequest() {

        System.out.print("Do you want to exit or continue: ");
    }
}
