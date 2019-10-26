package controller;

import model.Model;
import service.Service;
import util.Info;
import util.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Input input = new Input();
    private Info info = new Info();
    private Service service = new Service();

    private List<Integer> list = new ArrayList<Integer>();
    private String line;


    public void run() throws IOException {
        addNumbers();
        choice();
    }

    public String getPath() {
        info.getInfo();
        String path = input.getPath();
        return path;
    }

    public void addNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(getPath())));
        while ((line = br.readLine()) != null) {

            String[] h = line.split("\n");
            for (int j = 0; j < h.length; j++) {
                int val = Integer.parseInt(h[j]);
                list.add(val);
            }
        }
        br.close();
    }

    public int countTicketsMoscow() {
        int sum = 0;
        for (int i = 0; i <= list.size() - 1; i++) {
            Model num = new Model(list.get(i));
            if (service.methodMoscow(num)) {
                sum++;
            }
        }
        return sum;
    }

    public int countTicketsPeter() {
        int sum = 0;
        for (int i = 0; i <= list.size() - 1; i++) {
            Model num = new Model(list.get(i));
            if (service.methodPeter(num)) {
                sum++;
            }
        }
        return sum;
    }

    public void choice() {
        info.getChoose();
        int method = input.getChose();
        switch (method) {
            case 1:
                info.getCount("Moscow", countTicketsMoscow());
                break;
            case 2:
                info.getCount("Peter", countTicketsPeter());
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
