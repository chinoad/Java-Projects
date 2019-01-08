public class TestHeadPhone {
    
    public static void main(String[] args)
    {
    
HeadPhone hp1= new HeadPhone ();
hp1.setManufacturer("Sony");
hp1.setHeadphoneColor("Black");
hp1.setHeadphoneModel("Wireless");
hp1.setPluggedIn(true);
hp1.changeVolume(3);
       
System.out.println(hp1);

HeadPhone hp2= new HeadPhone ();
hp2.setManufacturer("Panasonic");
hp2.setHeadphoneColor("Pink");
hp2.setHeadphoneModel("Wireless");
hp2.setPluggedIn(false);
hp2.changeVolume(1);
       
System.out.println(hp2);

HeadPhone hp3= new HeadPhone ();
hp3.setManufacturer("AKG");
hp3.setHeadphoneColor("White");
hp3.setHeadphoneModel("Wired");
hp3.setPluggedIn(true);
hp3.changeVolume(2);
       
System.out.println(hp3);
        
    }

}
