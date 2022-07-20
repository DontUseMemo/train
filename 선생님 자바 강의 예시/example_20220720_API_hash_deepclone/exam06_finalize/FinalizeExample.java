package 인터페이스.example_20220720_API_hash_deepclone.exam06_finalize;

public class FinalizeExample {
	public static void main(String[] args) {
		Counter counter = null;
		for(int i=1; i<=50; i++) {
			counter = new Counter(i);
			counter = null;
			System.gc();
		}
	}
}
