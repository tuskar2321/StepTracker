public class Converter {
    public void stepStatsTwo(int sum) {
        double stepKm;
        stepKm = ((double) sum * 75) / 100000;
        int stepKk = (sum * 50) / 1000;

        System.out.println("-���������� ���������: " + stepKm + " ��");
        System.out.println("-���������� �������� �����������: " + stepKk);
    }
}

