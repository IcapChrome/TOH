package game;

import java.util.Iterator;
import java.util.Stack;

public class Bin {
    private Stack<Disk> disks;
    private String label;
    
    public Bin(){
        disks = new Stack<Disk>();
        label = "";
    }
    
    int getNumDisks(){
        return disks.size();
    }
    
    public void setlabel(String lbl){ // set label name for Bin
        label = lbl;
    }
    
    public String getLabel(){ // getter method for label.
        return label;
    }
    
    public boolean addDisk(Disk d){
        if (disks.empty()) {
            disks.push(d);
            return true;
        } else {
            Disk t = disks.peek();
            if (t.compareTo(d) > 0){
                disks.push(d);
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    public Disk removeDisk(){
        if (!disks.empty()){
            return disks.pop();
        }
        else
            return null;
    }
    
    public Disk peekDisk(){
        if (!disks.empty()){
            return disks.peek();
        }
        else
            return null;
    }
      
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        
        Iterator it = disks.iterator();
        while (it.hasNext()) {
           sb.append(it.next());
        }
        return sb.toString();
    }
    
}
