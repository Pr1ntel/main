package Tamago4i_Ga4imy4i;

import java.util.Random;
import java.util.Scanner;

public class Build {

    private boolean isLife;       //цикл игры
    private int needInHealth;           // хп
    private int needInFood;             //еда
    private int needInHygiene;          //гигиена
    private int needInTreatment;        //лечение
    private int needInSlip;             //сон


    public Build(int needInHealth, int needInFood, int needInHygiene, int needInTreatment, int needInSlip) {
        this.needInHealth = needInHealth;
        this.needInFood = needInFood;
        this.needInHygiene = needInHygiene;
        this.needInTreatment = needInTreatment;
        this.needInSlip = needInSlip;
        this.isLife = true;

    }

    int food = 10;
    int hygiene = 5;
    int treatment = 10;
    int sleep = 15;

    int antiHugiene = 15;
    int antiTreatment = 10;
    int antiFood = 20;
    int antiSleep = 15;

    public void printlnMenu() {
        System.out.println("Ваш тамагочи");
        printlCharacteristic();
        System.out.println("В скобках указано сколько прибавится к данной характеристике");
        System.out.println("Каждое действие влечет за собой последствия!!!");
        System.out.println("1.Покормить питомца (+10)");
        System.out.println("2.Помыть питомца(+5)");
        System.out.println("3.Излечить питомца(+10)");
        System.out.println("4.Уложить питомца спать(+15)");
        System.out.println("5.Сохранить питомца(написать имя файла)");
        System.out.println("6.Загрузить питомца(написать имя файла)");
        System.out.println("0.Выход из программы");
        int games = inputInt("Выбери пункт:", 0, 6);

        switch (games) {
            case 1: {
                if (needInFood < 0) {
                    isLife = false;
                    System.out.println("Питомец умер от голода");
                } else if (needInFood + food > 100) {
                    isLife = false;
                    System.out.println("Ваш питомец слишком много съел, от чего был разрыв желудка");
                    System.out.println("Конец игры!");
                } else {
                    Random random = new Random();
                    int randNumber = random.nextInt(3);
                    switch (randNumber){
                        case 1:{
                            System.out.println("Вы накормили питомца протухшей рыбой!");
                            needInFood = needInFood - antiFood;
                            needInHealth--;
                        }
                        break;
                        case 2:{
                            System.out.println("Вы накормили питомца тортиком, но он испачкался.");
                            needInFood = needInFood +food;
                            needInHygiene = needInHygiene - hygiene;
                        }
                        break;
                        case 3:{
                            System.out.println("Вы накормили питомца картошечкой");
                            needInFood++;
                        }
                    }


                }
            }
            break;
            case 2: {
                if (needInHygiene < 0) {
                    isLife = false;
                    System.out.println("Питомец увяз в грязи. R.I.P.");
                } else if (needInHygiene + hygiene > 100) {
                    isLife = false;
                    System.out.println("Вы протерли в питомце дыру.");
                    System.out.println("Конец игры!");
                } else {
                    needInHygiene = needInHygiene + hygiene;
                    needInTreatment = needInTreatment - antiTreatment;
                }
            }
            break;
            case 3: {
                if (needInTreatment < 0) {
                    isLife = false;
                    System.out.println("Питомец заболел и погиб :(");
                } else if (needInTreatment + treatment > 100) {
                    isLife = false;
                    System.out.println("Вы  напичкали питомца таблетками и вызвали эпилепсию");
                    System.out.println("Конец игры!");
                } else {
                    needInTreatment = needInTreatment + treatment;
                    needInSlip = needInSlip - antiSleep;
                }
            }
            break;
            case 4: {
                if (needInSlip < 0) {
                    isLife = false;
                    System.out.println("Питомец уснул вечным сном, из-за недосыпа");
                } else if (needInSlip + sleep > 100) {
                    isLife = false;
                    System.out.println("Питомец спал 25 часов из 24. R.I.P.");
                    System.out.println("Конец игры!");
                } else {
                    needInSlip = needInSlip + sleep;
                    needInFood = needInFood - antiFood;
                }
            }
            break;
            case 5: {

            }
            break;
            case 6: {

            }
            break;
            case 0: {
                System.exit(0);
            }
            break;
        }
    }


    public boolean isLife() {
        return true;
    }

    static int inputInt(String message, int min, int max) {
        boolean isValidInput;
        int output = 0;
        do {
            try {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.print(message);
                output = scanner.nextInt();

                if (output < min || output > max) {
                    System.out.println("Ошибка ввода. Вы вышли за границы диапазона от " + min + " до " + max);
                    throw new Exception();
                }

            } catch (Exception e) {
                isValidInput = false;
                System.out.println("Ошибка ввода. Пожалуйста повторите ввод");
            }

        } while (isValidInput == false);

        return output;
    }


    public void printlCharacteristic() {
        System.out.println("Шкала здоровья питомца - " + needInHealth);
        System.out.println("Шкала голода питомца - " + needInFood);
        System.out.println("Шкала чистоты питомца - " + needInHygiene);
        System.out.println("Шкала иммунитета питомца - " + needInTreatment);
        System.out.println("Шкала сна питомца - " + needInSlip);
    }

    public int randomInt() {
        Random random = new Random();
        int num = random.nextInt(3);
    return num;
    }

}


