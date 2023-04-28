import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
        SearchCustomerPanel.add(new JLabel("Customer Bills: "));
        SearchCustomerPanel.add(new JLabel());

        // create a new list model
        DefaultListModel<Billing> listModelBilling = new DefaultListModel<>();
        DefaultListModel<String> listModelName = new DefaultListModel<>();

        Search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] components = SearchCustomerPanel.getComponents();
                for (Component component : components) {
                    if (component instanceof JScrollPane) {
                        SearchCustomerPanel.remove(component);
                    }
                }
                SearchCustomerPanel.revalidate();
                SearchCustomerPanel.repaint();
                CRUDCustomers customer = new CRUDCustomers();
                customer searchedAccount = customer.getCustomer(Integer.parseInt(IDField.getText()));
                searchedAccount.getCustomerID();
                NameLabel.setText(searchedAccount.getName());
                PhoneLabel.setText(searchedAccount.getPhoneNumber());
                AddressLabel.setText(searchedAccount.getAddress());
                MeterLabel.setText(searchedAccount.getMeterType());
                TariffLabel.setText(Integer.toString(searchedAccount.getEnergyTariff()));

                CRUDBilling bill = new CRUDBilling();
                ArrayList<Billing> billReading = bill.getBill(Integer.parseInt(IDField.getText()));
//                GasLabel.setText(Integer.toString(billReading.get(0).getGas()));
//                ElectricityLabel.setText(Integer.toString(billReading.get(0).getElectricity()));
//                WaterLabel.setText(Integer.toString(billReading.get(0).getWater()));
//                AirConditionLabel.setText(Integer.toString(billReading.get(0).getAirCondition()));

                listModelBilling.clear();
                for(int i = 0; i < billReading.size(); i++){
                    listModelBilling.addElement(billReading.get(i));
                    listModelName.addElement("Billing " + i);
                }

                JList<Billing> billingJList = new JList<>(listModelBilling);
                billingJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                billingJList.setLayoutOrientation(JList.VERTICAL);
                billingJList.setVisibleRowCount(-1);
                JScrollPane listScroller = new JScrollPane(billingJList);
                SearchCustomerPanel.add(listScroller);

                billingJList.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            String paidString = "";
                            Billing selectedObject = billingJList.getSelectedValue();
                            if(selectedObject.getPaid() == 0){
                                paidString = "No";
                            } else {
                                paidString = "Yes";
                            }
                            JOptionPane.showMessageDialog(null, "Bill details:\n" +
                                    "Billing ID: " + selectedObject.getBillingID() + "\nBilling Amount: "
                                    + selectedObject.getBillingAmt() + "\nGas Meter Reading: "
                                    + selectedObject.getGas() + "\nElectricity Meter Reading: "
                                    + selectedObject.getElectricity() + "\nWater Meter Reading: "
                                    + selectedObject.getWater() + "\nAir Conditioning Meter Reading: "
                                    + selectedObject.getAirCondition() + "\nPaid: "
                                    + paidString);
                        }
                    }
                });

            }
        });

    }
}
