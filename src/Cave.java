public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(3, player, "Cave",
                "You Are In The Cave. Between 1-3 Zombies Live Here.",
                new Zombie(), "Food");
    }

    public Cave() {
        super(3, null, "Cave",
                "You Are In The Cave. Between 1-3 Zombies Live Here.",
                new Zombie(), "Food");
    }
}
