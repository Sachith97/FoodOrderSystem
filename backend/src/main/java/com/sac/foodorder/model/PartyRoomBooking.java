package com.sac.foodorder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "party_room_bookings")
public class PartyRoomBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recordId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "party_room_id")
    private PartyRoom partyRoom;

    @Column
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column
    @Temporal(TemporalType.TIME)
    private Date orderTime;

    private String status;

    public long getRecordId() {
        return recordId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PartyRoom getPartyRoom() {
        return partyRoom;
    }

    public void setPartyRoom(PartyRoom partyRoom) {
        this.partyRoom = partyRoom;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
