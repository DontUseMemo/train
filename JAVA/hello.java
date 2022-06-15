package JAVA;
import java.util.ArrayList;

class hello {
    public static void main(String[] arg) {
        System.out.println("programmers start!");
        //main 은 시작점으로 하나는 반드시 필요

        // String[] inputText = {"Jane", "Kim"};
        ArrayList<String> inputArray = new ArrayList<String>();
        inputArray.add("Jane");
        inputArray.add("Kim");
        System.out.println(solution(inputArray));
    }

    public static String solution(ArrayList<String> seoul) {
        String answer = "";
        //seoul 배열을 순회해서 kim의 위치 찾기
        for(int i =0; i<=seoul.size(); i++) {
            // if(seoul.get(i).equals("Kim")) {
            if(seoul.get(i) == "Kim") {

                System.out.println("ok");
            }
        }
        StringBuffer text_test =new StringBuffer("helloww");
        text_test.append("abc");
        System.out.println(text_test.length()); //string의 불변성
        return answer;
    }
}
