import java.util.Arrays;
import java.util.Scanner;

public class StepTracker {

    int[][] MonthData = new int[12][30];
    public StepTracker() {
        for (int[] monthDatum : MonthData) Arrays.fill(monthDatum, 0);
    }
    boolean addSteps(int[][] MonthData, int month, int day, int steps) {
        if (MonthData[month-1][day-1] != 0){
            return false;
        }
        else {
            MonthData[month-1][day-1] = steps;
            return true;
        }
    }

    public void goalStat(int goal) {
        Scanner scanner = new Scanner(System.in);
        int yesNo;
        System.out.println("������ ���� - " + goal);
        System.out.println("������ �������� ����? \n1-�� \n2-���");
        yesNo = scanner.nextInt();
        if (yesNo == 1) {
            System.out.println("������� ���������� �����:");
            goal = scanner.nextInt();
            if (goal > 0){
            System.out.println("���� ��������� - " + goal);
            }
            else {
                System.out.println("������� ������������ ��������!");
            }
        }
        else {
            System.out.println("������ ��������.");
        }
    }

    public void stepStats(int goal, int neededMonth) {
        int sum = 0;
        int maxValue = 0;
        int counter = 0;
        Converter converter = new Converter();

        for (int j = 0; j < MonthData[neededMonth].length; j++){
            System.out.println((j + 1)+" ����: "+ MonthData[neededMonth-1][j]+ " �����");
            sum += MonthData[neededMonth-1][j];
            if (MonthData[neededMonth-1][j] > maxValue){
                maxValue = MonthData[neededMonth-1][j];
            }
            if (MonthData[neededMonth-1][j] != 0){
                ++counter;
            }
        }
        if (counter == 0){
            counter = 1;
        }
        System.out.println("\n �������������� ����������:");
        System.out.println("-����� �� �����: "+ sum +" �����");
        System.out.println("-������������ ���������� �� �����: " + maxValue+ " �����");
        System.out.println("-������� ����������: " + (sum / counter)+ " �����");
        converter.stepStatsTwo(sum);
        System.out.println("-������ �����: " + goalEpisode(goal, neededMonth)+ " ��(��/�).\n");
    }

    public int goalEpisode(int goal, int neededMonth){
        int counter = 0;
        int result = 0;

        for (int j = 0; j < MonthData[neededMonth-1].length; j++){
            if (MonthData[neededMonth-1][j] >= goal){
                ++counter;
                if ((MonthData[neededMonth-1][j+1]) < goal & (counter >= result)) {
                    result = counter;
                    counter = 0;
                }
                }
            }
            return result;
    }
}