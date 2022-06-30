package Bank;

import java.util.Scanner;

public class OOP {
    static double inputDouble(String message, double min, double max) {
        boolean isValidInput;
        double output = 0;
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

    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        bank.addClient("Иванов Иван Иванович");
        bank.addClient("Петров Пётр Петрович");

        while (true) {
            bank.printClientsToConsole();
            System.out.println("___________");

            System.out.println("1.Пополнить счет по номеру карты");
            System.out.println("2. Перевод денег со счета на счет");
            System.out.println("0. Выйти из программы");

           // int choosenMenuPoint = inputInt("Выберите пункт меню",0, 2);
        }
    }
}
