package com.grzegorz.todolist;

import com.grzegorz.todolist.datamodel.ToDoData;
import com.grzegorz.todolist.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class dialogController {

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;


    public ToDoItem processResult() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();
        ToDoItem newItem = new ToDoItem(shortDescription,details,deadline);
        ToDoData.getInstance().addToDoItem(newItem);
        return newItem;
    }
}
