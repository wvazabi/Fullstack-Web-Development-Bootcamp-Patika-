public class Main {
    public static void main(String[] args) {

    Teacher t1 = new Teacher("Enes","555","MATH");
    Teacher t2 = new Teacher("Halilİbo","454","HST");


    System.out.println("--------------------");

    Course history = new Course("101","HST",70,90,"History");
    history.addTeacher(t1);
    Course math = new Course("102","MATH",65,78,"Math");
    math.addTeacher(t2);

    Student st = new Student("İnek Şaban","123","5",history,math);

    st.addBulkExamNote(84,31,63,35);

    st.isPass();


    }
}