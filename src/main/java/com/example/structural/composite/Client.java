package com.example.structural.composite;

public class Client {

    public static void main(String[] args) {
        Composite root = new Composite("Root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite composite = new Composite("X");
        composite.add(new Leaf("Leaf XA"));
        composite.add(new Leaf("Leaf XB"));
        composite.add(new Composite("Composite XC"));
        
        root.add(composite);

        Composite composite2 = new Composite("XY");
        composite2.add(new Leaf("Leaf XYA"));
        composite2.add(new Leaf("Leaf XYB"));

        composite.add(composite2);
        root.display();
    }


}
