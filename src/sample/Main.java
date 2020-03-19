package sample;

import java.io.FileInputStream;
import java.lang.System;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Application {
    int   no_seats = 42;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,String> cus_info_to_colombo = new HashMap<Integer, String>();
        HashMap<Integer,String> cus_info_to_badulla = new HashMap<Integer, String>();


        while (true) {
            System.out.println("Enter \"A\" to add a customer");
            System.out.println("Enter \"V\" to view all seats");
            System.out.println("Enter \"E\" view all empty seats");
            System.out.println("Enter \"D\" delete booked seats");
            System.out.println("Enter \"F\"to find a seat by customer's name");
            System.out.println("Enter \"Q\" to exit the program");
            String option = sc.next();
            switch (option) {
                case "A":
                case "a":
                    System.out.println("Enter 1 if your destination is Colombo");
                    System.out.println("Enter 2 if your destination is Badulla");
                    System.out.print("Enter your option : ");
                    int user_input = sc.nextInt();

                    if(user_input==1){
                        addcustomer(cus_info_to_colombo);
                    } else if (user_input==2){
                        addcustomer(cus_info_to_badulla);
                    } else {
                        System.out.println("Invalid Input");
                    }

                    break;
                case "V":
                case "v":
                    System.out.println("Enter 1 if your destination is Colombo");
                    System.out.println("Enter 2 if your destination is Badulla");
                    System.out.print("Enter your option : ");
                    int user_input1 = sc.nextInt();

                    if(user_input1==1){
                        viewAllSeats(cus_info_to_colombo);;
                    } else if (user_input1==2){
                        viewAllSeats(cus_info_to_badulla);
                    } else {
                        System.out.println("Invalid Input");
                    }

                    break;
                case "E":
                case "e":
                    System.out.println("Enter 1 if your destination is Colombo");
                    System.out.println("Enter 2 if your destination is Badulla");
                    System.out.print("Enter your option : ");
                    int user_input2 = sc.nextInt();

                    if(user_input2==1){
                        viewEmptySeats(cus_info_to_colombo);
                    } else if (user_input2==2){
                        viewEmptySeats(cus_info_to_badulla);
                    } else {
                        System.out.println("Invalid Input");
                    }

                    break;
                case "D":
                case "d":
                    System.out.println("Enter 1 if your destination is Colombo");
                    System.out.println("Enter 2 if your destination is Badulla");
                    System.out.print("Enter your option : ");
                    int user_input3 = sc.nextInt();

                    if(user_input3==1){
                        deleteBooking(cus_info_to_colombo);
                    } else if (user_input3==2){
                        deleteBooking(cus_info_to_badulla);
                    } else {
                        System.out.println("Invalid Input");
                    }

                    break;
                case "F":
                case "f":
                    System.out.println("Enter 1 if your destination is Colombo");
                    System.out.println("Enter 2 if your destination is Badulla");
                    System.out.print("Enter your option : ");
                    int user_input4 = sc.nextInt();

                    if(user_input4==1){
                        findSeatByCusName(cus_info_to_colombo);
                    } else if (user_input4==2){
                        findSeatByCusName(cus_info_to_badulla);
                    } else {
                        System.out.println("Invalid Input");
                    }
                case "O":
                case"o":
                    System.out.println("Enter 1 if your destination is Colombo");
                    System.out.println("Enter 2 if your destination is Badulla");
                    System.out.print("Enter your option : ");
                    int user_input5 = sc.nextInt();

                    if(user_input5==1){
                        cusnameAlphabaticallyOrdered(cus_info_to_colombo);
                    } else if (user_input5==2){
                        cusnameAlphabaticallyOrdered(cus_info_to_badulla);
                    } else {
                        System.out.println("Invalid Input");
                    }


                    break;
                case "Q":
                case "q":
                    exit();
                default:
                    System.out.println("Invalid input re enter: ");

            }


        }

    }

    private void exit() {
        int i = 0;
        System.exit(i);
    }
    private void addcustomer(HashMap<Integer, String> cus_info) throws FileNotFoundException {
        ArrayList<Integer> seat_number = new ArrayList<Integer>();
        ArrayList<String> cus_name = new ArrayList<String>();


        Stage primaryStage = new Stage();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Add Customer");
        BorderPane borderPane = new BorderPane();

        VBox left_seats = new VBox();
        left_seats.setSpacing(10);

        VBox right_seats = new VBox();
        right_seats.setSpacing(10);

        try {
            // create a input stream
            FileInputStream input = new FileInputStream("C:\\Users\\user\\Desktop\\bg.jpg");

            // create a image
            Image image = new Image(input);

            // create a background image
            BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

            // create Background
            Background background = new Background(backgroundimage);



            // set background
            borderPane.setBackground(background);

        } catch (Exception e) {
            //ignored
        }


        for (int a = 1; a <= 21; a++) {
            ToggleButton button = new ToggleButton("Seat" + a);
            button.setId(Integer.toString(a));
            left_seats.getChildren().addAll(button);
            borderPane.setLeft(left_seats);
            Button book = new Button("Book");
            book.setStyle("-fx-background-color: blue; -fx-text-fill:white");
            borderPane.setBottom(book);

            if (cus_info.containsKey(a)) {
                button.setStyle("-fx-background-color: red; -fx-text-fill:white");
            } else {

                button.setOnAction((e) -> {
                    if (button.isSelected()) {
                        button.setStyle("-fx-background-color: red; -fx-text-fill:white");
                        seat_number.add(Integer.valueOf(button.getId()));
                        System.out.println(seat_number);
                    } else {
                        seat_number.remove(Integer.valueOf(button.getId()));
                        System.out.println(seat_number);
                    }
                });

                book.setOnAction(e -> {
                    primaryStage.close();
                    book.setStyle("-fx-background-color: green; -fx-text-fill:white");
                    Stage Popup = new Stage();

                    //Popup.initModality(Modality.APPLICATION_MODAL);
                    Popup.setTitle("Customer's_Info");

                    AnchorPane anchorPane = new AnchorPane();

                    TextField name = new TextField();
                    name.setLayoutX(250);
                    name.setLayoutY(330);
                    Button confirm = new Button("confirm");
                    // confirm.setAlignment(Pos.CENTER_RIGHT);

                    if(cus_name.contains(name.getText().toLowerCase())){
                        cus_info.put(Integer.valueOf(button.getId()),name.getText().toLowerCase());
                    }else{
                        cus_info.put(Integer.valueOf(button.getId()),name.getText().toLowerCase());
                        cus_name.add(name.getText().toLowerCase());
                    }

                    // flowPane.setAlignment(Pos.CENTER);
                    anchorPane.getChildren().addAll(confirm, name);


                    confirm.setOnAction(e1 -> {
                        for (Integer i : seat_number) {
                            cus_info.put(i, name.getText());
                            Popup.close();
                        }
                    });

                    Scene scene2 = new Scene(anchorPane, 600, 550);
                    Popup.setScene(scene2);
                    Popup.showAndWait();
                });


            }
        }


        for (int a = 22; a <= 42; a++) {
            ToggleButton button1 = new ToggleButton("Seat" + a);
            button1.setId(Integer.toString(a));
            right_seats.getChildren().addAll(button1);
            borderPane.setRight(right_seats);
            Button book = new Button("Book");
            book.setStyle("-fx-background-color: blue; -fx-text-fill:white");
            borderPane.setBottom(book);

            if (cus_info.containsKey(a)) {
                button1.setStyle("-fx-background-color: red; -fx-text-fill:white");
            } else {


                book.setOnAction(e -> {
                    book.setStyle("-fx-background-color: green; -fx-text-fill:white");

                    Stage Popup = new Stage();

                    //Popup.initModality(Modality.APPLICATION_MODAL);
                    Popup.setTitle("Customer's_Info");

                    FlowPane flowPane = new FlowPane();

                    TextField name1 = new TextField();
                    Button confirm1 = new Button("confirm");
                    confirm1.setAlignment(Pos.CENTER_RIGHT);
                    flowPane.setHgap(50);
                    flowPane.setVgap(50);

                    flowPane.setAlignment(Pos.CENTER);
                    flowPane.getChildren().addAll(confirm1, name1);


                    confirm1.setOnAction(e1 -> {
                        for (Integer i : seat_number) {
                            cus_info.put(i, name1.getText());
                            System.out.println("Thanks for booking" + name1.getText() + i);
                        }
                        Popup.close();
                    });

                    Scene scene2 = new Scene(flowPane, 600, 550);
                    Popup.setScene(scene2);
                    Popup.showAndWait();
                });

                button1.setOnAction((e) -> {
                    if (button1.isSelected()) {
                        button1.setStyle("-fx-background-color: red; -fx-text-fill:white");
                        seat_number.add(Integer.valueOf(button1.getId()));
                        System.out.println(seat_number);
                    } else {
                        seat_number.remove(Integer.valueOf(button1.getId()));
                        System.out.println(seat_number);
                    }
                });
            }

        }
            Scene scene = new Scene(borderPane, 200, 750);
            primaryStage.setScene(scene);
            primaryStage.showAndWait();


    }
    private void viewAllSeats(HashMap<Integer,String> cus_info) {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Seats");

        VBox left_seats = new VBox();
        left_seats.setSpacing(10);

        VBox right_seats = new VBox();
        right_seats.setSpacing(10);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(left_seats);
        borderPane.setRight(right_seats);

        try {
            // create a input stream
            FileInputStream input = new FileInputStream("C:\\Users\\user\\Desktop\\bg.jpg");

            // create a image
            Image image = new Image(input);

            // create a background image
            BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

            // create Background
            Background background = new Background(backgroundimage);



            // set background
            borderPane.setBackground(background);

        } catch (Exception e) {
            //ignored
        }


        for (int a = 1; a <= 21; a++) {
            Button button = new Button("Seat" + a);
            button.setId(Integer.toString(a));
            left_seats.getChildren().add(button);


        }
        for (int b = 22; b <= 42; b++) {
            Button button1 = new Button("Seat" + b);
            button1.setId(Integer.toString(b));
            right_seats.getChildren().add(button1);

        }




        Scene scene = new Scene(borderPane, 200, 750);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();


    }
    private void viewEmptySeats(HashMap<Integer,String> cus_info) {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("View Empty Seats");
        BorderPane borderPane = new BorderPane();

        VBox left_seats = new VBox();
        left_seats.setSpacing(10);

        VBox right_seats = new VBox();
        right_seats.setSpacing(10);

        for (int i = 1; i <= 21; i++) {
            Button button = new Button("Seat " + i);
            button.setId(Integer.toString(i));
            left_seats.getChildren().add(button);
            borderPane.setLeft(left_seats);

            if (cus_info.containsKey(Integer.parseInt(button.getId()))) {
                button.setVisible(false);
            }
        }
        for (int i = 22; i <= 42; i++) {
            Button button1 = new Button("Seat " + i);
            button1.setId(Integer.toString(i));
            right_seats.getChildren().add(button1);
            borderPane.setRight(right_seats);
            if (cus_info.containsKey(Integer.parseInt(button1.getId()))) {
                button1.setVisible(false);

            }
        }
        Scene scene = new Scene(borderPane, 250, 700);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }
    private void deleteBooking(HashMap<Integer,String> cus_info){
        Scanner sc = new Scanner(System.in);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Delete Seats");
        FlowPane flowPane = new FlowPane();

        HBox hBox = new HBox();
        Label label = new Label("Enter the customer's name:  ");
        TextField name = new TextField();
        Button enter = new Button("Enter");
        hBox.getChildren().addAll(name,enter,label);
        enter.setOnAction(e -> {
                    if (cus_info.isEmpty()) {
                        empty();
                    } else {
                        String remove_seat_name = name.getText();
                        primaryStage.close();
                        if (!cus_info.containsValue(remove_seat_name)) {
                            System.out.println("No seats booked under the name " + remove_seat_name);
                        } else {
                            System.out.println("You have booked these seats");
                            if (cus_info.containsValue(remove_seat_name)) {
                                for (HashMap.Entry<Integer, String> entry : cus_info.entrySet()) {
                                    if (remove_seat_name.equals(entry.getValue())) {
                                        System.out.println(entry.getKey() + " ");
                                    }
                                }
                                System.out.println("Which seat number do you want yo delete: ");
                                while (!sc.hasNextInt()) {
                                    System.out.println("Enter Integers! ");
                                    System.out.println("Which seat you want to delete:");
                                    sc.nextInt();


                                }
                                int remove_seat_number = sc.nextInt();
                                success();

                                if (cus_info.containsKey(remove_seat_number)) {
                                    cus_info.remove(remove_seat_number);
                                } else {
                                    System.out.println("Incorrect seat number re enter :");
                                    sc.nextInt();
                                }
                            }
                        }
                    }
                });

        flowPane.setHgap(50);
        flowPane.setVgap(50);


        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.getChildren().add(hBox);

        Scene scene= new Scene(flowPane,600,550);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }
    private void findSeatByCusName(HashMap<Integer,String> cus_info){
        ArrayList<String> cus_name = new ArrayList<String>(cus_info.values());
        Scanner sc = new Scanner(System.in);
        Stage stage = new Stage();
        stage.setTitle("Find Seat");

        AnchorPane anchorPane=new AnchorPane();
        Label label=new Label("Enter the name here :");
        label.setLayoutY(50);
        label.setLayoutX(50);
        TextField txt = new TextField();
        txt.setLayoutY(100);
        txt.setLayoutX(100);
        Button find= new Button("Find");
        find.setLayoutX(100);
        find.setLayoutY(200);
        anchorPane.getChildren().addAll(label,find,txt);

        find.setOnAction(e->{
            if(cus_info.isEmpty()){
                empty();
            }else{
                stage.close();
                String find_name = txt.getText();
                if(cus_info.containsValue(find_name)){
                    for(String name : cus_name ){
                        if(name.equalsIgnoreCase(find_name)){
                            for(Object seat: cus_info.keySet() ){
                                if(cus_info.get(seat).equalsIgnoreCase(find_name)){
                                    System.out.println(name +" has booked seat " + seat);
                                }
                            }
                        }
                    }
                }
            }
        });
        Scene scene = new Scene(anchorPane,500,500);
        stage.setScene(scene);
        stage.showAndWait();

    }
    private void cusnameAlphabaticallyOrdered(HashMap<Integer,String> cus_info ){
        ArrayList<String> cus_name = new ArrayList<String>(cus_info.values());
        String x;
        int i,j;
        System.out.println("Names after sorted alphabatically are :");
        System.out.println();
        for(i=0; i < cus_name.size(); i++){
            for(j = i + 1; j < cus_name.size(); j++){
                if(cus_name.get(j).compareTo(cus_name.get(i)) <0);{
                    x = cus_name.get(i);
                    cus_name.set(i, cus_name.get(j));
                    cus_name.set(j ,x);
                }
            }
        }
        for(String s: cus_name){
            for(Object o: cus_info.keySet()){
                if(cus_info.get(o).equalsIgnoreCase(s)){
                    System.out.println(s +"-" + o);
                }
            }
        }
        System.out.println();
    }
    private void success(){
        Stage stage = new Stage();
        stage.setTitle("Deleted the booking");

        FlowPane flowPane = new FlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        Label label=new Label("You have succesfully deleted the booking");
        label.setAlignment(Pos.CENTER);
        flowPane.getChildren().add(label);

        Scene scene = new Scene(flowPane,300,200);
        stage.setScene(scene);
        stage.showAndWait();
    }
    private void failed(){
        Stage stage = new Stage();
        stage.setTitle("Failed");

        FlowPane flowPane = new FlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        Label label=new Label("There is no customer by that name");
        label.setAlignment(Pos.CENTER);
        flowPane.getChildren().add(label);

        Scene scene = new Scene(flowPane,300,200);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private void empty(){
        Stage stage = new Stage();
        stage.setTitle("Still Empty");

        FlowPane flowPane = new FlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        Label label=new Label("No seats have been booked yet");
        label.setAlignment(Pos.CENTER);
        flowPane.getChildren().add(label);

        Scene scene = new Scene(flowPane,300,200);
        stage.setScene(scene);
        stage.showAndWait();
    }
}

