import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to Adventure Game");
        System.out.println("Please Enter to Username");
        String UserName = input.nextLine();
        Player player = new Player(UserName);
        System.out.println("Dear " + player.getName() + " Welcome To The Dark and Foggy Island !!");
        System.out.println("Everything that happens here is real.");
        player.selectChar();
    }
}
