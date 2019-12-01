package sample;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.FileHandler;
import Classes.Structure;
import Classes.Student;
import Classes.StudentDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;


public class mainController {
    String name = new String();
    String fac = new String();
    String num = new String();
    int curse;
    String nameTeach = new String();
    String nameSub = new String();
    String assessment = new String();

    ToggleGroup cursGroup = new ToggleGroup();
    ToggleGroup asGroup1 = new ToggleGroup();
    ToggleGroup asGroup2 = new ToggleGroup();
    ToggleGroup asGroup3 = new ToggleGroup();
    ToggleGroup asGroup4 = new ToggleGroup();

    Structure struct = new Structure();
    Student student = new Student();
    StudentDB stDB = new StudentDB();
    FileHandler fH = new FileHandler();
    private ObservableList<Student> list = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField sub4;

    @FXML
    private TextField sub2;

    @FXML
    private TextField sub3;

    @FXML
    private TextField sub1;

    @FXML
    private TextField numZach;

    @FXML
    private RadioButton assessment1_1;

    @FXML
    private RadioButton assessment2_1;

    @FXML
    private RadioButton assessment3_1;

    @FXML
    private RadioButton assessment2_2;

    @FXML
    private RadioButton assessment1_3;

    @FXML
    private RadioButton assessment1_2;

    @FXML
    private RadioButton assessment1_5;

    @FXML
    private RadioButton assessment4_3;

    @FXML
    private RadioButton assessment3_4;

    @FXML
    private RadioButton assessment2_5;

    @FXML
    private RadioButton assessment1_4;

    @FXML
    private RadioButton assessment4_4;

    @FXML
    private RadioButton assessment3_5;

    @FXML
    private RadioButton assessment4_1;

    @FXML
    private RadioButton assessment3_2;

    @FXML
    private RadioButton assessment2_3;

    @FXML
    private TextField lecturer4;

    @FXML
    private RadioButton assessment4_2;

    @FXML
    private RadioButton assessment3_3;

    @FXML
    private RadioButton assessment2_4;

    @FXML
    private RadioButton assessment4_5;

    @FXML
    private RadioButton course4;

    @FXML
    private RadioButton course3;

    @FXML
    private RadioButton course5;

    @FXML
    private TextField lecturer2;

    @FXML
    private TextField FAC;

    @FXML
    private TextField lecturer3;

    @FXML
    private Button addButton;

    @FXML
    private TextField lecturer1;

    @FXML
    private TextField FIO;

    @FXML
    private RadioButton course2;

    @FXML
    private RadioButton course1;

    @FXML
    private TableView<Student> tableInfo;

    @FXML
    private TableColumn<Student, String> colStudent;

    @FXML
    private TableColumn<Student,Integer> colCourse;

    @FXML
    private TableColumn<Student,String> colFac;

    @FXML
    private TableColumn<Student,String> colNum;

    @FXML
    private TableColumn<Student,String> colSub;

    @FXML
    private TableColumn<Student,String> colLec;

    @FXML
    private TableColumn<Student,String> colAs;


    @FXML
    void initialize() {
        course1.setToggleGroup(cursGroup);
        course2.setToggleGroup(cursGroup);
        course3.setToggleGroup(cursGroup);
        course4.setToggleGroup(cursGroup);
        course5.setToggleGroup(cursGroup);

        assessment1_1.setToggleGroup(asGroup1);
        assessment1_2.setToggleGroup(asGroup1);
        assessment1_3.setToggleGroup(asGroup1);
        assessment1_4.setToggleGroup(asGroup1);
        assessment1_5.setToggleGroup(asGroup1);

        assessment2_1.setToggleGroup(asGroup2);
        assessment2_2.setToggleGroup(asGroup2);
        assessment2_3.setToggleGroup(asGroup2);
        assessment2_4.setToggleGroup(asGroup2);
        assessment2_5.setToggleGroup(asGroup2);

        assessment3_1.setToggleGroup(asGroup3);
        assessment3_2.setToggleGroup(asGroup3);
        assessment3_3.setToggleGroup(asGroup3);
        assessment3_4.setToggleGroup(asGroup3);
        assessment3_5.setToggleGroup(asGroup3);

        assessment4_1.setToggleGroup(asGroup4);
        assessment4_2.setToggleGroup(asGroup4);
        assessment4_3.setToggleGroup(asGroup4);
        assessment4_4.setToggleGroup(asGroup4);
        assessment4_5.setToggleGroup(asGroup4);

        clear();

        colStudent.setCellValueFactory(new PropertyValueFactory<Student,String>("Name"));
        colCourse.setCellValueFactory(new PropertyValueFactory<Student,Integer>("course"));
        colFac.setCellValueFactory(new PropertyValueFactory<Student,String>("faculty"));
        colNum.setCellValueFactory(new PropertyValueFactory<Student,String>("numberRecord"));
        colLec.setCellValueFactory(new PropertyValueFactory<Student,String>("lecturer"));
        colSub.setCellValueFactory(new PropertyValueFactory<Student,String>("subject"));
        colAs.setCellValueFactory(new PropertyValueFactory<Student,String>("assessment"));

        addToTable();

        addButton.setOnAction(event->{Input();});



    }

