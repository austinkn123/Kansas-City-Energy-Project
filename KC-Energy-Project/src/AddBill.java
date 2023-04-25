import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddBill extends JPanel {
    private JPanel AddBillPanel = new JPanel();
    public AddBill(){
        setLayout(new BorderLayout());
        AddBillPanel.setLayout(new GridLayout(2, 2));
        add(AddBillPanel, BorderLayout.CENTER);

        JLabel customerIDLabel = new JLabel("Who are you billing (customerID):");
        JTextField customerIDField = new JTextField();
        JButton AddBillButton = new JButton("Bill Customer");

        AddBillPanel.add(customerIDLabel);
        AddBillPanel.add(customerIDField);
        AddBillPanel.add(new JLabel());
        AddBillPanel.add(AddBillButton);

        AddBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new instance of Random
                Random random = new Random();

                // Generate a random integer between 0 and 100 (inclusive)
                int billingID = random.nextInt(999999);
                int paid = random.nextInt(2);
                int gas = random.nextInt(100);
                int electric = random.nextInt(100);
                int water = random.nextInt(100);
                int airCondition = random.nextInt(100);

                Billing billReading = new Billing();
                int billAmt = billReading.calculateBill(gas, electric, water, airCondition);

                CRUDBilling bill = new CRUDBilling();

                bill.addBill(billingID, billAmt, Integer.parseInt(customerIDField.getText()),
                        gas, electric, water, airCondition, paid);

                JOptionPane.showMessageDialog(null, "Bill added successfully");
            }
        });

    }
}
