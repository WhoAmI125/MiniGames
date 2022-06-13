import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.*;

public class DetermineDifferenceGameEnd extends StartMenu {
	//The game is determined to be end, now the value of left over heart is needed
	 public DetermineDifferenceGameEnd(int value) throws IOException {
		super();
		//get the value of the heart number
		int heartNumber = value;
		//Use dialog to show information about the heart left and stats
		JLabel label = new JLabel("<html><body><div width='100px' align='center'>Congratulation!<br>You Won the game!<br>And you have:<br>" + heartNumber + " hearts left!<br></div></body></html>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JOptionPane test = new JOptionPane();
		label.setSize(new Dimension(100, 50));
		label.setPreferredSize(new Dimension(100, label.getPreferredSize().height)); 
		JOptionPane.showMessageDialog(null, label, "Game Over", JOptionPane.DEFAULT_OPTION);
	}
	 
}
