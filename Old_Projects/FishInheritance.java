class Fish {
    String name;
    public void swim() {
    System.out.println("I can swim");
    }
   }
   class Tilapia extends Fish {
    public void display() {
    System.out.println("My name is " + name);
    }
   }
   class Main {
    public static void main(String[] args) {
    Tilapia freshwater = new Tilapia();
    freshwater.name = "Tippy";
    freshwater.display();
    freshwater.swim();
    }
   }
