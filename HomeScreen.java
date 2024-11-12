//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeScreen extends JFrame{
    public HomeScreen(){
        //Arrays to laminate moving Variables {"i_count", "sumOfUnits", "sumOfFurniture", "sumOfElectronic"}
        int HomeArray[]={0, 0, 0, 0};

        //JFrame Definitions
        setTitle("IM Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        //JFrame Logo
        ImageIcon iconImage = new ImageIcon("icon.png");
        Image image = iconImage.getImage();
        setIconImage(image);

        //JFrame Background Image A
        ImageIcon backgroundImageSetA = new ImageIcon("assets/backgroundImageStat.png");
        Image imageSetA = backgroundImageSetA.getImage();
        Image resizedImageA = imageSetA.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon backgroundImageA = new ImageIcon(resizedImageA);
        JLabel backgroundImageSetterA = new JLabel(backgroundImageA);
        backgroundImageSetterA.setBounds(100, 100, 200, 200);

        //JFrame Background Image B
        ImageIcon backgroundImageSetB = new ImageIcon("assets/backgroundImage.png");
        Image imageSetB = backgroundImageSetB.getImage();
        Image resizedImageB = imageSetB.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon backgroundImageB = new ImageIcon(resizedImageB);
        JLabel backgroundImageSetterB = new JLabel(backgroundImageB);
        backgroundImageSetterB.setBounds(480, 100, 200, 200);

        //JPanel for title Ribbon
        JPanel titleRibbon = new JPanel();
        titleRibbon.setBackground(new Color(150, 130, 180));
        titleRibbon.setBounds(0, 0, 800, 60);

        //JPanel for Left Side Panel
        JPanel currentBox = new JPanel();
        currentBox.setBounds(0, 60, 405, 600);

        JPanel briefBox = new JPanel();
        briefBox.setBackground(new Color(150, 130, 180));
        briefBox.setBounds(10, 319, 380, 194);


        //JLabel to display the time
        JLabel timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(40, 18, 400, 20);

        //JLabel to display the date
        JLabel dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setBounds(520, 18, 400, 20);

        //JLabel to display Item Brrief Title
        JLabel itemBrief = new JLabel("INVENTORY SUMMARY");
        itemBrief.setFont(new Font("Arial", Font.BOLD, 24));
        itemBrief.setForeground(Color.WHITE);
        itemBrief.setBounds(41, 325, 400, 25);

        //JLabel to Display Inventory Type Count
        JLabel typeCount = new JLabel("Item Types Available: " + FileArray.StoreArray.length );
        typeCount.setFont(new Font("Arial", Font.BOLD, 20));
        typeCount.setForeground(Color.WHITE);
        typeCount.setBounds(41, 365, 400, 20);

        //JLabel to Display Units Count
        for(int i=0; (i < FileArray.StoreArray.length); i++){
            HomeArray[0] = i;
            //Conditions for Furniture Count and Electronics Count
            HomeArray[1] += Integer.valueOf(FileArray.StoreArray[i][2]);
            if(FileArray.StoreArray[i][3] == "Furniture Item"){
                HomeArray[2] += Integer.valueOf(FileArray.StoreArray[i][2]);

            }else if(FileArray.StoreArray[i][3] == "Electronic Item"){
                HomeArray[3] += Integer.valueOf(FileArray.StoreArray[i][2]);
            }
        }
        //Jlabel For unit Count
        JLabel unitCount = new JLabel("Total Units Available: " + HomeArray[1]);
        unitCount.setFont(new Font("Arial", Font.BOLD, 20));
        unitCount.setForeground(Color.WHITE);
        unitCount.setBounds(41, 405, 400, 25);

        //JLabel For Furniture count
        JLabel furnitureCount = new JLabel("Furnitures: " + HomeArray[2]);
        furnitureCount.setFont(new Font("Arial", Font.BOLD, 20));
        furnitureCount.setForeground(Color.WHITE);
        furnitureCount.setBounds(41, 445, 400, 25);

        //JLabel For electronic Count
        JLabel electronicCount = new JLabel("Electronics: " + HomeArray[3]);
        electronicCount.setFont(new Font("Arial", Font.BOLD, 20));
        electronicCount.setForeground(Color.WHITE);
        electronicCount.setBounds(41, 485, 400, 25);



        //JButton for viewInventory Link
        JButton viewInventory = new JButton("View Available Inventory");
        viewInventory.setBounds(420,320 , 350, 40);
        viewInventory.setBackground(new Color(150, 130, 180));
        viewInventory.setForeground(Color.white);
        viewInventory.setFont(new Font("Arial", Font.BOLD, 20));

        //JButton for addInventory Link
        JButton addInventory = new JButton("Add New Inventory Items");
        addInventory.setBounds(420, 370, 350, 40);
        addInventory.setBackground(new Color(150,130,180));
        addInventory.setForeground(Color.white);
        addInventory.setFont(new Font("Arial", Font.BOLD, 20));

        //JButton for removeInventory Link
        JButton removeInventory = new JButton("Delete from Available Inventory");
        removeInventory.setBounds(420, 420, 350, 40);
        removeInventory.setBackground(new Color(150,130,180));
        removeInventory.setForeground(Color.white);
        removeInventory.setFont(new Font("Arial", Font.BOLD, 20));

        //JButton for modifyInventory Link
        JButton modifyInventory = new JButton("Modify Available Inventory");
        modifyInventory.setBounds(420, 470, 350, 40);
        modifyInventory.setBackground(new Color(150,130,180));
        modifyInventory.setForeground(Color.white);
        modifyInventory.setFont(new Font("Arial", Font.BOLD, 20));


        //Add Elements to the Frame
        add(backgroundImageSetterA);
        add(backgroundImageSetterB);
        add(timeLabel);
        add(dateLabel);
        add(itemBrief);
        add(typeCount);
        add(unitCount);
        add(furnitureCount);
        add(electronicCount);
        add(titleRibbon);
        add(viewInventory);
        add(addInventory);
        add(removeInventory);
        add(modifyInventory);
        add(briefBox);
        add(currentBox);
        


        //Event actions defined for timers related to date and time
        Timer timer = new Timer(1000, e -> {
            // Get the current time and format it
            String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            timeLabel.setText("TIME  : " + currentTime);
            dateLabel.setText("DATE : " + currentDate);
        });
        timer.start();

        //Event actions defined for viewInventory
        viewInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new ViewInventory().setVisible(true);              
            }
        });

        //Event actions defined for addInventory
        addInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new AddInventory().setVisible(true);
            }
        });

        //Event actions defined for removeInventory
        removeInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new RemoveInventory().setVisible(true);
            }
        });

        //Event actions defined for modifyInventory
        modifyInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new ModifyInventory().setVisible(true);
            }
        });
    }

    public static void main(String []args){
        new HomeScreen().setVisible(true);
    }
}



