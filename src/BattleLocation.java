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
                if(combat(this.randomMonsterNumber())){
                    System.out.println("All Monster is Dead");
                    return true;
                }
                else {
                    return false;
                }
            case 2:
                this.getPlayer().selectLocation();
                break;
            default:
                onLocation();
        }
        return true;
    }
    public boolean combat(int monsterNumber){
        int defaultMonsterHealth = this.getMonster().getHealth();
        for (int i=1; i<=monsterNumber; i++){
            this.getMonster().setHealth(defaultMonsterHealth);
            playerStats();
            monsterStats();
            while (this.getPlayer().getHealth() >  0 && this.getMonster().getHealth() > 0 ){
                System.out.println("Hit (1) or  Run (2)");
                int selectCombat = input.nextInt();
                switch (selectCombat){
                    case 1:
                        System.out.println("You Hit The Monster");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        if (this.getMonster().getHealth()>0){
                            System.out.println("Monster Hit To You");
                            int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (monsterDamage > 0){
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                            }
                            else{
                                System.out.println("Monster is Dead");
                                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getLoot());
                            }
                        }
                        break;
                    case 2:
                        this.getPlayer().selectLocation();
                        break;
                }
            }
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getLoot());
        }
        if (this.getPlayer().getHealth() > 0){
            return true;
        }
        else {
            return false;
        }
    }
    private void monsterStats() {
        System.out.println(this.getMonster().getName() + " Values");
        System.out.println("Health : "+this.getMonster().getHealth());
        System.out.println("Damage : "+this.getMonster().getDamage());
        System.out.println("Loot   : "+this.getMonster().getLoot());
    }

    public void playerStats(){
        System.out.println("Player Values");
        System.out.println("Health : "+this.getPlayer().getHealth());
        System.out.println("Damage : "+this.getPlayer().getTotalDamage());
        System.out.println("Weapon : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor  : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block  : "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money  : "+this.getPlayer().getMoney());
    }
    public int randomMonsterNumber(){
        Random random = new Random();
        return random.nextInt(3)+1;
    }
}
