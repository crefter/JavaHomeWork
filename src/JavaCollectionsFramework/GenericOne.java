package JavaCollectionsFramework;

public class GenericOne {

    public static void main(String[] args) {
        new GenericOne().go();
    }

    public void takeAnimals(Animal[] animals) {
        for (Animal a : animals) {
            a.eat(a);
        }
    }

    private void go() {
        Animal[] animals = {new Dog(), new Cat(), new Cat()};
        Dog[] dog = {new Dog(), new Dog(), new Dog()};
        takeAnimals(animals);
        takeAnimals(dog);
    }

}

abstract class Animal {
    void eat(Animal a) {
        System.out.println("Animal eating" + "(" + a.getClass() + ")");
    }
}

class Dog extends Animal {
    void bark(){

    }
}

class Cat extends Animal {
    void meow() {

    }
}
