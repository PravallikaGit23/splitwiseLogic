package dev.scaler.model;

public class User implements Comparable<User> {
    int id;
    String name;
    String mobileNUmber;
    Double currentPendingAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNUmber() {
        return mobileNUmber;
    }

    public void setMobileNUmber(String mobileNUmber) {
        this.mobileNUmber = mobileNUmber;
    }

    public Double getCurrentPendingAmount() {
        return currentPendingAmount;
    }

    public void setCurrentPendingAmount(Double currentPendingAmount) {
        this.currentPendingAmount = currentPendingAmount;
    }

    public User(int id, String name, String mobileNUmber, Double currentPendingAmount) {
        this.id = id;
        this.name = name;
        this.mobileNUmber = mobileNUmber;
        this.currentPendingAmount = currentPendingAmount;
    }

    public int compareTo(User other) {
        return Double.compare(this.getCurrentPendingAmount(), other.getCurrentPendingAmount());
    }

    @Override
    public String toString() {
        return name + ": " + getCurrentPendingAmount();
    }
}
