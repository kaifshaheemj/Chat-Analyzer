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

public class Chat_StudPieChart extends Application {

    @Override public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Group());
        stage.setTitle("WhatsApp Pie Chart");
        stage.setWidth(500);
        stage.setHeight(500);

        FileReader f = new FileReader("D:\\JAVA\\Whatsapp_Analytics\\Vaanga Palakalam.txt");
        BufferedReader Br = new BufferedReader(f);
        String line;
        String sentence;

        String[] Str = new String[5];
        Str[0] = "Sanjay";
        Str[1] = "Dhivyadharshini";
        Str[2] = "Jagadeesh";
        Str[3] = "Harish";
        Str[4] = "Prethika";

        boolean t;
        int count_San = 0, count_har = 0,count_Pre = 0,count_DD = 0,count_jag = 0;
        while((line = Br.readLine())!=null)
        {
            if(line.contains("Sanjay"))
            {
                count_San++;
            }
            if(line.contains("Aayush"))
            {
                count_har++;
            }
            if(line.contains("Prethika"))
            {
                count_Pre++;
            }
            if(line.contains("Dhivyadharshini"))
            {
                count_DD++;
            }
            if(line.contains("Jagadeesh"))
            {
                count_jag++;
            }

        }
        System.out.println("San:"+count_San);
        System.out.println("Har:"+count_har);
        System.out.println("P:"+count_Pre);
        System.out.println("DD:"+count_DD);
        System.out.println("Jaggu:"+count_jag);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(new PieChart.Data("Sanjay Ram", count_San),
                        new PieChart.Data("Dhivyadarshini", count_DD),
                        new PieChart.Data("Jagadeesh", count_jag),
                        new PieChart.Data("Aayush", count_har),
                        new PieChart.Data("Prethika", count_Pre));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Student's pie chart");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}