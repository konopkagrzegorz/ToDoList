package com.grzegorz.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class ToDoData {

    private static ToDoData instance = new ToDoData();
    private static String filename = "ToDoListItem.txt";

    private ObservableList<ToDoItem> toDoItems;
    private DateTimeFormatter formatter;


    public ToDoData() {
        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static ToDoData getInstance() {
        return instance;
    }

    public ObservableList<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void addToDoItem(ToDoItem item) {
        toDoItems.add(item);
    }

//    public void setToDoItems(List<ToDoItem> toDoItems) {
//        this.toDoItems = toDoItems;
//    }

    public void loadToDoItems() throws IOException {
        toDoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while((input = br.readLine()) != null) {
            String[] itemPieces = input.split("\t");

            String shortDescription = itemPieces[0];
            String details = itemPieces[1];
            String dateString = itemPieces[2];

            LocalDate date = LocalDate.parse(dateString,formatter);
            ToDoItem toDoItem = new ToDoItem(shortDescription,details,date);
            toDoItems.add(toDoItem);
            }

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void saveToDoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try {
            Iterator<ToDoItem> iterator = toDoItems.iterator();
            while (iterator.hasNext()) {
                ToDoItem toDoItem = iterator.next();
                bw.write(String.format("%s\t%s\t%s", toDoItem.getDescription(), toDoItem.getDetails(), toDoItem.getDate().format(formatter)));
                bw.newLine();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    public void deleteToDoItem (ToDoItem item) {
        toDoItems.remove(item);
    }
}
