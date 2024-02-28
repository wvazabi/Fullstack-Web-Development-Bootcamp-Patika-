public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;

    }

    double tax(double salary) {
        if (salary <= 1000) {
            return 0;
        }
        else {
            return salary * 0.03;
        }

    }

    int bonus(int workHour){
        if (workHour > 40) {
            workHour =  (workHour - 40) * 30;
            return workHour;
        }
        else {
            return 0;
        }

    }

    double raiseSalary(int hireYear, double salary) {
       final int year = 2024;
       int tempYear = year - hireYear;
        if(tempYear < 10) {
            return salary * 0.05;
        } else if (tempYear > 9 && tempYear < 20) {
            return salary * 0.10;
        } else  {
            return salary * 0.15;
        }

    }

    double newSalary(){
        double tax = tax(this.salary);
        int bonus = bonus(this.workHours);
        double raise = raiseSalary(this.hireYear,this.salary);
        return (raise - tax) + bonus + this.salary;
    }

    double bonusAndTax(){
        return this.salary + this.bonus(this.workHours) - this.tax(this.salary);
    }

    void toString(Employee emp1) {
        System.out.println("Adı:\t" + emp1.name);
        System.out.println("Maaşı:\t" + emp1.salary);
        System.out.println("Çalışma saati:\t" + emp1.workHours);
        System.out.println("Başlangıç yılı:\t" + emp1.hireYear);
        System.out.println("Vergi kesintisi:\t" + emp1.tax(emp1.salary));
        System.out.println("Bonus:\t" + emp1.bonus(emp1.workHours));
        System.out.println("Maaş artışı:\t" + emp1.raiseSalary(emp1.hireYear, emp1.salary));
        System.out.println("Vergi ve bonus\t" + emp1.bonusAndTax());
        System.out.println("Yeni Maaş:\t" + emp1.newSalary());
    }



}
