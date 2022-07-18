package 인터페이스.익명중첩클래스;

public class Annonymous extends Person {

    WayToWork wayToWork2 = new WayToWork() {
        @Override
        public void run() {
            System.out.println("달려가 봅니다.");
        }

        @Override
        public void car() {
            System.out.println("차를 타고 갑니다.");
        }
    };
    Person person = new Person() {
        int field1 = 7;

        @Override
        public void wake() {
            System.out.println("아침 " + field1 + "에 일어납니다.");
            work();
        }

        void work() {
            System.out.println("걸어갑니다.");
        }

    };


    public void method1() {
        System.out.println("적당한 시간입니다.");
        person.wake();
    }

    public void method2(int input_int) {
        //매개변수 (인자값 혹은 전역변수의 라이프사이클에 따라 살아있다.)

        //지역변수 (메서드의 라이프사이클에 따라 변수가 활용)
        int wake_time = 7;

        //익명객체의 라이프 사이클 start
        Person a = new Person() {
            @Override
            public void wake() {
                System.out.println("앗 11시! 너무 늦게 일어났습니다.");
            }
        };
        //익명객체의 라이프 사이클 end
        a.wake();
    }
}
