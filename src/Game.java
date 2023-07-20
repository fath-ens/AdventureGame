import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to Adventure Game");
        System.out.println("Please Enter to Username");
        String UserName = input.nextLine();

        System.out.println("Username : " + UserName);
    }
}
