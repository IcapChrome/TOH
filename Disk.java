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
    
    @Override
    public String toString(){
        return String.format("%d %s %c\n",size,player,player.getSym());
    }

    @Override
    public int compareTo(Disk t) {
        if (t == null) return 1;
        else if (size == t.getSize()) 
                return 1;
            else if (size > t.getSize()) 
                return 1;
            else
                return 0;
    }
}
