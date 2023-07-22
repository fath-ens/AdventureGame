import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public abstract class BattleLocation extends Location{
    private Monster monster;
    private String award;
    private int monsterNumber = 3;
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
                combatStatus();
                System.out.println("Hit (1) or  Run (2)");
                int selectCombat = input.nextInt();
                switch (selectCombat){
                    case 1:
                        Random random = new Random();
                        int firstHit = random.nextInt(2);
                        switch (firstHit){
                            case 0:
                                playerHit();
                                if (monsterStatus()){
                                    monsterHit();
                                }
                                break;
                            case 1:
                                monsterHit();
                                if (playerStatus()){
                                    playerHit();
                                }
                                break;
                        }
                        break;
                    case 2:
                        this.getPlayer().selectLocation();
                        break;
                }
            }
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getLoot());
            if (this.getMonster().getId() == 4){
                int AwardType = randAward();
                if (AwardType < 15){
                    int awardTypeWeapon = randAward();
                    if (awardTypeWeapon < 20){
                        Weapon AwardWeapon = Weapon.getByIdWeapon(3);
                        if (this.getPlayer().getInventory().getWeapon().getDamage() < AwardWeapon.getDamage()){
                            this.getPlayer().getInventory().setWeapon(AwardWeapon);
                        }
                    } else if (awardTypeWeapon < 50 && awardTypeWeapon >= 20) {
                        Weapon AwardWeapon = Weapon.getByIdWeapon(2);
                        if (this.getPlayer().getInventory().getWeapon().getDamage() < AwardWeapon.getDamage()){
                            this.getPlayer().getInventory().setWeapon(AwardWeapon);
                        }
                    }else {
                        Weapon AwardWeapon = Weapon.getByIdWeapon(1);
                        if (this.getPlayer().getInventory().getWeapon().getDamage() < AwardWeapon.getDamage()){
                            this.getPlayer().getInventory().setWeapon(AwardWeapon);
                        }
                    }
                } else if (AwardType >= 15 && AwardType < 30) {
                    int awardTypeArmor = randAward();
                    if (awardTypeArmor < 20){
                        Armor AwardArmor = Armor.getByIdArmor(3);
                        if (this.getPlayer().getInventory().getArmor().getBlock() < AwardArmor.getBlock()){
                            this.getPlayer().getInventory().setArmor(AwardArmor);
                        }
                    } else if (awardTypeArmor < 50 && awardTypeArmor >= 20) {
                        Armor AwardArmor = Armor.getByIdArmor(2);
                        if (this.getPlayer().getInventory().getArmor().getBlock() < AwardArmor.getBlock()){
                            this.getPlayer().getInventory().setArmor(AwardArmor);
                        }
                    }else {
                        Armor AwardArmor = Armor.getByIdArmor(1);
                        if (this.getPlayer().getInventory().getArmor().getBlock() < AwardArmor.getBlock()){
                            this.getPlayer().getInventory().setArmor(AwardArmor);
                        }
                    }
                } else if (AwardType >= 30 && AwardType <55) {
                    int awardTypeMoney = randAward();
                    if (awardTypeMoney < 20){
                        this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
                    } else if (awardTypeMoney < 50 && awardTypeMoney >= 20) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
                    }
                    else {
                        this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
                    }
                }
            }
        }
        if (this.getPlayer().getHealth() > 0){
            return playerGameStatus();
        }
        else {
            this.getPlayer().setGameStatus(false);
            return false;
        }
    }

    private boolean playerStatus() {
        if (this.getPlayer().getHealth()>0){
            return true;
        }
        else{
            return false;
        }

    }

    private void monsterHit() {
        System.out.println("Monster Hit To You");
        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
        if (monsterDamage > 0){
            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
        }
    }

    private boolean monsterStatus() {
        if (this.getMonster().getHealth()>0){
            return true;
        }
        else{
            return false;
        }
    }

    private void playerHit() {
        System.out.println("You Hit The Monster");
        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
    }

    private void combatStatus() {
        System.out.println("Player Health : " + this.getPlayer().getHealth());
        System.out.println("Monster Health : "+ this.getMonster().getHealth());
    }

    private boolean playerGameStatus() {
        Inventory inventory = this.getPlayer().getInventory();
        if (inventory.isFirewood() && inventory.isFood() && inventory.isWater()){
            this.getPlayer().setGameStatus(true);
            return false;
        }
        else {
            return true;
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
        return random.nextInt(this.getMonsterNumber())+1;
    }
    private int randAward(){
        Random random = new Random();
        return random.nextInt(100);
    }
}
