import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class GameChar {
    private int id;
    private String name;
    private int damage;
    private int healthy;
    private int money;
    final int regHealth;


}
