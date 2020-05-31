package lesson06;

public class Animal {
    String name;
    int maxRun;
    int maxSwim;
    private static int createdAnimal;

    public Animal(String name, int maxRun,int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        createdAnimal++;
    }

    public void run(int distance){
        if (distance < maxRun){
            System.out.println(name + " пробежал "+ distance + " м");
        } else {
            System.out.println(name + " не может пробежать больше "+ maxRun + " м");
        }


    }
    public void swim(int distance){
        if (distance < maxSwim){
            System.out.println(name + " проплыл "+ distance + " м");
        } else {
            System.out.println(name + " не может проплыть больше "+ maxSwim + " м");
        }
    }

    public int getCreatedAnimal() {
        return createdAnimal;
    }
}
