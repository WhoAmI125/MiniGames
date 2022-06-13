import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.SystemColor;

public class StartMenu extends JFrame {
	//Panel and Layer that would contain everything. All will be build up from here
	public JPanel contentPane;
	public JLayeredPane ControlLayer;
	//The top variables are for the find differnce game
	//Variable that can contain the background image of the start
	private Icon introBackground;
	private JLabel BackgroundImageLabel;
	//Image and button for starting Find the Difference game
	private ImageIcon startButtonForFindDifference;
	private ImageIcon startButtonForTicTacToe;
	private JButton btnStartFindDifference;
	private JLabel developerInformation;
	private JButton gameDifferenceStartButton;
	private JButton gameRuleButton;
	private JButton DeveloperButton;
	//This to have a link that connects to another site outside of GUI
	private JLabel textDeveloper;
	private JLabel hyperlink;
	private JButton ButtonCloseDeveloperInformation;
	private JLabel ruleInformation;
	private JLabel textRule;
	private JButton ButtonCloseRuleInformation;
	//The JLabel of left+@ is used to detect the area that it is right answer to the difference
	public JLabel playFindDifferenceLabel;
	public JLabel playFindDifferenceLabelCover;
	private JLabel leftCorrectImage;
	private JLabel rightCorrectImage;
	private JLabel leftFootDifferenceLabel;
	private JLabel leftTreeDifferenceLabel;
	private JLabel leftAcornDIfferenceLabel;
	private JLabel leftTreeLeafDifferenceLabel;
	private JLabel leftEarDIfferenceLabel;
	//Check if the answer was clicked or not since we do not want answer to be clicked more than once
	private Boolean leftFootDifferenceLabelCheck = true;
	private Boolean leftTreeDifferenceLabelCheck = true;
	private Boolean leftAcornDIfferenceLabelCheck = true;
	private Boolean leftTreeLeafDifferenceLabelCheck = true;
	private Boolean leftEarDIfferenceLabelCheck = true;
	// Heart and count bar showing about the information given
	private JLabel heartUILabel;
	private Integer heartCount = 5;
	private Integer checkDifferenceGameDone = 0;
	private JTextField heartTextField;
	private JButton ButtonCloseDifferenceGameMenu;
	private JButton ButtonCloseDiffernceGame;
	private JLabel correctShowJLabel;
	private JLabel correctShowJLabelNumber;
	//Progress bar for tracking the time of the game
	public JProgressBar progressBar;
	Timer timer;
	
	//This variables are for login
	private JPanel LogInPanel;
	private JLabel LoginLabel;
	private JTextField textFieldID;
	private JTextField textFieldPassword;
	private JButton registerButton;
	private JButton btnLogin;
	
