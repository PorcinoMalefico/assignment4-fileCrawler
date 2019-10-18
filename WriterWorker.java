import java.io.File;

public class WriterWorker implements Runnable {
	String root;
	
	public WriterWorker(String root) {
		this.root = root;
	}

	@Override
	public void run() {
		File rootdir = new File(root);
		
		exploreAndAdd(rootdir.getName());	

	}
	
	private void exploreAndAdd(String curfile) {
		File rootfile = new File(curfile);
		
		synchronized(MainClass.list){
			MainClass.list.add(rootfile.getName());
			MainClass.list.notifyAll();
		}
		if(rootfile.isDirectory()) {
			String[] filelist = rootfile.list();
			for(String file : filelist) {
				exploreAndAdd(rootfile.getName()+"\\"+file);
			}
		}
		
		return;
	}

}
