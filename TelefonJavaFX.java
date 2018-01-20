/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author badow
 */
public class TelefonJavaFX extends Application {
    
    Telefon tel = new Telefon();
    TextField zadzwonTextField;
    TextField numerTelefonuWyslijSmsTextField;
    TextField trescWyslijSmsTextField;
    TextArea przegladajTextArea;
    Label komunikatLabel;
    Button odbierzPolaczenieButton;
    Button odrzucPolaczenieButton;
    Button zakonczPolaczenieButton;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Tworzenie siatki pionowej
        VBox siatkaPionowaVBox = new VBox(5);
        siatkaPionowaVBox.setPadding(new Insets(5));
        
        // Tworzenie etykiety zadzwon
        Label zadzwonLabel = new Label();
        zadzwonLabel.setText("Zadzwon");
        siatkaPionowaVBox.getChildren().add(zadzwonLabel);
        
        // Tworzenie siatki poziomej zadzwon
        HBox zadzwonHBox = new HBox(5);
        
        // Tworzenie etykiety numer telefonu zadzwon
        Label zadzwonNumerTelefonuLabel = new Label();
        zadzwonNumerTelefonuLabel.setText("Numer telefonu:");
        zadzwonNumerTelefonuLabel.setMinWidth(100);
        
        // Tworzenie pola edycyjnego do wprowadzenia numeru telefonu zadzwon
        zadzwonTextField = new TextField();
        zadzwonTextField.setMinWidth(175);
        
