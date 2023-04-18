import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchCustomer extends JPanel {
    private JPanel SearchCustomerPanel = new JPanel();
    public SearchCustomer() {
        setLayout(new BorderLayout());
        SearchCustomerPanel.setLayout(new GridLayout(9, 2));
        add(SearchCustomerPanel, BorderLayout.CENTER);

        JLabel IDLabel = new JLabel("ID:");
        JTextField IDField = new JTextField();
        JButton Search = new JButton("Search");
        JLabel NameLabel = new JLabel();
        JLabel PhoneLabel = new JLabel();
        JLabel AddressLabel = new JLabel();
        JLabel MeterLabel = new JLabel();
        JLabel TariffLabel = new JLabel();

        IDLabel.setFont(new Font("Arial", Font.BOLD, 14));
        SearchCustomerPanel.add(IDLabel);
        SearchCustomerPanel.add(IDField);
        SearchCustomerPanel.add(new JLabel());
        SearchCustomerPanel.add(Search);

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
        SearchCustomerPanel.add(new JLabel("Name: "));
        SearchCustomerPanel.add(NameLabel);
        SearchCustomerPanel.add(new JLabel("Phone Number: "));
        SearchCustomerPanel.add(PhoneLabel);
        SearchCustomerPanel.add(new JLabel("Address: "));
        SearchCustomerPanel.add(AddressLabel);
        SearchCustomerPanel.add(new JLabel("Meter Type: "));
        SearchCustomerPanel.add(MeterLabel);
        SearchCustomerPanel.add(new JLabel("Energy Tariff: "));
        SearchCustomerPanel.add(TariffLabel);

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CRUDCustomers customer = new CRUDCustomers();
                customer searchedAccount = customer.getCustomer(Integer.parseInt(IDField.getText()));
                searchedAccount.getCustomerID();
                NameLabel.setText(searchedAccount.getName());
                PhoneLabel.setText(searchedAccount.getPhoneNumber());
                AddressLabel.setText(searchedAccount.getAddress());
                MeterLabel.setText(searchedAccount.getMeterType());
                TariffLabel.setText(Integer.toString(searchedAccount.getEnergyTariff()));

            }
        });
    }
}
