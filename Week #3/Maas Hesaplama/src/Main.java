public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Employee emp1 = new Employee("Kemal",2000,45,1985);
        Employee emp2 = new Employee("kadın",2000,40,2015);

//        System.out.println(emp1.salary);
//        System.out.println(emp2);
//
//        System.out.println(emp1.tax(emp1.salary));
//        System.out.println(emp2.tax(emp2.salary));

//        System.out.println(emp1.raiseSalary(emp1.hireYear,emp1.salary));
//        System.out.println( emp1.newSalary());
        emp1.toString(emp1);
        System.out.println("-----");

    }

}