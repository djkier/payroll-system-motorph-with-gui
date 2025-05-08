package org.motorph.model.datarepositories;

public class EmployeeDetails {
    private String id;
    private String lastName;
    private String firstName;
    private String birthDate;
    private String address;
    private String phone;
    private String sss;
    private String philhealth;
    private String tin;
    private String pagibig;
    private String status;
    private String position;
    private String immSup;
    private Double basicSalary;
    private Double riceSubs;
    private Double phoneAll;
    private Double clothingAll;
    private Double semiMonthlySal;
    private Double hourlyRate;

    public EmployeeDetails(String id,
                           String lastName,
                           String firstName,
                           String birthDate,
                           String address,
                           String phone,
                           String sss,
                           String philhealth,
                           String tin,
                           String pagibig,
                           String status,
                           String position,
                           String immSup,
                           Double basicSalary,
                           Double riceSubs,
                           Double phoneAll,
                           Double clothingAll,
                           Double semiMonthlySal,
                           Double hourlyRate) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.sss = sss;
        this.philhealth = philhealth;
        this.tin = tin;
        this.pagibig = pagibig;
        this.status = status;
        this.position = position;
        this.immSup = immSup;
        this.basicSalary = basicSalary;
        this.riceSubs = riceSubs;
        this.phoneAll = phoneAll;
        this.clothingAll = clothingAll;
        this.semiMonthlySal = semiMonthlySal;
        this.hourlyRate = hourlyRate;
    }

    public String getId() {
        return id;
    }

    //not editable
    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSss() {
        return sss;
    }

    public void setSss(String sss) {
        this.sss = sss;
    }

    public String getPhilhealth() {
        return philhealth;
    }

    public void setPhilhealth(String philhealth) {
        this.philhealth = philhealth;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getPagibig() {
        return pagibig;
    }

    public void setPagibig(String pagibig) {
        this.pagibig = pagibig;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    //immediate supervisor
    public String getImmSup() {
        return immSup;
    }

    public void setImmSup(String immSup) {
        this.immSup = immSup;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getRiceSubs() {
        return riceSubs;
    }

    public void setRiceSubs(Double riceSubs) {
        this.riceSubs = riceSubs;
    }

    public Double getPhoneAll() {
        return phoneAll;
    }

    public void setPhoneAll(Double phoneAll) {
        this.phoneAll = phoneAll;
    }

    public Double getClothingAll() {
        return clothingAll;
    }

    public void setClothingAll(Double clothingAll) {
        this.clothingAll = clothingAll;
    }

    //Semi monthlySalary is always half of the gross
    public Double getSemiMonthlySal() {
        return semiMonthlySal;
    }

    public void setSemiMonthlySal(Double semiMonthlySal) {
        this.semiMonthlySal = semiMonthlySal;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.lastName + ", " + this.firstName + " - " + this.status;
    }
}
