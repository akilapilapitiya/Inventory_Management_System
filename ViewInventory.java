//Imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInventory extends JFrame {

    public ViewInventory(){
        //Frame Definitions
        setTitle("IM Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        //Frame Icon Definition
        ImageIcon iconImage = new ImageIcon("assets/icon.png"); 
        Image image = iconImage.getImage();
        setIconImage(image);

        //Frame Background Image
        ImageIcon backgroundImageSet = new ImageIcon("assets/inventoryImage.png");
        Image imageSet = backgroundImageSet.getImage();
        Image resizedImage = imageSet.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);
        JLabel backgroundImageSetter = new JLabel(backgroundImage);
        backgroundImageSetter.setBounds(650, 450, 100, 100);

        //JPanel for titleRibbon
        JPanel titleRibbon = new JPanel();
        titleRibbon.setBackground(new Color(150, 130, 180));
        titleRibbon.setBounds(0, 0, 800, 60);

        //JLabel for Title
        JLabel bodyTitle = new JLabel("VIEW INVENTORY");
        bodyTitle.setBounds(10, 1, 1000, 80);
        bodyTitle.setForeground(Color.WHITE);
        bodyTitle.setFont(new Font("Arial", Font.BOLD, 30));

        //Table Column Headings Defined
        String []columnNames = {"Item ID", "Item Name", "Number of Units", "Type"};

        //Define the table model
        DefaultTableModel model = new DefaultTableModel(FileArray.StoreArray, columnNames);
        JTable viewTable = new JTable(model);

        //Table Appearance Customizations
        viewTable.setFont(new Font("Arial",Font.PLAIN, 14));
        viewTable.setRowHeight(30);
        viewTable.setBackground(Color.WHITE);
        viewTable.setForeground(Color.BLACK);
        viewTable.setGridColor(Color.DARK_GRAY);
        viewTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        viewTable.getTableHeader().setBackground(new Color(209, 179, 255));
        viewTable.getTableHeader().setForeground(Color.BLACK);

        //Column Width Customizations
        viewTable.getColumnModel().getColumn(0).setPreferredWidth(150); 
        viewTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        viewTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        viewTable.getColumnModel().getColumn(3).setPreferredWidth(150);

        //ScrollPane Customizations 
        JScrollPane scrollPane = new JScrollPane(viewTable);
        scrollPane.setBounds(50, 90, 690, 300);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));

        //Back Button Defined
        JButton backButton = new JButton("Return to Main Menu");
        backButton.setBackground(new Color(150, 130, 180));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBounds(10,500 , 200, 40);


        //Events Defined for backButton
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new HomeScreen().setVisible(true);              
            }
        });

        //Add elements to the frame
        add(bodyTitle);
        add(titleRibbon);
        add(scrollPane);
        add(backButton);
        add(backgroundImageSetter);
    }

    public static void main (String []args){
        new ViewInventory().setVisible(true);
    }   
}