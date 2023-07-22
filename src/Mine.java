public class Mine extends BattleLocation{
    public Mine( Player player) {
        super(6, player, "Mine",
                "You Are In The Mine. Between 1-5 Snake Live Here.",
                new Snake(), null);
        super.setMonsterNumber(5);
    }

    public Mine(){
        super(6, null, "Mine",
                "You Are In The Mine. Between 1-5 Snake Live Here.",
                new Snake(), null);
    }


}
