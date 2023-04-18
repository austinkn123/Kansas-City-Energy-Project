public class customer implements ICustomer {

    private int customerID;
    private String Name;
    private String PhoneNumber;
    private String Address;
    private String UserName;
    private String Password;
    private double Balance;
    private String MeterType;
    private int EnergyTariff;

    public customer() {
        UserName = "default";
        Password = "default";
    }

    public customer(int customerID, String Name, String PhoneNumber, String Address, String UserName, String Password, double Balance, String MeterType, int EnergyTariff) {
        this.customerID = customerID;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.UserName = UserName;
        this.Password = Password;
        this.Balance = Balance;
        this.MeterType = MeterType;
        this.EnergyTariff = EnergyTariff;
    }

    @Override
    public int getCustomerID() { return customerID; }

    @Override
    public void setName(String Name) { this.Name = Name; }
    @Override
    public String getName() { return Name; }

    @Override
    public void setPhoneNumber(String PhoneNumber) { this.PhoneNumber = PhoneNumber; }
    @Override
    public String getPhoneNumber() { return PhoneNumber; }

    @Override
    public void setAddress(String Address) { this.Address = Address; }
    @Override
    public String getAddress() { return Address; }

    @Override
    public void setUserName(String UserName) { this.UserName = UserName; }
    @Override
    public String getUserName() { return UserName; }

    @Override
    public void setPassword(String Password) { this.Password = Password; }
    @Override
    public String getPassword() { return Password; }

    @Override
    public void setBalance(double Balance) { this.Balance = Balance; }
    @Override
    public double getBalance() { return Balance; }

    @Override
    public void setMeterType(String MeterType) { this.MeterType = MeterType; }
    @Override
    public String getMeterType() { return MeterType; }

    @Override
    public void setEnergyTariff(int EnergyTariff) { this.EnergyTariff = EnergyTariff; }
    @Override
    public int getEnergyTariff() { return EnergyTariff; }


}
