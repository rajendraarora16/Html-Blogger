package com.RajendraArora.HtmlEditor;

/**
 * Created by Raj on 6/9/2014.
 */

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class MainProgram extends Application{

    HTMLEditor he=null;
    String my_text="<html><body>This is an open source html blog editor made by Rajendra Arora. " +
            "You could use this editor to post such a blog into your website " +
            "and it would generate automatically source code for html.</body></html>";

    public void start(Stage primaryStage){
        primaryStage.setTitle("HTML blog editor.");
        Group gp=new Group();
        primaryStage.setScene(new Scene(gp));
        VBox vb=new VBox();
        vb.setPadding(new Insets(1, 1, 1, 1));
        he=new HTMLEditor();
        he.setPrefSize(900, 400);
        he.setHtmlText(my_text);
        vb.getChildren().add(he);

        Label lb=new Label("Copy below the generated Source codes:");
        lb.setOpacity(0.45);
        lb.setFont(Font.font(28.0));

        final TextArea tf=new TextArea();
        tf.setPadding(new Insets(2, 2, 2, 2));
        tf.setPrefWidth(1020.0);
        tf.setPrefHeight(100.0);

        Button btn=new Button("Generate HTML source codes..");
        vb.setAlignment(Pos.CENTER);
        btn.setOnAction(new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent e){
                tf.setText(he.getHtmlText());
            }
        });

        vb.getChildren().add(btn);
        vb.getChildren().add(lb);
        vb.getChildren().add(tf);
        gp.getChildren().add(vb);

        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
