package 인터페이스.test20220706.exam01_field_polymorphism;

public class Car {

	//필드값
	//인스턴스만들어줌
	//인스턴스인 Tire를 인터페이스 Trie로 구현된 HankookTire에 연결해줌
	public Tire frontLeftTire = new HankookTire();
	public Tire frontRightTire = new HankookTire();
	//제한자 차이
	Tire backLeftTire = new HankookTire();
	Tire backRightTire = new HankookTire();
	//브레이크추가
	Number01_break num1 = new Number01_break();
	Number02_break num2 = new Number02_break();
	brake brake01 = new Number01_break();
	Pedal pedal01 = new Number02_break();

	//Tire라는 배열이있는데
	//tires라는 변수명으로 네개를 넣음 HankookTire를 몽땅
	public Tire[] tires =  {
			new newHankookTire(),
			new newHankookTire(),
			new newHankookTire(),
			new newHankookTire()
	};

	public void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();

		//개선된for문 문법
		//for(자료형 변수명 : 배열명){문장}
		for(Tire tire : tires){
			tire.roll();
		}
		System.out.println("--------------자식인 number01,02-------------------");
		num1.push();
		num1.stop();
		num2.push();
		num2.stop();
		System.out.println("------------부모인 brake01----------------");

		brake01.stop();
//      brake01.push(); //push라는 메소드없었음

		System.out.println("--------brake02-자식으로형변환-자식의push출력--------");

		//형변환해서 push가 되지않는데 되게 만들기!
		//자식클래스 변수 = (자식클래스) 부모클래스타입
		//부모클래스타입 = 부모클래스변수
		Number01_break brake02 = (Number01_break) brake01;
		brake02.push();

		System.out.println("------------부모인 pedal01----------------");

		pedal01.push();
//      pedal01.stop(); //stop이라는 메소드없었음
		System.out.println("--------pedal01-자식으로형변환-자식의stop출력------------");

		Number02_break pedal02 = (Number02_break) pedal01;
		pedal02.stop();


	}
}
