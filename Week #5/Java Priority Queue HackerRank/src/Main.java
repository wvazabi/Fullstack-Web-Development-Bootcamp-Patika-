import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Comparator;

/*import java.util.Collection;
 * Create the Student and Priorities classes here.
 * Inputt
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
 */


class Student implements Comparable<Student>{


    private int id;
    public String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    public int compareTo(Student s){
        if(cgpa == s.cgpa) {
            if(name.compareTo(s.name) == 0) {
                if(id == s.id)
                    return 0;
                else if(id > s.id)
                    return 1;
                else
                    return -1;

            }
            else
                return name.compareTo(s.name);
        }
        else if(cgpa > s.cgpa)
            return -1;
        else return 1;
    }

}

class Priorities {

    public ArrayList<Student> getStudents(List<String> events){

        int n = events.size();

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for(String i : events) {
            String[] s = i.split("\\s");
            if(s[0].equals("ENTER")) {
                pq.add(new Student(Integer.valueOf(s[3]), s[1], Double.valueOf(s[2])));

            } else if(s[0].equals("SERVED")) {
                pq.poll();
            }
        }

        while(pq.size() > 1) {
            System.out.println(pq.poll().name);
        }

        return new ArrayList<Student>(pq);

    }

}



public class Main {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}