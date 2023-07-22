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
    private Inventory inventory;
    private int regHealth;
    private boolean gameStatus ;
    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }
    public void printInfo(){
        System.out.println("Characters : "+this.getCharName()
                +"\nCharacter's Weapon : "+this.getInventory().getWeapon().getName()
                +"\nDamage : "+this.getTotalDamage()
                +"\nHealth : "+this.getHealth()
                +"\nMoney : "+this.getMoney());
    }
    public boolean selectLocation() {
        printInfo();
        Location location = null;
        Location[] locations = {new SafeHouse(), new ToolStore(), new Cave(),
                new Forest(), new River(), new Mine()};
        System.out.println("------------------------------------");
        for (Location loc : locations) {
            System.out.println("ID: " + loc.getId()
                    + "\tRegion Name : " + loc.getLocationName());
        }
        System.out.println("-----------------------");
        System.out.println("Please Select The Region You Want To Go To.");
        int selectRegion = input.nextInt();
        switch (selectRegion) {
            case 1:
                location = new SafeHouse(this);
                break;
            case 2:
                location = new ToolStore(this);
                break;
            case 3:
                if (this.getInventory().isFood()){
                    System.out.println("You Selection The Other Region");
                    selectLocation();
                }
                else {
                    location = new Cave(this);
                }
                break;
            case 4:
                if (this.getInventory().isFirewood()){
                    System.out.println("You Selection The Other Region");
                    selectLocation();
                }
                else {
                    location = new Forest(this);
                }
                break;
            case 5:
                if (this.getInventory().isWater()){
                    System.out.println("You Selection The Other Region");
                    selectLocation();
                }else {
                    location = new River(this);
                }
                break;
            case 6:
                location = new Mine(this);
                break;
            default:
                selectLocation();
        }
        return location.onLocation();
    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealthy());
        this.setMoney(gameChar.getMoney());
        this.setRegHealth(gameChar.getRegHealth());

    }
    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("------------------------------------");
        for (GameChar gameChar : charList){
            System.out.println("ID:" + gameChar.getId()
                    +"\tCharacter : "+gameChar.getName()
                    +"\t Damage : "+ gameChar.getDamage()
                    +"\t Health : "+gameChar.getHealthy()
                    +"\t Money : "+gameChar.getMoney());
        }
        System.out.println("-----------------------");
        System.out.println("Please Select A Character");
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
                selectChar();
        }
    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }
}
