package controller;

import model.Model;
import service.Service;
import util.Info;
import util.Input;
import util.Validator;

import java.io.*;

public class Controller {

    private Input input = new Input();
    private Info info = new Info();
    private Service service = new Service();
    private Validator validator = new Validator();

    private String path;

    public void run() throws IOException {

        if (getTestFile()) {
            service.addNumbers(path);
        }
        choice(getMethod());

    }

    public boolean getTestFile() {

        while (true) {
            path = getPath();
            if (validator.fileExist(path)) {
                return true;
            } else {
                info.fileError();
            }
        }

    }

    public String getPath() {
        info.getInfo();
        String path = input.getPath();
        return path;
    }

    public int getMethod() {
        info.getChoose();
        int method = input.getChose();
        while (!validator.isPositiveNumber(method)) {
            info.getChoose();
            method = new Input().getChose();
        }
        return method;

    }


    public void choice(int method) {
        switch (method) {
            case 1:
                info.getCount("Moscow", service.countTickets(method));
                break;
            case 2:
                info.getCount("Peter", service.countTickets(method));
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
            choice(getMethod());
        } else {
            System.exit(0);
        }
    }
}
