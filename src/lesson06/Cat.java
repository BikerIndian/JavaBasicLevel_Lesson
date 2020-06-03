package lesson06;

public class Cat extends Animal{
    private static int createdCat;

    public Cat(String name, int maxRun) {
        super(name, maxRun, 0);
        createdCat++;
    }


    @Override
    public void swim(int distance){
        System.out.println(name + " не умеет плавать");
    }

     public int getCreatedCat() {
        return createdCat;
    }
}
