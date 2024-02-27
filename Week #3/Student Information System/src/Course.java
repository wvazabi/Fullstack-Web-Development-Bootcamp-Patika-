public class Course {
    String name;
    String courseCode;
    String prefix;
    Teacher teacher;
    int grade;
    int oralGrade;

    double courseAvr;

    Course(String courseCode, String prefix, int grade, int oralGrade, String name) {

        this.courseCode = courseCode;
        this.name = name;
        this.prefix = prefix;
        this.grade = 0;
        this.oralGrade = 0;
        this.courseAvr = 0;
        //this.teacher = teacher;


    }

    void addTeacher(Teacher teacher) {
        if (teacher.branch.equals(this.prefix)) {
            this.teacher = teacher;
        }else {
            System.out.println("Teacher an prefix doent match");

        }

    }

    void printTeacherInfo() {
        this.teacher.print();
    }


}
