import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Inventory {
    private Weapon weapon;

    public Inventory(){
        this.weapon = new Weapon(0, "Punch", 0, 0);
    }

}
