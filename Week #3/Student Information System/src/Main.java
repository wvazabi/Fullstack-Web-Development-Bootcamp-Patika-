public class Main {
    public static void main(String[] args) {

    Teacher t1 = new Teacher("Enes","555","MATH");
    Teacher t2 = new Teacher("Halilİbo","454","HST");
    Teacher ogretmen3 = new Teacher("Deniz","435","BESYO");

    System.out.println("--------------------");

    Course beden = new Course("321","BESYO",0,0,"Beden");
    Course history = new Course("101","HST",70,90,"History");


    beden.addTeacher(ogretmen3);
    beden.printTeacherInfo();
   // history.addTeacher(t1);

//    Course math = new Course("102","MATH",65,78,"Math");
//    math.addTeacher(t2);
//
//    Student st = new Student("İnek Şaban","123","5",history,math);
//
//    st.addBulkExamNote(84,31,63,35);
//
//    st.isPass();
//

    }
}