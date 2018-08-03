package JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.List;

public class GenericTwo {

    public static void main(String[] args) {
        new GenericTwo().go();
    }

    public void takeAnimals(ArrayList<AnimalA> animals) {
        for (AnimalA a : animals) {
            a.eat(a);
        }
    }

    private void go() {
        ArrayList<AnimalA> animals = new ArrayList<AnimalA>();
        animals.add(new Dogg());
        animals.add(new Catt());
        animals.add(new Dogg());
        animals.add(new Catt());

        takeAnimals(animals);

        /*ArrayList<Dogg> doggs = new ArrayList<Dogg>(); - Запрещено!
        (Должны передавать одинаковые типы либо <AnimalA>, либо ничего другого)*/
        //Создаем ArrayList с передаваемым типом <AnimalA> - так можно
        ArrayList<AnimalA> doggs = new ArrayList<AnimalA>();
        doggs.add(new Dogg());
        doggs.add(new Dogg());
        doggs.add(new Dogg());

        

        takeAnimals(doggs);
    }
}
abstract class AnimalA {
        void eat(AnimalA a) {
            System.out.println("Animal eating" + "(" + a.getClass() + ")");
        }
    }

class Dogg extends AnimalA {
        void bark(){
        }
    }

class Catt extends AnimalA {
        void meow() {
        }
    }
