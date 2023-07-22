import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean water;
    private boolean food;
    private boolean firewood;
    public Inventory(){
        this.weapon = new Weapon(0, "Punch", 0, 0);
        this.armor = new Armor(0, "Rag", 0, 0);
        this.food = false;
        this.firewood = false;
        this.water = false;
    }

}
