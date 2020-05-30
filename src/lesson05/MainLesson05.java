package lesson05;

/*
    ФИО:  		    Свищ Владимир Сергеевич
    Факультет:      Geek University Android-разработки (478 - 12.05.2020)
    Курс: 		    Java Core. Базовый уровень
    Урок: 		    Урок 5. Введение в ООП
    Дата правки:    28.05.2020
*/

public class MainLesson05 {
    public static void main(String[] args) {
    /*

    * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
    * Конструктор класса должен заполнять эти поля при создании объекта;
    * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    * Создать массив из 5 сотрудников

    Пример:
    Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
    persArray[1] = new Person(...);
    ...
    persArray[4] = new Person(...);
    * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    */

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312468", 45000, 30);
        persArray[1] = new Person("Petrov Nikolay", "Manager", "nikolay@mailbox.com", "89256812", 50000, 20);
        persArray[2] = new Person("Sidorov Sergey", "Director", "sergey@mailbox.com", "8923145612", 400000, 43);
        persArray[3] = new Person("Smirnov Pavel", "Administrator", "pavel@mailbox.com", "892312312", 60000, 35);
        persArray[4] = new Person("Pyatruk Vladimir", "Security", "vladimir@mailbox.com", "892248447", 30000, 50);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge()>40){
                persArray[i].print();
            }
        }

    }
}