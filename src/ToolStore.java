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

    public void printWeapon(){
        //silahlar menüsü
        System.out.println(" Weapon Menu");
        for (Weapon weapon : Weapon.weapons()){
            System.out.println("ID : " + weapon.getId() +
                    "\t Weapon Name : " + weapon.getName() +
                    "\t Damage : " + weapon.getDamage() +
                    "\t Price : " + weapon.getPrice());
        }
        System.out.println(Weapon.weapons().length+1 + "   Select To Exit The Store");
        System.out.println("Please Select The Weapon You Want To Buy");
        Weapon selectWeapon;
        int WeaponId = input.nextInt();
        if (WeaponId<=Weapon.weapons().length && WeaponId > 0) {
            selectWeapon = Weapon.getByIdWeapon(WeaponId);
        } else if (WeaponId == Weapon.weapons().length+1) {
            //Exit İşlemi
        } else {
            System.out.println("You Have Made a Non-Menu Selection.\n" + "Please choose again.");
            printWeapon();
        }
    }

    public void printArmor(){
        //zırh menüsü
    }
    @Override
    public boolean onLocation() {
        System.out.println("Welcome To Store");
        switch (selectCase()){
            case 1:
                printWeapon();
                break;
            case 2:
                printArmor();
                break;
            default:
                System.out.println("Bye, We Are Waiting For You Again");
                return true;
        }
        return true;
    }
}
