package testSpring;

import java.util.Arrays;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long t1 = System.currentTimeMillis();
		int size = 10000;
		String chuan = "aa";
		for(int i=0;i<1000;i++){
			char[] ff = new char[size];
			Arrays.fill(ff,'a');
			chuan = chuan + new String(ff);
	}	
		long t2 = System.currentTimeMillis();

		System.out.println("result " + (t2-t1));
	}

	
	
}
