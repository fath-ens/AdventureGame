import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Monster {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int loot;

    public void setHealth(int health) {
        if (health<0){
            health=0;
        }
        this.health = health;
    }
}
