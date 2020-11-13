package Fall2020;
public class Shapes {
    
    public static void main(String[] args) {
        calcsquare(5.0);
        calccirc(4.0);
        calcrect(4.0, 5.0);
        calctri(8.0, 4.0);
    }

    public static double calcsquare(double side){
        double sum = (side * side);
        System.out.println(sum);
        return sum;
    }
    
    public static double calccirc(double radius){
        double sum = Math.PI*(Math.pow(radius, 2));
        System.out.println(sum);
        return sum;
    }

    public static double calcrect(double width, double length){
        double sum = (length * width);
        System.out.println(sum);
        return sum;
    }

    public static double calctri(double height, double base){
        double sum = ((height * base)/2);
        System.out.println(sum);
        return sum;
    }
}
