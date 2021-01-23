public class StudentSRC {
    public static void main(String[] args) {
        Student student1 = new Student("Bryant Luna Ramos", "219772290");
        Student student2 = new Student("Luna Ramos Bryant", "198229030");
        Student student3 = new Student("Luna Ramos Bryant", "319888457");
        double grades[] = {100.0 ,97.0 ,96.5 ,94.6 ,94.7 ,94.5 ,92.4 ,93.6 ,96.9 ,98.9 };
        double grades2[] = {87.9 ,92.0 ,86.4 ,78.9 ,85.0 ,90.3 ,84.6 ,87.8 ,92.3 ,88.0 };
        double grades3[] = {97.9 ,99.8 ,94.5 ,95.9 ,96.0 ,94.0 ,98.4 ,99.3 ,100.0 ,100.0 };

        student1.addGrade(grades);
        student2.addGrade(grades2);
        student3.addGrade(grades3);

        System.out.println("\n" + student1.name + "   " + student1.osis + "\nAverage: " + student1.Average());
        student1.displayGrades();
        System.out.println("\n" + student2.name + "   " + student1.osis + "\nAverage: " + student2.Average());
        student2.displayGrades();
        System.out.println("\n" + student3.name + "   " + student3.osis + "\nAverage: " + student3.Average());
        student3.displayGrades();
    }
}
