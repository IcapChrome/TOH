package game;
public class Player {
    String name;
    private char symbol;

    
    public Player(){
        this("Anonymous",'$');
    }
    
    public Player (String nm, char sm){
        name = nm;
        symbol = sm;
    }
    
    void setName(String nm){
        name = nm;
    }
    
    String getName(){
        return name;
    }
    
    void setSym(char sm){
        symbol = sm;
    }
    
    char getSym(){
        return symbol;
    }
    
    public String toString(){
        return name;
    }
}
