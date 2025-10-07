package com.example.ProductService.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Booking  extends BaseModel{


    @OneToOne(cascade = {CascadeType.PERSIST})
    private Review review ; // we have define one to one relationship between booking and review;


    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus ;


    @Temporal(value = TemporalType.TIMESTAMP )
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP )
    private Date endTime;


    private Long totalDistance;
}
