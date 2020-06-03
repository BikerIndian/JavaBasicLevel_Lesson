package lesson07;

public class Cat {
    private String name;
    private boolean satiety = false; // сытость
    private int hunger;              // голод

    public Cat(String name, int hunger) {
        this.name = name;
        this.hunger = hunger;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        satiety = plate.decreaseFood(hunger);
    }

    // Сытость
    public boolean isSatiety() {
        return satiety;
    }
}
