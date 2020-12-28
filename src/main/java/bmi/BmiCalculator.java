package bmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BmiCalculator extends Application {
    public static String filePath;

    public static void main(String[] args) {
        filePath = args[0];
        launch(args);
     }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gui.fxml"));
        primaryStage.setTitle("BMI calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}




















//MOCNO ZBEDNE PONIZEJ
//20 – 23 lata: 19 – 24
//26 – 33 lata: 20 – 25
//36 – 43 lata: 21 – 26
//46 – 53 lata: 22 – 27
//56 – 63 lata: 23 – 28
//ponad 64 lata: 24 – 29

// ilość tkanki tłuszczowej
// styl życia

// symulator osoby regulacja ile je, zmiana masy, ilość ruchu
// jak sie bd zmieniała waga