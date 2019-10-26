package controller;

import model.Model;
import service.Service;
import util.Info;
import util.Input;

import java.io.*;

public class Controller {

    private Input input = new Input();
    private Info info = new Info();
    private Service service = new Service();

    public void run() throws IOException {
        service.addNumbers(getPath());
        choice();
    }

    public String getPath() {
        info.getInfo();
        String path = input.getPath();
        return path;
    }

    public void choice() {
        info.getChoose();
        int method = input.getChose();
        switch (method) {
            case 1:
                info.getCount("Moscow", service.countTicketsMoscow());
                break;
            case 2:
                info.getCount("Peter", service.countTicketsPeter());
                break;
            default:
                repeat();
        }
    }

    public void repeat() {
        String exit;
        info.getRequest();
        exit = input.getAnswer();
        if (exit.equals("y") || exit.equals("yes")) {
            choice();
        } else {
            System.exit(0);
        }
    }
}
