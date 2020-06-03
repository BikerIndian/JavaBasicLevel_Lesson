package lesson06;

/*
    ФИО:  		    Свищ Владимир Сергеевич
    Факультет:      Geek University Android-разработки (478 - 12.05.2020)
    Курс: 		    Java Core. Базовый уровень
    Урок: 		    Урок 6. Продвинутое ООП
    Дата правки:    31.05.2020
*/

import java.util.Random;

public class MainLesson06 {
    private static final Random random = new Random();

    public static void main(String[] args) {
    /*
        1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому
        методу передается длина препятствия. Результатом выполнения действия
         будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
        плавание: кот не умеет плавать, собака 10 м.).
        4. * Добавить подсчет созданных котов, собак и животных.
        5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение
         на бег может быть 400 м., у другой 600 м.
     */

        Dog dogBobik = new Dog("Бобик",random.nextInt(200)+400,10);
        Dog dogSharik = new Dog("Шарик",random.nextInt(200)+400,10);
        Dog dogTuzik = new Dog("Тузик",random.nextInt(200)+400,10);

        dogBobik.run(1500);
        dogSharik.run(150);
        dogTuzik.swim(5);
        dogTuzik.swim(20);

        Cat catBarsik = new Cat("Барсик",random.nextInt(200)+300);
        Cat catMurzik = new Cat("Мурзик",random.nextInt(200)+300);
        System.out.println();
        catMurzik.run(20);
        catBarsik.swim(0);

        System.out.println("\nСобак "+dogBobik.getCreatedDog());
        System.out.println("Котов "+catBarsik.getCreatedCat());
        System.out.println("Всего животных "+catBarsik.getCreatedAnimal());
    }

}