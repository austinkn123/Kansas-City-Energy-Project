public interface ICustomer {
    public int getCustomerID();

    public void setName(String Name);
    public String getName();

    public void setPhoneNumber(String PhoneNumber);
    public String getPhoneNumber();

    public void setAddress(String Address);
    public String getAddress();

    public void setMeterType(String MeterType);
    public String getMeterType();

    public void setEnergyTariff(int EnergyTariff);
    public int getEnergyTariff();

}
