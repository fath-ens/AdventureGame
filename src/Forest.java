public class Forest extends BattleLocation{
    public Forest( Player player) {
        super(4, player, "Forest",
                "You Are In The Forest. Between 1-3 Vampire Live Here.",
                new Vampire(), "Firewood");
    }

    public Forest(){
        super(4, null, "Forest",
                "You Are In The Forest. Between 1-3 Vampire Live Here.",
                new Vampire(), "Firewood");
    }
}
