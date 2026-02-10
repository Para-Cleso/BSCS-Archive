package com.example;

public class Cardemo {
    enum Color {RED, YELLOW, BLUE, GREEN, MAROON, NAVY};

    enum Model {SEDAN, SUV, CONVERTIBLE, HATCHBACK};

    static class Car{
        private int year;
        private Model model;
        private Color color;

        public Car(int yr, Model m, Color c){
            this.year = yr;
            this.color = c;
            this.model = m;
        }
        public void display(){
        
            System.out.println("\nCar: " + year + " " + model + " " + color);
        } 
    }
    public static void main(String[] args) {
        Car car1 = new Car(2014, Model.SUV, Color.RED);
        Car car2 = new Car(2020, Model.SEDAN, Color.MAROON);
        Car car3 = new Car(2018, Model.CONVERTIBLE, Color.BLUE);
        
        car1.display();
        car2.display();
        car3.display();
    }
}


