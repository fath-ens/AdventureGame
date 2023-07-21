import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public abstract class Location {
    private int id;
    private Player player;
    private String LocationName;
    private String information;
    protected Scanner input = new Scanner(System.in);


    public Location(int id, Player player, String locationName, String information) {
        this.id = id;
        this.player = player;
        LocationName = locationName;
        this.information = information;
    }

    public abstract boolean onLocation();

}
