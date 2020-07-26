package com.grzegorz.todolist.datamodel;

import java.time.LocalDate;

public class ToDoItem {

    private String description;
    private String details;
    private LocalDate date;

    public ToDoItem(String description, String details, LocalDate date) {
        this.description = description;
        this.details = details;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
