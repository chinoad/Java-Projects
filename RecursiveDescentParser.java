
package cmsc330p1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import java.util.StringTokenizer;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 *
 * @author chihiro
 */
public class RecursiveDescentParser {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws FileNotFoundException, Exception {

        File file = new File("file3.txt");
        Scanner sc = new Scanner(file);
        parse(sc);
    }
    
    public static void parse(Scanner scan) throws Exception{
        if(scan.hasNext()){
            createWindow(scan);
        }
        else{
            throw new Exception("Error, Syntax is invalid");
        }
    }

    private static void createWindow(Scanner scanLine) throws Exception {
        if (scanLine.hasNext()){
            String token = scanLine.next();
            if(token.equals("Window")){
                if (scanLine.hasNext()){
                    token = scanLine.next();
                    JFrame mainFrame = new JFrame(getString(token));
                    if(!checkParenthesis(scanLine.next(),mainFrame)){
                        throw new Exception("Error, wrong Syntax!");
                    }
                    createFrameLayout(scanLine,mainFrame);
                        while(scanLine.hasNext()){
                            token = scanLine.next();
                            if(token.equals("END.")){
                                break;
                            }
                            else{
                                if(token.equals("Textfield")){
                                    mainFrame.add(createTextField(scanLine));
                                }
                                else if(token.equals("Panel")){
                                    mainFrame.add(createPanel(scanLine));
                                }
                                else if(token.equals("Button")){
                                    mainFrame.add(createButton(scanLine));
                                }
                                else if(token.equals("Label")){
                                    mainFrame.add(createLabel(scanLine));
                                }
                                else if(token.equals("Group")){
                                    createGroup(scanLine,mainFrame);
                                }
                            }
                        }
                    mainFrame.setVisible(true);
                }
            }
        }
    }
    
    private static JPanel createPanel(Scanner scanLine) throws Exception {
        if (scanLine.hasNext()){
            String token;
            JPanel myPanel = new JPanel();
            createPanelLayout(scanLine,myPanel);
                while(scanLine.hasNext()){
                    token = scanLine.next();
                    if(token.equals("END;")){
                        break;
                    }
                    else{
                        if(token.equals("Textfield")){
                            myPanel.add(createTextField(scanLine));
                        }
                        else if(token.equals("Panel")){
                            myPanel.add(createPanel(scanLine));
                        }
                        else if(token.equals("Button")){
                            myPanel.add(createButton(scanLine));
                        }
                        else if(token.equals("Label")){
                             myPanel.add(createLabel(scanLine));
                        }
                        else if(token.equals("Group")){
                            createGroup(scanLine,myPanel);
                        }
                }
            }
                return myPanel;
        }
        throw new Exception("Error, wrong syntax!");
    }
    
