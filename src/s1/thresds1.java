package s1;

public class thresds1 extends Thread {
public thresds1(String name) {
super(name);
}
	public void run() {
for(int x=1;x<10;x++) {
	System.out.print("name "+Thread.currentThread().getName()+" ");
	System.out.println("id "+Thread.currentThread().getId());
}
	}

}
