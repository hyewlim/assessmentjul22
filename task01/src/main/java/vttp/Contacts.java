package vttp;

public class Contacts {
    private String first_name;
    private String last_name;
    private String address;
    private int years;
    private String salutations;
    private String package_name;
    private double price;

    public Contacts(String first_name, String last_name, String address, int years) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.years = years;
    }

    

    public Contacts(String last_name, String salutations, String package_name, double price) {
        this.last_name = last_name;
        this.salutations = salutations;
        this.package_name = package_name;
        this.price = price;
    }



    public String getSalutations() {
        return salutations;
    }



    public void setSalutations(String salutations) {
        this.salutations = salutations;
    }



    public String getPackage_name() {
        return package_name;
    }



    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }



    public double getPrice() {
        return price;
    }



    public void setPrice(double price) {
        this.price = price;
    }



    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Contacts [address=" + address + ", first_name=" + first_name + ", last_name=" + last_name + ", years="
                + years + "]";
    }

    
    
}
