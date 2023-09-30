package com.example.weddingplanner;

public class RVbudgeting {
    int category;
    int budget;
    int remaining_budget;
    int total_spent;
    int total_paid;
    int img;

    public RVbudgeting(int category, int budget, int remaining_budget, int total_spent, int total_paid, int img) {
        this.category = category;
        this.budget = budget;
        this.remaining_budget = remaining_budget;
        this.total_spent = total_spent;
        this.total_paid = total_paid;
        this.img = img;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRemaining_budget() {
        return remaining_budget;
    }

    public void setRemaining_budget(int remaining_budget) {
        this.remaining_budget = remaining_budget;
    }

    public int getTotal_spent() {
        return total_spent;
    }

    public void setTotal_spent(int total_spent) {
        this.total_spent = total_spent;
    }

    public int getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(int total_paid) {
        this.total_paid = total_paid;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
