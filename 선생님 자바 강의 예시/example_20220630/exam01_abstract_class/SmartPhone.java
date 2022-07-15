package example_20220630.exam01_abstract_class;

public class SmartPhone extends Phone {
	//������
	public SmartPhone(String owner) {
		super(owner);
	}
	//�޼ҵ�
	public void internetSearch() {
		System.out.println("���ͳ� �˻��� �մϴ�.");
	}
}
