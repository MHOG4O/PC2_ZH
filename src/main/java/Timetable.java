import java.util.ArrayList;
import java.util.Scanner;

public class Timetable {
    private String courseName;
    private String timestamp;

    public Timetable(String courseName, String timestamp) {
        this.courseName = courseName;
        this.timestamp = timestamp;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public static void main(String[] args) {
        ArrayList<Timetable> timetables=new ArrayList<>();
        int choice=-1;
        while(choice!=0){
            Scanner scanner=new Scanner(System.in);
            System.out.println("Valasszon muveletet: ");
            System.out.println("1 - Kurzusok listazasa\r\n2 - Uj kurzus hozzaadasa\r\n3 - Kurzus modositasa\r\n4 - Kurzus torlese\r\n" +
                    "0 - Kilepes");
            try {
                System.out.print("--> ");
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ervenytelen!\n");
            }
            scanner.nextLine();
            switch (choice) {
                case 1 -> getCourses(timetables);
                case 2 -> newCourse(timetables);
                case 3 -> Scheduler.setTimestamp(timetables);
                case 4 -> removeCourse(timetables);
            }
        }
    }

    public static void newCourse(ArrayList<Timetable> timetables){
        Scanner scanner=new Scanner(System.in);
        String a;
        String b;
        System.out.print("Kurzus neve: ");a=scanner.nextLine();
        System.out.print("Idopontja: ");b=scanner.nextLine();
        timetables.add(new Timetable(a,b));
    }

    public static Timetable findCourse(ArrayList<Timetable> timetables, String nev)
            throws IllegalArgumentException {
        for (Timetable timetable : timetables) {
            if (timetable.getCourseName().equals(nev)) {
                return timetable;
            }
        }
        throw new IllegalArgumentException("Nem talalhato kurzus a megadott nevvel!");
    }

    public static void removeCourse(ArrayList<Timetable> timetables){
        System.out.print("Irja be a torolni kivant kurzus nevet: ");
        try {
            Scanner scanner=new Scanner(System.in);
            timetables.remove(findCourse(timetables, scanner.nextLine()));
            System.out.println("Sikeres torles\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getCourses(ArrayList<Timetable> timetables) {
        System.out.println(timetables);
    }


    @Override
    public String toString() {
        return "\n---------------------------\n" +
                "Kurzus neve: " + courseName + "\n" +
                "Idopontja: " + timestamp +
                "\n---------------------------\n";
    }

}
class Scheduler extends Timetable{
    public Scheduler(String courseName, String timestamp) {
        super(courseName, timestamp);
    }

    public static void setTimestamp(ArrayList<Timetable> timetables){
        System.out.print("Adja meg a kurzus nevet: ");
        try{
            Scanner scanner=new Scanner(System.in);
            Timetable timetable=findCourse(timetables,scanner.nextLine());
            System.out.print("Irja be az uj idopontot: ");scanner=new Scanner(System.in);
            timetables.set(timetables.indexOf(timetable),new Timetable(timetable.getCourseName(), scanner.nextLine()));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
