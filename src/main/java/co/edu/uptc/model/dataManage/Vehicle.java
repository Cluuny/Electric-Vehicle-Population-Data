package co.edu.uptc.model.dataManage;


public class Vehicle {
    private String vin;
    private String county;
    private String state;
    private String city;
    private String manufacturer;
    private String model;
    private int electricRange;

    public Vehicle(String vin, String county, String state, String city, String manufacturer, String model, int electricRange) {
        this.vin = vin;
        this.county = county;
        this.state = state;
        this.city = city;
        this.manufacturer = manufacturer;
        this.model = model;
        this.electricRange = electricRange;
    }

    public String getVin() {
        return vin;
    }

    public String getCounty() {
        return county;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getElectricRange() {
        return electricRange;
    }



    
    
}
