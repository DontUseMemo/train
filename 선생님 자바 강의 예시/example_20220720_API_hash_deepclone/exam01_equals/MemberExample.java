package 인터페이스.example_20220720_API_hash_deepclone.exam01_equals;

public class MemberExample {
	public static void main(String[] args) {

		//인스턴스 생성
		//선언 부분 : (선언)Member 타입으로 obj1 변수명으로 선언
		// = : 대입연산자 (우측에 잇는 인스턴스를 좌측에 있는 선언부분엔 할당(연결))
		//new : 인스턴스 부부능로 실제로 메모리에 할당되는 값
		//(실제) Member타입으로 실제로 구현(생성자 호출:인자값 String 넣기)
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		//메모리에 obj라는 객체가 3개 할당된 상황(주소값)

		//재정의 된 equals 사용
		if(obj1.equals(obj2)) { //obj1와 obj2 객체를 배교 (단, 참조타입이어서 equals메서드를 써서 비교)
			//기본 타입끼리 비교할 때 에는 == 사용
			System.out.println("obj1�� obj2�� �����մϴ�.");
		} else {
			System.out.println("obj1�� obj2�� �������� �ʽ��ϴ�.");
		}

		//obj3라는 변수명(선언부분)에 obj2의 실제값을 대입(주소 연결)
		//기존, obj3에 하당된 인스턴스 대신에 obj2의 인스턴스가 연결되어서
		//원래 있던 obj3에 할당된 인스턴스는 연결 끊어짐 (가비지 컬렉터가 찾아서 회수)
		if(obj1.equals(obj3)) { //같은 인스턴스 주소를 가리키기 때문에
			//인스턴스가 같다고 보고, if문의 True값이 나옴
			System.out.println("obj2 obj3 같음");
			System.out.println("obj1�� obj3�� �����մϴ�.");
		} else {
			System.out.println("obj1�� obj3�� �������� �ʽ��ϴ�.");
		}
	}
}
