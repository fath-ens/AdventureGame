public abstract class NormalLocation extends Location{
    public NormalLocation(int id, Player player, String name, String information ) {
        super(id, player, name, information);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
