/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 Well I hope this program doesn't suck.
 * @author Akash Kumar S
 */
public class HC {
    
    public static int t1=0,t2=0,i,j,ch,v1,v2,toss,ut,ct;

    public static void main(String args[]){
        
        
        System.out.println("Let's start Digital Hand Cricket:\n");
        JOptionPane.showMessageDialog(null,"Welcome to Digital Hand Cricket: ","Greetings",JOptionPane.PLAIN_MESSAGE );
        String str1,str2;
        Scanner in=new Scanner(System.in);
        
        Random r=new Random();
        str1=JOptionPane.showInputDialog("Select 1.Odd or 2.Even for Toss:");
        toss=Integer.parseInt(str1);
        str2=JOptionPane.showInputDialog("Enter a number for Toss:");
        ut=Integer.parseInt(str2);
        ct=r.nextInt(10);
        switch(toss)
        {
            case 1:
                if((ut+ct)%2==0){
                    
                    JOptionPane.showMessageDialog(null,"The CPU Value is:"+ct+" Sum is Even "+(ct+ut),"CPU TossValue",JOptionPane.PLAIN_MESSAGE );
                    JOptionPane.showMessageDialog(null,"You selected 'Odd!' and LOST the toss:","TossValuE",JOptionPane.PLAIN_MESSAGE );
                                        
                    ch=1+r.nextInt(2);
                    if(ch==1){
                        
                        JOptionPane.showMessageDialog(null,"CPU chose to Bowl.","CPU Choice",JOptionPane.PLAIN_MESSAGE );
                    }
                    else{
                        
                        JOptionPane.showMessageDialog(null,"CPU chose to Bat.","CPU Choice",JOptionPane.PLAIN_MESSAGE );
                    }
                }
                else{
                    
                    JOptionPane.showMessageDialog(null,"The CPU Value is:"+ct+" Sum is 'Odd'"+(ct+ut),"CPU TossValue",JOptionPane.PLAIN_MESSAGE );
                    JOptionPane.showMessageDialog(null,"You selected 'Odd!' and WON the toss:","TossValuE",JOptionPane.PLAIN_MESSAGE );
                    
                    String str3=JOptionPane.showInputDialog("Select 1.Bat or 2.Bowl:");
                    ch=Integer.parseInt(str3);
                              
                }
                break;
            case 2:
                if((ut+ct)%2==0){
                    JOptionPane.showMessageDialog(null,"The CPU Value is:"+ct+" Sum is 'Even'"+(ct+ut),"CPU TossValue",JOptionPane.PLAIN_MESSAGE );
                    JOptionPane.showMessageDialog(null,"You selected 'Even!' and WON the toss:","TossValuE",JOptionPane.PLAIN_MESSAGE );
                    
                    String str3=JOptionPane.showInputDialog("Select 1.Bat or 2.Bowl:");
                    ch=Integer.parseInt(str3);
                                      
                }
                else{
                    
                    JOptionPane.showMessageDialog(null,"The CPU Value is:"+ct+" Sum is Odd "+(ct+ut),"CPU TossValue",JOptionPane.PLAIN_MESSAGE );
                    JOptionPane.showMessageDialog(null,"You selected 'Even!' and LOST the toss:","TossValuE",JOptionPane.PLAIN_MESSAGE );
                                        
                    ch=1+r.nextInt(2);
                    if(ch==1){
                        
                        JOptionPane.showMessageDialog(null,"CPU chose to Bowl.","CPU Choice",JOptionPane.PLAIN_MESSAGE );
 
                    }
                    else{
                        
                        JOptionPane.showMessageDialog(null,"CPU chose to Bat.","CPU Choice",JOptionPane.PLAIN_MESSAGE );
                        
                    }           
                }
                break;
            default:
                System.out.println("Invalid Entry in 'Odd or Even' Value#");
        }
               
        System.out.println("**Enter value from 0 to 6**\n");
        
        if(ch==1){
            System.out.println("<<FIRST INNINGS>>");
            t2=1000000;
            bat();
            t2=0;
            System.out.println("<<SECOND INNINGS>>");
            System.out.println("\nScore to Defend:"+t1);
            bowl();
        }
        else{
            
            System.out.println("<<FIRST INNINGS>>");
            t1=1000000;
            bowl();
            t1=0;
            System.out.println("<<SECOND INNINGS>>");
            System.out.println("\nScore to Chase:"+t2);
            bat();
        }
        
        
        if(t1>t2){
            System.out.println("You Won the match :D ");
        }
        else if(t2>t1){
            System.out.println("You Lost the match _|_ ");
        }
        else{
            System.out.println("It's Tie.");
        }
        
        System.out.println("<<-------END OF GAME------>>");
        
      
    }
    
    public static void bat(){
        
         Scanner in=new Scanner(System.in);
         Random r=new Random();
         
        do{
            
            System.out.print("Your Bat:");
            v1=in.nextInt();
            if(v1>6){
                JOptionPane.showMessageDialog(null,"Input value exceeded 6!  Try again","Error",JOptionPane.WARNING_MESSAGE );
                continue;
            }
            v2=r.nextInt(7);
            System.out.println("CPU Bowl:"+v2);
            if(v1==v2){
                System.out.println("\nOops!OUT\n");
                break;
            }
            else{
                t1+=v1;
                System.out.println("Runs Scored:"+t1);
            }    
        }while(t1<=t2);
        
    }
    
    public static void bowl(){
        
         Scanner in=new Scanner(System.in);
         Random r=new Random();
         
        do{
            
            System.out.print("Your Bowl:");
            v1=in.nextInt();
            if(v1>6){
                JOptionPane.showMessageDialog(null,"Input value exceeded 6! Try again","Error",JOptionPane.WARNING_MESSAGE );
                continue;
            }
            v2=r.nextInt(7);
            System.out.println("CPU Bat:"+v2);
            if(v1==v2){
                System.out.println("\nIt's WICKET!!\n");
                break;
            }
            else{
                t2+=v2;
                System.out.println("Runs Scored:"+t2);
            }    
        }while(t2<=t1);
        
    }    
}
