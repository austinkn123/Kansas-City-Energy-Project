import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DeleteCustomer extends JPanel {
    private JPanel DeleteCustomerPanel = new JPanel();
    public DeleteCustomer() {
        setLayout(new BorderLayout());
        DeleteCustomerPanel.setLayout(new GridLayout(2, 2));
        add(DeleteCustomerPanel, BorderLayout.CENTER);

        JLabel IDLabel = new JLabel("ID:");
        JTextField IDField = new JTextField();
        JButton DeleteCustomerButton = new JButton("Delete Customer");

        IDLabel.setFont(new Font("Arial", Font.BOLD, 14));
        DeleteCustomerPanel.add(IDLabel);
        DeleteCustomerPanel.add(IDField);
        DeleteCustomerPanel.add(new JLabel());
        DeleteCustomerPanel.add(DeleteCustomerButton);

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

        DeleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CRUDCustomers customer = new CRUDCustomers();
                customer.deleteCustomer(Integer.parseInt(IDField.getText()));
                JOptionPane.showMessageDialog(null, "Customer Deleted Successfully");
            }
        });
    }
}
