

import java.awt.Color;

public class Guitar 
{
    public static void main(String[] args)
    {
     
        
    }

  private int numStrings;
  private double guitarLength;
  private String guitarManufacturer;
  private Color guitarColor;
  private String color;

  //no argument constructor
    public Guitar()
  {
    numStrings = 6;
    guitarLength = 28.2;
    guitarManufacturer = "Gibson";
    guitarColor = Color.RED;
    color = "Red";
  }

    //constructor
     public Guitar(int n, double l, String m, String c)
  {
    numStrings = n;
    guitarLength = l;
    guitarManufacturer = m;
    guitarColor = Color.getColor(c);    
    color = c;
  }
    
     public int getNumStrings()
  {
    return numStrings;
  }
  
    public double getGuitarLength()
  {
    return guitarLength;
  }
  public String getGuitarManufacturer()
  {
    return guitarManufacturer;
  }
  
  public String getGuitarColor()
  {
    return color;
  }
public String playGuitar()
  {
    String play = "";
    play += "[";
    
    String[] notes = new String[]{"A", "B", "C", "D", "E", "F"};
    String[] duration = new String[]{"0.25", "0.5", "1", "2", "4"};
    
    
    for (int i=0; i<16; i++)
    {
      int n_index = (int) (Math.random()*6);
      int d_index = (int) (Math.random()*5);
      
      play += notes[n_index] + "(" + duration[d_index] + ")";
      
      if (i!=15)
        play += ", ";
    }
    
    play += "]";
    
    return play;
  }
    public String toString()
  {
    String str = "";
    str += "(numStrings=" + numStrings + ",";
    str += " Length=" + guitarLength + ",";
    str += " manufacturer=" + guitarManufacturer + ",";
    str += " color=" + color;
    return str;
  }
  }

