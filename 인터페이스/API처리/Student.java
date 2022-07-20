package 인터페이스.API처리;

import java.lang.reflect.Member;

public class Student {
    //필드
    //private : 같은 클래스 내에서만 접근 가능
    //public : 모두 접근 가능
    //default : 같은 패키지 내에서 접근 가능
    //protected : 같은 패키지 + 상속 내에서 겁근 가능
    private String name;
    private int groupNum;

    //생성자 : 생성자는 클래스 이름과 동일
    //오버로딩(클래스의 스타일) : 생성자의 매개변수를 통해 다양한 타입으로 생성
    //기본적으로 생성자(매개변수 없는) 1개는 있다 (안 보일 뿐)
    //public Student() {};
    public Student(String i_name, int i_groupNum) {

        //this : 제일 가까운 객체를 지칭 > Student라는 클래스
        //this.name = Student의 필드 name
        //this.groupNum = Stuent의 필드 groupNum
        this.name = i_name;
        this.groupNum = i_groupNum;
    }

    //메서드
    //getter, setter 쓰는 이유 : 객체의 캡슐화, 데이터 입출력이라는 기능의 메서들 잘 쓰기 위해서
    //외부에서 필드값을 바로 조회 또는 수정을 막기 위해서! 객체는 딱 닫혀야 한다.
    public int getGroupNum() {
        return groupNum;
    }

    public String getName() {
        return name;
    }

    public void setGroupNum(int i_groupNum) {
        this.groupNum = i_groupNum;
    }

    public void setName(String i_name) {
        this.name = i_name;
    }

    @Override
    public boolean equals(Object obj) {
        //instanceof : 메모리 heap에 있는 인스턴스끼리 비교하는 것
        //상속받았다면 부모클래스도 동일하다가 true가 나온다.
        if(obj instanceof Student) {
            Student student_1 = (Student) obj;
            if(groupNum == student_1.getGroupNum()) {
                if(name == student_1.getName()) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}
