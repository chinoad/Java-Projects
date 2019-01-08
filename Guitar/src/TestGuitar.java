

public class TestGuitar 
{
    public static void main(String [] args)
    {
    Guitar guitar1 = new Guitar(7,30.2,"Fender","Black");
    System.out.println("toString():\n" + guitar1.toString());
    System.out.println("getNumStrings(): " + guitar1.getNumStrings());
    System.out.println("getGuitarLength(): " + guitar1.getGuitarLength());
    System.out.println("getGuitarManufacturer(): " + guitar1.getGuitarManufacturer());
    System.out.println("getGuitarColor(): " + guitar1.getGuitarColor());
    System.out.println("playGuitar(): " + guitar1.playGuitar());

        System.out.println();
    
    Guitar guitar2 = new Guitar();
    System.out.println("toString():\n" + guitar2.toString());
    System.out.println("getNumStrings(): " + guitar2.getNumStrings());
    System.out.println("getGuitarLength(): " + guitar2.getGuitarLength());
    System.out.println("getGuitarManufacturer(): " + guitar2.getGuitarManufacturer());
    System.out.println("getGuitarColor(): " + guitar2.getGuitarColor());
    System.out.println("playGuitar(): " + guitar2.playGuitar());

        System.out.println();
    
    Guitar guitar3 = new Guitar(9,42.9,"Guit","Yellow");
    System.out.println("toString():\n" + guitar3.toString());
    System.out.println("getNumStrings(): " + guitar3.getNumStrings());
    System.out.println("getGuitarLength(): " + guitar3.getGuitarLength());
    System.out.println("getGuitarManufacturer(): " + guitar3.getGuitarManufacturer());
    System.out.println("getGuitarColor(): " + guitar3.getGuitarColor());
    System.out.println("playGuitar(): " + guitar3.playGuitar());


    }
        
      
    

  