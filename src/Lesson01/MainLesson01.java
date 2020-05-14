package lesson01;

    /*
	    ФИО:  		    Свищ Владимир Сергеевич
	    Факультет:      Geek University Android-разработки
	    Курс: 		    Java Core. Базовый уровень
	    Урок: 		    Урок 1. Java. Введение
	    Дата правки:    13.05.2020
	*/


public class MainLesson01 {

    /*
        1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    */
    public static void main(String[] args) {

    /*
        2. Создать переменные всех пройденных типов данных,
        и инициализировать их значения;
    */
        byte valByte = 127;
        short valShort = 32767;
        int valInt = 2147483647;
        long valLong = 9223372036854775807L;
        float valFloat = 333.333f;
        double valDouble = -4444.4444;
        char valChar = '*';
        boolean valBoolean = false;

    }


    /*
        3. Метод вычисляющий выражение a * (b + (c / d))
        и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    */
    private static double calculate(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }


    /*
        4. Метод, принимающий на вход два числа,
        и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
        если да – вернуть true, в противном случае – false;
     */
    private static boolean isCheckAmount(double num1, double num2) {
        double sum = num1 + num2;
        return 10 < sum && sum <= 20;
    }


    /*
        5. Метод, которому в качестве параметра передается целое число,
        метод должен напечатать в консоль положительное ли число передали, или отрицательное;

        Замечание: ноль считаем положительным числом.
    */
    private static void printIsPositiveNum(int num) {

        if ( num >= 0) {
            System.out.println("Положительное число.");
        }else {
            System.out.println("Отрицательное число.");
        }
    }


    /*
        6. Метод, которому в качестве параметра передается целое число,
        метод должен вернуть true, если число отрицательное;
    */
    private static boolean isNegativeNum(int num) {
        return 0 > num;
    }

    /*
        7. Метод, которому в качестве параметра передается строка,
        обозначающая имя,
        метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    */
    private static void printHello(String name) {
        System.out.println("«Привет, "+name+"!»");

    }

    /*
        8. * Метод, который определяет является ли год високосным,
        и выводит сообщение в консоль.

        Каждый 4-й год является високосным, кроме каждого 100-го,
        при этом каждый 400-й – високосный.
    */
    private static void printLeapYear(int year) {
        if(year %4==0 && year % 100 !=0 || year % 400==0)
        {
            System.out.println(year + "г. - високосный!");
        }else {
            System.out.println(year + "г. - не високосный!");
        }
    }



}
