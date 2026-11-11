package com.test.qlph;

public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String customerPhone;

    public CustomerDTO(){

    }

    public CustomerDTO(String customerId, String customerName, String customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
