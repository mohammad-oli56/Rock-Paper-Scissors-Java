

//--------------------------------------------backend---------------------------------------------------

import java.util.Random;

public class RockPaperScissor {

    private static final String[]computerChoices = {"Rock","Paper","Scissor"};

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    private String computerChoice;

    private int computerScore , playerScore;

    private Random random;

    public RockPaperScissor(){
         random = new Random();
    }

    public String playRockPaperScissor(String playerChoice){

        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        String result;

        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Scissor")) {
                result = "Computer Wins";
                computerScore++;
            }else {
                result = "Draw";
            }
        }else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissor")){
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result = "Computer Wins";
                computerScore++;
            }else {
                result = "Draw";
            }
        }else {
            //computer chooses scissor
            if(playerChoice.equals("Rock")){
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Paper")) {
                result = "Computer Wins";
                computerScore++;
            }else {
                result = "Draw";
            }
        }
        return result ;

    }
}
