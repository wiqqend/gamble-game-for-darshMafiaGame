import java.util.Random;
import java.util.Scanner;

public class Gamble {

    // Exchange rates
    private static final int COINS_PER_CHIP = 10;   // deposit: 10 coins = 1 chip
    private static final int COINS_PER_CASHOUT = 9; // cashout: 1 chip = 9 coins (casino tax)

    // Fields
    private int chips;
    private Player player; // need to find  the class name for what the player is
    private Scanner scanner;
    private Random random;


    // Constructor
    public Gamble(Player player) {
        this.player = player;
        this.chips = 0;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    // ------------------------------
    // Menu
    // ------------------------------

    // Main entry point. Shows options and loops until the player exits.
    public void gambleMenu() {
        // TODO: show games, deposit, payout and exit options
        // TODO: read the choice and call the matching method
        // TODO: loop until the player exits
        
    }

    // ------------------------------
    // Chip methods
    // ------------------------------

    // Turns coins into chips (10 coins = 1 chip) and lowers honor.
    public void depositCoins() {
        // TODO: ask how many coins to deposit
        // TODO: check the player has enough coins
        // TODO: remove the coins from the player
        // TODO: add coins / COINS_PER_CHIP to chips
        // TODO: call lowerHonor(...)
    }

    // Turns chips into coins (1 chip = 9 coins) and adds them to the wallet.
    public void payout() {
        // TODO: display the current chips
        // TODO: ask how many chips to cash out
        // TODO: check hasEnoughChips(amount)
        // TODO: remove the chips
        // TODO: call player.addMoney(amount * COINS_PER_CASHOUT)
    }

    public int getChips() {
        return chips;
    }

    public void addChips(int amount) {
        chips += amount;
    }

    public void removeChips(int amount) {
        chips -= amount;
    }

    public boolean hasEnoughChips(int bet) {
        return chips >= bet;
    }

    // ------------------------------
    // Game methods
    // ------------------------------

    // Rey and Henry
// Emilia
    public void threeCups() {
        printGameInfo("Three Cups", "You will be given 3 cups, one of which has a ball under it. You will have to guess which cup the ball is under. If you guess correctly, you will win 2x your bet.");
        int bet = askForBet();
        System.out.println("Pick a cup (1, 2, or 3): ");
        int userChoice = this.scanner.nextInt();
        int ball = random.nextInt(1, 3);
        //always lose the game
        while (ball == userChoice) {
            ball = random.nextInt(1, 3);
        }
        System.out.println("The ball was under cup " + ball);
        System.out.println("You have lost " + bet + " chips");
        loseBet(bet);
        if (askPlayAgain() == true) {
            threeCups();
        } else {
            System.out.println("You have cashed out with " + chips + " chips");
        }
    }

    // Jacob
    public void slots() {
        // TODO
    }

    // Jacob
     public void blackjack() {
        printGameInfo("Blackjack", "You will be given 2 cards, of possible values together of 2 to 21, \nthe dealer you are versing will also be given cards. Your goal: \n Get as close to 21 as possible without going over. ");
 
        int bet = askForBet();
        int player = randomInt(2, 21);
        int dealer = randomInt(2, 21);
        System.out.println("Your hand is " + player + ".");
 
        boolean hit = true;
        while (hit && player < 21) {
            System.out.println("Hit or stand?");
            if (readChoice("hit", "stand").equals("hit")) {
                player += randomInt(1, 11);
                System.out.println("Your hand is " + player + ".");
            } else {
                hit = false;
            }
        }
 
        System.out.println("The dealer has " + dealer + ".");
 
        if (player <= 21 && player > dealer) {
            System.out.println("You win!");
            winBet(bet, 1);
        } else {
            System.out.println("You lose.");
            loseBet(bet);
        }
    }
 

// Rafal (coin based)
    public void lottery() {
        // TODO
        System.out.println("Pick an integer between 1 and 1000 ");
        int userNum = this.scanner.nextInt();
        if (userNum > 1000 || userNum < 1) {
            System.out.println("Please enter a number between 1 and 1000 ");
        } 
        int winningNum = (int) Math.random() * 1001;

        if (userNum == winningNum) {
            System.out.println("Congratulations you won! ");
        } else {
            System.out.println("You did not win, the correct number was " + winningNum);
        }
    }

    // Rafal (red, black, green)
    public void roulette() {
        // TODO
        System.out.println("Bet on red, black, or green 1 = red, 2 = black, 3 = green. ");
        int userPred = this.scanner.nextInt();
        int table = (int) Math.random() * 101;
        boolean userRed = false;
        boolean userBlack = false;
        boolean userGreen = false;
        if (userPred == 1) {
            userRed = true;
        } else if (userPred == 1) {
            userBlack = true;
        } else if (userPred == 3) {
            userGreen = true;
        }
        
        boolean tableRed = false;
        boolean tableBlack = false;
        boolean tableGreen = false;
        if (table >= 99) {
            tableBlack = true;
        } else if (table % 2 == 0) {
            tableBlack = true;
        } else if (table % 2 != 0) {
            tableBlack = true;
        }

        if (tableBlack == true && userBlack == true) {
            System.out.println("Congratulations you guessed correctly");
        } else if (tableRed == true && userRed == true) {
            System.out.println("Congratulations you guessed correctly");
        } else if (tableGreen == true && userGreen == true) {
            System.out.println("Congratulations you guessed correctly");
        } else {
            System.out.println("You did not guess correctly");
        }


    // Emilia (lowers honor while playing)
// Emilia (lowers honor while playing)
    public void russianRoulette() {
        // explain
        printGameInfo("Russian Roulette", "A revolver will be passed around until someone loses");
        int bet = askForBet();
        lowerHonor(10);
        int chance = random.nextInt(1,6);
        if (chance == 6) {
            int shotNumber = random.nextInt(1,6);
            for (int i = 1; i <= shotNumber; i++) {
                System.out.println("Click");
                //space out clicks
                try {Thread.sleep(1000);}
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("BANG!");
            int hospitalChances = random.nextInt(1,2);
            if (hospitalChances == 1) {
                System.out.println("You have been shot and are now in the hospital");
                int Health = 10;
            } else {
                System.out.println("You have been shot and have died");
                System.exit(0);
            }
        } else {
            System.out.println("You have survived this round and won " + bet * 6 + " chips");
            winBet(bet, 6);
            askPlayAgain();
            if (askPlayAgain() == true) {
                russianRoulette();
            } else {
                System.out.println("You have cashed out with " + chips + " chips");
               
            }}

        }

 // Reg
    public void highLow() {
        printGameInfo("High Low", "You will play a card, then guess if the following card will be Higher or Lower than the current. If you win, you win 2x your bet. You win nothing if you lose.");
       
        int bet = askForBet();
       
        String[] ranks = {"Ace","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // Ace is highest (14)
        String[] suits = {"♠ (Spades)", "♥ (Hearts)", "♦ (Diamonds)", "♣ (Clubs)"};

        int firstRankIndex = randomInt(0, ranks.length - 1);
        int firstSuitIndex = randomInt(0, suits.length - 1);
        int firstValue = values[firstRankIndex];
       
        System.out.println("\nYour current card is: " + ranks[firstRankIndex] + " of " + suits[firstSuitIndex]);
       
        this.scanner.nextLine();

        System.out.print("Will the next card be Higher or Lower? (Type 'high' or 'low'): ");
        String guess = this.scanner.nextLine().trim().toLowerCase();

        int secondRankIndex = randomInt(0, ranks.length - 1);
        int secondSuitIndex = randomInt(0, suits.length - 1);
        int secondValue = values[secondRankIndex];
       
        System.out.println("The next card is: " + ranks[secondRankIndex] + " of " + suits[secondSuitIndex]);

        boolean won = false;
        if (secondValue > firstValue && guess.equals("high")) {
            won = true;
        } else if (secondValue < firstValue && guess.equals("low")) {
            won = true;
        } else if (secondValue == firstValue) {
            System.out.println("It's a tie! You lost.");
        }

        if (won) {
            System.out.println("Congratulations! You guessed correctly.");
            winBet(bet, 2); // 2x win
            System.out.println("You won " + (bet * 2) + " chips! Total chips: " + getChips());
        } else {
            System.out.println("Incorrect guess! You lost your bet.");
            loseBet(bet);
            System.out.println("Total chips remaining: " + getChips());
        }
    }
    // Henry
public void coinFlip() {
        printGameInfo("Coin Flip", "You will Pick Heads or Tails, if you're prediction is correct you will 2x your bet. ");
        int bet = askForBet();
        System.out.println("Heads Or Tails");
        String coinFlip = this.scanner.nextLine();
        int cf; // 0 for Heads, 1 for Tails
        String lowerCoinFlip = coinFlip.toLowerCase();

        if (lowerCoinFlip.startsWith("h")) {
            cf = 0; // Heads
        }      
        else if (lowerCoinFlip.startsWith("t")) {
            cf = 1; // Tails
        }
        else {
            System.out.println("Invalid input. Please enter 'Heads' or 'Tails'. As consequence, your bet is forfeited.");
            loseBet(bet);
            return;
        }
        double randomFlip = Math.random();
        if (randomFlip <= 0.5) {
            randomFlip = 0; // Heads
        } else {
            randomFlip = 1; // Tails
        }
        if (cf == randomFlip) {
            System.out.println("You win!");
            winBet(bet, 2);
        } else {
            System.out.println("You lose!!!");
            loseBet(bet);
        }
        System.out.println("Thanks for playing!");
    }

    // ------------------------------
    //  helper methods
    // ------------------------------

    // Explains a game before it starts.
    private void printGameInfo(String name, String rules) {
        // TODO
        System.out.println("Welcome to " + name + " the rules are as follows: " + rules);
    }

    // Prompts for a bet and returns a valid amount.
    private int askForBet() {
        System.out.println("How much would you like to bet? ");
        int bet = this.scanner.nextInt();
        if (validateBet(bet)){
            return bet;
        } else {
            askForBet();
            return 0;
        }
    }

    // Returns true if the bet is above 0 and within the chip count.
    private boolean validateBet(int bet) {
        if (hasEnoughChips(bet)){
            return true;
        } else {
            return false;
        }
    }

    // Returns true if the player wants to play again.
    private boolean askPlayAgain() {
        System.out.println("Do you want to play again? (Y/N): ");
        String playAgainAns = this.scanner.nextLine();
        playAgainAns = playAgainAns.toUpperCase();
        if (playAgainAns == "Y"){
            return true;
        } else if (playAgainAns =="N"){
            return false;
        }
        else {
            askPlayAgain();
            return false;
        }
    }

    // Returns a random int from min to max, inclusive.
    private int randomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    // Adds winnings to chips (bet * multiplier).
    private void winBet(int bet, int multiplier) {
        chips += (bet * multiplier);
    }

    // Removes the bet from chips.
    private void loseBet(int bet) {
        chips -= bet;
    }

    // Reads a valid text choice from the given options.
    private String readChoice(String... options) {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
 
            for (String option : options) {
                if (input.equals(option.toLowerCase())) {
                    return option.toLowerCase();
                }
            }
 
            System.out.println("Please type one of these: " + String.join(", ", options));
        }
    }

    // Lowers the player's honor.
    private void lowerHonor(int amount) {
        // TODO: call the honor method on player
        // Player.lowerHonor(100); // Not sure yet since I need class name for player
    }
}