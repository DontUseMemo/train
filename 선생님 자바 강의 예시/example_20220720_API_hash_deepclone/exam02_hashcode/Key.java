package 선생님_자바_강의_예시.example_20220720_API_hash_deepclone.exam02_hashcode;

public class Key {
	public int number;
	
	public Key(int number) {
		this.number = number;
	}
	//@ : 어노테이션은 아래 메서드의 성질을 JVM에게 선언해주는 구문
	//JVM이 Key클래스에 있는 eqauls라는 메서드가 Object에서 상속받은 메서드가 아닌
	//재정의가 된 메서드인 것으로 인식할 수 있도록 @ 어노테이션 Override라서 선언
	//모든 객체(메서드)는 입구(통로)는 매개변수이기 때문에
	//Object로 "자동형변환" (Object obj) >> 하면 모든 클래스의 부모는 Object이기 때문에 가능
	//모든 클래스로 매개변수로 받을 수 있으므로 자바(객체)의 다형성을 표현한다.
	//Heap메모리에 잇는 인스턴스가 바뀌는 것이 아님
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key compareKey = (Key) obj;
			if(this.number == compareKey.number) {
				return true;
			}
		} 
		return false;
	}

	//주소 + 31(홀수 > 특정연산작업속도를 간략히) + 기타등등 (컴퓨터의 기초 메타데이터)
	//hashcode() 메서드는 equals() 메서드랑 동일하게 Object 클래스(최상의 부모클래스)의 메서드
	//어떤 클래스나 Object클래스를 상속받기 때문에 hashcode()와 equals() 메서드를 쓸 수 있다.
	@Override
	public int hashCode() {
		return number;
	}
}

