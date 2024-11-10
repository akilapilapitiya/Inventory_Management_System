import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RemoveInventory extends JFrame {
    public RemoveInventory() {
        //Frame Defintions
        setTitle("IM Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon iconImage = new ImageIcon("icon.png"); 
        Image image = iconImage.getImage();
        setIconImage(image);

        //Frame Background Image
        ImageIcon backgroundImageSet = new ImageIcon("deleteImage.png");
        Image imageSet = backgroundImageSet.getImage();
        Image resizedImage = imageSet.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);
        JLabel backgroundImageSetter = new JLabel(backgroundImage);
        backgroundImageSetter.setBounds(650, 450, 100, 100);

        //JPanel for titleRibbon
        JPanel titleRibbon = new JPanel();
        titleRibbon.setBackground(new Color(150, 130, 180));
        titleRibbon.setBounds(0, 0, 800, 60);

        //Jpanel for contextBox
        JPanel contentBox = new JPanel();
        contentBox.setBounds(50, 70, 690, 400);

        //JLabel for bodyTitle
        JLabel bodyTitle = new JLabel("REMOVE AVAILABLE INVENTORY ITEMS");
        bodyTitle.setBounds(10, 1, 1000, 80);
        bodyTitle.setForeground(Color.WHITE);
        bodyTitle.setFont(new Font("Arial", Font.BOLD, 30));

        //JLabel for removeIdLabel
        JLabel removeIdLabel = new JLabel("Enter Item ID");
        removeIdLabel.setForeground(Color.black);
        removeIdLabel.setBounds(100, 150, 400, 30);
        removeIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        //JLabel for removeConfirmation
        JLabel removeConfirmation = new JLabel("Are you sure you want to remove?");
        removeConfirmation.setForeground(Color.black);
        removeConfirmation.setBounds(100, 350, 400, 30);
        removeConfirmation.setFont(new Font("Arial", Font.BOLD, 16));

        //Text Field Definitions for removeIdTextBox
        JTextField removeIdTextBox = new JTextField("");
        removeIdTextBox.setBounds(300, 150, 150, 30);

        //JButton defined for backButton
        JButton backButton = new JButton("Return to Main Menu");
        backButton.setBackground(new Color(150, 130, 180));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBounds(10,500 , 200, 40);

        //JButton for searchResetButton
        JButton searchResetButton = new JButton("Reset Item");
        searchResetButton.setBounds(100, 200, 180, 40);
        searchResetButton.setBackground(new Color(150, 130, 180));
        searchResetButton.setForeground(Color.white);
        searchResetButton.setFont(new Font("Arial", Font.BOLD, 16));

        //JButton for searchButton
        JButton searchButton = new JButton("Search Item");
        searchButton.setBackground(new Color(150, 130, 180));
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        searchButton.setBounds(300, 200, 200, 40);

        //JButton for confirmButton
        JButton confirmButton = new JButton("Yes");
        confirmButton.setBackground(new Color(150, 130, 180));
        confirmButton.setForeground(Color.white);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));
        confirmButton.setBounds(380, 350, 100, 40);

        //Table Column Headings Defined
        String[] columnNames = {"Item ID", "Item Name", "Number of Units", "Type"};
        //Default Empty Column Fill at refreshing of the page
        String[][] data = {
            {"", "", "", ""}
        };
        //Intial Table Drawing with the empty cells
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        //Table Implentation
        JTable confirmTable = new JTable(model);

        // Table Appearance Customizations
        confirmTable.setFont(new Font("Roboto", Font.PLAIN, 14));
        confirmTable.setRowHeight(30);
        confirmTable.setBackground(Color.WHITE);
        confirmTable.setForeground(Color.BLACK);
        confirmTable.setGridColor(Color.BLACK);
        confirmTable.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 16));
        confirmTable.getTableHeader().setBackground(Color.WHITE);
        confirmTable.getTableHeader().setForeground(Color.BLACK);

        //Table ScrollPane implemented
        JScrollPane confirmScrollPane = new JScrollPane(confirmTable);
        confirmScrollPane.setBounds(50, 290, 690, 50);
        confirmScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        //Events defined for backButton
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeScreen().setVisible(true);
            }
        });

        //Events define for searchButton
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredId = removeIdTextBox.getText();
                boolean found = false;  //Found state variable
                for (int i = 0; i < FileArray.StoreArray.length; i++) {
                    if (FileArray.StoreArray[i][0].equals(enteredId)) {
                        String[][] filteredData = {FileArray.StoreArray[i]};
                        DefaultTableModel newModel = new DefaultTableModel(filteredData, columnNames);
                        confirmTable.setModel(newModel);
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

        //Event defined for searchResetButton
        searchResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearTextFields(removeIdTextBox);
                // Reset table to empty
                DefaultTableModel emptyModel = new DefaultTableModel(data, columnNames);
                confirmTable.setModel(emptyModel);
            }
        });

        //Event defined for confirmButton
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredId = removeIdTextBox.getText();
                int removeIndex = -1;
        
                // Find the index of the item to remove
                for (int i = 0; i < FileArray.StoreArray.length; i++) {
                    if (FileArray.StoreArray[i][0].equals(enteredId)) {
                        removeIndex = i;
                        break;
                    }
                }
        
                // If item is found, remove it by creating a new array without it
                if (removeIndex != -1) {
                    String[][] newArray = new String[FileArray.StoreArray.length - 1][];
                    for (int i = 0, j = 0; i < FileArray.StoreArray.length; i++) {
                        if (i != removeIndex) {
                            newArray[j++] = FileArray.StoreArray[i];
                        }
                    }
                    FileArray.StoreArray = newArray; // Update the original array
                    JOptionPane.showMessageDialog(null, "Item removed successfully!");
        
                    // Clear the input field and reset the table
                    removeIdTextBox.setText("");
                    DefaultTableModel emptyModel = new DefaultTableModel(new String[0][0], columnNames);
                    confirmTable.setModel(emptyModel);
                } else {
                    JOptionPane.showMessageDialog(null, "Item ID not found. Cannot remove.");
                }
            }
        });
        
        
        //Add elements to the frame
        add(backButton);
        add(bodyTitle);
        add(titleRibbon);
        add(backgroundImageSetter);
        add(removeIdLabel);
        add(removeIdTextBox);
        add(searchResetButton);
        add(searchButton);
        add(confirmButton);
        add(confirmScrollPane);
        add(removeConfirmation);
        add(contentBox);     
    }

    public static void main(String[] args) {
        new RemoveInventory().setVisible(true);
    }

    public static void clearTextFields(JTextField... textFields) {
        Arrays.stream(textFields).forEach(field -> field.setText(""));
    }
}