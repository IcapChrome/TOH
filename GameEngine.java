package game;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GameEngine {
    private int numOfBins = 6;
    private int numOfDisks = 5;
    private Bin[] bin;
    private Player p1;
    private Player p2;
    private Disk [] dA;
    private Disk [] dF;
    private CommandProcessor cp;
    private String moveComment;
    
    private void CreatePlayers(){
        p1 = new Player("sharaf",'#');        
        p2 = new Player("Ahmad",'H');
    }
    
    private void CreateDisks(){
        dA = new Disk[numOfDisks]; // For Disks on A
        int ds = 1;        
        for (int i=numOfDisks-1;i>=0;i--){
            dA[i] = new Disk(p1, ds);
            ds += 2;
        }
        
        dF = new Disk[numOfDisks]; // For Disks on F
        ds = 1;
        for (int i=numOfDisks-1;i>=0;i--){
            dF[i] = new Disk(p2, ds);
            ds += 2;
        }
    }
    
    private void CreateBins(){
        bin = new Bin[numOfBins];
        for (int i=0;i<numOfBins;i++){
            bin[i] = new Bin();
            switch(i){
                case 0: bin[i].setlabel("A");
                        break;
                case 1: bin[i].setlabel("B");
                        break;
                case 2: bin[i].setlabel("C");
                        break;
                case 3: bin[i].setlabel("D");
                        break;
                case 4: bin[i].setlabel("E");
                        break;
                case 5: bin[i].setlabel("F");
                        break;
                default: break;
                
            }
            //bin[i] = new Bin();
        } 
            
                
        for (int i=0;i<numOfDisks;i++) bin[0].addDisk(dA[i]); //adds disk on Bin A
        for (int i=0;i<numOfDisks;i++)  bin[numOfBins-1].addDisk(dF[i]); // adds disk on Bin F
    }
   
    public GameEngine(){
        CreatePlayers();
        CreateDisks();
        CreateBins();
        cp = new CommandProcessor(bin,p1,p2);
        
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                int x = 0;
                System.out.print("Move From ");
                String input = sc.next();
                String upInput = input.toUpperCase();
                if (upInput.equals("A") ) x = 0;
                if (upInput.equals("B") ) x = 1;
                if (upInput.equals("C") ) x = 2;
                if (upInput.equals("D") ) x = 3;
                if (upInput.equals("E") ) x = 4;
                if (upInput.equals("F") ) x = 5;
                if (upInput.equals("Z") ) x = 99;
                //int x = sc.nextInt();
                int y = 0;
                System.out.print("To ");
                String input2 = sc.next();
                String upInput2 = input2.toUpperCase();
                if (upInput2.equals("A") ) y = 0;
                if (upInput2.equals("B") ) y = 1;
                if (upInput2.equals("C") ) y = 2;
                if (upInput2.equals("D") ) y = 3;
                if (upInput2.equals("E") ) y = 4;
                if (upInput2.equals("F") ) y = 5;
                if (upInput2.equals("Z") ) y = 99;
                //int y = sc.nextInt();
                if (x == 99) System.exit(1);

                //validation 1
                Disk testX = bin[x].peekDisk();
                Disk testY = bin[y].peekDisk();
                if(bin[x].peekDisk() == null){
                    moveComment = "Illegal Move";
                }else if(testX.getSize() > testY.getSize()){
                    moveComment = "Illegal Move";
                }
                else{
                    cp.move(x, y);
                }

                print(moveComment);
                
            }catch(InputMismatchException err){
                System.out.println("Select Bin A - F Only");
            }
        }
        
    }   
    
    public void print(String comment){
        for (int i=0;i<numOfBins;i++) {
            System.out.println("Bin "+bin[i].getLabel());
            System.out.println(bin[i]);
        }
        System.out.println(comment);
    }
}