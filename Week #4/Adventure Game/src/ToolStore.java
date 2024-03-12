public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("---------- Welcome to ToolStore!!! ----------");
        
        return true;
    }
}
