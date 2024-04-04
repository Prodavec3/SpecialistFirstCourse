package lab1;

public class Lab12 {
    public static void main(String[] args) {
        int year = 1999;
        int dayNum = 91;

        int[] dayIsMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] nameMonth = {"January", "February", "March",
                "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};

        int monthNum = 0;

        boolean isLeapYear = ((year%4==0) && (year%100!=0 || year%400==0));

        for(int days : dayIsMonths){
            if(isLeapYear && days == 28) days++; // я бы убрал isLeapYear, т.к проверка лишняя по логике

            if (dayNum <= days) break;

            dayNum -= days;
            monthNum++;
        }

        System.out.println(nameMonth[monthNum] + " " + dayNum);
    }
}
