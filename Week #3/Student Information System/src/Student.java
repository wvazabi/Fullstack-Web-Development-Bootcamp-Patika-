public class Student {
    Course c1;
    Course c2;
    String name;
    String stNo;
    String classes;
    double average;
    boolean isPass;


    Student(String name, String stNo, String classes, Course c1, Course c2) {

        this.average = 0.0;
        this.c1 = c1;
        this.c2 = c2;
        this.name = name;
        this.isPass = false;
        this.stNo = stNo;
        this.classes = classes;

    }

    void addBulkExamNote(int gr1, int og1, int gr2, int og2) {

        this.c1.grade = gr1;
        this.c1.oralGrade = og1;
        this.c1.courseAvr = og1 * 0.20 + gr1 * 0.80;
        this.c2.grade = gr2;
        this.c2.oralGrade = og2;
        this.c2.courseAvr = og2 * 0.20 + gr2 * 0.80;
        //System.out.println("course avr" + this.c1.courseAvr);

    }

    void printNote() {
        System.out.println(c1.name + "\tnotu: " + this.c1.courseAvr);
        System.out.println(c2.name + "\tnotu: " + this.c2.courseAvr);

    }

    void isPass() {
        this.average = (this.c1.courseAvr + this.c2.courseAvr) / 2;
        printNote();
        System.out.println("Average " + average);
        if (average > 55) {
            System.out.println("PASS");
        }
        else {
            System.out.println("Fail");
        }
    }

}
