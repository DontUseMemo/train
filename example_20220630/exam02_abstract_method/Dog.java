package example_20220630.exam02_abstract_method;

public class Dog extends Animal {
	public Dog() {
		this.kind = "������";
	}

	@Override
	public void sound() {
		System.out.println("�۸�");
	}
}