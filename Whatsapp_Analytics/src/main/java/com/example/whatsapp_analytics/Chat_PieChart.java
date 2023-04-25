package com.example.whatsapp_analytics;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chat_PieChart extends Application {

    @Override public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Group());
        stage.setTitle("WhatsApp Pie Chart");
        stage.setWidth(500);
        stage.setHeight(500);

        FileReader f = new FileReader("D:\\JAVA\\Whatsapp_Analytics\\Vaanga Palakalam.txt");
        BufferedReader Br = new BufferedReader(f);
        String line;
        String sentence;

        boolean t;
        int count_pm = 0, count_am = 0,count_deleted = 0,count_file = 0,count_https = 0;
        while((line = Br.readLine())!=null)
        {
            if(line.contains("pm"))
            {
                count_pm++;
            }
            if(line.contains("am"))
            {
                count_am++;
            }
            if(line.contains("(file attached)"))
            {
                count_file++;
            }
            if(line.contains("https"))
            {
                count_https++;
            }
            if(line.contains("deleted"))
            {
                count_deleted++;
            }

        }
        System.out.println("pm:"+count_pm);
        System.out.println("Am:"+count_am);
        System.out.println("Files:"+count_file);
        System.out.println("Deleted Files:"+count_deleted);
        System.out.println("Links:"+count_https);
        System.out.println("countpm = "+count_pm);

        ObservableList<PieChart.Data> pieChartofViz =
                FXCollections.observableArrayList(new PieChart.Data("Afternoon chats", count_pm),
                        new PieChart.Data("Forenoon chats", count_am),
                        new PieChart.Data("Files", count_file),
                        new PieChart.Data("Links", count_https),
                        new PieChart.Data("Deleted chats", count_deleted));
        final PieChart chartViz = new PieChart(pieChartofViz);
        chartViz.setTitle("Chats pie chart");

        ((Group) scene.getRoot()).getChildren().add(chartViz);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}