public class customer implements ICustomer {

    private int customerID;
    private String Name;
    private String PhoneNumber;
    private String Address;
    private String MeterType;
    private int EnergyTariff;


    public customer(int customerID, String Name, String PhoneNumber, String Address, String MeterType, int EnergyTariff) {
        this.customerID = customerID;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
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
    public void setMeterType(String MeterType) { this.MeterType = MeterType; }
    @Override
    public String getMeterType() { return MeterType; }

    @Override
    public void setEnergyTariff(int EnergyTariff) { this.EnergyTariff = EnergyTariff; }
    @Override
    public int getEnergyTariff() { return EnergyTariff; }


}
