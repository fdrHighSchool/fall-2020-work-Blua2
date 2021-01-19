public class FRQ_2019 {
    public static void main(String[] args){
        System.out.println(numberOfLeapYears(2002, 2008));
    }

    public static int numberOfLeapYears(int year1, int year2){
        int dist = 0; //distance

        for(int i = year1; i < year2; i++){
            if(isLeapYear(i)){
                dist++;
            }
        }
        return dist;
    }

    public static int dayOfWeek(int month, int day, int year){
        int date = 0;
        int firstDAY = firstDayOfTheYear(year);
        int dayYear = dayOfYear(month, day, year);
        date = (firstDAY + dayYear - 1) % 7;
        return date;
    }
}
