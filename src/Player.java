import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private Scanner input = new Scanner(System.in);
    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    public Player(String name) {
        this.name = name;
    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealthy());
        this.setMoney(gameChar.getMoney());

    }
    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("------------------------------------");
        for (GameChar gameChar : charList){
            System.out.println("ID:" + gameChar.getId()
                    +"\tCharacter : "+gameChar.getName()+"\t Damage : "+ gameChar.getDamage()
                    +"\t Health : "+gameChar.getHealthy()+"\t Money : "+gameChar.getMoney());
        }
        System.out.println("-----------------------");
        System.out.println("Please Choose A Character");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
    }
}