	//This variables are for TicTacToe game
	private JLabel TicTacToeBackground;
	private JButton gameTicTacToeStartButton;
	private JButton ButtonCloseTicTacToeGameMenu;
	private JLabel ruleInformationTicTacToe;
	private JButton ButtonCloseRuleInformationTicTacToe;
	private JLabel textRule2;
	private JLabel playTicTacToeLabel;
	private JButton ButtonCloseTicTacToeGame;
	//This part is to decided whether who's turn it is and reandomly locate the area
	private Random random;
	private JButton[] buttons;
	private JLabel button_Label;
	private char playerTurn = 'o';
	private JButton playerX;
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	//Starts the GUI
	public StartMenu() throws IOException {
		//This is part about the login, the user needs to login to work on anything
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		//Set the GUI size as default that cannot be changed
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel that will cover up the GUI with the login options
		LogInPanel = new JPanel();
		LogInPanel.setBounds(0, 0, 1350, 729);
		contentPane.add(LogInPanel);
		LogInPanel.setLayout(null);
		//Set up the image with Label
		LoginLabel = new JLabel("");
		LoginLabel.setBounds(0, 0, 1350, 729);
		ImageIcon login = new ImageIcon(Main.class.getResource("images/LogInImage.jpg"));
		LoginLabel.setIcon(login);
		LogInPanel.add(LoginLabel);
		//Use getter and setter to safely assign the values of private
		setTextFieldID(new JTextField());
		getTextFieldID().setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		getTextFieldID().setBounds(129, 338, 296, 48);
		LoginLabel.add(getTextFieldID());
		getTextFieldID().setColumns(10);
		getTextFieldID().setOpaque(false);
		getTextFieldID().setBorder(null);
		getTextFieldID().addMouseListener(new MouseAdapter()
	    {
			//When mouse is clicked over the textbox of GUI, turn the text to blank
	        public void mouseClicked(MouseEvent e)
	        {
	        	getTextFieldID().setText("");          
	        }
	    });
		//Simiar applies to the textbox of password
		setTextFieldPassword(new JTextField());
		getTextFieldPassword().setText("  Enter Password");
		getTextFieldPassword().setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		getTextFieldPassword().setColumns(10);
		getTextFieldPassword().setBounds(332, 430, 296, 47);
		getTextFieldPassword().setOpaque(false);
		getTextFieldPassword().setBorder(null);
		getTextFieldPassword().addMouseListener(new MouseAdapter()
	    {
			//Remove the text when the mouse is clicked onto the textbox
	        public void mouseClicked(MouseEvent e)
	        {
	        	getTextFieldPassword().setText("");          
	        }
	    });
		LoginLabel.add(getTextFieldPassword());
		//This is button that will pop-up dialog asking about register
		registerButton = new JButton("Want to Register?");
		registerButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//When the button is clicked, call the constructor and run the dialog
				RegisterDialog registerForm = new RegisterDialog();
				registerForm.run();
			}
		});
		registerButton.setBackground(new Color(128, 128, 0));
		registerButton.setBounds(34, 503, 194, 52);
		LoginLabel.add(registerButton);
		//Button for click to check if login works
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Also call constructor to check the value if it is equal or not and get the return
					LoginControl loginTest = new LoginControl(getTextFieldID().getText(), getTextFieldPassword().getText());
					//If the return value is true, meaning there exist password and id, the user is allowed to enter to the game room
					if(loginTest.correct == true)
					{
						//Remove the Label and Panel about the login since it is not needed anymore
						LoginLabel.setVisible(false);
						LoginLabel.validate();
						LoginLabel.repaint();
						LogInPanel.setVisible(false);
						LogInPanel.validate();
						LogInPanel.repaint();
						//Start the main Menu where it allows to choose options
						startMenu();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		LoginLabel.add(btnLogin);
		btnLogin.setFont(new Font("Bell MT", Font.PLAIN, 18));
		btnLogin.setBackground(new Color(219, 112, 147));
		btnLogin.setBounds(231, 503, 194, 52);
		//Start to add new JLable at ControlLayer, making it easy to override each other
		ControlLayer = new JLayeredPane();
		ControlLayer.setBounds(0, 0, 1350, 729);
		contentPane.add(ControlLayer);
//		
//		
//		startMenu();
		
		
		//testing line
	}
	
	//Start the main Menu of everything
	public void startMenu() throws IOException
	{
		//Start the music when startMenu starts
		Music introMusic = new Music();
		introMusic.run();
		//Set the background image for the intro
		introBackground = new ImageIcon(Main.class.getResource("images/IntroBackground.jpg"));
		//Add the image to Label, then add the label to the contentPane to display
		BackgroundImageLabel = new JLabel("");
		BackgroundImageLabel.setBounds(0, 0, 1350, 729);
		BackgroundImageLabel.setIcon(introBackground);
		ControlLayer.add(BackgroundImageLabel, JLayeredPane.DEFAULT_LAYER);
				
		//Button for starting the Game for find the difference of image
		btnStartFindDifference = new JButton(startButtonForFindDifference);	
		//Button Event to start the game
		btnStartFindDifference.setBounds(50, 80, 200, 200);
		btnStartFindDifference.setVisible(true);
		BackgroundImageLabel.add(btnStartFindDifference);
		//Change the size of image into the button, first get the image and convert
        Image changeSizeforDifferenceOption = ImageIO.read(Main.class.getResource("/images/test.png"));
        //Convert to size of image size that fitx Button
        Image ConvertimgforDifferenceOption = changeSizeforDifferenceOption.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        btnStartFindDifference.setIcon(new ImageIcon(ConvertimgforDifferenceOption));
		//Add event
		btnStartFindDifference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//If the button for Find Difference is clicked, start new function
					FindDiffernceScreenDraw();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//Button for starting the Game for find the difference of image
		gameTicTacToeStartButton = new JButton(startButtonForTicTacToe);	
		//Button Event to start the game for TicTacToe
		gameTicTacToeStartButton.setBounds(50, 380, 200, 200);
		gameTicTacToeStartButton.setVisible(true);
		BackgroundImageLabel.add(gameTicTacToeStartButton);
		//Change the size of image into the button, first get the image and convert
        Image changeSizeforTicTacToeOption = ImageIO.read(Main.class.getResource("/images/TicTacToeImage.png"));
        //Convert to size of image and fit the size
        Image ConvertimgforTicTacToeOption = changeSizeforTicTacToeOption.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        gameTicTacToeStartButton.setIcon(new ImageIcon(ConvertimgforTicTacToeOption));
		//Add mouse effect for start button for tictacto game
        gameTicTacToeStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//If TicTacToe button is clicked, draw screen for tictactoe game JLabel
					TicTacToeScreenDraw();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	//Find DIfference Screen JLabel drawn
	public void FindDiffernceScreenDraw() throws IOException, URISyntaxException
	{
		//Change the background and remove the button for option
		BackgroundImageLabel.setIcon(new ImageIcon(Main.class.getResource("images/FindDifferenceBackground.jpg")));
		btnStartFindDifference.setVisible(false);
		gameTicTacToeStartButton.setVisible(false);
		//Set the mouse for the game start. This button is to show the Label for the game part
		gameDifferenceStartButton = new JButton(new ImageIcon(Main.class.getResource("images/gameStartButton.png")));
		gameDifferenceStartButton.setBounds(572, 280, 206, 46);
		BackgroundImageLabel.add(gameDifferenceStartButton);
		gameDifferenceStartButton.addMouseListener(new MouseAdapter() {
			//Check if mouse is clicked
			public void mouseClicked(MouseEvent e) {
				//Need IOException for loading the image
				try {
					//Open up another JLabel playing the game
					runDifferenceGame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//Check if mouse is on the button, then put motion
			public void mouseEntered(MouseEvent e) {
				gameDifferenceStartButton.setIcon(new ImageIcon(Main.class.getResource("images/gameStartButtonEffect.png")));
			}
			//If mouse is no longer in the button, remove the motion
			public void mouseExited(MouseEvent e) {
				gameDifferenceStartButton.setIcon(new ImageIcon(Main.class.getResource("images/gameStartButton.png")));
			}
		});
		
		//Set the mouse for information about Developer
		DeveloperButton = new JButton(new ImageIcon(Main.class.getResource("images/ButtonDeveloper.png")));
		DeveloperButton.setBounds(572, 440, 206, 50);
		BackgroundImageLabel.add(DeveloperButton);
		DeveloperButton.addMouseListener(new MouseAdapter() {
			//When mouse is clicked
			public void mouseClicked(MouseEvent e) {
				//Need IOException for loading the image
				try {
					//Show the information about develop, who is Hajong Kim
					DevelopInformation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//Check if mouse is on the button, then put motion
			public void mouseEntered(MouseEvent e) {
				DeveloperButton.setIcon(new ImageIcon(Main.class.getResource("images/ButtonDeveloperEffect.png")));
			}
			//If mouse is no longer in the button, remove the motion
			public void mouseExited(MouseEvent e) {
				DeveloperButton.setIcon(new ImageIcon(Main.class.getResource("images/ButtonDeveloper.png")));
			}
		});
		//Button that will explain about the rule of the game and what needs to be done		
		gameRuleButton = new JButton(new ImageIcon(Main.class.getResource("images/gameRuleButton.png")));
		gameRuleButton.setBounds(572, 360, 206, 46);
		BackgroundImageLabel.add(gameRuleButton);
		gameRuleButton.addMouseListener(new MouseAdapter() {
			//When mouse is clicked
			public void mouseClicked(MouseEvent e) {
				try {
					//Open up JLabel that shows the rule of the find difference game
					findDifferenceRule();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//Check if mouse is on the button, then put motion
			public void mouseEntered(MouseEvent e) {
				gameRuleButton.setIcon(new ImageIcon(Main.class.getResource("images/gameRuleEffectButton.png")));
			}
			//If mouse is no longer in the button, remove the motion
			public void mouseExited(MouseEvent e) {
				gameRuleButton.setIcon(new ImageIcon(Main.class.getResource("images/gameRuleButton.png")));
			}
		});
		//Button that is use to close the Difference Game Screen and return to the main Screen
		ButtonCloseDifferenceGameMenu = new JButton("");
		ButtonCloseDifferenceGameMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ControlLayer.remove(BackgroundImageLabel);
        		try {
					startMenu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	        		
        	}
        });
        //Set no border for the image
		ButtonCloseDifferenceGameMenu.setBorderPainted(false);
		ButtonCloseDifferenceGameMenu.setVisible(true);
		ButtonCloseDifferenceGameMenu.setBackground(Color.WHITE);
        //Change the size of image into the button, first get the image and convert
        Image changeSizeClose2 = ImageIO.read(Main.class.getResource("/images/closeIcon.png"));
        //Convert to size of image size and apply to the Button
        Image Convertimg2 = changeSizeClose2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ButtonCloseDifferenceGameMenu.setIcon(new ImageIcon(Convertimg2));
        ButtonCloseDifferenceGameMenu.setBounds(1314, 0, 35, 35);
        BackgroundImageLabel.add(ButtonCloseDifferenceGameMenu);
		
	}
	
	//JLabel for the develop draw when it is clicked
	public void DevelopInformation() throws IOException {
		//Set up the panel for the developer information
		developerInformation = new JLabel();
		developerInformation.setBounds(25, 25, 1300, 680);
		developerInformation.setBackground(Color.WHITE);
		developerInformation.setVisible(true);
		developerInformation.setOpaque(true);
		//Remove the button of the previous JLabel so no error happens
		ButtonCloseDifferenceGameMenu.setVisible(false);
		// create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
 
        // set the border of this component
        developerInformation.setBorder(border);
		ControlLayer.add(developerInformation, JLayeredPane.PALETTE_LAYER);
		//Set up the text to be add
		textDeveloper = new JLabel("<html><body><div align='center'>Hello!!! Nice to Meet You all Playing the Game.<br>My name is Hajong Kim, student in SKKU."
				+ " I made this game using Java for my final project."
				+ " I hope that you will enjoy playing the game."
				+ "<br>For more information about me check out this link!</div></body></html>");
		developerInformation.add(textDeveloper);
		textDeveloper.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textDeveloper.setBounds(345, 40, 641, 500);
		//Set up hyperlink to my web page
		String linkText = "My WebPage";
		hyperlink = new JLabel(linkText);
		hyperlink.setBounds(550, 350, 287, 97);
		developerInformation.add(hyperlink);
		//Style for hyperlink
		hyperlink.setFont(new Font("Century", Font.PLAIN, 34));
        hyperlink.setForeground(Color.BLUE.darker());
        //Change when mouse is over
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Button use to close the JLabel for Developer and return to Find Difference menu
        ButtonCloseDeveloperInformation = new JButton("");
        ButtonCloseDeveloperInformation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ControlLayer.remove(developerInformation);
        		ControlLayer.revalidate();
        		ControlLayer.repaint();	
        		ButtonCloseDifferenceGameMenu.setVisible(true);
        	}
        });
        //Set no border for the image
        ButtonCloseDeveloperInformation.setBorderPainted(false);
        ButtonCloseDeveloperInformation.setBackground(Color.WHITE);
        //Change the size of image into the button, first get the image and convert
        Image changeSizeClose = ImageIO.read(Main.class.getResource("/images/closeIcon.png"));
        //Convert to size of image size of ButtonCloseDeveloperInformation
        Image Convertimg = changeSizeClose.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ButtonCloseDeveloperInformation.setIcon(new ImageIcon(Convertimg));
        ButtonCloseDeveloperInformation.setBounds(1262, 3, 35, 35);
        developerInformation.add(ButtonCloseDeveloperInformation);
        hyperlink.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		            try {
		            	//Gives the link and change the color. When the button is clicked, open up the link
		                Desktop.getDesktop().browse(new URI("https://whoami125.github.io/"));
		                } catch (Exception e1) {
		                    e1.printStackTrace();
		                }
		            }
		        	//Remove the motion when mouse is no longer on the link
		            @Override
		            public void mouseExited(MouseEvent e) {
		                hyperlink.setText(linkText);
		            }
		 
		            @Override
		            public void mouseEntered(MouseEvent e) {
		                hyperlink.setText("<html><a href=''>" + linkText + "</a></html>");
		        }
			});
	}
	//Set up the JLabel explaining about the rule
	public void findDifferenceRule() throws IOException {
		//Set up the panel for the developer information
		ruleInformation = new JLabel();
		ruleInformation.setBounds(25, 25, 1300, 680);
		ruleInformation.setBackground(Color.WHITE);
		ruleInformation.setVisible(true);
		ruleInformation.setOpaque(true);
		ButtonCloseDifferenceGameMenu.setVisible(false);
		// create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
 
        // set the border of this component
        ruleInformation.setBorder(border);
		ControlLayer.add(ruleInformation, JLayeredPane.PALETTE_LAYER);
		//Set up the text to be add
		textRule = new JLabel("<html><body><div align='center'>There are total 5 different parts in the picture.<br>You need to find them all to win the game!"
				+ "<br>Also, You have total of five hearts, if all of hearts are gone, the game is over.<br><br>Have FUN!!!</div></body></html>");
		ruleInformation.add(textRule);
		textRule.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textRule.setBounds(345, 40, 641, 500);
        
        ButtonCloseRuleInformation = new JButton("");
        ButtonCloseRuleInformation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Remove the panel when it is clicked
        		ControlLayer.remove(ruleInformation);
        		ControlLayer.revalidate();
        		ControlLayer.repaint();	
        		ButtonCloseDifferenceGameMenu.setVisible(true);
        	}
        });
        //Set no border for the image
        ButtonCloseRuleInformation.setBorderPainted(false);
        ButtonCloseRuleInformation.setBackground(Color.WHITE);
        //Change the size of image into the button, first get the image and convert
        Image changeSizeClose2 = ImageIO.read(Main.class.getResource("/images/closeIcon.png"));
        //Convert to size of image size of ButtonCloseDeveloperInformation
        Image Convertimg2 = changeSizeClose2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ButtonCloseRuleInformation.setIcon(new ImageIcon(Convertimg2));
        ButtonCloseRuleInformation.setBounds(1262, 3, 35, 35);
        ruleInformation.add(ButtonCloseRuleInformation);
	}
	//Play the game when it starts by the button gameStart
	public void runDifferenceGame() throws IOException
	{
		//Reset the values to the default in case the game starts again
		heartCount = 5;
		checkDifferenceGameDone = 0;
		leftFootDifferenceLabelCheck = true;
		leftTreeDifferenceLabelCheck = true;
		leftAcornDIfferenceLabelCheck = true;
		leftTreeLeafDifferenceLabelCheck = true;
		leftEarDIfferenceLabelCheck = true;
		//Turn off the button for the Find Difference menu, which should not exist anymore
		ButtonCloseDifferenceGameMenu.setVisible(false);
		//Draw the JLabel for the game
		playFindDifferenceLabel = new JLabel();
		playFindDifferenceLabel.setBounds(25, 25, 1300, 680);
		playFindDifferenceLabel.setBackground(Color.WHITE);
		playFindDifferenceLabel.setVisible(true);
		playFindDifferenceLabel.setOpaque(true);
		// create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        // set the border of this component
        playFindDifferenceLabel.setBorder(border);
		ControlLayer.add(playFindDifferenceLabel, JLayeredPane.MODAL_LAYER);
		
		//Set up the image for the left side of the game, with fit the JLabel and border
		Image changeSizeClose = ImageIO.read(Main.class.getResource("/images/leftImageNoError.png"));
        Image Convertimg = changeSizeClose.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        //The left image is where it will show the correct image of difference
        leftCorrectImage = new JLabel();
        leftCorrectImage.setBounds(330, 205, 300, 400);
        leftCorrectImage.setIcon(new ImageIcon(Convertimg));
        playFindDifferenceLabel.add(leftCorrectImage);
        
        //Set up for the size of the image fitting the JLabel
        Image changeSizeCloseRight = ImageIO.read(Main.class.getResource("/images/rightImageError.png"));
        Image ConvertimgRight = changeSizeCloseRight.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        //Click on the right side where the image is difference from the left
        rightCorrectImage = new JLabel();
        rightCorrectImage.setBounds(670, 205, 300, 400);
        rightCorrectImage.setIcon(new ImageIcon(ConvertimgRight));
        rightCorrectImage.addMouseListener(new MouseAdapter() {
        	//When region other than the different is clicked, decrease the heart by one
            public void mouseClicked(MouseEvent evt) {
            	heartCount -= 1;
            	//Apply the decease to the screen
            	heartTextField.setText(heartCount.toString());
            	try {
            		//Check if the game still can be run, over 5 heart or not
					checkDifferenceGameRun();
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
         });
        playFindDifferenceLabel.add(rightCorrectImage);
        
        //Cover the game panel with extra JLayer JLabel to detect if mouse is over or not
        playFindDifferenceLabelCover = new JLabel();
        playFindDifferenceLabelCover.setBounds(25, 25, 1300, 680);
        playFindDifferenceLabelCover.setBackground(Color.WHITE);
        playFindDifferenceLabelCover.setVisible(true);
        playFindDifferenceLabelCover.setOpaque(false);
		ControlLayer.add(playFindDifferenceLabelCover, JLayeredPane.POPUP_LAYER);
		
		//Run the progress bar that shows how many seconds are left
		//FindDifferenceProgressBar check = new FindDifferenceProgressBar();
		//Thread tortoiseThread = new Thread(check, "Tortoise");
		//check.run();
		//playFindDifferenceLabelCover.add(check.progressBar);
		
		//Check if the game still can be run, over 5 heart or not
        leftFootDifferenceLabel = new JLabel();
        leftFootDifferenceLabel.setBounds(766, 485, 18, 39);
        leftFootDifferenceLabel.setVisible(true);
        leftFootDifferenceLabel.setOpaque(false);
        leftFootDifferenceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	//If one the correct parts are clicked
            	if(leftFootDifferenceLabelCheck == true)
            	{
            		//Update information about correct
            		checkDifferenceGameDone += 1;
            		//Remove this region so that it does not decrease heart, but also increase the correct
            		leftFootDifferenceLabelCheck = false;
            	}
            	//Update the heart information
            	heartTextField.setText(heartCount.toString());
            	try {
            		//Check if all 5 are matched and game is done
					checkDifferenceGameDone();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
         });
        playFindDifferenceLabelCover.add(leftFootDifferenceLabel);
        //Another part of answer
        leftTreeDifferenceLabel = new JLabel("");
        leftTreeDifferenceLabel.setBounds(700, 520, 26, 33);
        leftTreeDifferenceLabel.setVisible(true);
        leftTreeDifferenceLabel.setOpaque(false);
        leftTreeDifferenceLabel.addMouseListener(new MouseAdapter() {
        	//Check if the mouse has clicked the right region
            public void mouseClicked(MouseEvent evt) {
            	if(leftTreeDifferenceLabelCheck == true)
            	{
            		//Same applies to this, increase the correct and disable. Do not allow more answer to be considered
            		checkDifferenceGameDone += 1;
            		leftTreeDifferenceLabelCheck = false;
            	}
            	heartTextField.setText(heartCount.toString());
            	try {
            		//Check if the game has meet the requirement
					checkDifferenceGameDone();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
         });
        playFindDifferenceLabelCover.add(leftTreeDifferenceLabel);
        //Another answer
        leftAcornDIfferenceLabel = new JLabel("");
        leftAcornDIfferenceLabel.setBounds(810, 424, 20, 25);
        leftAcornDIfferenceLabel.setVisible(true);
        leftAcornDIfferenceLabel.setOpaque(false);
        leftAcornDIfferenceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	//Increase the value just like previous, this would only happen when the button is clicked for the first time
            	if(leftAcornDIfferenceLabelCheck == true)
            	{
            		checkDifferenceGameDone += 1;
            		leftAcornDIfferenceLabelCheck = false;
            	}
            	heartTextField.setText(heartCount.toString());
            	try {
            		//Check if the game has meet the requirement or not
					checkDifferenceGameDone();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
         });
        playFindDifferenceLabelCover.add(leftAcornDIfferenceLabel);
        //Another part of the answer
        leftTreeLeafDifferenceLabel = new JLabel("");
        leftTreeLeafDifferenceLabel.setBounds(772, 227, 42, 33);
        leftTreeLeafDifferenceLabel.setVisible(true);
        leftTreeLeafDifferenceLabel.setOpaque(false);
        leftTreeLeafDifferenceLabel.addMouseListener(new MouseAdapter() {
        	//Check if the mouse clicked the answer region and increase the value of correct and disable for more
            public void mouseClicked(MouseEvent evt) {
            	if(leftTreeLeafDifferenceLabelCheck == true)
            	{
            		checkDifferenceGameDone += 1;
            		leftTreeLeafDifferenceLabelCheck = false;
            	}
            	heartTextField.setText(heartCount.toString());
            	try {
            		//Check if the game has meet the requirement
					checkDifferenceGameDone();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
         });
        playFindDifferenceLabelCover.add(leftTreeLeafDifferenceLabel);
      //Check if the mouse clicked the answer region and increase the value of correct and disable for more
        leftEarDIfferenceLabel = new JLabel("");
        leftEarDIfferenceLabel.setBounds(855, 300, 26, 33);
        leftEarDIfferenceLabel.setVisible(true);
        leftEarDIfferenceLabel.setOpaque(false);
        leftEarDIfferenceLabel.addMouseListener(new MouseAdapter() {
        	//Check if the mouse clicked the answer region and increase the value of correct and disable for more
            public void mouseClicked(MouseEvent evt) {
            	if(leftEarDIfferenceLabelCheck == true)
            	{
            		checkDifferenceGameDone += 1;
            		leftEarDIfferenceLabelCheck = false;
            	}
            	heartTextField.setText(heartCount.toString());
            	try {
            		//Check if the game has meet the requirement
					checkDifferenceGameDone();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
         });
        playFindDifferenceLabelCover.add(leftEarDIfferenceLabel);
        //Set up HeartUI and text
        heartUILabel = new JLabel("");
        playFindDifferenceLabelCover.add(heartUILabel);
        heartUILabel.setBounds(1130, 3, 80, 80);
        //Convert the size of heart to the right size with ratio fitting the screen
        Image heartUIConvert = ImageIO.read(Main.class.getResource("/images/heartUIDesign.png"));
        Image ConvertedHeartUI = heartUIConvert.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        heartUILabel.setIcon(new ImageIcon(ConvertedHeartUI));
        //Text telling how many hearts are left
        heartTextField = new JTextField();
        heartTextField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 80));
        heartTextField.setHorizontalAlignment(SwingConstants.CENTER);
        heartTextField.setText(heartCount.toString());
        heartTextField.setBorder(null);
        heartTextField.setBounds(1225, 10, 68, 65);
        playFindDifferenceLabelCover.add(heartTextField);
        heartTextField.setColumns(10);
        //Text telling how many correct are found
        correctShowJLabel = new JLabel("");
        correctShowJLabel.setText("Correct: ");
        correctShowJLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
        correctShowJLabel.setBounds(1125, 80, 150, 65);
        playFindDifferenceLabelCover.add(correctShowJLabel);
        correctShowJLabelNumber = new JLabel("");
        correctShowJLabelNumber.setText(checkDifferenceGameDone.toString());
        correctShowJLabelNumber.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
        correctShowJLabelNumber.setBounds(1250, 80, 150, 65);
        playFindDifferenceLabelCover.add(correctShowJLabelNumber);
        
        //Set no border for the image
        ButtonCloseDiffernceGame = new JButton("");
        ButtonCloseDiffernceGame.setBorderPainted(false);
        ButtonCloseDiffernceGame.setBackground(Color.WHITE);
        //Change the size of image into the button, first get the image and convert
        BufferedImage changeSizeClose6 = ImageIO.read(Main.class.getResource("/images/closeIcon.png"));
        //Convert to size of image size of ButtonCloseDeveloperInformation
        Image Convertimg6 = changeSizeClose6.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ButtonCloseDiffernceGame.setIcon(new ImageIcon(Convertimg6));
        ButtonCloseDiffernceGame.setBounds(3, 3, 35, 35);
        //Remove the Find difference game run when user clicks close
        ButtonCloseDiffernceGame.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Remove the screen and reset to Menu Bar
        		ControlLayer.remove(playFindDifferenceLabelCover);
        		ControlLayer.revalidate();
        		ControlLayer.repaint();	
        		ControlLayer.remove(playFindDifferenceLabel);
        		ControlLayer.revalidate();
        		ControlLayer.repaint();	
        		ButtonCloseDifferenceGameMenu.setVisible(true);
        	}
        });
        playFindDifferenceLabelCover.add(ButtonCloseDiffernceGame);
		
	}
	//check if game can still be played or not
	public void checkDifferenceGameRun() throws IOException, URISyntaxException
	{
		//Check if game can be continued or not
		if(heartCount == 0)
		{
			//Use html format which allows easy style
			JLabel label = new JLabel("<html><body><div width='100px' align='center'>Game Over!<br>No Heart Left!!!</div></body></html>");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane.showMessageDialog(null, label, "Game Over", JOptionPane.ERROR_MESSAGE);
			//Remove the screen and reset to Find difference Game Menu Bar
			ControlLayer.remove(playFindDifferenceLabelCover);
    		ControlLayer.revalidate();
    		ControlLayer.repaint();
    		ControlLayer.remove(playFindDifferenceLabel);
    		ControlLayer.revalidate();
    		ControlLayer.repaint();
    		//Make the button visible again, which is belonged in the game menu
    		ButtonCloseDifferenceGameMenu.setVisible(true);
		}
		//This mean that the progress bar has reached 0 seconds, making the time over
		else if(heartCount == -5)
		{
			//Show that time is over
			JLabel label = new JLabel("<html><body><div width='100px' align='center'>Game Over!<br>No Time Left!!!</div></body></html>");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane.showMessageDialog(null, label, "Game Over", JOptionPane.ERROR_MESSAGE);
			//Remove the screen and reset to Find difference Menu Bar
			ControlLayer.remove(playFindDifferenceLabelCover);
    		ControlLayer.revalidate();
    		ControlLayer.repaint();
    		ControlLayer.remove(playFindDifferenceLabel);
    		ControlLayer.revalidate();
    		ControlLayer.repaint();
    		ButtonCloseDifferenceGameMenu.setVisible(true);
		}
	}
	//Check the requirement if the game is done or not
	public void checkDifferenceGameDone() throws IOException
	{
		//If the game has meet the requirement that it can be done, finish the game, else continue
		correctShowJLabelNumber.setText(checkDifferenceGameDone.toString());
		//All the parts are found
		if(checkDifferenceGameDone == 5)
		{
			//Print out the dialog for the heart
			DetermineDifferenceGameEnd Determine = new DetermineDifferenceGameEnd(heartCount);
			//Remove the screen and reset to Find Difference Menu Bar
			ControlLayer.remove(playFindDifferenceLabelCover);
    		ControlLayer.revalidate();
    		ControlLayer.repaint();
    		ControlLayer.remove(playFindDifferenceLabel);
    		ControlLayer.revalidate();
    		ControlLayer.repaint();
    		ButtonCloseDifferenceGameMenu.setVisible(true);
		}
	}
	
	//This function is to run the game about TicTacToe Menu Bar
	public void TicTacToeScreenDraw() throws IOException
	{
		//Disable button for FindDifference since it is not required in tictactoe
		btnStartFindDifference.setVisible(false);
		gameTicTacToeStartButton.setVisible(false);
		//Set the background
		Icon TicTacToeBackgroundImage = new ImageIcon(Main.class.getResource("images/tictactoebackground.jpg"));
		//Add the image to Label, then add the label to the contentPane to display
		BackgroundImageLabel.setIcon(TicTacToeBackgroundImage);
		BackgroundImageLabel.setVisible(true);
		//Change the background and remove the button for option
		//Set the mouse for the game start
		gameTicTacToeStartButton = new JButton(new ImageIcon(Main.class.getResource("images/gameStartButton.png")));
		gameTicTacToeStartButton.setBounds(572, 280, 206, 46);
		BackgroundImageLabel.add(gameTicTacToeStartButton);
		gameTicTacToeStartButton.addMouseListener(new MouseAdapter() {
			//Check if mouse is clicked
			public void mouseClicked(MouseEvent e) {
				try {
					//Start the game by reading the function
					runTicTacToeGame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//Check if mouse is on the button, then put motion
			public void mouseEntered(MouseEvent e) {
				gameTicTacToeStartButton.setIcon(new ImageIcon(Main.class.getResource("images/gameStartButtonEffect.png")));
			}
			//If mouse is no longer in the button, remove the motion
			public void mouseExited(MouseEvent e) {
				gameTicTacToeStartButton.setIcon(new ImageIcon(Main.class.getResource("images/gameStartButton.png")));
			}
		});
		
		//Set the mouse for information about Developer
		DeveloperButton = new JButton(new ImageIcon(Main.class.getResource("images/ButtonDeveloper.png")));
		DeveloperButton.setBounds(572, 440, 206, 50);
		BackgroundImageLabel.add(DeveloperButton);
		DeveloperButton.addMouseListener(new MouseAdapter() {
			//When mouse is clicked
			public void mouseClicked(MouseEvent e) {
				//Need IOException for loading the image
				try {
					DevelopInformationForTicTacToe();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//Check if mouse is on the button, then put motion
			public void mouseEntered(MouseEvent e) {
				DeveloperButton.setIcon(new ImageIcon(Main.class.getResource("images/ButtonDeveloperEffect.png")));
			}
			//If mouse is no longer in the button, remove the motion
			public void mouseExited(MouseEvent e) {
				DeveloperButton.setIcon(new ImageIcon(Main.class.getResource("images/ButtonDeveloper.png")));
			}
		});
		//Get the information about the game rule, it is repeated as same in the Find difference, but the text is differecnt		
		gameRuleButton = new JButton(new ImageIcon(Main.class.getResource("images/gameRuleButton.png")));
		gameRuleButton.setBounds(572, 360, 206, 46);
		BackgroundImageLabel.add(gameRuleButton);
		gameRuleButton.addMouseListener(new MouseAdapter() {
			//When mouse is clicked
			public void mouseClicked(MouseEvent e) {
				try {
					//Run the rule JLabel for the tictactoe
					findTicTacToeRule();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//Check if mouse is on the button, then put motion
			public void mouseEntered(MouseEvent e) {
				gameRuleButton.setIcon(new ImageIcon(Main.class.getResource("images/gameRuleEffectButton.png")));
			}
			//If mouse is no longer in the button, remove the motion
			public void mouseExited(MouseEvent e) {
				gameRuleButton.setIcon(new ImageIcon(Main.class.getResource("images/gameRuleButton.png")));
			}
		});
		//Button use to close TicTacToe Game Menu and return to start menu
		ButtonCloseTicTacToeGameMenu = new JButton("");
		ButtonCloseTicTacToeGameMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//remove the JLabel for TicTacToe
        		ControlLayer.remove(BackgroundImageLabel);
        		try {
        			//run again the menu
					startMenu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	        		
        	}
        });
        //Set no border for the image
		ButtonCloseTicTacToeGameMenu.setBorderPainted(false);
		ButtonCloseTicTacToeGameMenu.setVisible(true);
		ButtonCloseTicTacToeGameMenu.setBackground(Color.WHITE);
        //Change the size of image into the button, first get the image and convert
        Image changeSizeClose2 = ImageIO.read(Main.class.getResource("/images/closeIcon.png"));
        //Convert to size of image size of ButtonCloseDeveloperInformation
        Image Convertimg2 = changeSizeClose2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ButtonCloseTicTacToeGameMenu.setIcon(new ImageIcon(Convertimg2));
        ButtonCloseTicTacToeGameMenu.setBounds(1314, 0, 35, 35);
        BackgroundImageLabel.add(ButtonCloseTicTacToeGameMenu);
	}
	//Play the game of Tic Tac Toe
	public void runTicTacToeGame() throws IOException
	{
		//TicTacToe tictactoe = new TicTacToe();
		ButtonCloseTicTacToeGameMenu.setVisible(false);
		playTicTacToeLabel = new JLabel();
		playTicTacToeLabel.setBounds(25, 25, 1300, 680);
		playTicTacToeLabel.setBackground(Color.WHITE);
		playTicTacToeLabel.setVisible(true);
		playTicTacToeLabel.setOpaque(true);
		// create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        // set the border of this component
        playTicTacToeLabel.setBorder(border);
		ControlLayer.add(playTicTacToeLabel, JLayeredPane.MODAL_LAYER);
		buttons = new JButton[9];
		button_Label = new JLabel();
		button_Label.setLayout(new GridLayout(3,3));
		button_Label.setBounds(385, 120, 500, 500);
		button_Label.setBackground(new Color(150,150,150));
		playTicTacToeLabel.add(button_Label);
		//Reset the buttons to be able to be clicked
		playerTurn = 'o';
		//This button is automatically place the player to random location by the button
		playerX = new JButton("Click For Player X");
		playerX.addActionListener(new ActionListener() {
			//Automatically place the Player X (computer) to one of the location
			public void actionPerformed(ActionEvent e) {
				//Randomly access to one of index 0~8
				Random ran = new Random();
				int x = ran.nextInt(9) + 0;
				//Check if there is input already or not
				if(buttons[x].getText()=="") 
				{
					buttons[x].setForeground(Color.white);
					buttons[x].setText("X");
					buttons[x].setEnabled(false);
					playerTurn = 'o';
					try {
						//Check if the computer has won or not
						check();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//If there was input then find another location
				else if(buttons[x].getText() != "")
				{
					//While it continues to search for location
					while(buttons[x].getText()=="")
					{
						//Find another location and fill up the Button with X
						x = ran.nextInt(9) + 0;
						buttons[x].setForeground(Color.white);
						buttons[x].setText("X");
						buttons[x].setEnabled(false);
						try {
							check();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					//When computer finds location, change the turn to user
					playerTurn = 'o';
				}
			}
		});
		playTicTacToeLabel.add(playerX);
		playerX.setBackground(SystemColor.info);
		playerX.setBounds(1039, 303, 143, 49);
		//For the 9 buttons
		for(int i=0;i<9;i++)
		{
			//Assign each button with value by JLabel
			buttons[i] = new JButton();
			buttons[i].setBackground(new Color(0,71,113));
			button_Label.add(buttons[i]);
			buttons[i].setFont(new Font("Comic Sans MS",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					for(int i=0;i<9;i++) {
						//When the button is clicked, by getSouce get the number of location
						if(actionEvent.getSource() == buttons[i])
						{
							//If it is turn for the user, user chooses one of the location
							if(playerTurn == 'o')
							{
								//If the area is not filled up with anything
								if(buttons[i].getText()=="")
								{
									//User can select the button and fill up with O
									buttons[i].setForeground(Color.black);
									buttons[i].setText("O");
									//Cannot be clicked anymore
									buttons[i].setEnabled(false);
									//Move the turn to computer
									playerTurn = 'x';
									try {
										check();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}			
					}
				}
			});
        }
		
		//Set no border for the image
        ButtonCloseTicTacToeGame = new JButton("");
        ButtonCloseTicTacToeGame.setBorderPainted(false);
        ButtonCloseTicTacToeGame.setBackground(Color.WHITE);
        //Change the size of image into the button, first get the image and convert
        BufferedImage changeSizeClose6 = ImageIO.read(Main.class.getResource("/images/closeIcon.png"));
        //Convert to size of image size of ButtonCloseDeveloperInformation
        Image Convertimg6 = changeSizeClose6.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ButtonCloseTicTacToeGame.setIcon(new ImageIcon(Convertimg6));
        ButtonCloseTicTacToeGame.setBounds(3, 3, 35, 35);
        ButtonCloseTicTacToeGame.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//When buttons is clicked ending the tictactoe, reset the values
        		for(int i=0;i<9;i++)
        		{
        			buttons[i].setEnabled(true);
        		}
        		//Remove and return to the Tic Tac Toe Menu
        		ControlLayer.remove(playTicTacToeLabel);
        		ControlLayer.revalidate();
        		ControlLayer.repaint();	
        		ButtonCloseTicTacToeGameMenu.setVisible(true);
        	}
        });
        playTicTacToeLabel.add(ButtonCloseTicTacToeGame);
		
	}
	//Check the case of any when 3 are together it can be vertical horizontal or diagonal
	public void check() throws IOException 
	{
		//Check the top three if someone has won the game or not
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X"))
		{
			xWins(0,1,2);
		}
		else if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
		{
			oWins(0,1,2);
		}
		else if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
		{
			xWins(3,4,5);
		}
		else if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
		{
			oWins(3,4,5);
		}
		else if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
		{
			xWins(6,7,8);
		}
		else if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
		{
			oWins(6,7,8);
		}
		else if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
		{
			xWins(0,3,6);
		}
		else if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
		{
			oWins(0,3,6);
		}
		else if((buttons[1].getText()=="X") &&(buttons[4].getText()=="X") &&(buttons[7].getText()=="X"))
		{
			xWins(1,4,7);
		}
		else if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
		{
			oWins(1,4,7);
		}
		else if((buttons[2].getText()=="X") &&(buttons[5].getText()=="X") &&(buttons[8].getText()=="X"))
		{
			xWins(2,5,8);
		}
		else if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
		{
			oWins(2,5,8);
		}
		else if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
		{
			xWins(0,4,8);
		}
		else if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
		{
			oWins(0,4,8);
		}
		else if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
		{
			xWins(2,4,6);
		}
		else if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
		{
			oWins(2,4,6);
		}
	}
	//Determine who wins the game by having the return from the oWIns
	public void xWins(int a,int b,int c) throws IOException
	{
		buttons[a].setBackground(new Color(204,255,255));
		buttons[b].setBackground(new Color(204,255,255));
		buttons[c].setBackground(new Color(204,255,255));
		//Print out the result for if x wins
		DetermineOXWin result = new DetermineOXWin("x");
		//Remove the screen and reset to TicTacToe Menu Bar
		ControlLayer.remove(playTicTacToeLabel);
		ControlLayer.revalidate();
		ControlLayer.repaint();
		ButtonCloseTicTacToeGameMenu.setVisible(true);
		
	}
	//Determine who wins the game by having the return from the oWIns
	public void oWins(int a,int b,int c) throws IOException
	{
		buttons[a].setBackground(new Color(204,255,255));
		buttons[b].setBackground(new Color(204,255,255));
		buttons[c].setBackground(new Color(204,255,255));
		//Print out the result for if x wins
		DetermineOXWin result = new DetermineOXWin("o");
		//Remove the screen and reset to TicTacToe Menu Bar
		ControlLayer.remove(playTicTacToeLabel);
		ControlLayer.revalidate();
		ControlLayer.repaint();
		ButtonCloseTicTacToeGameMenu.setVisible(true);
	}
	//Rule explain for the Tic Tac Toe
	public void findTicTacToeRule() throws IOException
	{
		//Set up the panel for the developer information
		ruleInformationTicTacToe = new JLabel();
		ruleInformationTicTacToe.setBounds(25, 25, 1300, 680);
		ruleInformationTicTacToe.setBackground(Color.WHITE);
		ruleInformationTicTacToe.setVisible(true);
		ruleInformationTicTacToe.setOpaque(true);
		ButtonCloseTicTacToeGameMenu.setVisible(false);
		// create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
 
        // set the border of this component
        ruleInformationTicTacToe.setBorder(border);
		ControlLayer.add(ruleInformationTicTacToe, JLayeredPane.PALETTE_LAYER);
		//Set up the text to be add
		textRule2 = new JLabel("<html><body><div align='center'>There are 3x3 matrix.<br>You need three in row to win!"
				+ "<br>Also, if there is no win, it is tie.<br><br>Have FUN!!!</div></body></html>");
		ruleInformationTicTacToe.add(textRule2);
		textRule2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textRule2.setBounds(485, 40, 641, 500);
        //Close and reset
        ButtonCloseRuleInformationTicTacToe = new JButton("");
        ButtonCloseRuleInformationTicTacToe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Remove the panel when it is clicked
        		//Remove the screen and reset to TicTacToe Menu Bar
        		ControlLayer.remove(ruleInformationTicTacToe);
        		ControlLayer.revalidate();
        		ControlLayer.repaint();	
        		ButtonCloseTicTacToeGameMenu.setVisible(true);
        	}
        });
        //Set no border for the image
        ButtonCloseRuleInformationTicTacToe.setBorderPainted(false);
        ButtonCloseRuleInformationTicTacToe.setBackground(Color.WHITE);
        //Change the size of image into the button, first get the image and convert
        Image changeSizeClose22 = ImageIO.read(Main.class.getResource("/images/closeIcon.png"));
        //Convert to size of image size of ButtonCloseDeveloperInformation
        Image Convertimg22 = changeSizeClose22.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ButtonCloseRuleInformationTicTacToe.setIcon(new ImageIcon(Convertimg22));
        ButtonCloseRuleInformationTicTacToe.setBounds(1262, 3, 35, 35);
        ruleInformationTicTacToe.add(ButtonCloseRuleInformationTicTacToe);
	}
	public void DevelopInformationForTicTacToe() throws IOException {
		//Set up the panel for the developer information
		developerInformation = new JLabel();
		developerInformation.setBounds(25, 25, 1300, 680);
		developerInformation.setBackground(Color.WHITE);
		developerInformation.setVisible(true);
		developerInformation.setOpaque(true);
		//Remove the button of the previous JLabel so no error happens
		ButtonCloseTicTacToeGameMenu.setVisible(false);
		// create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
 
        // set the border of this component
        developerInformation.setBorder(border);
		ControlLayer.add(developerInformation, JLayeredPane.PALETTE_LAYER);
		//Set up the text to be add
		textDeveloper = new JLabel("<html><body><div align='center'>Hello!!! Nice to Meet You all Playing the Game.<br>My name is Hajong Kim, student in SKKU."
				+ " I made this game using Java for my final project."
				+ " I hope that you will enjoy playing the game."
				+ "<br>For more information about me check out this link!</div></body></html>");
		developerInformation.add(textDeveloper);
		textDeveloper.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textDeveloper.setBounds(345, 40, 641, 500);
		//Set up hyperlink to my web page
		String linkText = "My WebPage";
		hyperlink = new JLabel(linkText);
		hyperlink.setBounds(550, 350, 287, 97);
		developerInformation.add(hyperlink);
		hyperlink.setFont(new Font("Century", Font.PLAIN, 34));
        hyperlink.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ButtonCloseDeveloperInformation = new JButton("");
        ButtonCloseDeveloperInformation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Remove the screen and reset to TicTacToe Menu Bar
        		ControlLayer.remove(developerInformation);
        		ControlLayer.revalidate();
        		ControlLayer.repaint();	
        		ButtonCloseTicTacToeGameMenu.setVisible(true);
        	}
        });
        //Set no border for the image
        ButtonCloseDeveloperInformation.setBorderPainted(false);
        ButtonCloseDeveloperInformation.setBackground(Color.WHITE);
        //Change the size of image into the button, first get the image and convert
        Image changeSizeClose = ImageIO.read(Main.class.getResource("/images/closeIcon.png"));
        //Convert to size of image size of ButtonCloseDeveloperInformation
        Image Convertimg = changeSizeClose.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ButtonCloseDeveloperInformation.setIcon(new ImageIcon(Convertimg));
        ButtonCloseDeveloperInformation.setBounds(1262, 3, 35, 35);
        developerInformation.add(ButtonCloseDeveloperInformation);
        hyperlink.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		            try {
		            	//Get the hyperlink about information since the develop
		                Desktop.getDesktop().browse(new URI("https://whoami125.github.io/"));
		                } catch (Exception e1) {
		                    e1.printStackTrace();
		                }
		            }
		 
		            @Override
		            //Remove effect since left the mouse
		            public void mouseExited(MouseEvent e) {
		                hyperlink.setText(linkText);
		            }
		 
		            @Override
		            public void mouseEntered(MouseEvent e) {
		                hyperlink.setText("<html><a href=''>" + linkText + "</a></html>");
		        }
			});
	}
	
	//Setter and Getter that is used in other class private
	public Icon getIntroBackground() {
		return introBackground;
	}

	public void setIntroBackground(Icon introBackground) {
		this.introBackground = introBackground;
	}

	public ImageIcon getStartButtonForFindDifference() {
		return startButtonForFindDifference;
	}

	public void setStartButtonForFindDifference(ImageIcon startButtonForFindDifference) {
		this.startButtonForFindDifference = startButtonForFindDifference;
	}

	public JButton getBtnStartFindDifference() {
		return btnStartFindDifference;
	}

	public void setBtnStartFindDifference(JButton btnStartFindDifference) {
		this.btnStartFindDifference = btnStartFindDifference;
	}

	public JLabel getDeveloperInformation() {
		return developerInformation;
	}

	public void setDeveloperInformation(JLabel developerInformation) {
		this.developerInformation = developerInformation;
	}

	public JButton getDeveloperButton() {
		return DeveloperButton;
	}

	public void setDeveloperButton(JButton developerButton) {
		DeveloperButton = developerButton;
	}

	public JLayeredPane ControlLayer() {
		return ControlLayer;
	}

	public void setControlLayer(JLayeredPane controlLayer) {
		ControlLayer = controlLayer;
	}

	public JLabel getTextDeveloper() {
		return textDeveloper;
	}

	public void setTextDeveloper(JLabel textDeveloper) {
		this.textDeveloper = textDeveloper;
	}

	public JLabel getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(JLabel hyperlink) {
		this.hyperlink = hyperlink;
	}

	public JButton getButtonCloseDeveloperInformation() {
		return ButtonCloseDeveloperInformation;
	}

	public void setButtonCloseDeveloperInformation(JButton buttonCloseDeveloperInformation) {
		ButtonCloseDeveloperInformation = buttonCloseDeveloperInformation;
	}

	public JLabel getRuleInformation() {
		return ruleInformation;
	}

	public void setRuleInformation(JLabel ruleInformation) {
		this.ruleInformation = ruleInformation;
	}

	public JLabel getTextRule() {
		return textRule;
	}

	public void setTextRule(JLabel textRule) {
		this.textRule = textRule;
	}

	public JButton getButtonCloseRuleInformation() {
		return ButtonCloseRuleInformation;
	}

	public void setButtonCloseRuleInformation(JButton buttonCloseRuleInformation) {
		ButtonCloseRuleInformation = buttonCloseRuleInformation;
	}

	public JLabel getPlayFindDifferenceLabel() {
		return playFindDifferenceLabel;
	}

	public void setPlayFindDifferenceLabel(JLabel playFindDifferenceLabel) {
		this.playFindDifferenceLabel = playFindDifferenceLabel;
	}

	public JLabel getPlayFindDifferenceLabelCover() {
		return playFindDifferenceLabelCover;
	}

	public void setPlayFindDifferenceLabelCover(JLabel playFindDifferenceLabelCover) {
		this.playFindDifferenceLabelCover = playFindDifferenceLabelCover;
	}

	public JLabel getLeftCorrectImage() {
		return leftCorrectImage;
	}

	public void setLeftCorrectImage(JLabel leftCorrectImage) {
		this.leftCorrectImage = leftCorrectImage;
	}

	public JLabel getRightCorrectImage() {
		return rightCorrectImage;
	}

	public void setRightCorrectImage(JLabel rightCorrectImage) {
		this.rightCorrectImage = rightCorrectImage;
	}

	public JLabel getLeftFootDifferenceLabel() {
		return leftFootDifferenceLabel;
	}

	public void setLeftFootDifferenceLabel(JLabel leftFootDifferenceLabel) {
		this.leftFootDifferenceLabel = leftFootDifferenceLabel;
	}

	public JLabel getLeftTreeDifferenceLabel() {
		return leftTreeDifferenceLabel;
	}

	public void setLeftTreeDifferenceLabel(JLabel leftTreeDifferenceLabel) {
		this.leftTreeDifferenceLabel = leftTreeDifferenceLabel;
	}

	public JLabel getLeftAcornDIfferenceLabel() {
		return leftAcornDIfferenceLabel;
	}

	public void setLeftAcornDIfferenceLabel(JLabel leftAcornDIfferenceLabel) {
		this.leftAcornDIfferenceLabel = leftAcornDIfferenceLabel;
	}

	public JLabel getLeftTreeLeafDifferenceLabel() {
		return leftTreeLeafDifferenceLabel;
	}

	public void setLeftTreeLeafDifferenceLabel(JLabel leftTreeLeafDifferenceLabel) {
		this.leftTreeLeafDifferenceLabel = leftTreeLeafDifferenceLabel;
	}

	public JLabel getLeftEarDIfferenceLabel() {
		return leftEarDIfferenceLabel;
	}

	public void setLeftEarDIfferenceLabel(JLabel leftEarDIfferenceLabel) {
		this.leftEarDIfferenceLabel = leftEarDIfferenceLabel;
	}

	public Boolean getLeftFootDifferenceLabelCheck() {
		return leftFootDifferenceLabelCheck;
	}

	public void setLeftFootDifferenceLabelCheck(Boolean leftFootDifferenceLabelCheck) {
		this.leftFootDifferenceLabelCheck = leftFootDifferenceLabelCheck;
	}

	public Boolean getLeftTreeDifferenceLabelCheck() {
		return leftTreeDifferenceLabelCheck;
	}

	public void setLeftTreeDifferenceLabelCheck(Boolean leftTreeDifferenceLabelCheck) {
		this.leftTreeDifferenceLabelCheck = leftTreeDifferenceLabelCheck;
	}

	public Boolean getLeftAcornDIfferenceLabelCheck() {
		return leftAcornDIfferenceLabelCheck;
	}

	public void setLeftAcornDIfferenceLabelCheck(Boolean leftAcornDIfferenceLabelCheck) {
		this.leftAcornDIfferenceLabelCheck = leftAcornDIfferenceLabelCheck;
	}

	public Boolean getLeftTreeLeafDifferenceLabelCheck() {
		return leftTreeLeafDifferenceLabelCheck;
	}

	public void setLeftTreeLeafDifferenceLabelCheck(Boolean leftTreeLeafDifferenceLabelCheck) {
		this.leftTreeLeafDifferenceLabelCheck = leftTreeLeafDifferenceLabelCheck;
	}

	public Boolean getLeftEarDIfferenceLabelCheck() {
		return leftEarDIfferenceLabelCheck;
	}

	public void setLeftEarDIfferenceLabelCheck(Boolean leftEarDIfferenceLabelCheck) {
		this.leftEarDIfferenceLabelCheck = leftEarDIfferenceLabelCheck;
	}

	public JLabel getHeartUILabel() {
		return heartUILabel;
	}

	public void setHeartUILabel(JLabel heartUILabel) {
		this.heartUILabel = heartUILabel;
	}

	public Integer getHeartCount() {
		return heartCount;
	}

	public void setHeartCount(Integer heartCount) {
		this.heartCount = heartCount;
	}

	public Integer getCheckDifferenceGameDone() {
		return checkDifferenceGameDone;
	}

	public void setCheckDifferenceGameDone(Integer checkDifferenceGameDone) {
		this.checkDifferenceGameDone = checkDifferenceGameDone;
	}

	public JTextField getHeartTextField() {
		return heartTextField;
	}

	public void setHeartTextField(JTextField heartTextField) {
		this.heartTextField = heartTextField;
	}

	public JButton getButtonCloseDifferenceGameMenu() {
		return ButtonCloseDifferenceGameMenu;
	}

	public void setButtonCloseDifferenceGameMenu(JButton buttonCloseDifferenceGameMenu) {
		ButtonCloseDifferenceGameMenu = buttonCloseDifferenceGameMenu;
	}

	public JButton getButtonCloseDiffernceGame() {
		return ButtonCloseDiffernceGame;
	}

	public void setButtonCloseDiffernceGame(JButton buttonCloseDiffernceGame) {
		ButtonCloseDiffernceGame = buttonCloseDiffernceGame;
	}

	public JLabel getCorrectShowJLabel() {
		return correctShowJLabel;
	}

	public void setCorrectShowJLabel(JLabel correctShowJLabel) {
		this.correctShowJLabel = correctShowJLabel;
	}

	public JLabel getCorrectShowJLabelNumber() {
		return correctShowJLabelNumber;
	}

	public void setCorrectShowJLabelNumber(JLabel correctShowJLabelNumber) {
		this.correctShowJLabelNumber = correctShowJLabelNumber;
	}

	//Create getter & setter so other class can access
	public JButton getGameStartButton() {
		return gameDifferenceStartButton;
	}

	public void setGameStartButton(JButton gameDifferenceStartButton) {
		this.gameDifferenceStartButton = gameDifferenceStartButton;
	}

	public JLabel getBackgroundImageLabel() {
		return BackgroundImageLabel;
	}

	public void setBackgroundImageLabel(JLabel backgroundImageLabel) {
		BackgroundImageLabel = backgroundImageLabel;
	}

	public JButton getGameRuleButton() {
		return gameRuleButton;
	}

	public void setGameRuleButton(JButton gameRuleButton) {
		this.gameRuleButton = gameRuleButton;
	}


	public JTextField getTextFieldID() {
		return textFieldID;
	}


	public void setTextFieldID(JTextField textFieldID) {
		this.textFieldID = textFieldID;
		textFieldID.setText("  Enter ID");
	}


	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}


	public void setTextFieldPassword(JTextField textFieldPassword) {
		this.textFieldPassword = textFieldPassword;
	}
}
