package lesson06;

public class Dog extends Animal{
    private static int createdDog;

    public Dog(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
        createdDog++;
    }


    public int getCreatedDog() {
        return createdDog;
    }
}
