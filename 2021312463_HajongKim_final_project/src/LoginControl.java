import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
//This is about control the login
public class LoginControl extends StartMenu{
	//Check how many of it is correct
	Integer count = 0;
	//Return false is default about whether ID and password is right or wrong
	Boolean correct = false;
	//Get the values by constructor
	String ID;
	String PWD;
	//Constructor of LoginControl class, get the value
	public LoginControl(String Id, String Pwd) throws IOException {
		ID = Id;
		PWD = Pwd;
		count = 0;
		correct = false;
		//ArrayList gaining the value of the text
		ArrayList<Boolean> conditions = new ArrayList();
		//Read off
		conditions = doRead();
		//If the count == 2, meaning all the match happens
		if (count==2) {
			//Set the return value correct true, allowing the user to login
			correct = true;
			//Print out dialog about that user is authorized to enter
			JLabel label = new JLabel("<html><body><div width='100px' align='center'>ID and Password Matched!</div></body></html>");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane test = new JOptionPane();
			label.setSize(new Dimension(100, 50));
			label.setPreferredSize(new Dimension(100, label.getPreferredSize().height)); 
			JOptionPane.showMessageDialog(null, label, "Accepted", JOptionPane.DEFAULT_OPTION);
		}
	}
		//This is reading off the data from the file given
		public ArrayList<Boolean> doRead() {
			count = 0;
			ArrayList<Boolean> flage = new ArrayList();
			//File IO
			FileInputStream fileObject;
			try {
				//Check if the file exists about the data.txt
				fileObject = new FileInputStream("data.txt");
				//Read off the values
				Scanner x = new Scanner(fileObject); 
				while(x.hasNext()) //If next line exits
				{
					//Cut the text, diving into two parts to get the data about the login is allowed or not
					String lineContent[] = x.nextLine().split(":");
					if(lineContent[0].equals("UserName")&&
							lineContent[1].length()>0){
							if(ID.equals(" ")) //Check if it is blank or not
							{
								continue;
							}
							//If it equals then increase. Check the class variable gotten by constructor with the text value
							else if (lineContent[1].equals(ID) == true) {
								flage.add(true);
								count++;
							}
							else
							{
								//Show that ID does not match and there is error if the constructor value ID and data.txt file value does not match
								JOptionPane.showMessageDialog(null, "ID does not match", "Declined", JOptionPane.ERROR_MESSAGE);
							}
								
							}
					//Similar to ID happening in Password
					if(lineContent[0].equals("Password")&&
							lineContent[1].length()>0) 
					{
						if (lineContent[1].equals(PWD) == true)
						{
							flage.add(true);
							count++;
						}
						else
						{
							//Print out no since the password did not match
							JOptionPane.showMessageDialog(null, "PWD does not match", "Declined", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				x.close();
			
			} catch (FileNotFoundException e) {
				System.out.println(e);
		}
			//Return the value of boolean, so the size can be determined by the correctness
			return flage;
		}

}
