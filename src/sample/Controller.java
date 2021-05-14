package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button btnCheck;
    @FXML
    private Button btnReset;
    @FXML
    private TextField txtIct1;
    @FXML
    private TextField txtIct2;
    @FXML
    private Label lblResult;
    @FXML
    private Label lblAverage;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblGrade;


    @FXML
    public void checking(){

        double ict1=Double.parseDouble(txtIct1.getText());
        double ict2=Double.parseDouble(txtIct2.getText());
        double average=(ict1+ict2)/2;

        if(0<=ict1 && ict1<=100){
            if(0<=ict2 && ict2<=100){
                text(average,ict1,ict2);
            }else{
                lblResult.setText("Enter correct ICT2 marks");
            }

        }else{
            lblResult.setText("Enter correct ICT1 marks");
        }

    }

    @FXML
    public void text(double average,double ict1,double ict2){
        if(average>=40){
            if(ict1<30 && ict2<30){
                lblResult.setText("ICT 1 and 2 got bellow 30. FAIL😑");
                lblGrade.setText("F");
            }else if (ict1<30){
                lblResult.setText("ICT 1 got bellow 30. FAIL😑");
                lblGrade.setText("F");
            }else if (ict2<30){
                lblResult.setText("ICT 2 got bellow 30. FAIL😑");
                lblGrade.setText("F");
            }else{
                lblResult.setText("You passed to next semester. 🤞");
                grade(average);//to set the grade
            }

        }else{
            lblResult.setText("Average is bellow 40.😑");
            lblGrade.setText("F");
        }
        lblAverage.setText(Double.toString(average));
        lblTotal.setText(Double.toString(ict1+ict2));
    }
    @FXML
    public void grade(double average){
        //to give the class of the module
        if(average>=75){
            lblGrade.setText("A");
        }else if(average>=65){
            lblGrade.setText("B");
        }else if(average>=55){
            lblGrade.setText("C");
        }else if(average>=40){
            lblGrade.setText("S");
        }else{
            lblGrade.setText("F");
        }

    }

    @FXML
    public void reset(){
        lblResult.setText("");
        lblTotal.setText("0.0");
        lblAverage.setText("0.0");
        txtIct1.setText("");
        txtIct2.setText("");
        lblGrade.setText("_");
    }
}
