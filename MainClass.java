import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * Argomenti:
 * String D : directory radice da cui partire
 * int k : numero di thread reader
 */

public class MainClass {
	
	public static LinkedList<String> list = new LinkedList<String>();
	public static boolean done = false;

	public static void main(String[] args) {
		
		int k = Integer.parseInt(args[1]);
		Executor pool = Executors.newFixedThreadPool(1+k);
		
		pool.execute(new WriterWorker(args[0]));
		for(int i=0 ; i<k ; i++) {
			pool.execute(new ReaderWorker());
		}

	}

}
