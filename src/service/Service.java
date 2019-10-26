package service;

import model.Model;

public class Service {

    public boolean methodMoscow(Model tickets) {
        if (number(tickets)[0] + number(tickets)[1] + number(tickets)[2] == number(tickets)[3] + number(tickets)[4] + number(tickets)[5]) {
            return true;
        }
        return false;
    }

    public boolean methodPeter(Model tickets) {
        int countOne = 0, countTwo = 0;
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
        int number1 = tickets.getTickets() / 100000;
        int number2 = (tickets.getTickets() % 100000) / 10000;
        int number3 = (tickets.getTickets() % 10000) / 1000;
        int number4 = (tickets.getTickets() % 1000) / 100;
        int number5 = (tickets.getTickets() % 100) / 10;
        int number6 = tickets.getTickets() % 10;
        int[] arr = {number1, number2, number3, number4, number5, number6};
        return arr;
    }
}
