package subject01;

import java.util.Scanner;
import subject02.StudentGrade;


public class main {
    public static void main(String[] arg) {

        //Scanner 인스턴스 생성
        Scanner input = new Scanner(System.in);
        System.out.println("Student Name!!");
        String inputStudentName = input.nextLine();
        
        System.out.println("Subject Name!!");
        String inputSubjectName = input.nextLine();

        System.out.println("Grade Name!!");
        int inputGradeName = input.nextInt();

        System.out.println("student = " + inputStudentName + "// subject = " + inputSubjectName + "// grade = " + inputGradeName);

        //input 데이터 무결성 체크 (데이터가 잘 왔는지 확인)
        //인자값을 통해 인스턴스 생성자 생성
        StudentGrade student = new StudentGrade();
        // StudentGrade student_1 = new StudentGrade(inputStudentName);
        StudentGrade student_2 = new StudentGrade(inputStudentName, inputSubjectName, inputGradeName);

        System.out.println(student.ClassName);
        System.out.println("------------");
        System.out.println(student_2.ClassName);
        System.out.println(student_2.name);
        System.out.println(student_2.subject);
        System.out.println(student_2.grade);
        System.out.println("------------");
    }
}
