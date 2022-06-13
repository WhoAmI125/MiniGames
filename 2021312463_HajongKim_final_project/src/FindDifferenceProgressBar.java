import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.*;

public class FindDifferenceProgressBar extends StartMenu implements Runnable{
	
	 public FindDifferenceProgressBar() throws IOException {
		super();
		run();
	}

	@Override
	public void run() {
		progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 60);
        ActionListener listener = new ActionListener() {
            int counter = 60;
            public void actionPerformed(ActionEvent ae) {
                counter--;
                progressBar.setString(counter+" seconds");
                progressBar.setValue(counter);
                if (counter<1) {
                    timer.stop();
                    setHeartCount(-5);
                } 
            }
        };
        timer = new Timer(1000, listener);
        timer.start();
		progressBar.setBounds(400, 5, 500, 50);
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("MV Boli",Font.BOLD,25));
		progressBar.setForeground(new Color(128, 128, 0));
		progressBar.setBackground(Color.black);
		progressBar.setBorder(null);
		
	}

	public void stop() {
		timer.stop();
	}
	
}

