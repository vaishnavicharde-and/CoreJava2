import java.util.Scanner;
public class StudentManagement{
	private int studentId;
    private String name;
    private int age;
    private String course;
	
	public StudentManagement(int studentId, String name, int age, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
    }
	public void displayStudent() {
        System.out.println("Student ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Course: " + course);
    }
	public void updateCourse(int studentId, String newCourse) {
        if (this.studentId == studentId) {
            this.course = newCourse;
            System.out.println("Course updated" + studentId);
        }
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        StudentManagement[] students = null;
        int choice;
		do {
            System.out.println("===== Student Management Menu =====");
            System.out.println("1. Add Students");
            System.out.println("2. View all Students");
            System.out.println("3. Update Student Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of students to add: ");
                    int size = sc.nextInt();
                    students = new StudentManagement[size];

                    for (int i = 0; i < size; i++) {
                        System.out.println("Enter details for Student ");
                        System.out.println("Student ID: ");
                        int studentId = sc.nextInt();
                     
                        System.out.println("Name: ");
                        String name = sc.next();
                        System.out.println("Age: ");
                        int age = sc.nextInt();
                        
                        System.out.println("Course: ");
                        String course = sc.next();

                        students[i] = new StudentManagement(studentId, name, age, course);
                    }
                    System.out.println("Students added successfully.");
                    break;

                case 2:
                    if (students != null) {
                        System.out.println("Student list:");
                        for (StudentManagement student : students) {
                            student.displayStudent();
                        }
                    } else {
                        System.out.println(" No students to display. Add students first.");
                    }
                    break;

                case 3:
                    if (students != null) {
                        System.out.print("Enter Student ID to update course: ");
                        int idToUpdate = sc.nextInt();

                        System.out.println("Enter new course: ");
                        String newCourse = sc.next();

                        for (StudentManagement student : students) {
                            student.updateCourse(idToUpdate, newCourse);
                        }
                    } else {
                        System.out.println(" No student data available. Please add students first.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Student Management System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        } while (true);
	}
}