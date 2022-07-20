package 인터페이스.예외처리.문제풀이;

import java.util.Scanner;

public class TeamUpMain {
    public static void main(String[] arg) {
        Programmer programmer = new Programmer();
        programmer.task_check(new Programmer("",""));
        Team_build();
    }

    private static void Team_build() {

        Scanner scan = new Scanner(System.in);
        Programmer programmer = new Programmer();
        System.out.println("프로젝트 개발자로 지원하시겠습니까?\n1. 네 / 2. 아니오");

        System.out.println("프로젝트 개발자 팀 지원서 작성\n지원가능 분야 (프론트엔드, 백엔드, 데이터베이스, 프로젝트 매니저)");
        System.out.print("이름 : ");
        String user_name = scan.nextLine();
        System.out.print("지원 분야 : ");
        String user_task = scan.nextLine();
        programmer.team_joining(new Programmer(user_name, user_task));
    }
}
