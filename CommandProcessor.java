package game;
public class CommandProcessor {
    private Bin [] bins;
    private Player p1;
    private Player p2;
    private Player activePlayer;
    
    public CommandProcessor(Bin[] b,Player p1,Player p2){
        bins = b;
        this.p1 = p1;
        this.p2 = p2;
        activePlayer = p1;
    }
    
    public void move(int src, int des) {    // Moves the disk from the source to destination
         bins[des].addDisk(bins[src].removeDisk());      
    }
    
    public void setActivePlayer(Player p){
        activePlayer = p;
    }
    
    
}
