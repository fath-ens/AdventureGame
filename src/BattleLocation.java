import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;
@Getter
@Setter
public abstract class BattleLocation extends Location{
    private Monster monster;
    private String award;

    public BattleLocation(int id, Player player, String LocationName,
                          String information, Monster monster, String award) {
        super(id, player, LocationName, information);
        this.monster = monster;
        this.award = award;
    }

    @Override
    public boolean onLocation() {
        System.out.println("Be Carefully!! " + randomMonsterNumber() + " Times "
                + this.getMonster().getName() + " Living in here");
        System.out.println("Fight (1) or Flight (2)");
        int selectCase = input.nextInt();
        switch (selectCase){
            case 1:
                //Savaş
                break;
            case 2:
                //Kaç
                break;
            default:
                onLocation();
        }
        return true;
    }

    public int randomMonsterNumber(){
        Random random = new Random();
        return random.nextInt(3)+1;
    }
}
