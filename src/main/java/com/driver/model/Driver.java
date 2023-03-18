package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;

    private String mobile;

    private String password;

    //assuming driver is parent of cab
    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;

    // driver parent of TripBooking
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList = new ArrayList<>();
}