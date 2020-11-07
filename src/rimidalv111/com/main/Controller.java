package rimidalv111.com.main;


public class Controller
{
	private SerpHelper instance;
	
	//is program running
	private boolean runningSearchAndClick = false;
	
	public Controller(SerpHelper sh)
	{
		instance = sh;
	}
	
	public void startController()
	{
		(new PageCrawler(instance, instance.getKeywordTextbox().getText(), instance.getDomainToClickTextField().getText())).start();
		runningSearchAndClick = true;
	}
	
	
	public void stopController()
	{
		
		runningSearchAndClick = false;
	}

	
	//Controller Thread
	public class ControllerThread extends Thread
	{
		private SerpHelper sinstance;
		
		public ControllerThread(SerpHelper v)
		{
			sinstance = v;
		}
		
		public void run()
		{
			
		}

		public SerpHelper getSinstance()
        {
	        return sinstance;
        }

		public void setSinstance(SerpHelper sinstance)
        {
	        this.sinstance = sinstance;
        }
	}
	
	
	public boolean isRunningSearchAndClick()
    {
    	return runningSearchAndClick;
    }

	public void setRunningSearchAndClick(boolean runningSearchAndClick)
    {
    	this.runningSearchAndClick = runningSearchAndClick;
    }
	
	
}
