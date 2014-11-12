package views;

//import controllers.ItemController;
//import controllers.OrderController;
//import global.Global;
//import models.ItemModel;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class HistoryView2 extends JFrame{

    private JPanel HistoryListPane;
    private JLabel HistoryInfoLabel;
    private JTextField searchField;
    private GridBagConstraints c;
    private JTextArea accountNameList;
    private JTextArea passwordList;
    private JTextArea subscriptionList;
    private JTextArea detailsList;
    private JTextArea bakeryList;
    JTextArea[] labels;

    //private LoginView loginView;
public HistoryView2() {

        Container content = getContentPane();


        this.c = new GridBagConstraints();
        this.HistoryInfoLabel = new JLabel("History Info");
        this.HistoryListPane = new JPanel();
        this.accountNameList = new JTextArea("History Item 1");
        this.passwordList = new JTextArea("History Item 2");
        this.subscriptionList = new JTextArea("History Item 3");
        this.detailsList = new JTextArea("History Item 4");
        this.labels = new JTextArea[3];


////        1st column for account info list
//        c.fill = GridBagConstraints.LINE_START;
//        c.weightx = 1;
//        c.weighty = 0;
//        c.gridx = 0;
//        c.gridy =1;
        HistoryListPane.setLayout(new BoxLayout(HistoryListPane, BoxLayout.Y_AXIS));
//        HistoryListPane.setLayout(new BoxLayout(HistoryListPane, BoxLayout.PAGE_AXIS));
        //int[] orderIds = OrderController.getOrderIds(0);


        //System.out.print("number of orders" + orderIds.length);


//        for (int i =0; i < labels.length; i++ ){
//            GridLayout experimentLayout = new GridLayout(1,1);
//            labels[i].setLayout(experimentLayout);
//            HistoryListPane.add(labels[i]);
//
//        }

        //ItemModel[] items;
        //int[] orderIds = OrderController.getOrderIds(Global.currentAccount.getUserId()); //todo this is the real version of the method that we'll need to call
       // for(int i : orderIds)
        {

          //  items = ItemController.getItems(i);
           // labels =  new JTextArea[items.length];
            int itemIndex = 0;
           // for(ItemModel item : items)
            {
                labels[itemIndex]= new JTextArea();
               // labels[itemIndex].setText(item.getDescription());
                HistoryListPane.add(labels[itemIndex]);
               // System.out.print(item.getDescription());
               // if(itemIndex < items.length)
                {
                    itemIndex++;
                }
            }
        };

        content.add(HistoryListPane);

//
//


        setVisible(true);
    }


    public static void main(String[] args){
        HistoryView2 history = new HistoryView2();
        history.setTitle("History View");
        history.setLayout(new GridBagLayout());
        history.setSize(500, 500);
        history.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // int[] orderIds = OrderController.getOrderIds(0);
        //ItemModel[] items;
        //int[] orderIds = OrderController.getOrderIds(Global.currentAccount.getUserId()); //todo this is the real version of the method that we'll need to call
//
//
//            for(int i : orderIds)
//        {
//            items = ItemController.getItems(i);
//            System.out.print(i);
//            for(ItemModel item : items)
//            {
//                System.out.print(item.getDescription());
//            }
//        };
       }
}