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
                System.out.println("������� �����:");
                month = scanner.nextInt();
                if (month >= 1 && month <= 12) {
                    System.out.println("������� ����:");
                    day = scanner.nextInt();
                    if (day >= 1 && day <= 30) {
                        System.out.println("������� ���������� �����:");
                        steps = scanner.nextInt();
                    } else {
                        System.out.println("�������� ��������! (������� ����� �� 1 �� 30)");
                        continue;
                    }

                } else {
                    System.out.println("�������� ��������! (������� ����� �� 1 �� 12)");
                    continue;
                }

                boolean isSuccess = stepTracker.addSteps(stepTracker.MonthData, month, day, steps);
                if (isSuccess) {
                    System.out.println("���� ��������!");
                } else {
                    System.out.println("���� � ���� ���� ��� ���������!");
                }

            } else if (command == 2) {
                System.out.println("������� ����� ������:");
                monthStat = scanner.nextInt();
                System.out.println("\n���������� �� "+ monthStat +" �����");
                if (monthStat >= 1 && monthStat <= 12){
                     stepTracker.stepStats(stepTracker.goal, monthStat);
                }else {
                    System.out.println("����������� ����, ������� �� 1 �� 12");
                    continue;
                }

            } else if (command == 3) {
                System.out.println("�������� - �������� ���� �� ���������� ����� � ����");
                System.out.println("���������� ���� - " + stepTracker.goal);
                stepTracker.goalStat();

            } else {
                System.out.println("������ �������� ���!");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("��������� ���������");
    }

    private static void printMenu() {
        System.out.println("����:");
        System.out.println("1. ������ ���������� ����� �� ����������� ����");
        System.out.println("2. ���������� ���������� �� ����������� �����");
        System.out.println("3. �������� ���� �� ���������� ����� � ����");
        System.out.println("0. ����� �� ����������");
        System.out.println("������� ����� ��������: ");
    }
} 