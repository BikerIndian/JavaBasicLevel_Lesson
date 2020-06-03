package lesson07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int amount){
        if (0 > (food - amount)){
            System.out.println("Не хватает еды");
            return false;
        } else {
            food -= amount;
            return true;
        }


    }

    public void info(){
        System.out.println("Plate: "+ food);
    }
}
