
public class ReaderWorker implements Runnable {

	@Override
	public void run() {
		
		while (true) {
			synchronized (MainClass.list) {
				while (MainClass.list.isEmpty()) {
					try {
						MainClass.list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(MainClass.list.remove());
			}

		}
		
		
		

	}

}
