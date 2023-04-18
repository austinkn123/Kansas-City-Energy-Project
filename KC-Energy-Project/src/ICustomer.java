public interface ICustomer {
    public int getCustomerID();

    public void setName(String Name);
    public String getName();

    public void setPhoneNumber(String PhoneNumber);
    public String getPhoneNumber();

    public void setAddress(String Address);
    public String getAddress();

    public void setUserName(String UserName);
    public String getUserName();

    public void setPassword(String Password);
    public String getPassword();

    public void setBalance(double Balance);
    public double getBalance();

    public void setMeterType(String MeterType);
    public String getMeterType();

    public void setEnergyTariff(int EnergyTariff);
    public int getEnergyTariff();

}
