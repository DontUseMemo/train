package 인터페이스.예외처리.문제풀이;

public class Programmer {
    private String name;
    private String task;
    private static String[] task_list = {"프론트엔드", "프론트엔드", "백엔드", "백엔드", "데이터베이스", "프로젝트매니저"};
    private static Programmer[] team = new Programmer[6];

    public Programmer() {}

    public Programmer(String input_name, String input_work) {
        this.name = input_name;
        this.task = input_work;
    }

    public void team_joining(Programmer applicant) {
        for(int i = 0; i< team.length; i++) {
            team[i] = applicant;
        }
    }

    public Programmer task_check(Programmer applicant) {
        Programmer checked_applicant = null;
        for(Programmer team_member : team) {
            if(team_member != null) {
                for (int i = 0; i < task_list.length - 1; i++) {
                    if (team_member.task.equals(task_list[i])) {
                        task_list[i] = task_list[i + 1];
                        break;
                    }
                }
            }
        }
        for (String s : task_list) {
            if (s.equals(applicant.task)) {
                checked_applicant = applicant;
                break;
            }
        }
        return checked_applicant;
    }
}