    public static boolean checkParenthesis(String x,JFrame mainFrame){
        StringTokenizer tok = new StringTokenizer(x, "[\\(\\)\\,]", true);
        if(tok.hasMoreTokens()){
            String token;
            if((token = tok.nextToken()).equals("(")){
                if(tok.hasMoreTokens()){
                    token = tok.nextToken();
                    int height = getNumber(token);
                    if(tok.hasMoreTokens()){
                        token = tok.nextToken();
                        if(token.equals(",")){
                             if(tok.hasMoreTokens()){
                                  token = tok.nextToken();
                                  int width = getNumber(token);
                                  if(tok.hasMoreTokens()){
                                       token = tok.nextToken();
                                        if(token.equals(")")){
                                            mainFrame.setSize(height,width);
                                            return true;
                                        }
                                  }
                             }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static void createFrameLayout(Scanner scanLine, JFrame mainFrame) throws Exception{
        if(scanLine.hasNext()){
            String token;
            if((token = scanLine.next()).equals("Layout")){
                if(scanLine.hasNext()){
                    token = scanLine.next();
                    StringTokenizer tok = new StringTokenizer(token, ":", true);
                    if((token = tok.nextToken()).equals("Flow")){
                        mainFrame.setLayout(new FlowLayout());
                        if(tok.hasMoreTokens()){
                            token = tok.nextToken();
                            if(!(":").equals(token)){
                                throw new Exception("Error, wrong Syntax!");
                            }
                        }
                    }else{
                        mainFrame.setLayout(createGridLayout(token));
                    }
                }
            }else throw new Exception("Error, wrong Syntax!");
        }else throw new Exception("Error, wrong Syntax!");
    }
    
    public static void createPanelLayout(Scanner scanLine, JPanel myPanel) throws Exception{
        if(scanLine.hasNext()){
            String token;
            if((token = scanLine.next()).equals("Layout")){
                if(scanLine.hasNext()){
                    token = scanLine.next();
                    StringTokenizer tok = new StringTokenizer(token, ":", true);
                    if((token = tok.nextToken()).equals("Flow")){
                        myPanel.setLayout(new FlowLayout());
                        if(tok.hasMoreTokens()){
                            token = tok.nextToken();
                            if(!(":").equals(token)){
                                throw new Exception("Error, wrong Syntax!");
                            }
                        }
                    }else{
                        myPanel.setLayout(createGridLayout(token));
                    }
                }
            }else throw new Exception("Error, wrong Syntax!");
        }else throw new Exception("Error, wrong Syntax!");
    }
    
    public static GridLayout createGridLayout(String token) throws Exception{
        StringTokenizer tok = new StringTokenizer(token, "[\\(\\)\\,]", true);
        if(tok.hasMoreTokens()){
            if((token = tok.nextToken()) .equals("Grid")){
                if(tok.hasMoreTokens()){
                    if((token = tok.nextToken()) .equals("(")){
                        if(tok.hasMoreTokens()){
                            token = tok.nextToken();
                            int n1 = getNumber(token);
                            if(tok.hasMoreTokens()){
                                token = tok.nextToken();
                                if(token.equals(",")){
                                    if(tok.hasMoreTokens()){
                                        token = tok.nextToken();
                                        int n2 = getNumber(token);
                                        if(tok.hasMoreTokens()){
                                           token = tok.nextToken();
                                           if(token.equals(",")){
                                               if(tok.hasMoreTokens()){
                                                    token = tok.nextToken();
                                                    int n3 = getNumber(token);
                                                    if(tok.hasMoreTokens()){
                                                        token = tok.nextToken();
                                                        if(token.equals(",")){
                                                            if(tok.hasMoreTokens()){
                                                                token = tok.nextToken();
                                                                int n4 = getNumber(token);
                                                                if(tok.hasMoreTokens()){
                                                                    token = tok.nextToken();
                                                                    if(token.equals(")")){
                                                                        return new GridLayout(n1,n2,n3,n4);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                               }
                                           } 
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new Exception("Error, wrong syntax!");
    }
    
    private static JTextField createTextField(Scanner scanLine) throws Exception{
        if (scanLine.hasNext()){
            String token = scanLine.next();
            StringTokenizer tok = new StringTokenizer(token, ";", true);
                token = tok.nextToken();
                int size = getNumber(token);
                JTextField myTxtField = new JTextField(size);
                if(tok.hasMoreTokens()){
                    token = tok.nextToken();
                    if(!(";").equals(token)){
                        throw new Exception("Error, wrong Syntax!");
                    }
                    else{
                        return myTxtField;
                    }
                }
            }
        throw new Exception("Error, wrong Syntax!");
    }
    
    private static JButton createButton(Scanner scanLine) throws Exception{
        if (scanLine.hasNext()){
            String token = scanLine.next();
            StringTokenizer tok = new StringTokenizer(token, ";", true);
                token = tok.nextToken();
                String name = getString(token);
                JButton myButton = new JButton(name);
                if(tok.hasMoreTokens()){
                    token = tok.nextToken();
                    if(!(";").equals(token)){
                        throw new Exception("Error, wrong Syntax!");
                    }
                    else{
                        return myButton;
                    }
                }
            }
        throw new Exception("Error, wrong Syntax!");
    }
    
    private static JLabel createLabel(Scanner scanLine) throws Exception{
        if (scanLine.hasNext()){
            String token = scanLine.next();
            StringTokenizer tok = new StringTokenizer(token, ";", true);
                token = tok.nextToken();
                String name = getString(token);
                JLabel myLabel = new JLabel(name);
                if(tok.hasMoreTokens()){
                    token = tok.nextToken();
                    if(!(";").equals(token)){
                        throw new Exception("Error, wrong Syntax!");
                    }
                    else{
                        return myLabel;
                    }
                }
            }
        throw new Exception("Error, wrong Syntax!");
    }
    
     private static void createGroup(Scanner scanLine,JFrame mainFrame) throws Exception{
           ButtonGroup myGroup = new ButtonGroup();
           boolean syntaxOK = false;
           String token;
            while(scanLine.hasNext()){
                 token = scanLine.next();
                 if(token.equals("End;")){
                     syntaxOK = true;
                     break;
                 }
                 else{
                     if(token.equals("Radio")){
                         JRadioButton myButton = createRadioButton(scanLine);
                         myGroup.add(myButton);
                         mainFrame.add(myButton);
                     }
                     else {
                         throw new Exception("Error, wrong syntax!");
                     }
                 }
             }
           if(!syntaxOK){
               throw new Exception("Error, wrong syntax!");
           }
    }
     
      private static void createGroup(Scanner scanLine,JPanel myPanel) throws Exception{
           ButtonGroup myGroup = new ButtonGroup();
           boolean syntaxOK = false;
           String token;
            while(scanLine.hasNext()){
                 token = scanLine.next();
                 if(token.equals("End;")){
                     syntaxOK = true;
                     break;
                 }
                 else{
                     if(token.equals("Radio")){
                         JRadioButton myButton = createRadioButton(scanLine);
                         myGroup.add(myButton);
                         myPanel.add(myButton);
                     }
                     else {
                         throw new Exception("Error, wrong syntax!");
                     }
                 }
             }
           if(!syntaxOK){
               throw new Exception("Error, wrong syntax!");
           }
    }
    
    private static JRadioButton createRadioButton(Scanner scanLine) throws Exception{
         if (scanLine.hasNext()){
            String token = scanLine.next();
            StringTokenizer tok = new StringTokenizer(token, ";", true);
                token = tok.nextToken();
                String name = getString(token);
                JRadioButton myButton = new JRadioButton(name);
                if(tok.hasMoreTokens()){
                    token = tok.nextToken();
                    if(!(";").equals(token)){
                        throw new Exception("Error, wrong Syntax!");
                    }
                    else{
                        return myButton;
                    }
                }
            }
        throw new Exception("Error, wrong Syntax!");
    }
      
    private static String getString(String token) throws Exception{

        if(token.equals("\"\"")){
            return "";
        }
        StringTokenizer tok = new StringTokenizer(token, "\"", true);
        if(tok.hasMoreTokens()){
            token = tok.nextToken();
            if(token.equals("\"")){
                if(tok.hasMoreTokens()){
                    token = tok.nextToken();
                    String response = token;
                    if(tok.hasMoreTokens()){
                        token = tok.nextToken();
                        if(token.equals("\"")){
                            return response;
                        }
                    }
                }
            }
        }
       throw new Exception("Error, wrong syntax!");
    }
    
    private static int getNumber(String token){
        return Integer.parseInt(token);
    }
     
}