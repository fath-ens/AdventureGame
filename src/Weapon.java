import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    public static Weapon[] weapons(){
        return new Weapon[]{new Weapon(1, "Pistol", 2, 25),
                new Weapon(2, "Sword", 3, 35),
                new Weapon(3, "Gun",7, 45)};
    }

    public static Weapon getByIdWeapon(int id){
        for (Weapon weapon : weapons()){
            if (weapon.getId() == id){
                return weapon;
            }
        }
        return null;
    }
}
