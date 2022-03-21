package tarea.src;

public class software {

	public static void main(String[] args) {
	//int n=0;
		for (int i = 1; i <= 101; ++i) {
			if(i%3==0) {
				System.out.println("Drei");
				continue;
			}
			if(i%5==0) {
				System.out.println("Funf");
				continue;
			}
			System.out.println(i);
		}
	}

}
