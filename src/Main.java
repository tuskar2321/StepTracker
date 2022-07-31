import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int command = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        int month;
        int day;
        int steps;
        int monthStat;

        while (command != 0) {

            if (command == 1) {
                System.out.println("Введите месяц:");
                month = scanner.nextInt();
                if (month >= 1 && month <= 12) {
                    System.out.println("Введите день:");
                    day = scanner.nextInt();
                    if (day >= 1 && day <= 30) {
                        System.out.println("Введите количество шагов:");
                        steps = scanner.nextInt();
                    } else {
                        System.out.println("Неверное значение! (Введите число от 1 до 30)");
                        continue;
                    }

                } else {
                    System.out.println("Неверное значение! (Введите число от 1 до 12)");
                    continue;
                }

                boolean isSuccess = stepTracker.addSteps(stepTracker.MonthData, month, day, steps);
                if (isSuccess) {
                    System.out.println("Шаги записаны!");
                } else {
                    System.out.println("Шаги в этот день уже заполнены!");
                }

            } else if (command == 2) {
                System.out.println("Введите номер месяца:");
                monthStat = scanner.nextInt();
                System.out.println("\nСтатистика за "+ monthStat +" месяц");
                if (monthStat >= 1 && monthStat <= 12){
                     stepTracker.stepStats(stepTracker.goal, monthStat);
                }else {
                    System.out.println("Некоректный ввод, введите от 1 до 12");
                    continue;
                }

            } else if (command == 3) {
                System.out.println("Выбранно - Изменить цель по количеству шагов в день");
                System.out.println("Актуальная цель - " + stepTracker.goal);
                stepTracker.goalStat();

            } else {
                System.out.println("Такого действия нет!");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
        System.out.println("Введите номер действия: ");
    }
} 