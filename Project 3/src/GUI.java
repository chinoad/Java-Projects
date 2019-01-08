
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

public class GUI {

    public static void main(String[] args) {
        JFrame myFrame = new Window();
        myFrame.setTitle("Project 3");
        myFrame.setSize(500, 400);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

    static class Window extends JFrame {

        //Radiobuttons
        JRadioButton jrbIterative = new JRadioButton("Iterative  ");
        JRadioButton jrbRecursive = new JRadioButton("Recursive");

        //Label
        JLabel jlb = new JLabel("Enter n");
        JLabel jlbResult = new JLabel("Result");
        JLabel jlbEfficiency = new JLabel("Efficiency");

        //Textbox
        JTextField jtxtText = new JTextField(12);
        JTextField jtxResult = new JTextField(12);
        JTextField jtxEfficiency = new JTextField(12);

        //Buttons
        JButton jbtCalculate = new JButton("Calculate");

        //Button Group
        ButtonGroup group = new ButtonGroup();


        public Window() {
            this.addWindowListener(new closeHandler());
            //Add Radiobuttons to the group
            group.add(jrbIterative);
            group.add(jrbRecursive);
            jrbIterative.setSelected(true);

            //Register event handlers to buttons

            //Create the panels
            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JPanel p3 = new JPanel(new GridLayout(1,3,1,1));
            JPanel p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JPanel p5 = new JPanel(new GridLayout(2,2,2,2));

            //Add the elements to the p1
            p1.add(jrbIterative);

            //Add the elements to the p2
            p2.add(jrbRecursive);

            //Add the elements to the p3
            p3.add(jlb);
            p3.add(jtxtText);

            //Add the elements to the p4
            p4.add(jbtCalculate);
            jbtCalculate.addActionListener(new computeHandler());

            //Add the elements to the p5
            p5.add(jlbResult);
            p5.add(jtxResult);
            p5.add(jlbEfficiency);
            p5.add(jtxEfficiency);

            //Create a main panel
            JPanel mainPanel = new JPanel(new GridLayout(5,1,2,2));

            //Add panel to the frame
            setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

            //Add panels to the main panel
            mainPanel.add(p1);
            mainPanel.add(p2);
            mainPanel.add(p3);
            mainPanel.add(p4);
            mainPanel.add(p5);

            //Add the main panel
            add(mainPanel);

        }

        class computeHandler implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer number = Integer.parseInt(jtxtText.getText());
                    Integer result = 0, efficiency = 0;
                    if(jrbIterative.isSelected()){
                        result = Sequence.computeIterative(number);
                        efficiency = Sequence.getEfficiency();
                    }
                    else{
                        result = Sequence.computeRecursive(number);
                        efficiency = Sequence.getEfficiency();
                    }
                    jtxResult.setText(result.toString());
                    jtxEfficiency.setText(efficiency.toString());
                }
                catch(Exception ex){
                    jtxtText.setText("");
                }
            }
        }

        class closeHandler extends WindowAdapter {
            public void windowClosing(WindowEvent e)
            {
                PrintWriter writer;
                try {
                    writer = new PrintWriter("Project3.csv", "UTF-8");
                    writer.println("n,iterativeEfficiency,recursiveEfficiency");
                    for(int i=0; i<11;++i){
                        String line = String.valueOf(i);
                        Sequence.computeIterative(i);
                        line+= "," + Sequence.getEfficiency();
                        Sequence.computeRecursive(i);
                        line+= "," + Sequence.getEfficiency();
                        writer.println(line);
                    }
                    writer.close();
                } catch (Exception ex) {
                }
            }
        }


    }

}