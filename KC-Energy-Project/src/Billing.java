public class Billing implements IBilling {
    private int billingID;
    private int billingAmt;
    private int customerID;
    private int Gas;
    private int Electricity;
    private int Water;
    private int AirCondition;
    private int paid;

    public Billing(int billingID, int billingAmt, int customerID, int Gas, int Electricity, int Water, int AirCondition, int paid) {
        this.billingID = billingID;
        this.billingAmt = billingAmt;
        this.customerID = customerID;
        this.Gas = Gas;
        this.Electricity = Electricity;
        this.Water = Water;
        this.AirCondition = AirCondition;
        this.paid = paid;
    }

    public Billing(){

    }

    public int calculateBill(int Gas, int Electricity, int Water, int AirCondition){
        int total = 0;
        total = (Gas * 15) + (Electricity * 45) +( Water * 30) +( AirCondition * 18);
        return total;
    }

    public int getBillingID() { return billingID; }
    public int getCustomerID() { return customerID; }

    public void setBillingAmt(int billingAmt) { this.billingAmt = billingAmt; }
    public int getBillingAmt() { return billingAmt; }

    public void setGas(int Gas) { this.Gas = Gas; }
    public int getGas() { return Gas; }

    public void setElectricity(int Electricity) { this.Electricity = Electricity; }
    public int getElectricity() { return Electricity; }

    public void setWater(int Water) { this.Water = Water; }
    public int getWater() { return Water; }

    public void setAirCondition(int AirCondition) { this.AirCondition = AirCondition; }
    public int getAirCondition() { return AirCondition; }

    public void setPaid(int paid) { this.paid = paid; }
    public int getPaid() { return paid; }


}
