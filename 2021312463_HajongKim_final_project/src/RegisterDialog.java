import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirmPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//Form up the constructor inside the RegisterDialog if it is run directly from the class, but in other cases it is not used
			RegisterDialog dialog = new RegisterDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Function that will run the RegisterDialog class outside of the current class
	void run()
	{
		//Form up the constructor, no need of giving values
		RegisterDialog dialog = new RegisterDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	/**
	 * Create the dialog.
	 */
	public RegisterDialog() {
		setTitle("Register Account");
		setBounds(100, 100, 344, 250);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 328, 178);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		//There is 0 2 0 0 grid, having total of four factors as input
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			//Collection of button group
			ButtonGroup G = new ButtonGroup();

		}
		{
			//Label for text showing where ID should be written
			JLabel IDLabel = new JLabel("ID: ");
			contentPanel.add(IDLabel);
		}
		{
			//Textfield where user would input ID
			textFieldUserName = new JTextField ();
			contentPanel.add(textFieldUserName);
			textFieldUserName.setColumns(10);
		}
		{
			//Label for text showing where Password should be written
			JLabel lblPassword = new JLabel("Password: ");
			contentPanel.add(lblPassword);
		}
		{
			//Textfield where user would input password
			textFieldPassword = new JPasswordField();
			textFieldPassword.setColumns(10);
			contentPanel.add(textFieldPassword);
		}
		{
			//Location to write down the password once again to check if user did not input wrong
			JLabel lblConfirmPassword = new JLabel("Confirm Password: ");
			contentPanel.add(lblConfirmPassword);
		}
		{
			textFieldConfirmPassword = new JPasswordField();
			textFieldConfirmPassword.setColumns(10);
			contentPanel.add(textFieldConfirmPassword);
		}
		{
			//Panel where several buttons are located
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 178, 328, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				//Okay button, where user would click and submit the result
				JButton okButton = new JButton("Register");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Write down on the file
						doWrite();
						//Only if the two password matches, in case if both is blank, it matches, but should not be allowed
						if(textFieldPassword.getText().equals("") || textFieldConfirmPassword.getText().equals(""))
						{
							//Dialog that does not allow
							int res = JOptionPane.showOptionDialog(null, "Password does not match\nNot Registered",getTitle(), JOptionPane.ERROR_MESSAGE,
							        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						}
						//Another allow without limit
						else if(textFieldPassword.getText().equals(textFieldConfirmPassword.getText()))
						{
							int res = JOptionPane.showOptionDialog(null, "Thank you \n You are registered",getTitle(), JOptionPane.DEFAULT_OPTION,
							        JOptionPane.INFORMATION_MESSAGE, null, null, null);
							if (res == 0) {
								//End
								dispose();
							}
						}
						else
						{
							int res = JOptionPane.showOptionDialog(null, "Password does not match\nNot Registered",getTitle(), JOptionPane.ERROR_MESSAGE,
							        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						}
					}
				});
				 
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				//Canceling register if user does not want
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//When cancelButton is clicked, finish the the Register Dialog and end 
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	//Write file IO
	public void doWrite(){
		
		//FileWriter fileObject =new FileWriter("data.txt",true);
		try {
		FileOutputStream fileObject =new FileOutputStream("data.txt",false);
		 
		PrintWriter x = new PrintWriter(fileObject);
		
		
		x.println("UserName:"+ textFieldUserName.getText());
		
		if (textFieldPassword.getText().equals(textFieldConfirmPassword.getText())) {
			x.println("Password:"+ textFieldPassword.getText());
			}
		x.close();
		}catch (Exception e) {
			 e.printStackTrace();
		}
		
	
		
	}
	
	

}
