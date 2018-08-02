package Dog;

public class Dog {
    private String name;

    private void bark(){
        System.out.println(name + " сказал гав");
    }


    public void eat(){}
    public void chaseCat(){}

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "KEK";

        Dog[] pets = new Dog[3];
        pets[0] = new Dog();
        pets[1] = new Dog();
        pets[2] = dog1;

        pets[0].name = "Cheburek";
        pets[1].name = "LOL";

        int x = 0;
        while (x < pets.length){
            pets[x].bark();
            x++;
        }
    }
}
