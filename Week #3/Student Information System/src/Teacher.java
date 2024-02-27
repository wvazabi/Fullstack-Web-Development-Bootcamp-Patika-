public class Teacher {
    String name;
    String mobileNo;
    String branch;

Teacher(String name, String mobileNo, String branch) {

    this.name = name;
    this.mobileNo = mobileNo;
    this.branch = branch;

}

void print() {
    System.out.println("Namwe   \t" + this.name);
    System.out.println("Mobil No\t" + this.mobileNo);
    System.out.println("Branch  \t" + this.branch);
}

}