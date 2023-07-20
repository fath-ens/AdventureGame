import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Location {
    private int id;
    private Player player;
    private String LocationName;
    private String information;



    public abstract boolean onLocation();

}
