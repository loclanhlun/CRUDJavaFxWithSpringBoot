package com.huynhbaoloc.utils;

public enum Menu {
    Home("Dashboard"),
    ClassRoom("ClassRoom Management"),
    Student("Student Management"),
    Exit("Exit");

    private String title;

    Menu(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getFxml() {
        return String.format("%s.fxml", name());
    }
}
