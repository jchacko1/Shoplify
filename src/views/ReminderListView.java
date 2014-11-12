
package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;


public class ReminderListView extends JFrame {
    
    private JLabel reminderListLabel, item1, item2, item3, item4, item5, item6,
    item7, item8, item9, item10, item11, item12, item13, item14, item15, item16,
            item17, item18;
    private JPanel topPanel, midPanel, bottomPanel;
    private JButton closeButton;
    private JScrollPane scrollpane;



    public ReminderListView() {
        
        ActionListener closeListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
   
        };
   
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        topPanel = new JPanel();
        reminderListLabel = new JLabel("Reminder List");
        topPanel.add(reminderListLabel);
        content.add(topPanel);
        
        midPanel = new JPanel();
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        scrollpane = new JScrollPane(midPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setPreferredSize(new Dimension(300, 250));
        
        item1 = new JLabel("item 1");
        midPanel.add(item1);
        item2 = new JLabel("item 2");
        midPanel.add(item2);
        item3 = new JLabel("item 3");
        midPanel.add(item3);
        item4 = new JLabel("item 4");
        midPanel.add(item4);
        item5 = new JLabel("item 5");
        midPanel.add(item5);
        item6 = new JLabel("item 6");
        midPanel.add(item6);
        item7 = new JLabel("item 7");
        midPanel.add(item7);
        item8 = new JLabel("item 8");
        midPanel.add(item8);
        item9 = new JLabel("item 9");
        midPanel.add(item9);
        item10 = new JLabel("item 10");
        midPanel.add(item10);
        item11 = new JLabel("item 11");
        midPanel.add(item11);
        item12 = new JLabel("item 12");
        midPanel.add(item12);
        item13 = new JLabel("item 13");
        midPanel.add(item13);
        item14 = new JLabel("item 14");
        midPanel.add(item14);
        item15 = new JLabel("item 15");
        midPanel.add(item15);
        item16 = new JLabel("item 16");
        midPanel.add(item16);
        item17 = new JLabel("item 17");
        midPanel.add(item17);
        item18 = new JLabel("item 18");
        midPanel.add(item18);

        
        
        content.add(scrollpane);
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        closeButton = new JButton("Close");
        closeButton.addActionListener(closeListener);
        bottomPanel.add(closeButton);
        content.add(bottomPanel);
        



    }

    public static void main(String[] args) {

        ReminderListView frame = new ReminderListView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Reminder List");
        frame.setSize(300,350);
    }

}
