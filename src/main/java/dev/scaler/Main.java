package dev.scaler;

import dev.scaler.model.User;
import dev.scaler.service.SplitExpenses;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Shiva", "123", 1750.00);
        User user2 = new User(2, "sai", "548", -50.00);
        User user3 = new User(3, "Dhananjaya", "9012", -1250.00);
        User user4 = new User(4, "anand", "2123", -450.00);

        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        SplitExpenses splitExpenses = new SplitExpenses();
        splitExpenses.splitExpenses(users);
    }
}