package com.example.ProductService.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel{

    private String name;


    @Column(nullable = false, unique = true)
    private String licenseNumber;

    //1:n association mapping because a driver has many Booking ;

   @OneToMany(mappedBy = "driver")
   private List<Booking > bookings = new ArrayList<>();
}