        // Tworzenie przycisku zadzwon
        Button zadzwonButton = new Button("Zadzwon");
        zadzwonButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                tel.zadzwon(zadzwonTextField.getText());
                komunikatLabel.setText("Dzwonie do abonenta o numerze "+zadzwonTextField.getText()+"...");
            }
        });
        
        // Dodanie kontrolek zadzwon do siatki poziomej
        zadzwonHBox.getChildren().add(zadzwonNumerTelefonuLabel);
        zadzwonHBox.getChildren().add(zadzwonTextField);
        zadzwonHBox.getChildren().add(zadzwonButton);
        
        // Dodanie siatki poziomej zadzwon do siatki pionowej
        siatkaPionowaVBox.getChildren().add(zadzwonHBox);
        
        // Tworzenie etykiety wyslij sms
        Label wyslijSmsLabel = new Label();
        wyslijSmsLabel.setText("Wyslij sms");
        siatkaPionowaVBox.getChildren().add(wyslijSmsLabel);
        
        // Tworzenie siatki poziomej numer telefonu wyslij sms
        HBox numerTelefonuWyslijSmsHBox = new HBox(5);
        
        // Tworzenie etykiety numer telefonu wyslij sms
        Label numerTelefonuWyslijSmsLabel = new Label();
        numerTelefonuWyslijSmsLabel.setText("Numer telefonu:");
        numerTelefonuWyslijSmsLabel.setMinWidth(100);
        
        // Tworzenie pola edycyjnego do wprowadzenia numeru telefonu wyslij sms
        numerTelefonuWyslijSmsTextField = new TextField();
        numerTelefonuWyslijSmsTextField.setMinWidth(175);
        
        // Dodanie kontrolek numer telefonu wyslij sms do siatki poziomej
        numerTelefonuWyslijSmsHBox.getChildren().add(numerTelefonuWyslijSmsLabel);
        numerTelefonuWyslijSmsHBox.getChildren().add(numerTelefonuWyslijSmsTextField);
        
        // Dodanie siatki poziomej numer telefonu wyslij sms do siatki pionowej
        siatkaPionowaVBox.getChildren().add(numerTelefonuWyslijSmsHBox);
        
        // Tworzenie siatki poziomej tresc wyslij sms
        HBox trescWyslijSmsHBox = new HBox(5);
        
        // Tworzenie etykiety tresc wyslij sms
        Label trescWyslijSmsLabel = new Label();
        trescWyslijSmsLabel.setText("Tresc:");
        trescWyslijSmsLabel.setMinWidth(100);
        
        // Tworzenie pola edycyjnego do wprowadzenia tresci wyslij sms
        trescWyslijSmsTextField = new TextField();
        trescWyslijSmsTextField.setMinWidth(175);
        
        // Tworzenie przycisku wyslij sms
        Button wyslijSmsButton = new Button("Wyslij sms");
        wyslijSmsButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                tel.wyslijSms(numerTelefonuWyslijSmsTextField.getText(), trescWyslijSmsTextField.getText());
                komunikatLabel.setText("Wyslano sms do abonenta o numerze "+numerTelefonuWyslijSmsTextField.getText()+" o tresci "+trescWyslijSmsTextField.getText());
            }
        });
        
        // Dodanie kontrolek tresc wyslij sms do siatki poziomej
        trescWyslijSmsHBox.getChildren().add(trescWyslijSmsLabel);
        trescWyslijSmsHBox.getChildren().add(trescWyslijSmsTextField);
        trescWyslijSmsHBox.getChildren().add(wyslijSmsButton);
        
        // Dodanie siatki poziomej tresc wyslij sms do siatki pionowej
        siatkaPionowaVBox.getChildren().add(trescWyslijSmsHBox);
        
        // Tworzenie siatki poziomej przegladaj historie polaczen
        HBox przegladajHistoriePolaczenHBox = new HBox(5);
        
        // Tworzenie etykiety przegladaj historie polaczen
        Label przegladajHistoriePolaczenLabel = new Label();
        przegladajHistoriePolaczenLabel.setText("Przegladaj historie polaczen");
        
        // Tworzenie przycisku przegladaj historie polaczen
        Button przegladajHistoriePolaczenButton = new Button("Przegladaj");
        przegladajHistoriePolaczenButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                przegladajTextArea.setText(tel.przegladajHistoriePolaczen());
            }
        });
        
        // Dodanie kontrolek do siatki poziomej przegladaj historie polaczen
        przegladajHistoriePolaczenHBox.getChildren().add(przegladajHistoriePolaczenLabel);
        przegladajHistoriePolaczenHBox.getChildren().add(przegladajHistoriePolaczenButton);
        
        // Dodanie siatki poziomej przegladaj historie polaczen do siatki pionowej
        siatkaPionowaVBox.getChildren().add(przegladajHistoriePolaczenHBox);
        
        // Tworzenie siatki poziomej przegladaj tresci sms
        HBox przegladajTresciSmsHBox = new HBox(5);
        
        // Tworzenie etykiety przegladaj tresci sms
        Label przegladajTresciSmsLabel = new Label();
        przegladajTresciSmsLabel.setText("Przegladaj tresci sms");
        
        // Tworzenie przycisku przegladaj tresci sms
        Button przegladajTresciSmsButton = new Button("Przegladaj");
        przegladajTresciSmsButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                przegladajTextArea.setText(tel.przegladajTresciSms());
            }
        });
        
        // Dodanie kontrolek do siatki poziomej przegladaj tresci sms
        przegladajTresciSmsHBox.getChildren().add(przegladajTresciSmsLabel);
        przegladajTresciSmsHBox.getChildren().add(przegladajTresciSmsButton);
        
        // Dodanie siatki poziomej przegladaj tresci sms do siatki pionowej
        siatkaPionowaVBox.getChildren().add(przegladajTresciSmsHBox);
        
        // Tworzenie pola edycyjnego przegladaj
        przegladajTextArea = new TextArea();
        przegladajTextArea.setWrapText(true);
        przegladajTextArea.setEditable(false);
        przegladajTextArea.setMaxHeight(150);
        siatkaPionowaVBox.getChildren().add(przegladajTextArea);
        
        // Tworzenie etykiety komunikat
        komunikatLabel = new Label();
        komunikatLabel.setText("Brak powiadomien");
        komunikatLabel.setWrapText(true);
        siatkaPionowaVBox.getChildren().add(komunikatLabel);
        
        // Tworzenie siatki poziomej polaczenie
        HBox polaczenieHBox = new HBox(5);
        
        // Tworzenie przycisku generuj polaczenie
        Button generujPolaczenieButton = new Button("Generuj Polaczenie");
        generujPolaczenieButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                tel.generujPolaczenie();
                komunikatLabel.setText("Otrzymano polaczenie"+tel.getPolaczenie(0).toString());
                odbierzPolaczenieButton.setVisible(true);
                odrzucPolaczenieButton.setVisible(true);
            }
        });
        
        siatkaPionowaVBox.getChildren().add(generujPolaczenieButton);
        
        // Tworzenie przycisku odbierz polaczenie
        odbierzPolaczenieButton = new Button("Odbierz");
        odbierzPolaczenieButton.setVisible(false);
        odbierzPolaczenieButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //tel.odbierzPolaczenie(0);
                odbierzPolaczenieButton.setVisible(false);
                odrzucPolaczenieButton.setVisible(false);
                zakonczPolaczenieButton.setVisible(true);
            }
        });
        
        // Tworzenie przycisku odrzuc polaczenie
        odrzucPolaczenieButton = new Button("Odrzuc");
        odrzucPolaczenieButton.setVisible(false);
        odrzucPolaczenieButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //tel.odrzucPolaczenie(0);
                odbierzPolaczenieButton.setVisible(false);
                odrzucPolaczenieButton.setVisible(false);
            }
        });
        
        // Tworzenie przycisku zakoncz polaczenie
        zakonczPolaczenieButton = new Button("Zakoncz");
        zakonczPolaczenieButton.setVisible(false);
        zakonczPolaczenieButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                zakonczPolaczenieButton.setVisible(false);
            }
        });
        
        // Dodanie przyciskow do siatki poziomej polaczenie
        polaczenieHBox.getChildren().add(odbierzPolaczenieButton);
        polaczenieHBox.getChildren().add(odrzucPolaczenieButton);
        polaczenieHBox.getChildren().add(zakonczPolaczenieButton);
        
        // Dodanie siatki poziomej polaczenie do siatki pionowej
        siatkaPionowaVBox.getChildren().add(polaczenieHBox);
        
        // Tworzenie przycisku zakoncz
        Button zakonczButton = new Button("Zakoncz");
        zakonczButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        siatkaPionowaVBox.getChildren().add(zakonczButton);
        
        // Tworzenie sceny
        Scene scene = new Scene(siatkaPionowaVBox, 400, 600);
        
        // Ustalenie tytulu, glownej sceny i pokazanie glownej sceny
        primaryStage.setTitle("Telefon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
