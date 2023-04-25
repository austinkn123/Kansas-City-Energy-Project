public interface IBilling {
    public int calculateBill(int Gas, int Electricity, int Water, int AirCondition);


    public int getBillingID();

    public void setBillingAmt(int billingAmt);
    public int getBillingAmt();


    public int getCustomerID();

    public void setGas(int Gas);
    public int getGas();

    public void setElectricity(int Electricity);
    public int getElectricity();

    public void setWater(int Water);
    public int getWater();

    public void setAirCondition(int AirCondition);
    public int getAirCondition();

    public void setPaid(int paid);
    public int getPaid();


}
