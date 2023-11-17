package com.example.exercise9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// a simple JavaFX calculator.
public class HelloApplication extends Application {

    public void start(Stage primaryStage) {
        // Create the top section of the UI
        Text tNumber1 = new Text("Number 1:");
        Text tNumber2 = new Text("Number 2:");
        Text tResult = new Text("Result:");
        TextField tfNumber1 = new TextField();
        TextField tfNumber2 = new TextField();
        TextField tfResult = new TextField();
        tfResult.setEditable(false);

        // Create the bottom section of the UI
        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        Button btMultiply = new Button("*");
        Button btDivide = new Button("/");
        Button btClear = new Button("Clear");

        // Add top and bottom UI to HBox containers
        HBox calcTop = new HBox(5);
        calcTop.setAlignment(Pos.CENTER);
        calcTop.setPadding(new Insets(5));
        calcTop.getChildren().addAll(tNumber1, tfNumber1);
        calcTop.getChildren().addAll(tNumber2, tfNumber2);

        HBox calcBottom = new HBox(5);
        calcBottom.setAlignment(Pos.CENTER);
        calcBottom.setPadding(new Insets(5));
        calcBottom.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide, btClear);

        HBox calcRes = new HBox(5);
        calcRes.setAlignment(Pos.CENTER);
        calcRes.setPadding(new Insets(5));
        calcRes.getChildren().addAll(tResult, tfResult);

        // Add HBox containers to a BorderPane
        BorderPane pane = new BorderPane();
        pane.setTop(calcTop);
        pane.setCenter(calcBottom);
        pane.setBottom(calcRes);

        // Register event handlers for buttons
        btAdd.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a + b));
        });

        btSubtract.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a - b));
        });

        btMultiply.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a * b));
        });

        btDivide.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(b == 0 ? "NaN" : String.valueOf(a / b));
        });

        btClear.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfNumber1.setText("");
            tfNumber2.setText("");
            tfResult.setText("");
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("my calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private static double getDoubleFromTextField(TextField t) {
        return Double.parseDouble(t.getText());
    }

}