//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ModifyInventory extends JFrame {
    public ModifyInventory(){
        //Arrays to laminate moving Variables(Furniture and Electronic Type)
         String itemType[] = {""};
         //Array to laminate the matched array element number
         int arrayMatch[] = {1};

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
        ImageIcon backgroundImageSet = new ImageIcon("assets/modifyImage.png");
        Image imageSet = backgroundImageSet.getImage();
        Image resizedImage = imageSet.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);
        JLabel backgroundImageSetter = new JLabel(backgroundImage);
        backgroundImageSetter.setBounds(650, 450, 100, 100);

        //JPanel for titleRibbon
        JPanel titleRibbon = new JPanel();
        titleRibbon.setBackground(new Color(150, 130, 180));
        titleRibbon.setBounds(0, 0, 800, 60);

        //JPanel for contextBox
        JPanel contentBox = new JPanel();
        contentBox.setBounds(50, 70, 690, 400);

        //JLabel For bodyTitle
        JLabel bodyTitle = new JLabel("MODIFY AVAILABLE INVENTORY");
        bodyTitle.setBounds(10, 1, 1000, 80);
        bodyTitle.setForeground(Color.WHITE);
        bodyTitle.setFont(new Font("Roboto", Font.BOLD, 30));

        //JLabel for idLabel
        JLabel idLabel = new JLabel("Item ID");
        idLabel.setForeground(Color.black);
        idLabel.setBounds(100, 100, 400, 30);
        idLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //JLabel for nameLabel
        JLabel nameLabel = new JLabel("Enter Item Name");
        nameLabel.setForeground(Color.black);
        nameLabel.setBounds(100, 250, 400, 30);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //JLabel for quantityLabel
        JLabel quantityLabel = new JLabel("Enter the Quantity");
        quantityLabel.setForeground(Color.black);
        quantityLabel.setBounds(100, 300, 400, 30);
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //JLabel for 
        JLabel typeLabel = new JLabel("Type");
        typeLabel.setForeground(Color.black);
        typeLabel.setBounds(100, 350, 400, 30);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 16));


        //Text Fields Defined for idTextBox
        JTextField idTextBox = new JTextField("");
        idTextBox.setBounds(300, 100, 150, 30);

        //Text Fields Defined for nameTextBox
        JTextField nameTextBox = new JTextField("");
        nameTextBox.setBounds(300, 250, 150, 30);

        //Text Fields Defined for quantityTextBox
        JTextField quantityTextBox = new JTextField("");
        quantityTextBox.setBounds(300, 300, 150, 30);


        //Radio Buttons Defined for furniture items
        JRadioButton furnitureRadio = new JRadioButton("Furniture Item");
        furnitureRadio.setBounds(300,350 , 140, 30);
        furnitureRadio.setFont(new Font("Arial", Font.BOLD, 16));

        //Radio buttons deifned for electronic items
        JRadioButton electronicRadio = new JRadioButton("Electronic Item");
        electronicRadio.setBounds(450,350 , 200, 30);
        electronicRadio.setFont(new Font("Arial", Font.BOLD, 16));

        //Button Grouping for radio buttons
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(furnitureRadio);
        typeGroup.add(electronicRadio);


        //Buttons defined for searchResetButton 
        JButton searchResetButton = new JButton("Reset Item");
        searchResetButton.setBounds(100, 150, 180, 40);
        searchResetButton.setBackground(new Color(150, 130, 180));
        searchResetButton.setForeground(Color.white);
        searchResetButton.setFont(new Font("Arial", Font.BOLD, 16));

        //Buttons defined for searchButton 
        JButton searchButton = new JButton("Search Item");
        searchButton.setBackground(new Color(150, 130, 180));
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        searchButton.setBounds(300, 150, 200, 40);

        //Buttons defined for saveItem 
        JButton saveItem = new JButton("Save Item");
        saveItem.setBounds(300, 400, 200, 40);
        saveItem.setBackground(new Color(150, 130, 180));
        saveItem.setForeground(Color.white);
        saveItem.setFont(new Font("Arial", Font.BOLD, 16));

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

        //Event Defined for electronicRadio
        electronicRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itemType[0] = "Electronic Item";    //Update the itemType[0] value
            }
        });

        //Event defined for search button
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredId = idTextBox.getText();
                boolean found = false;  //Found state variable
                for (int i = 0; i < FileArray.StoreArray.length; i++) {
                    if (FileArray.StoreArray[i][0].equals(enteredId)) {
                        arrayMatch[0] = i;
                        nameTextBox.setText(FileArray.StoreArray[i][1]);
                        quantityTextBox.setText(FileArray.StoreArray[i][2]);

                        if(FileArray.StoreArray[i][3] == "Furniture Item"){
                            itemType[0] = "Furniture Item";
                            furnitureRadio.setSelected(true);
                        }
                        else if(FileArray.StoreArray[i][3] == "Electronic Item"){
                            itemType[0] = "Electronic Item";
                            electronicRadio.setSelected(true);
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog
                    (null, "Item ID not found. Please try again");
                }
            }
        });

        //Event defined for saveItem
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Get values from text boxes
                String itemIdString = idTextBox.getText();
                String itemNameString = nameTextBox.getText();
                String quantityString = quantityTextBox.getText();
                String itemTypeString = itemType[0];

                System.out.println(itemIdString);
        
                //Update the Array with values
                FileArray.StoreArray[arrayMatch[0]][0] = itemIdString;
                FileArray.StoreArray[arrayMatch[0]][1] = itemNameString;
                FileArray.StoreArray[arrayMatch[0]][2] = quantityString;
                FileArray.StoreArray[arrayMatch[0]][3] = itemTypeString;

                // Print values for debugging Purposes
                /*System.out.println(FileArray.StoreArray[arrayMatch[0]][0]);
                System.out.println(FileArray.StoreArray[arrayMatch[0]][1]);
                System.out.println(FileArray.StoreArray[arrayMatch[0]][2]);
                System.out.println(FileArray.StoreArray[arrayMatch[0]][3]);*/

                // Verify if the new item was added successfully
                if (FileArray.StoreArray[arrayMatch[0]][1].equals(itemNameString) &&
                    FileArray.StoreArray[arrayMatch[0]][2].equals(quantityString) &&
                    FileArray.StoreArray[arrayMatch[0]][3].equals(itemTypeString)) {
                    JOptionPane.showMessageDialog(null, "Item Successfully Updated in the Inventory");
                } else {
                    JOptionPane.showMessageDialog(null, "Error In Updating the Item. Please Try Again");
                }
        

        
            }
        });
        
        //Event defined for searchResetButton
        searchResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Clear the text Fields
                clearTextFields(idTextBox ,nameTextBox, quantityTextBox);
                typeGroup.clearSelection();
            }
        });

        //Add elements to the Frame
        add(idLabel);
        add(nameLabel);
        add(quantityLabel);
        add(typeLabel);
        add(bodyTitle);
        add(titleRibbon);
        add(backgroundImageSetter);
        add(idTextBox);
        add(nameTextBox);
        add(quantityTextBox);
        add(furnitureRadio);
        add(electronicRadio);
        add(saveItem);
        add(backButton);
        add(searchButton);
        add(searchResetButton);
        add(contentBox);
    }

    public static void main(String []args){
        new ModifyInventory().setVisible(true);

    }
    //Clear text Fields Function
    public static void clearTextFields(JTextField... textFields) {
        Arrays.stream(textFields).forEach(field -> field.setText(""));
    }
}