
import java.awt.Color;
public class HeadPhone {

        {
            
        }
//defining constant
private final static int LOW =1;
private final static int MEDIUM = 2;
private final static int HIGH =3;

//variable and data type
private int volume;
private boolean pluggedIn;
private String manufacturer;
private Color headphoneColor;
private String color;
private String headphoneModel;

//default values
public HeadPhone()
{
    volume=MEDIUM;
    pluggedIn= false;
    manufacturer="Sony";
    headphoneColor=Color.BLACK;
    color = "Black";
    headphoneModel = "Wireless";
}
//constructor
public HeadPhone(int v, boolean f, String m, String c, String h)
{
    volume=MEDIUM;
    pluggedIn=false;
    manufacturer=m;
    headphoneColor=Color.getColor(c);
    color =c;  
    headphoneModel =h;
}
//getter method
public int getVolume()
{
    return volume;
}
public boolean getPluggedIn()
{
    return pluggedIn;
}
public String getManufacturer()
{
    return manufacturer;
}
public String getHeadphoneColor()
{
    return color;
}
public String getHeadphoneModel()
{
    return headphoneModel;
}
public String toString()
{
    String str = "";
    str += "Volume = ";
    
    if ( volume == LOW )
      str+= "LOW, ";
    else if ( volume == MEDIUM )
      str+= "MEDIUM, ";
    else if  ( volume == HIGH )
      str+= "HIGH, ";
    
    if (pluggedIn)
      str += "Plugged in. ";
    else
      str += "Not plugged in. ";
    str += "Manufacturer = " + manufacturer + ", ";
    str += "Headphone Color = " + color + ", ";
    str += "Headphone Model =" + headphoneModel;
    return str;
}

//setter methods
public void changeVolume(int vol)
{
  volume = vol;
}
public void setManufacturer(String m)
{
  manufacturer = m;
}
public void setHeadphoneModel(String h)
{
  headphoneModel = h;
}
public void setHeadphoneColor(String c)
{
  color = c;
}

public void setPluggedIn(boolean b) {
    }

}