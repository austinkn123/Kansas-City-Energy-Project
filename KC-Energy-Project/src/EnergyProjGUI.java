import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnergyProjGUI extends JFrame {
    private JPanel LoginPanel = new JPanel();
    private JPanel userPanel = new JPanel();
    private JLabel LoginLabel = new JLabel("Login", JLabel.CENTER);
    private JTextField UserNameField = new JTextField();
    private JTextField PasswordField = new JTextField();
    private JLabel UserNameLabel = new JLabel("Username:");
    private JLabel PasswordLabel = new JLabel("Password:");
    private JButton LoginButton = new JButton("Login");

    private AddCustomer AddCustomerPanel = new AddCustomer();

    private CardLayout cardLayout;

    public String globalUserName;
    public String globalPassword;

    public EnergyProjGUI() {
//        setContentPane(LoginPanel);
        setTitle("KC Energy");
        LoginPanel.setLayout(new GridLayout(4, 1));
        LoginLabel.setFont(new Font("Arial", Font.BOLD, 50));

        cardLayout = new CardLayout();
        setLayout(cardLayout);
        add(LoginPanel, "loginPanel");
        add(AddCustomerPanel, "signUpPanel");

        LoginLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        LoginPanel.add(LoginLabel);
        LoginPanel.add(userPanel);
        userPanel.setLayout(new GridLayout(2, 2));

        // Set the font size to 20
        UserNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        UserNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        UserNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
        userPanel.add(UserNameLabel);
        UserNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        userPanel.add(UserNameField);

        PasswordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        PasswordLabel.setHorizontalAlignment(JLabel.RIGHT);
        PasswordLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
        userPanel.add(PasswordLabel);
        PasswordField.setFont(new Font("Arial", Font.PLAIN, 20));
        userPanel.add(PasswordField);

        LoginPanel.add(LoginButton);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        UserNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        PasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                globalUserName = UserNameField.getText();
                globalPassword = PasswordField.getText();
                Dashboard dashboardPanel = new Dashboard();
                add(dashboardPanel, "dashboardPanel");
                cardLayout.show(getContentPane(), "dashboardPanel");

////                switch to another panel
//                CRUDAdmins adminAccount = new CRUDAdmins();
//                if(adminAccount.login(UserNameField.getText(), PasswordField.getText()) != null){
//                    globalUserName = UserNameField.getText();
//                    globalPassword = PasswordField.getText();
//                    Dashboard dashboardPanel = new Dashboard();
//                    add(dashboardPanel, "dashboardPanel");
//                    cardLayout.show(getContentPane(), "dashboardPanel");
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Invalid username or password");
//                }
//                if(UserNameField.getText().equals("")){
//                    JOptionPane.showMessageDialog(null, "Please enter your username");
//                }
//                if(PasswordField.getText().equals("")){
//                    JOptionPane.showMessageDialog(null, "Please enter your password");
//                }

            }
        });
    }

    public class Dashboard extends JPanel {
        private AddCustomer AddCustomerPanel = new AddCustomer();
        private UpdateCustomer UpdateCustomerPanel = new UpdateCustomer();
        private DeleteCustomer DeleteCustomerPanel = new DeleteCustomer();
        private SearchCustomer Search = new SearchCustomer();
        private JPanel DashboardPanel = new JPanel();
//        private JPanel Search = new JPanel();
        private JPanel Billing = new JPanel();

        private JButton LogoutButton = new JButton("Log Out");

        public Dashboard() {
            CRUDCustomers account = new CRUDCustomers();
            JTabbedPane tabbedPane = new JTabbedPane();

            setLayout(new BorderLayout());
            DashboardPanel.setLayout(new GridLayout(2, 1));

            add(tabbedPane, BorderLayout.CENTER);
            JLabel DashboardLabel = new JLabel("Welcome, " + globalUserName , JLabel.CENTER);

            DashboardLabel.setFont(new Font("Arial",Font.BOLD, 20));
            DashboardLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));


            tabbedPane.addTab("Home", DashboardPanel);
            tabbedPane.addTab("Search Customer", Search);
            tabbedPane.addTab("Billing", Billing);
            tabbedPane.addTab("Add Customer", AddCustomerPanel);
            tabbedPane.addTab("Update Customer", UpdateCustomerPanel);
            tabbedPane.addTab("Delete Customer", DeleteCustomerPanel);


            DashboardPanel.add(DashboardLabel);
            DashboardPanel.add(LogoutButton);

            LogoutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "loginPanel");
                }
            });
        }
    }

    public static void main(String[] args) {
        EnergyProjGUI app = new EnergyProjGUI();

    }

}