    private void addToTable(){
        list.addAll(stDB.getList());
        tableInfo.setItems(list);
    }

    private void refresh(){
        tableInfo.getItems().clear();
        addToTable();
    }

    public void Input(){

        if(FIO.getLength()==0||FAC.getLength()==0||numZach.getLength()==0||lecturer1.getLength()==0||sub1.getLength()==0){
            error(1);
        }
        else{
            name = FIO.getText();
            fac = FAC.getText();
            num = numZach.getText();
            curse = cur();
            nameTeach = lecturer1.getText();
            nameSub = sub1.getText();
            assessment = assess1();
            if(lecturer2.getLength()!=0||sub2.getLength()!=0){
                nameTeach += "\r\n";
                nameSub +="\r\n";
                nameTeach+=lecturer2.getText();
                nameSub += sub2.getText();
                assessment += assess2();
                if(lecturer3.getLength()!=0&&sub3.getLength()!=0){
                    nameTeach += "\r\n";
                    nameSub +="\r\n";
                    nameTeach+=lecturer3.getText();
                    nameSub += sub3.getText();
                    assessment+= assess3();
                    if(lecturer4.getLength()!=0&&sub4.getLength()!=0) {
                        nameTeach += "\r\n";
                        nameSub +="\r\n";
                        nameTeach += lecturer4.getText();
                        nameSub += sub4.getText();
                        assessment += assess4();
                    }
                }
            }
            student.setName(name);
            student.setFaculty(fac);
            student.setNumberRecord(num);
            student.setCourse(curse);
//            struct.setAssessment(assessment);
            student.setLecturer(nameTeach);
            student.setSubject(nameSub);
            student.setAssessment(assessment);
            stDB.add(student);
            refresh();
//            colStudent.setCellFactory(stDB.students.get(0).getName());
//            try {
//                fH.writeF("Out",stDB);
//            } catch (IOException e) {
//                e.printStackTrace();
//                error(2);
//            }

        }
        clear();

    }

    public String assess1(){
        if(assessment1_1.isSelected()){
            return "1";
        }
        else if(assessment1_2.isSelected()){
            return "2";
        }
        else if(assessment1_3.isSelected()){
            return "3";
        }
        else if(assessment1_4.isSelected()){
            return "4";
        }
        else if(assessment1_5.isSelected()){
            return "5";
        }
        return null;
    }

    public String assess2(){
        if(assessment2_1.isSelected()){
            return "\r\n1";
        }
        else if(assessment2_2.isSelected()){
            return "\r\n2";
        }
        else if(assessment2_3.isSelected()){
            return "\r\n3";
        }
        else if(assessment2_4.isSelected()){
            return "\r\n4";
        }
        else if(assessment2_5.isSelected()){
            return "\r\n5";
        }
        return null;
    }

    public String assess3(){
        if(assessment3_1.isSelected()){
            return "\r\n1";
        }
        else if(assessment3_2.isSelected()){
            return "\r\n2";
        }
        else if(assessment3_3.isSelected()){
            return "\r\n3";
        }
        else if(assessment3_4.isSelected()){
            return "\r\n4";
        }
        else if(assessment3_5.isSelected()){
            return "\r\n5";
        }
        return null;
    }

    public String assess4(){
        if(assessment4_1.isSelected()){
            return "\r\n1";
        }
        else if(assessment4_2.isSelected()){
            return "\r\n2";
        }
        else if(assessment4_3.isSelected()){
            return "\r\n3";
        }
        else if(assessment4_4.isSelected()){
            return "\r\n4";
        }
        else if(assessment4_5.isSelected()){
            return "\r\n5";
        }
        return null;
    }

    public int cur(){
        if(course1.isSelected()){
            return 1;
        }
        else if(course2.isSelected()){
            return 2;
        }
        else if(course3.isSelected()){
            return 3;
        }
        else if(course4.isSelected()){
            return 4;
        }
        else if(course5.isSelected()){
            return 5;
        }
        return 0;
    }



    public void clear(){
        assessment1_5.setSelected(true);
        assessment1_5.setSelected(true);
        assessment2_5.setSelected(true);
        assessment3_5.setSelected(true);
        assessment4_5.setSelected(true);
        course1.setSelected(true);
        FIO.setText(null);
        FAC.setText(null);
        numZach.setText(null);
    }

    public void addTable(Student student){
//        colStudent.getCellValueFactory(new PropertyValueFactory<Student,String>(student.getName()));
    }

    public void error(int numE){

    }

}
