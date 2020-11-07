package rimidalv111.com.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SerpHelper extends JFrame
{

	private JPanel contentPane;
	private JTextField keywordTextbox;
	private JTextField domainToClickTextField;
	private JButton btnStart;
	private JButton btnStop;
	
	
	//controller class
	private Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					SerpHelper frame = new SerpHelper();
					frame.setVisible(true);
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SerpHelper()
	{
		
		System.setProperty("webdriver.chrome.driver", "./src/rimidalv111/browser/chromedriver.exe");
		
		setTitle("GoogleSERPHelper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		keywordTextbox = new JTextField();
		keywordTextbox.setText("best bongs");
		keywordTextbox.setBounds(10, 59, 253, 20);
		contentPane.add(keywordTextbox);
		keywordTextbox.setColumns(10);

		domainToClickTextField = new JTextField();
		domainToClickTextField.setText("slant33.com");
		domainToClickTextField.setBounds(10, 124, 253, 20);
		contentPane.add(domainToClickTextField);
		domainToClickTextField.setColumns(10);

		JLabel lblKeywords = new JLabel("Keyword(s):");
		lblKeywords.setBounds(10, 34, 253, 14);
		contentPane.add(lblKeywords);

		JLabel lblDomainToClick = new JLabel("Domain to Click:");
		lblDomainToClick.setBounds(10, 99, 253, 14);
		contentPane.add(lblDomainToClick);

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(controller.isRunningSearchAndClick())
				{
					System.out.println("Running already...");
					return;
				}
				System.out.println("Starting...");
				controller.startController();
			}
		});
		btnStart.setBounds(10, 239, 91, 23);
		contentPane.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(controller.isRunningSearchAndClick())
				{
					System.out.println("Stopping...");
					controller.stopController();
					return;
				}
				System.out.println("Stopped already...");
			}
		});
		btnStop.setBounds(172, 239, 91, 23);
		contentPane.add(btnStop);

		JCheckBox chckbxDailyAutomated = new JCheckBox("Daily Automated Run");
		chckbxDailyAutomated.setBounds(10, 151, 253, 23);
		contentPane.add(chckbxDailyAutomated);

		JCheckBox chckbxRandomClicks = new JCheckBox("Random SERP Clicks");
		chckbxRandomClicks.setBounds(10, 177, 253, 23);
		contentPane.add(chckbxRandomClicks);

		//initialize controller class
		controller = new Controller(this);
	}

	public JTextField getKeywordTextbox()
    {
    	return keywordTextbox;
    }

	public JTextField getDomainToClickTextField()
    {
    	return domainToClickTextField;
    }

	public JButton getBtnStart()
    {
    	return btnStart;
    }

	public JButton getBtnStop()
    {
    	return btnStop;
    }

	public void setKeywordTextbox(JTextField keywordTextbox)
    {
    	this.keywordTextbox = keywordTextbox;
    }

	public void setDomainToClickTextField(JTextField domainToClickTextField)
    {
    	this.domainToClickTextField = domainToClickTextField;
    }

	public void setBtnStart(JButton btnStart)
    {
    	this.btnStart = btnStart;
    }

	public void setBtnStop(JButton btnStop)
    {
    	this.btnStop = btnStop;
    }
}
