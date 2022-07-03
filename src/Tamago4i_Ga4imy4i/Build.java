package Tamago4i_Ga4imy4i;

import java.io.*;
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

    //region int peremen
    int food = 10;
    int hygiene = 5;
    int treatment = 10;
    int sleep = 15;
    int antiHealth = 5;
    int antiTreatment = 10;
    int antiFood = 20;
    int antiSleep = 15;

    //endregion

    //region utility function

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

    static String inputString(String message) {
        boolean isValidInput;
        String output = "";
        do {
            try {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.print(message);
                output = scanner.nextLine();
            } catch (Exception e) {
                isValidInput = false;
                System.out.println("Ошибка ввода. Пожалуйста повторите ввод");
            }

        } while (isValidInput == false);

        return output;
    }

    public static int randNum() {
        Random random = new Random();
        int min = 50;
        int max = 80;
        int randNumber = random.nextInt((max - min) + 1) + min;
        return randNumber;
    }
    //endregion

    //region println for main
    public void printlnMenu() throws IOException {
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
                if (needInFood <= 0) {
                    System.out.println("Питомец умер от голода");
                    isLife = false;
                    printlCharacteristic();

                } else if (needInFood + food > 100) {
                    isLife = false;
                    System.out.println("Ваш питомец слишком много съел, от чего был разрыв желудка");
                    System.out.println("Конец игры!");
                    printlCharacteristic();

                } else {
                    Random random = new Random();
                    int randNumber = random.nextInt(3);
                    switch (randNumber) {
                        case 1: {
                            System.out.println("Вы накормили питомца протухшей рыбой!");
                            needInFood -= antiFood;
                            needInHealth--;
                        }
                        break;
                        case 2: {
                            System.out.println("Вы накормили питомца тортиком, но он испачкался.");
                            needInFood += food;
                            needInHygiene -= hygiene;
                        }
                        break;
                        case 3: {
                            System.out.println("Вы накормили питомца картошечкой");
                            needInFood++;
                        }
                        break;
                    }
                }
            }
            break;
            case 2: {
                if (needInHygiene <= 0) {
                    isLife = false;
                    System.out.println("Питомец увяз в грязи. R.I.P.");
                    printlCharacteristic();

                } else if (needInHygiene + hygiene > 100) {
                    isLife = false;
                    System.out.println("Вы протерли в питомце дыру.");
                    System.out.println("Конец игры!");
                    printlCharacteristic();

                } else {
                    Random random = new Random();
                    int randNumber = random.nextInt(3);
                    switch (randNumber) {
                        case 1: {
                            System.out.println("Питомец баловался при купании, эффект уменьшен вдвое");
                            needInHygiene = needInHygiene + (hygiene / 2);
                        }
                        break;
                        case 2: {
                            System.out.println("Вода отключена, питомец грязный :(");
                            needInHealth--;
                        }
                        break;
                        case 3: {
                            System.out.println("Питомец помыт и доволен!");
                            needInHygiene += hygiene;
                        }
                        break;
                    }
                }
            }

            case 3: {
                if (needInTreatment <= 0) {
                    isLife = false;
                    System.out.println("Питомец заболел и погиб :(");
                    printlCharacteristic();


                } else if (needInTreatment + treatment > 100) {
                    isLife = false;
                    printlCharacteristic();
                    System.out.println("Вы напичкали питомца таблетками и вызвали эпилепсию");
                    System.out.println("Конец игры!");

                } else {
                    Random random = new Random();
                    int randNumber = random.nextInt(3);
                    switch (randNumber) {
                        case 1: {
                            System.out.println("Вы раствороили в кипятке лечебный порошек и дали питомцу");
                            needInTreatment += treatment;
                        }
                        break;
                        case 2: {
                            System.out.println("Вы перепутали и заварили питомцу не тот порошек :))");
                            needInHealth -= antiHealth;
                            needInTreatment -= antiTreatment;
                            needInFood -= antiFood;
                            needInSlip -= antiSleep;
                        }
                        break;
                        case 3: {
                            System.out.println("Во время профилактики вы растворили питомца. R.I.P.");
                            isLife = false;
                            printlCharacteristic();
                        }
                        break;
                    }
                }
            }
            case 4: {
                if (needInSlip <= 0) {
                    isLife = false;
                    System.out.println("Питомец уснул вечным сном, из-за недосыпа");
                    printlCharacteristic();

                } else if (needInSlip + sleep > 100) {
                    isLife = false;
                    System.out.println("Питомец спал 25 часов из 24. R.I.P.");
                    System.out.println("Конец игры!");
                    printlCharacteristic();

                } else {
                    needInSlip = needInSlip + sleep;
                    needInFood = needInFood - antiFood;
                }
            }
            break;
            case 5: {

                saveCharacteristicsToFile("output.txt");
            }
            break;
            case 6: {
                loadCharacteristicsToFile();
            }
            break;
            case 0: {
                System.exit(0);
            }
            break;
        }
    }

    public void printlCharacteristic() {
        System.out.println(String.format("%-12s%-8s%-10s%-13s%-5s", "Здоровье", "Голод", "Чистота", "Иммунитет", "Сон"));
        System.out.println(String.format("%-12s%-8s%-10s%-13s%-5s", needInHealth, needInFood, needInHygiene, needInTreatment, needInSlip));
    }

    public boolean isLife() {
        return isLife;
    }

    //endregion

    //region functions for the file
    void saveCharacteristicsToFile(String filename) throws IOException {
        filename = inputString("Введите файл для сохранения: ");
        FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(Integer.toString(needInHealth));
        bufferedWriter.newLine();

        bufferedWriter.write(Integer.toString(needInFood));
        bufferedWriter.newLine();

        bufferedWriter.write(Integer.toString(needInHygiene));
        bufferedWriter.newLine();

        bufferedWriter.write(Integer.toString(needInTreatment));
        bufferedWriter.newLine();

        bufferedWriter.write(Integer.toString(needInSlip));
        bufferedWriter.newLine();

        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Файл сохранён успешно");
    }

    void loadCharacteristicsToFile() throws IOException {

        String filename = inputString("Введите имя файла для выгрузки: ");

        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        needInHealth = Integer.parseInt(bufferedReader.readLine());
        needInFood = Integer.parseInt(bufferedReader.readLine());
        needInHygiene = Integer.parseInt(bufferedReader.readLine());
        needInTreatment = Integer.parseInt(bufferedReader.readLine());
        needInSlip = Integer.parseInt(bufferedReader.readLine());

        bufferedReader.close();
        fileReader.close();
        System.out.println("Персонаж загружен");
    }


    //endregion
}
