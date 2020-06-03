package lesson07;

public class Cat {
    private String name;
    private boolean satiety = false;
    int hunger;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        System.out.println(name + " eat...");

        if (plate.decreaseFood(hunger)){
            satiety = true;
        }
    }

}
