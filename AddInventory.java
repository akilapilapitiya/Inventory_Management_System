//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddInventory extends JFrame {
    public AddInventory(){
        //Arrays to laminate moving Variables(Furniture and Electronic Type)
         String itemType[] = {""};

        //Frame Definitions
        setTitle("IM Inventory Management System");        
        setSize(800, 600);                   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        setLayout(null);
        getContentPane().setBackground(Color.white);

        //JFrame Logo
        ImageIcon iconImage = new ImageIcon("icon.png"); 
        Image image = iconImage.getImage();
        setIconImage(image);

        //Frame Background Image
        ImageIcon backgroundImageSet = new ImageIcon("addItem.png");
        Image imageSet = backgroundImageSet.getImage();
        Image resizedImage = imageSet.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);
        JLabel backgroundImageSetter = new JLabel(backgroundImage);
        backgroundImageSetter.setBounds(650, 450, 100, 100);

        //JPanel for titleRibbon
        JPanel titleRibbon = new JPanel();
        titleRibbon.setBackground(new Color(150, 130, 180));
        titleRibbon.setBounds(0, 0, 800, 60);

        //JPanel for Context Box
        JPanel contentBox = new JPanel();
        contentBox.setBounds(50, 70, 690, 400);

        //JLabel for BodyTitle
        JLabel bodyTitle = new JLabel("ADD NEW INVENTORY");
        bodyTitle.setBounds(10, 1, 1000, 80);
        bodyTitle.setForeground(Color.WHITE);
        bodyTitle.setFont(new Font("Roboto", Font.BOLD, 30));

        //JLabel for idLabel
        JLabel idLabel = new JLabel("Enter Item ID");
        idLabel.setForeground(Color.black);
        idLabel.setBounds(100, 150, 400, 30);
        idLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //JLabel for nameLabel
        JLabel nameLabel = new JLabel("Enter Item Name");
        nameLabel.setForeground(Color.black);
        nameLabel.setBounds(100, 200, 400, 30);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //JLabel for quantityLabel
        JLabel quantityLabel = new JLabel("Enter the Quantity");
        quantityLabel.setForeground(Color.black);
        quantityLabel.setBounds(100, 250, 400, 30);
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //JLabel for type Label
        JLabel typeLabel = new JLabel("Type");
        typeLabel.setForeground(Color.black);
        typeLabel.setBounds(100, 300, 400, 30);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 16));


        //Text Fields Defined for idTextBox
        JTextField idTextBox = new JTextField("");
        idTextBox.setBounds(300, 150, 150, 30);

        //Text Fields Defined for nameTextBox
        JTextField nameTextBox = new JTextField("");
        nameTextBox.setBounds(300, 200, 150, 30);

        //Text Fields Defined for quantityTextBox
        JTextField quantityTextBox = new JTextField("");
        quantityTextBox.setBounds(300, 250, 150, 30);


        //Radio Buttons Defined for Furniture
        JRadioButton furnitureRadio = new JRadioButton("Furniture Item");
        furnitureRadio.setBounds(300,300 , 140, 30);
        furnitureRadio.setFont(new Font("Arial", Font.BOLD, 16));

        //Radio Buttons Defined for Electronics
        JRadioButton electronicRadio = new JRadioButton("Electronic Item");
        electronicRadio.setBounds(450,300 , 200, 30);
        electronicRadio.setFont(new Font("Arial", Font.BOLD, 16));

        //Button Grouping for Radio Buttons
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(furnitureRadio);
        typeGroup.add(electronicRadio);


        //Buttons defined for saveItem
        JButton saveItem = new JButton("Save Item");
        saveItem.setBounds(450, 350, 180, 40);
        saveItem.setBackground(new Color(150, 130, 180));
        saveItem.setForeground(Color.white);
        saveItem.setFont(new Font("Arial", Font.BOLD, 16));

        //Buttons defined for resetItem
        JButton resetItem = new JButton("Reset Item");
        resetItem.setBounds(250, 350, 180, 40);
        resetItem.setBackground(new Color(150, 130, 180));
        resetItem.setForeground(Color.white);
        resetItem.setFont(new Font("Arial", Font.BOLD, 16));

        //Buttons defined for backButton
        JButton backButton = new JButton("Return to Main Menu");
        backButton.setBackground(new Color(150, 130, 180));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBounds(10,500 , 200, 40);


        //Events defined for backButton
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new HomeScreen().setVisible(true);              
            }
        });

        //Events defined for furnitureRadio
        furnitureRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itemType[0] = "Furniture Item";     //Update the itemType[0] value
            }
        });

        //Events defined for electronicRadio
        electronicRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itemType[0] = "Electronic Item";    //Update the itemType[0] value
            }
        });

        //Events defined for saveItem
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Store written Length of the array
                int arrayLengthWritten = FileArray.StoreArray.length; 
        
                // Get values from text boxes
                String itemIdString = idTextBox.getText();
                String itemNameString = nameTextBox.getText();
                String quantityString = quantityTextBox.getText();
                String itemTypeString = itemType[0];
        
                // Print values for debugging Purposes
                System.out.println(itemIdString);
                System.out.println(itemNameString);
                System.out.println(quantityString);
                System.out.println(itemTypeString);
        
                // Create a new array with one additional row
                String[][] newArray = new String[arrayLengthWritten + 1][4];
                
                // Copy existing data to the new array
                for (int i = 0; i < arrayLengthWritten; i++) {
                    newArray[i] = FileArray.StoreArray[i];
                }
                
                // Add new item to the last row
                newArray[arrayLengthWritten][0] = itemIdString;
                newArray[arrayLengthWritten][1] = itemNameString;
                newArray[arrayLengthWritten][2] = quantityString;
                newArray[arrayLengthWritten][3] = itemTypeString;
        
                // Update StoreArray with the new array
                FileArray.StoreArray = newArray;
        
                // Verify if the new item was added successfully
                if (FileArray.StoreArray[arrayLengthWritten][0].equals(itemIdString) &&
                    FileArray.StoreArray[arrayLengthWritten][1].equals(itemNameString) &&
                    FileArray.StoreArray[arrayLengthWritten][2].equals(quantityString) &&
                    FileArray.StoreArray[arrayLengthWritten][3].equals(itemTypeString)) {
                    JOptionPane.showMessageDialog(null, "Item Successfully Added to the Inventory");
                } else {
                    JOptionPane.showMessageDialog(null, "Error In Adding the Item. Please Try Again");
                }
            }
        });
        
        //Events defined for resetItem
        resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Clear the text Fields
                clearTextFields(idTextBox ,nameTextBox, quantityTextBox);
                typeGroup.clearSelection();
            }
        });

        //Add elements to the Frame
        add(bodyTitle);
        add(titleRibbon);
        add(backgroundImageSetter);
        add(idLabel);
        add(nameLabel);
        add(quantityLabel);
        add(typeLabel);
        add(idTextBox);
        add(nameTextBox);
        add(quantityTextBox);
        add(furnitureRadio);
        add(electronicRadio);
        add(saveItem);
        add(resetItem);
        add(backButton);
        add(contentBox);
    }

    public static void main(String []args){
        new AddInventory().setVisible(true);

    }
    //Clear text Fields Function
    public static void clearTextFields(JTextField... textFields) {
        Arrays.stream(textFields).forEach(field -> field.setText(""));
    }
}
