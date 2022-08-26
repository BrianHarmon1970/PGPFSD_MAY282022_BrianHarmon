package com.harmonengineering.beans;

import java.sql.Timestamp;

public class BookingBean
{
    private Long        ID ;
    private Timestamp   createTime ;
    private Timestamp   updateTime ;
    private String      status ;
    private Long        customerID ;
    private Long        flightDetailID ;
    private Integer     reservedSeats ;
    private Double      totalPrice ;

    public BookingBean() {}

    public void setID(Long ID) { this.ID = ID; }
    public void setCreateTime(Timestamp createTime) { this.createTime = createTime; }
    public void setUpdateTime(Timestamp updateTime) { this.updateTime = updateTime; }
    public void setStatus(String status) { this.status = status; }
    public void setCustomerID(Long customerID) { this.customerID = customerID; }
    public void setFlightDetailID(Long flightDetailID) { this.flightDetailID = flightDetailID; }
    public void setReservedSeats( Integer reservedSeats) { this.reservedSeats = reservedSeats; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public Long getID() { return ID; }
    public Timestamp getCreateTime() { return createTime; }
    public Timestamp getUpdateTime() { return updateTime; }
    public String getStatus() { return status; }
    public Long getCustomerID() { return customerID; }
    public Long getFlightDetailID() { return flightDetailID; }
    public Integer getReservedSeats() { return reservedSeats; }
    public Double getTotalPrice() { return totalPrice; }
}
