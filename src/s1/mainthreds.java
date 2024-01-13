package s1;

public class mainthreds {
	public static void main(String[] args) {
		//thresds1 t1 = new thresds1();
		thresds1 th1 = new thresds1("irea");
		thresds1 th2 = new thresds1("sindi");
		th1.setPriority(1);
		th2.setPriority(10);

		th1.start();
		th2.start();
	}
}
