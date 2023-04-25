package com.example.whatsapp_analytics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.*;

public class Chat_BarChart extends Application
{

    @Override
    public void start(Stage stage) throws IOException
    {
        FileReader f = new FileReader("D:\\JAVA\\Whatsapp_Analytics\\Vaanga Palakalam.txt");
        BufferedReader Br = new BufferedReader(f);
        String line;
        String sentence;


        int i10 = 0,i11 = 0,i12 = 0,i13 = 0,i14 = 0,i15 = 0,i16 = 0,i17 = 0,i18 = 0,i19 = 0,i0 = 0;
        for(int i=0;i<10;i++)
        {
            Pattern P = Pattern.compile("10/11/22");

            while ((line = Br.readLine()) != null)
            {
                sentence = line;
                Matcher m = P.matcher(line);
                while (m.find())
                {
                    i10++;
                }
                if(line.contains("11/10/22"))
                {
                    i11++;
                }
                if(line.contains("12/10/22"))
                {
                    i12++;
                }
                if(line.contains("13/10/22"))
                {
                    i13++;
                }
                if(line.contains("14/10/22"))
                {
                    i14++;
                }
                if(line.contains("15/10/22"))
                {
                    i15++;
                }
                if(line.contains("16/10/22"))
                {
                    i16++;
                }
                if(line.contains("17/10/22"))
                {
                    i17++;
                }
                if(line.contains("18/10/22"))
                {
                    i18++;
                }
                if(line.contains("19/10/22"))
                {
                    i19++;
                }

                System.out.println(line);
            }
        }


        //@Override public void start(Stage stage) {
        stage.setTitle("WhatsApp Bar Chart ");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Chats Summary");
        xAxis.setLabel("Date");
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("10/2022");

        String I1,I2,I3,I4,I5,I6,I7,I8,I9,I0;
        I1 = "10/10/22";
        I2 = "11/10/22";
        I3 = "12/10/22";
        I4 = "13/10/22";
        I5 = "14/10/22";
        I6 = "15/10/22";
        I7 = "16/10/22";
        I8 = "17/10/22";
        I9 = "18/10/22";
        I0 = "19/10/22";

        /*for(int i=0;i<10;i++)
        {
            series1.getData().add(new XYChart.Data<>(I[i], A[i]));
        }*/
        series1.getData().add(new XYChart.Data<>(I1, i10));
        series1.getData().add(new XYChart.Data<>(I2, i11));
        series1.getData().add(new XYChart.Data<>(I3, i12));
        series1.getData().add(new XYChart.Data<>(I4, i13));
        series1.getData().add(new XYChart.Data<>(I5, i14));
        series1.getData().add(new XYChart.Data<>(I6, i15));
        series1.getData().add(new XYChart.Data<>(I7, i16));
        series1.getData().add(new XYChart.Data<>(I8, i17));
        series1.getData().add(new XYChart.Data<>(I9, i18));
        series1.getData().add(new XYChart.Data<>(I0, i19));

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
