import java.util.*;
public class Student {
  String name;
  String osis;
  double[] grades;
  int numGrades;


  public Student(String name, String osis) {
    this.name = name;
    this.osis = osis;
    this.grades = new double[10];
    this.numGrades = 0;
  }//end method Student


  public void ArrayF() {
    for (int element = 0; element < this.grades.length; element++) {
      this.grades[element] = (int)(Math.random() * 46 + 55);
    }//end loop
    this.numGrades = 10;
  }//end ArrayF method


  public void displayGrades() {
    System.out.println("Grades: " + Arrays.toString(this.grades));
  }//end displayGrades

  /*
   N  addGrade
   P  Locate and replace the lowest grade of the inputed array of grades with the most recent grade input(last).
   I  Array grades of doubles
   R  Nothing
  */
  public void addGrade(double grades[]) {
    if (this.numGrades == 10){
      int lwind = 0;//lowest index
      double lgrade = this.grades[0];//lowest grade

      for (int i = 0; i < this.grades.length; i++){
        if (this.grades[i] < lgrade){
          lwind = i;
          lgrade = this.grades[i];
        }//end if statement
      }//end for loop
      this.grades[lwind] = grades[grades.length-1];//Replace with recent grade
    }//end if statement

    else {//Adds the input array of grades into local grade array.
      for (int it = 0; it < this.grades.length; it++){
        this.grades[this.numGrades] = grades[it];
        this.numGrades++;
      }//end for loop
    }//end else

  }//end addGrade method


  public double Average() {
    double avg = 0;
    for (int num = 0; num < this.numGrades; num++){
      avg += this.grades[num];
    }
    return avg / this.numGrades;
  }//end method Average
}//end class