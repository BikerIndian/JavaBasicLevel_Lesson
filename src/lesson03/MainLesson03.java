package lesson03;

/*
    ФИО:  		    Свищ Владимир Сергеевич
    Факультет:      Geek University Android-разработки (478 - 12.05.2020)
    Курс: 		    Java Core. Базовый уровень
    Урок: 		    Урок 3. Практика
    Дата правки:    22.05.2020
*/

import java.util.Random;
import java.util.Scanner;

public class MainLesson03 {

    private static final Random random = new Random();
    private static final Scanner sc = new Scanner ( System.in );

    public static void main(String[] args) {
        // 1.
        gameNumber();

        // 2.
        gameWord();
    }


    /*
        1. Написать программу, которая загадывает случайное число от 0 до 9,
        и пользователю дается

        3 попытки угадать это число.

        При каждой попытке компьютер должен сообщить больше ли указанное пользователем
        число чем загаданное, или меньше. После победы или проигрыша выводится запрос
        – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */

    private static void gameNumber() {

        do {
            gameNumberStart();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

        }while (0 != sc.nextInt());
    }

    private static void gameNumberStart() {
        System.out.println("Угадай случайное число от 0 до 9");

        int tryGame = 3;                        // Число попыток
        int num = random.nextInt(10);

        for (int i = tryGame; i > 0; i--) {

            System.out.println("\nЧисло попыток: " + i);
            System.out.print("Введите число: ");

            int userAnswer = sc.nextInt();

            if (userAnswer == num){
                System.out.println("Поздравляю, Вы выиграли.\n");
                break;
            } else if (userAnswer > num){
                System.out.println("Вы ввели слишком большое число.");
            }else if (userAnswer < num){
                System.out.println("Вы ввели слишком маленькое число.");
            }

            if (1 == i){
                System.out.println("\nВы проиграли. Это число - ["+num+"]\n");
            }

        }



    }



/*
    2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
    Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.

    apple – загаданное
    apricot - ответ игрока

    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово
    Используем только маленькие буквы

 */

    private static void gameWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String wordGame = words[random.nextInt(words.length)];

        //System.out.println("wordGame = "+wordGame); // debug

        String wordIn;

        System.out.println("Я загадал слово. Отгадай!");
        do {
            System.out.print("Это слово?: ");
            wordIn = sc.nextLine();

            if (wordGame.equals(wordIn)) {
                System.out.println("Поздравляю Вы выиграли!");
                break;
            }
            printHelp(wordGame,wordIn);
            printHelpPeople(wordGame); //2**
        }while (true);

    }

    private static void printHelp(String wordGame, String wordIn) {

        String helpWord = "";
        for (int i = 0; i < Math.min( wordIn.length() , wordGame.length() ); i++) {
            if (wordGame.charAt(i) == wordIn.charAt(i)){
                helpWord += wordGame.charAt(i);
            }else {
                break;
            }
        }

        int size = 15 - helpWord.length();
        for (int i = 0; i < size; i++) {
            helpWord += '#';
        }
        System.out.println("Не верно: " + helpWord+"\n");

    }

    private static void printHelpPeople(String wordGame) {

        System.out.println("Помощь зала. Открыть какую букву ");
        System.out.print("под номером? ");

        String helpWord = "";

        int num = sc.nextInt();
        sc.nextLine();

        if (num <= wordGame.length()){

            for (int i = 0; i < 15; i++) {
                if (i == num-1){
                    helpWord += wordGame.charAt(i);
                    i++;
                }
                helpWord += '#';
            }
            System.out.println(helpWord+"\n");
        } else  {
            System.out.println("Это слово меньше "+num);
        }


    }

}
