package lesson07;

/*
    ФИО:  		    Свищ Владимир Сергеевич
    Факультет:      Geek University Android-разработки (478 - 12.05.2020)
    Курс: 		    Java Core. Базовый уровень
    Урок: 		    Урок 7. Практика ООП и работа со строками
    Дата правки:    03.06.2020
*/


import java.util.Random;

public class MainLesson07 {
    private static final Random random = new Random();

    public static void main(String[] args) {
    /*
       + 1. Расширить задачу про котов и тарелки с едой
       + 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного
            количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
       + 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
            Если коту удалось покушать (хватило еды), сытость = true
       + 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает,
            то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
       + 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
            и потом вывести информацию о сытости котов в консоль
       + 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
     */

        // 5. Создать массив котов и тарелку с едой...
        int createCat = 10;

        Cat[] cats = new Cat[createCat];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat "+(i+1),random.nextInt(6)+15);
        }
        Plate plate = new Plate(100);

        // 5. ... попросить всех котов покушать из этой тарелки ...
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        // 5. ... вывести информацию о сытости котов в консоль.
        printSatietyCats(cats);

        // Покормить голодных
        System.out.println("Кормим голодных котов");
        plate.setFood(100);
        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].isSatiety()) {
                cats[i].eat(plate);
            }

        }

        printSatietyCats(cats);
   }

    private static void printSatietyCats(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].isSatiety()) {
                System.out.println("Кот ["+cats[i].getName() + "] сыт");
            }else {
                System.out.println("Кот ["+cats[i].getName() + "] голоден");
            }

        }
    }


}