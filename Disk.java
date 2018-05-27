package game;

public class Disk implements Comparable<Disk>{
    private int size;
    private Player player;
    
    public Disk(Player p,int s){
        size = s;
        player = p;
    }
    
    int getSize(){
        return size;
    }
    
    public Player getPlayer(){
        return player;
    }
    
    @Override
    public String toString(){
        return String.format("%d %s %c\n",size,player,player.getSym());
    }

    @Override
    public int compareTo(Disk t) {
        if (t == null) return 1;
        else if (size == t.getSize()) // same disk size
                return 0;
            else if (size > t.getSize()) // disk source bigger than disk destination
                return 1;
            else
                return -1;
    }
}
