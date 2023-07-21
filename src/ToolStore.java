public class ToolStore extends NormalLocation{

    public ToolStore(Player player) {
        super(2, player, "Store", "You Can Buy Weapon And Armor.");
    }

    public ToolStore() {
        super(2, null, "Store", "You Can Buy Weapon And Armor.");
    }

    public int selectCase(){
        System.out.println("Select The Action You Want To Do");
        System.out.println("1 \t Weapon");
        System.out.println("2 \t Armor");
        System.out.println("3 \t Exit");
        return input.nextInt();
    }

    public void MenuWeapon(){
        System.out.println(" Weapon Menu");
        for (Weapon weapon : Weapon.weapons()){
            System.out.println("ID : " + weapon.getId() +
                    "\t Weapon Name : " + weapon.getName() +
                    "\t Damage : " + weapon.getDamage() +
                    "\t Price : " + weapon.getPrice());
        }
        System.out.println(Weapon.weapons().length+1 + "   Select To Exit The Store");
        BuyWeapon();
    }
    public boolean BuyWeapon(){
        System.out.println("Please Select The Weapon You Want To Buy");
        int WeaponId = input.nextInt();
        Weapon selectWeapon;
        if (WeaponId<=Weapon.weapons().length && WeaponId > 0 && Weapon.getByIdWeapon(WeaponId)!= null) {
            selectWeapon = Weapon.getByIdWeapon(WeaponId);
            if (selectWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You Don't Have Enough Money");
            }else{
                System.out.println("You Bought The "+selectWeapon.getName() + " Gun");
                this.getPlayer().setMoney(this.getPlayer().getMoney()-selectWeapon.getPrice());
                this.getPlayer().getInventory().setWeapon(selectWeapon);
                System.out.println("Your Remaining Money : " + this.getPlayer().getMoney());
            }
            return true;
        } else if (WeaponId == Weapon.weapons().length+1) {
            return true;
        } else {
            System.out.println("You Have Made a Non-Menu Selection.\n" + "Please choose again.");
            MenuWeapon();
        }
        return true;
    }

    public void MenuArmor(){
        System.out.println(" Armor Menu");
        for (Armor armor : Armor.armors()){
            System.out.println("ID : " + armor.getId() +
                    "\t Armor Name : " + armor.getName() +
                    "\t Block : " + armor.getBlock() +
                    "\t Price : " + armor.getPrice());
        }
        System.out.println(Armor.armors().length+1 + "   Select To Exit The Store");
        BuyArmor();
    }

    private void BuyArmor() {
        System.out.println("Please Select The Armor You Want To Buy");
        int ArmorId = input.nextInt();
        Armor selectArmor;
        if (ArmorId<=Armor.armors().length && ArmorId > 0 && Armor.getByIdArmor(ArmorId)!= null) {
            selectArmor = Armor.getByIdArmor(ArmorId);
            if (selectArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You Don't Have Enough Money");
            } else {
                System.out.println("You Bought The " + selectArmor.getName());
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectArmor);
                System.out.println("Your Remaining Money : " + this.getPlayer().getMoney());
            }
        }
        else {
            System.out.println("You Have Made a Non-Menu Selection.\n" + "Please choose again.");
            MenuArmor();
        }
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome To Store");
        switch (selectCase()){
            case 1:
                MenuWeapon();
                break;
            case 2:
                MenuArmor();
                break;
            default:
                System.out.println("Bye, We Are Waiting For You Again");
                return true;
        }
        return true;
    }
}
