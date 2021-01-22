public class FRQ_2019 {
    public static void main(String[] args){
        System.out.println(numberOfLeapYears(2002, 2008));
    }//end main method

    public static int numberOfLeapYears(int year1, int year2){
        int dist = 0; //distance

        for(int i = year1; i < year2; i++){//Inputs 2 years as a range and increments distance if the current iteration is a leap year
            if(isLeapYear(i)){
                dist++;
            }
        }//End for loop
        return dist;
    }//End of method numberOfLeapYears

    public static int dayOfWeek(int month, int day, int year){//Intakes 3 parameters and inputs them into provided methods
        int date = 0;
        int firstDAY = firstDayOfTheYear(year);
        int dayYear = dayOfYear(month, day, year);
        date = (firstDAY + dayYear - 1) % 7;
        return date;
    }//End of method dayOfWeek
}//End class
