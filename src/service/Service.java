package service;

import model.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Integer> list = new ArrayList<Integer>();

    public void addNumbers(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        while ((line = br.readLine()) != null) {

            String[] h = line.split("\n");
            for (int j = 0; j < h.length; j++) {
                int val = Integer.parseInt(h[j]);
                list.add(val);
            }
        }
        br.close();
    }

    public int countTickets(int choice) {
        int sum = 0;
        for (int i = 0; i <= list.size() - 1; i++) {
            Model num = new Model(list.get(i));
            if (choice == 1) {
                if (methodMoscow(num)) {
                    sum++;
                }
            }
            if (choice == 2) {
                if (methodPeter(num)) {
                    sum++;
                }
            }
        }
        return sum;

    }

    public boolean methodMoscow(Model tickets) {
        int countOne = 0;
        int countTwo = 0;
        for (int i = 0; i <= number(tickets).length - 1; i++) {
            if (i < (number(tickets).length / 2)) {
                countOne += number(tickets)[i];
            } else {
                countTwo += number(tickets)[i];
            }
        }
        if (countOne == countTwo) {
            return true;
        } else return false;
    }

    public boolean methodPeter(Model tickets) {
        int countOne = 0;
        int countTwo = 0;
        for (int i = 0; i <= number(tickets).length - 1; i++) {
            if (number(tickets)[i] == 0) {
                countTwo++;
            }
            if (number(tickets)[i] % 2 == 0) {
                countOne++;
            } else {
                countTwo++;
            }
        }
        if (countOne == countTwo) {
            return true;
        } else return false;
    }

    public int[] number(Model tickets) {
        int[] arr = new int[6];
        int index = 0;
        int number = tickets.getTickets();
        do {
            arr[index] = number % 10;
            number /= 10;
        }
        while (++index < 6);
        {
            return arr;
        }
    }



}
