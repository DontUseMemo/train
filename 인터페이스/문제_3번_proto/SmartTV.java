package 인터페이스.문제_3번_proto;

public class SmartTV extends Channel_save {

    public void login(String input_id, int input_pw) {
        if(user_list.containsKey(input_id)) {
            System.out.println(input_id + "님 환영합니다.");
        }
        else {
            System.out.println("존재하지 않는 아이디입니다");
        }
    }

    public void logout() {
        
    }
    
}
