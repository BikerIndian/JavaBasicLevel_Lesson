package lesson05;

public class Person {

    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void print(){

        printForm("ФИО",fullName);
        printForm("Должность",position);
        printForm("Email",email);
        printForm("Телефон",phone);
        printForm("Зарплата",salary);
        printForm("Возраст",age);
        System.out.println();

    }

    private void printForm(String title, String text) {
        System.out.printf("%-10s : %s\n",title,text);
    }

    private void printForm(String title, int num) {
        System.out.printf("%-10s : %s\n",title,num);
    }
}
