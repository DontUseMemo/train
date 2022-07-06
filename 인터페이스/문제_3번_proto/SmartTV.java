package 인터페이스.문제_3번_proto;

public class SmartTV extends Channel_save {

    public void login() {
        //사용자 확인될 때까지 무한 루프
        while(true) {
            System.out.print("\n아이디를 입력해주세요 : ");
            String id = scan.nextLine();
            //아이디 확인
            if(user_list.containsKey(id)) {
                System.out.print("\n비밀번호를 입력해주세요 : ");
                int password = scan.nextInt();
                //비밀번호 확인
                if(list.containsKey(password)) {
                    System.out.println(id + "님 환영합니다.");
                    break;
                }
                else {
                    System.out.println("비밀번호가 틀렸습니다.");
                    continue;
                }
            }
            else {
                System.out.println("존재하지 않는 아이디입니다");
                continue;
            }
        }
    }

    public void logout() {
        System.out.println("로그아웃 합니다.");
    }

    public void tv_running() {
        TV_function.turnOn();
        while(true) {
            login();

        }
    }
    
}
