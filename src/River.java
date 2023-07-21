public class River extends BattleLocation{
    public River(Player player) {
        super(5, player, "River",
                "You Are In The River. Between 1-3 Bear Live Here.",
                new Bear(), "Water");
    }
    public River(){
        super(5, null, "River",
                "You Are In The River. Between 1-3 Bear Live Here.",
                new Bear(), "Water");
    }
}
