public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(1, player, "Safe House", "This Place Is Safe For You. There Is No Enemy.");
    }

    public SafeHouse() {
        super(1, null, "Safe House", "This Place Is Safe For You. There Is No Enemy.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You Are In The Safe House");
        System.out.println("Your Life Has Been Renewed");
        return true;
    }
}
