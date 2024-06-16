/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Yahya
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;


public class ApplicationFrame 
{
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    
    
    
    public ApplicationFrame()
    {
    frame = new JFrame("FYPPrototype");
    
    frame.setSize(400,400);
    frame.setLocationRelativeTo(null); //easiest way to center frame on the main screen 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    firstPage();
    frame.setVisible(true);
    }  
   
    
    
    
    
    public void firstPage()
    {
       panel1 = new JPanel();
       JLabel label1 = new JLabel("If you are having issues with attending please tell us");
       JLabel space = new JLabel("                                                      ");
       JLabel label3 = new JLabel("-this may be due to illness, appoinment, or personal issue");
       JLabel label4 = new JLabel("-if you do have an unmanageable personal issue such as ");
       JLabel label5 = new JLabel("anxiety, depression, insomnia, domestic issue, or financial ");
       JLabel label6 = new JLabel("issue please feel comfortable communicating with us");
       panel1.add(label1);
       panel1.add(space);
       panel1.add(label3);
       panel1.add(label4);
       panel1.add(label5);
       panel1.add(label6);
       
       JPanel btnPanel = new JPanel ();
       panel1.add(btnPanel);        
        JButton noAttendancebutton= new JButton("I won't be attending");
        btnPanel.add(noAttendancebutton);
        
        frame.setResizable(false);
        frame.add(panel1);
        
         noAttendancebutton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          
          secondPage();
          frame.setVisible(true);
          frame.remove(panel1);
          frame.add(panel2);
          
      }
    });
  
    }
    
    
    
    public void secondPage()
    {
    panel2 = new JPanel();
       
    String lecturers[] = { "Bob Smith", "Ronaldo Messi", "Lucca Fred", "Abdul Adam", "Saul Goodman" };
    String reasons[] = { "Illness", "Child’s Illness", "Appointment", "Accident", "Death of a Loved One", "Car problem","Emergency","Mental health","Miscellaneous Absences"};
    
    JLabel label = new JLabel("Choice of lecturer:");
        JComboBox choiceOfLecturer = new JComboBox(lecturers);
        
        JLabel space = new JLabel("              ");
        JLabel label3 = new JLabel("Reason for absence:");
        JComboBox reason = new JComboBox(reasons);
        
        panel2.add(label);
       panel2.add(choiceOfLecturer);
       panel2.add(space);
       panel2.add(label3);
       panel2.add(reason);
       
       JTextArea comments = new JTextArea("Additional comments");
       comments.setLineWrap(true);
       comments.setWrapStyleWord(true);
       comments.setPreferredSize(new Dimension(300, 200)); 
       panel2.add(comments); 
       
       JPanel btnPanel = new JPanel ();
       panel2.add(btnPanel);
        JButton submitbutton= new JButton("Submit");
        JButton backButton = new JButton ("Back");
        btnPanel.add(submitbutton);
        btnPanel.add(backButton);
        
        frame.add(panel2);
        
        comments.addFocusListener(new FocusListener() {
        
        @Override
        public void focusGained(FocusEvent e) {
            if (comments.getText().equals("Additional comments"))
            {
            comments.setText("");
            }
        }

        
        @Override
        public void focusLost(FocusEvent e) {
            if (comments.getText().isEmpty())
            {
            comments.setText("Additional comments");
            }
        }
    }); 
                
        
         submitbutton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          thirdPage();
          frame.setVisible(true);
          frame.remove(panel2);
          frame.add(panel3);

        
      }
    });

      backButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
         firstPage();
          frame.setVisible(true);
          frame.remove(panel2);
          frame.add(panel1);
      }
    });    
    }
   
    public void thirdPage()
    {
    panel3 = new JPanel();
       JLabel label = new JLabel("Helpful resources:");
       JLabel space = new JLabel("                                                              ");
       JLabel hyperlink = new JLabel("-Kingston Student support                                              "); 
       hyperlink.setForeground(Color.BLUE.darker());
       hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       JLabel hyperlink2 = new JLabel("   -Domestic abuse - how to get help                                   "); 
       hyperlink2.setForeground(Color.BLUE.darker());
       hyperlink2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       JLabel hyperlink3 = new JLabel("-Youth mental health                                                         ");
       hyperlink3.setForeground(Color.BLUE.darker());
       hyperlink3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       panel3.add(label);
       panel3.add(space);
       panel3.add(hyperlink);
       panel3.add(hyperlink2);
       panel3.add(hyperlink3);
       
        frame.add(panel3);
       
        hyperlink.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e){
            try {
            Desktop.getDesktop().browse(new URI("https://www.kingston.ac.uk/undergraduate/student-support/"));
            } catch(IOException | URISyntaxException e1)
            {
            e1.printStackTrace();
            };
            }
            
        });
        
        hyperlink2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e){
            try {
            Desktop.getDesktop().browse(new URI("https://www.gov.uk/guidance/domestic-abuse-how-to-get-help#:~:text=of%20domestic%20abuse.-,Support%20someone%20you%20know,day%20on%200808%202000%20247."));
            } catch(IOException | URISyntaxException e1)
            {
            e1.printStackTrace();
            };
            }
            
        });
        
        hyperlink3.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e){
            try {
            Desktop.getDesktop().browse(new URI("https://www.nhs.uk/mental-health/children-and-young-adults/"));
            } catch(IOException | URISyntaxException e1)
            {
            e1.printStackTrace();
            };
            }
            
        });
        

    }
    
 
    
    
    
    
}
