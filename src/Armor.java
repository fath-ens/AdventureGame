import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public static Armor[] armors() {
        return new Armor[]{new Armor(1, "Lightweight Armor", 1,15),
                new Armor(2, "Medium Armor", 3, 25),
                new Armor(3, "Heavy Armor", 5, 40)};
    }

    public static Armor getByIdArmor(int id){
        for (Armor armor : armors()){
            if (armor.getId() == id){
                return armor;
            }
        }
        return null;
    }
}
