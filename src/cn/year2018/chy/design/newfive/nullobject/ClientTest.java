package cn.year2018.chy.design.newfive.nullobject;

public class ClientTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        hear(dog);
        hear(new NullAnimal());
    }

    public static void hear(Animal animal) {
//        if(animal != null)
        animal.makeSound();
    }
}
