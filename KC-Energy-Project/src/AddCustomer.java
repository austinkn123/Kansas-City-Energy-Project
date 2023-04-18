import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class AddCustomer extends JPanel {
    private JPanel AddCustomerPanel = new JPanel();

    public AddCustomer() {
        setLayout(new BorderLayout());
        AddCustomerPanel.setLayout(new GridLayout(5, 2));
        add(AddCustomerPanel, BorderLayout.CENTER);

        JLabel NameLabel = new JLabel("Name:");
        JLabel PhoneNumLabel = new JLabel("Phone Number:");
        JLabel AddressLabel = new JLabel("Address:");
        JLabel MeterTypeLabel = new JLabel("Meter Type:");

        JTextField NameField = new JTextField();
        JTextField PhoneNumField = new JTextField();
        JTextField AddressField = new JTextField();
        JComboBox<String> MeterTypeCombo = new JComboBox<>(new String[] {"Electricity", "Gas", "Water", "Heat/Cool"});
        JButton AddCustomerButton = new JButton("Add Customer");

        NameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        AddCustomerPanel.add(NameLabel);
        AddCustomerPanel.add(NameField);
        PhoneNumLabel.setFont(new Font("Arial", Font.BOLD, 14));
        AddCustomerPanel.add(PhoneNumLabel);
        AddCustomerPanel.add(PhoneNumField);
        AddressLabel.setFont(new Font("Arial", Font.BOLD, 14));
        AddCustomerPanel.add(AddressLabel);
        AddCustomerPanel.add(AddressField);
        MeterTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        AddCustomerPanel.add(MeterTypeLabel);
        AddCustomerPanel.add(MeterTypeCombo);

        AddCustomerPanel.add(new JLabel());
        AddCustomerPanel.add(AddCustomerButton);

        NameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (NameField.getText().length() >= 25) {
                    e.consume();
                }
            }
        });

        PhoneNumField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                //only accept numbers in text field
                if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });

        PhoneNumField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (PhoneNumField.getText().length() >= 10) {
                    e.consume();
                }
            }
        });

//            Record the data in the database
        AddCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int EnergyTariff = 0;
                // get selected item and decides the billing based on the meter type
                String selected = (String) MeterTypeCombo.getSelectedItem();
                if (selected.equals("Heat/Cool")) {
                    EnergyTariff = 100;
                }
                else if (selected.equals("Water")) {
                    EnergyTariff = 200;
                }
                else if (selected.equals("Gas")) {
                    EnergyTariff = 300;
                }
                else if (selected.equals("Electricity")) {
                    EnergyTariff = 400;
                }
                // Create a new instance of Random
                Random random = new Random();

                // Generate a random integer between 0 and 100 (inclusive)
                int randomNumber = random.nextInt(999999);
                CRUDCustomers newAccount = new CRUDCustomers(randomNumber, NameField.getText(), PhoneNumField.getText(),
                        AddressField.getText(), selected, EnergyTariff);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");

            }
        });
    }
}
