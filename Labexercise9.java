import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Labexercise9 extends JFrame {

    private JRadioButton refrigeratorRadioButton, washingMachineRadioButton;
    private JCheckBox maintenanceCheckBox, repairCheckBox;
    private JTextField customerNameTextField;

    public Labexercise9() {
        super("Appliances Services");

        // Create radio buttons
        refrigeratorRadioButton = new JRadioButton("Refrigerator");
        washingMachineRadioButton = new JRadioButton("Washing Machine");

        // Create checkboxes
        maintenanceCheckBox = new JCheckBox("Maintenance");
        repairCheckBox = new JCheckBox("Repair");

        // Create text field
        customerNameTextField = new JTextField(20);

        // Group radio buttons
        ButtonGroup applianceGroup = new ButtonGroup();
        applianceGroup.add(refrigeratorRadioButton);
        applianceGroup.add(washingMachineRadioButton);

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayServiceDetails();
            }
        });

        // Create layout using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to the layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Select Appliance:"), gbc);

        gbc.gridy++;
        add(refrigeratorRadioButton, gbc);

        gbc.gridy++;
        add(washingMachineRadioButton, gbc);

        gbc.gridy++;
        add(new JLabel("Select Service:"), gbc);

        gbc.gridy++;
        add(maintenanceCheckBox, gbc);

        gbc.gridy++;
        add(repairCheckBox, gbc);

        gbc.gridy++;
        add(new JLabel("Customer Name:"), gbc);

        gbc.gridy++;
        add(customerNameTextField, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gbc);

        // Set default appliance selection
        refrigeratorRadioButton.setSelected(true);

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set default size and visibility
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayServiceDetails() {
        String appliance = refrigeratorRadioButton.isSelected() ? "Refrigerator" : "Washing Machine";
        String services = "";
        if (maintenanceCheckBox.isSelected()) {
            services += "Maintenance, ";
        }
        if (repairCheckBox.isSelected()) {
            services += "Repair";
        }
        String customerName = customerNameTextField.getText();

        // Display service details
        JOptionPane.showMessageDialog(this,
                "Customer Name: " + customerName + "\n" +
                        "Selected Appliance: " + appliance + "\n" +
                        "Selected Services: " + (services.isEmpty() ? "None" : services),
                "Service Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                new Labexercise9();
            }
        });
    }
}
