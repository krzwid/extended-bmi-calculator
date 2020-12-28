package bmi;

import bmi.profession.Person;
import bmi.profession.WorkType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GuiController {
    @FXML TextField heightText;
    @FXML TextField weightText;
    @FXML TextField ageText;
    @FXML ComboBox professionText;
    @FXML Button calculateButton;

    private float height, weight;
    private int age;
    private String profession;

    public void calculate(ActionEvent event) {
        height = Float.parseFloat(heightText.getText());
        weight = Float.parseFloat(weightText.getText());
        age = Integer.parseInt(ageText.getText());
        profession = professionText.getValue().toString();
        startApp(BmiCalculator.filePath);
    }

    public void startApp(String folderPath) {
        try {

//            String folderPath = "C:\\Users\\Lenovo\\Documents\\STUDIA\\5_SEMESTR\\PSIIII\\BMI\\src\\main\\resources\\logic";
            String fileName = folderPath.concat("\\").concat(profession).concat(".fcl");

            if (!(16 < age && age < 100)) {
                throw new IllegalArgumentException("Age must be between 16 and 100.");
            }

            if (!(140 < height && height < 240)) {
                throw new IllegalArgumentException("Height must be between 140 and 240 cm.");
            }

            if (!(40 < weight && weight < 250)) {
                throw new IllegalArgumentException("Height must be between 40 and 250 kg.");
            }

            float bmi = weight/(height*height)*10000;
            System.out.println(bmi);
            WorkType workType = WorkType.fromString(profession);

            Person person = new Person(workType, fileName, bmi, age);
            person.evaluate();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid number of parameters: <path to folder logic> <age> <height> <weight> <bmi.profession>");
        }
    }
}