public class ToolStore extends NormalLocation{
    public ToolStore(Player player) {
        super(2, player, "Store", "You Can Buy Weapon And Armor.");
    }

    public ToolStore() {
        super(2, null, "Store", "You Can Buy Weapon And Armor.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome To Store");
        return true;
    }
}
