package com.example.ProductService.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="bookingreview")
@EntityListeners(AuditingEntityListener.class)
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // identity means auto increment
  private Long id;

  @Column(nullable = false)
  private String content;

  private Double rating;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP )
  @CreatedDate
  private Date createdAt;


  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP )
  @LastModifiedDate
  private Date updatedAt;

  @Override
  public String toString(){
    return "Review: "+this.content + " "+ this.rating +" "+this.createdAt;
  }

}
