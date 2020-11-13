package Fall2020;
public class Loops2 {
    
    public static void main(String[] args) {
        Square(5,5);
        Rectangle(2,4);
        Triangle(4);
        Rownum(3,6);
        Trinums(5);
    }
  
    public static void Square(int h, int w){
        for (int hi = 0; hi < h; hi++){
            for (int wi = 0; wi < w; wi++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void Rectangle(int h, int w){
        for (int hi = 0; hi < h; hi++){
            for (int wi = 0; wi < w; wi++){
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
        System.out.println();
    }

    public static void Triangle(int h){
        for (int hi = 0; hi <= h; hi++){
            for (int wi = 0; wi <= hi; wi++){
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
        System.out.println();
    }

    
    public static void Rownum(int h, int w){
        int nums = 0;
        for (int hi = 0; hi <= h; hi++){
            for (int wi = 0; wi < w; wi++){
                System.out.print(nums + " ");
            }
            System.out.println(" ");
            nums++;
        }
        System.out.println();
    }

    public static void Trinums(int h){
        int nums = 1;
        for (int wi = 1; wi <= h; wi++){
            for (int hi = 1; hi <= h - wi; hi++){
                System.out.print(" "); 
            }
            for (int line = 1; line <= wi ; line++){
                System.out.print(nums + ""); 
            }
            System.out.println();
            nums++;
        }
    }
}