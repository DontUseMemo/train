package 선생님_자바_강의_예시.example_20220720_API_hash_deepclone.exam02_hashcode;

import java.util.HashMap;

public class KeyExample {
	public static void main(String[] args) {
		//Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
		//HashMap이라는 타입으로 선언하되 안에 값은 Key라는 객체와 String 문자열을 넣는다.
		// = New HashMap<Key, String> : Heap메모리에 인스턴스 만들기
		//HashMap<String, String> > Key위치는 String, Value위치는 String
		//Key(String) 으로 검색해서 Value(String) 을 받는다.(HashMap 의 구조)
		//HashMap 특징 : Key값은 중복 안됨
		//Key값을 "김준석", Value "오전수업"
		//Key값을 "김준석", Value "오후수업"
		//"김준석"을 검색하면 "오후수업"이 뜹니다.
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		//Key라는 객체타입으로 testKey라는 변수명으로 타입 선언
		//= enw Key(25); = heap메모리에서 Key라는 인스턴스를 생성(단, 인자값 23 넣음)
		//�ĺ�Ű "new Key(1)" �� "ȫ�浿"�� ������
		//hashmap.get() : 인자값(key)를 넣어서 key와 함께 넣은 value를 반환(출력)
		//hashMap.get() 메서드의 비교방식
		//json 포맷으로 인터넷 통신을 주로 합니다.(key, value)
		//String[] a; a[0] = "김준석"
		//a[0] = key
		//"김준석" = "홍길동"
		hashMap.put(new Key(1), "ȫ�浿");

		//식별키 "new Key(1)" 로 "홍길동"을 읽어옴
		//새로운 인스턴스가 만들어져요
		//홍길동의 key값과 다르다고 인식 (인스턴스와 다르고, 주소가 다르므로 hashcode()도 다르기 때문)
		//홍길동의 key와 다르다고 인식(hashcode()기반으로 구분 = HashMap의 자료저장 구조조)		//�ĺ�Ű "new Key(1)" �� "ȫ�浿"�� �о��
		String value  = hashMap.get(new Key(1));
		System.out.println(value);
		
		Object obj = new Object();
		System.out.println(obj);
		System.out.println(obj.hashCode());
	}
}


