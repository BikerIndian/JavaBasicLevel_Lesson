package lesson02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Random;

public class MainLesson02 {

    private static final Random random = new Random();

/*
    ФИО:  		    Свищ Владимир Сергеевич
    Факультет:      Geek University Android-разработки
    Курс: 		    Java Core. Базовый уровень
    Урок: 		    Урок 2. Основные конструкции
    Дата правки:    17.05.2020
*/


    public static void main(String[] args) {

        testMethods();
    }

    private static void testMethods(){

        // 1:
        int[] arr = { 0, 0, 1, 1, 1, 0, 1, 1, 0, 0 };
        System.out.printf("1: Заменить 0 на 1, 1 на 0 \n%s\n", Arrays.toString(arr));
        replaceArr(arr);
        System.out.println(Arrays.toString(arr)+"\n");

        // 2:
        arr  = getArr();
        System.out.printf("2: Заполнить массив значениями 0 3 6 9 12 15 18 21 \n%s\n\n", Arrays.toString(arr));


        // 3:
        System.out.println("3:  Числа меньшие 6 умножить на 2;\n[1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]");
        arr =  multiplyArr();
        System.out.println(Arrays.toString(arr)+"\n");

        // 4:
        System.out.println("4: Заполнить диагональные элементы единицами.\n");
        int[][] square = getSquareArr4();

        for (int i = 0; i < square.length; i++) {
            System.out.println(Arrays.toString(square[i]));
        }


        // 5:
        arr = getRandomArr(10, 100);
        int minMax[] = searchMax(arr);

        System.out.println("\n\n"+
                "5**: Задать одномерный массив и найти в нем минимальный\n" +
                "и максимальный элементы \n" +
                Arrays.toString(arr)+
                "\nМинимальный - "+minMax[0]+
                "\nМаксимальный - "+minMax[1]);

        // 6:
        System.out.println("\n6**: Сумма левой и правой части массива равны.");

        arr = new int[] {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.printf("%s = %s\n",Arrays.toString(arr),checkBalance(arr));

        arr = new int[] {1, 1, 1, 2, 1};
        System.out.printf("%s = %s\n",Arrays.toString(arr),checkBalance(arr));

        arr = new int[] {1, 1, 1, 2, 3};
        System.out.printf("%s = %s\n",Arrays.toString(arr),checkBalance(arr));

        // 7:
        System.out.println("\n7****: Сместить все элементымассива на n позиций.");
        arr = new int[] {0,1,2,3,4,5,6,7,8,9};

        int bias = -3;

        System.out.printf("n = %d \n%s \n", bias,Arrays.toString(arr));
        replaceArr(arr,bias);
        System.out.println(Arrays.toString(arr)+"\n");


        arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        bias = 3;
        System.out.printf("n = %d \n%s \n", bias,Arrays.toString(arr));
        replaceArr(arr,bias);
        System.out.println(Arrays.toString(arr));

    }


    /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */

    private static void replaceArr(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            if (1 == arr[i]) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }

    /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    */

    private static int[] getArr(){

        int[] arr = new int[8];
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i]=num;
            num +=3;
        }

        return arr;
    }


    /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */

    private static int[] multiplyArr(){

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *=2;
            }
        }
        return arr;
    }

    /*
        4. Создать квадратный двумерный целочисленный массив
        (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
        заполнить его диагональные элементы единицами;
    */

    private static int[][] getSquareArr4(){

        int size = 11;

        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (i == j ||  j == (size -i-1)) {
                    arr[i][j] = 1;
                }

            }

        }

        return arr;
    }


    /*
        5. ** Задать одномерный массив и найти в нем минимальный
        и максимальный элементы (без помощи интернета);
    */

    private static int[] searchMax(int[] arr){

        int min = arr[0];
        int max = arr[0];


        for (int i = 0; i < arr.length; i++) {
            if ( max < arr[i]) {
                max = arr[i];
            }
            if ( min > arr[i]) {
                min = arr[i];
            }
        }

        return new int[]  {min,max};
    }



    /*
        6. ** Написать метод, в который передается
        не пустой одномерный целочисленный массив, метод должен вернуть true,
        если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) > true,
        checkBalance([1, 1, 1, || 2, 1]) > true,
        граница показана символами ||, эти символы в массив не входят.
    */

    private static boolean checkBalance(int[] arr){

        int sumLeftArr = arr[0];

        for (int i = 1; i < arr.length-1 ; i++) {
            sumLeftArr+=arr[i];

            if (sumLeftArr == getSumRightArr(arr,i+1)) {
                return true;
            }
        }

        return false;
    }

    // Сумма чисел массива начиная с index
    private static int getSumRightArr(int[] arr,int index){
        int sum = arr[index];

        for (int i = index+1; i < arr.length ; i++) {
            sum +=arr[i];
        }
        return sum ;
    }


    /*
        7. **** Написать метод, которому на вход подается одномерный массив
        и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементымассива на n позиций.
        Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    */

    private static void replaceArr(int[] arr, int n){
        if (n >= 0) {
            replaceRight(arr,n);
        }else{
            replaceLeft(arr,n);
        }
    }

    // При [+] числе n, смещение вправо.
    private static void replaceRight(int[] arr, int n){
        for (int i = 0; i < n ; i++) {
            int buf =  arr[arr.length-1];
            for (int j = arr.length-1; 0 < j; j--) {
                arr[j] = arr[j-1];
            }
            arr[0]=buf;
        }
    }

    // При [-] числе n, смещение влево.
    private static void replaceLeft(int[] arr, int n){

        for (int i = 0; i > n ; i--) {
            int buf =  arr[0];
            for (int j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length-1]=buf;
        }
    }


    /**
     * Создает массив и заполняет случайными числами
     *
     * @param size - Размер мвссива
     * @param boundary - Граница генерируемого числа
     * @return - Массив сгенерированных чисел
     */
    private static int[] getRandomArr(int size, int boundary) {
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] =  random.nextInt(boundary);
        }
        return arr;
    }


}
