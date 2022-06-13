import java.io.IOException;

import javax.swing.JOptionPane;

public class DetermineOXWin extends StartMenu{
	String result;
	//Get the result from constructor depending on the input decide who wins
	public DetermineOXWin(String x) throws IOException {
		super();
		result = x;
		//Depending on the result, print out the dialog for the winner
		if(result == "o")
		{
			JOptionPane.showMessageDialog(null, "O Wins the game!", "Game Over", JOptionPane.DEFAULT_OPTION);
		}
		else if(result == "x")
		{
			JOptionPane.showMessageDialog(null, "X Wins the game!", "Game Over", JOptionPane.DEFAULT_OPTION);
		}
	}

}
