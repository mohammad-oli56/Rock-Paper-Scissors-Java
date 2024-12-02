
//...........................................Frontend.....................................................

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorGUI extends JFrame implements ActionListener{

    //player button
    JButton rockButton,paperButton,scissorButton;

    //will display the choice of the computer
    JLabel computerChoice;

    JLabel computerScoreLabel,playerScoreLabel;

    RockPaperScissor rockPaperScissor;

    public RockPaperScissorGUI(){
        //invoke frame constructor and add title to the GuI
        super("Rock Paper Scissor");

        //set the size of the GUI
        setSize(450,574);

        //set layout to null to disable layout
        setLayout(null);

        //terminate the java virtual machine when closing the gui
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //load GUI in the center or screen every time we run the application
        setLocationRelativeTo(null);

        rockPaperScissor = new RockPaperScissor();

        //ADD gui components
        addGuiComponents();
    }
    private void addGuiComponents(){
    //create comPUTTER score label
        computerScoreLabel = new JLabel("Computer : 0");

        //set X,Y coordinates and width/height values
        computerScoreLabel.setBounds(0,43,450,30);

        //set the font to have a font family of dialog
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));


        //place the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);


        //add to GUI
        add(computerScoreLabel);


        //create computer choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog",Font.PLAIN,18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);


        //create player score label
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);


        //Player button

        //Rock Button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog",Font.PLAIN,18));
        rockButton.addActionListener(this);
        add(rockButton);


        //paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165,387,105,81);
        paperButton.setFont(new Font("Dialog",Font.PLAIN,18));
        paperButton.addActionListener(this);
        add(paperButton);

        //Scissor button
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(290,387,105,81);
        scissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
        scissorButton.addActionListener(this);
        add(scissorButton);

    }
    //displays a message dialog which will show the winner and a rry again button to play again
    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this,"Result",true);
        resultDialog.setSize(227,124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);


        //message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel);
       // add(resultLabel);


        //try again button
        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset computer choice

                computerChoice.setText("?");

                //close the dialog box
                resultDialog.dispose();
            }
        });

        resultDialog.add(tryAgainButton,BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String playerChoice = e.getActionCommand().toString();

        String result = rockPaperScissor.playRockPaperScissor(playerChoice);


        computerChoice.setText(rockPaperScissor.getComputerChoice());


        computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());


        showDialog(result);
    }
}
