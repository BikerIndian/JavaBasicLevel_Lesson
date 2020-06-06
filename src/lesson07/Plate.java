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
            return false;
        } else {
            food -= amount;
            return true;
        }


    }

    // 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void setFood(int food) {
        if (0 > food){
            System.out.println("Вы не положили еду");
        } else {
            this.food = food;
        }

    }

    public void info(){
        System.out.println("Plate: "+ food);
    }
}
