public class Employee {

    //Definition of attributes
    String name;
    double salary;
    int workHours;
    int hireYear;

    //Creating the constructor class
    Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    //Method to calculate tax
    double tax() {
        if (this.salary <= 1000) {
            return 0;
        } else {
            return this.salary * 0.03;
        }
    }

    //Bonus calculation method
    int bonus() {
        if (this.workHours > 40) {
            return (this.workHours - 40) * 30;
        }
        return 0;
    }

    //Method of calculating salary increase
    double raiseSalary(int hireYear, double salary) {
        final int year = 2024;
        if (year - hireYear < 10) {
            return salary * 0.05;
        } else if ((year - hireYear) > 9 && (year - hireYear) < 20) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    //Method of calculating salary with taxes and bonuses
    double bonusAndTax(){
        return this.salary + this.bonus() - this.tax();
    }

    //New salary calculation method
    double newSalary(){
        double tax = tax();
        int bonus = bonus();
        double raiseSalary = raiseSalary(this.hireYear, this.salary);
        return raiseSalary - tax + bonus + this.salary;
    }

    //Printing the result to the screen
    void toString(Employee employee){
        System.out.println("Adı: " + employee.name);
        System.out.println("Maaşı: " + employee.salary);
        System.out.println("Çalışma Saati: " + employee.workHours);
        System.out.println("Başlangıç Yılı: " + employee.hireYear);
        System.out.println("Vergi Kesintisi: " + employee.tax());
        System.out.println("Bonus: " + employee.bonus());
        System.out.println("Maaş Artışı : " + employee.raiseSalary(employee.hireYear, employee.salary));
        System.out.println("Vergi ve Bonuslar ile birlikte maaş : " + employee.bonusAndTax());
        System.out.println("Toplam Maaş: " + employee.newSalary());
    }


}
