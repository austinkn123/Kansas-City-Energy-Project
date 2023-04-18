import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateCustomer extends JPanel {
    private JPanel UpdateCustomerPanel = new JPanel();

    public UpdateCustomer() {
        setLayout(new BorderLayout());
        UpdateCustomerPanel.setLayout(new GridLayout(6, 2));
        add(UpdateCustomerPanel, BorderLayout.CENTER);

        JLabel IDLabel = new JLabel("ID:");
        JLabel NameLabel = new JLabel("Name:");
        JLabel PhoneNumLabel = new JLabel("Phone Number:");
        JLabel AddressLabel = new JLabel("Address:");
        JLabel MeterTypeLabel = new JLabel("Meter Type:");

        JTextField IDField = new JTextField();
        JTextField NameField = new JTextField();
        JTextField PhoneNumField = new JTextField();
        JTextField AddressField = new JTextField();
        JComboBox<String> MeterTypeCombo = new JComboBox<>(new String[] {"Electricity", "Gas", "Water", "Heat/Cool"});
        JButton UpdateCustomerButton = new JButton("Update Customer");

        IDLabel.setFont(new Font("Arial", Font.BOLD, 14));
        UpdateCustomerPanel.add(IDLabel);
        UpdateCustomerPanel.add(IDField);
        NameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        UpdateCustomerPanel.add(NameLabel);
        UpdateCustomerPanel.add(NameField);
        PhoneNumLabel.setFont(new Font("Arial", Font.BOLD, 14));
        UpdateCustomerPanel.add(PhoneNumLabel);
        UpdateCustomerPanel.add(PhoneNumField);
        AddressLabel.setFont(new Font("Arial", Font.BOLD, 14));
        UpdateCustomerPanel.add(AddressLabel);
        UpdateCustomerPanel.add(AddressField);
        MeterTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        UpdateCustomerPanel.add(MeterTypeLabel);
        UpdateCustomerPanel.add(MeterTypeCombo);

        UpdateCustomerPanel.add(new JLabel());
        UpdateCustomerPanel.add(UpdateCustomerButton);

        IDField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                //only accept numbers in text field
                if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });

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
        UpdateCustomerButton.addActionListener(new ActionListener() {
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

                CRUDCustomers customer = new CRUDCustomers();
                customer.updateCustomer(Integer.parseInt(IDField.getText()), NameField.getText(), PhoneNumField.getText(),
                        AddressField.getText(), selected, EnergyTariff);
                JOptionPane.showMessageDialog(null, "Customer Updated Successfully");

            }
        });
    }
}
