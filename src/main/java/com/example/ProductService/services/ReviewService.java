package com.example.ProductService.services;

import com.example.ProductService.models.Booking;
import com.example.ProductService.models.Review;
import com.example.ProductService.repositories.BookingRepository;
import com.example.ProductService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner  {

   private ReviewRepository reviewRepository ;

   private BookingRepository bookingRepository ;

   public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository ){
       this.reviewRepository =reviewRepository ;
       this.bookingRepository =bookingRepository ;
   }
    @Override
    public void run(String... args) throws Exception {
     System.out.println("***********");

         Review r = Review.builder().
                content("Amazing ride quality").
                rating(5.0).build();
        // plain java object:

        Booking b = Booking
                .builder()
                .review(r)
                .endTime(new Date())
                .build() ;


        System.out.println(r);
       // reviewRepository.save(r);
        // this code excecute sql quries:
        bookingRepository.save(b);

        List<Review> reviews = reviewRepository.findAll();

        for(Review review : reviews){
            System.out.println(review.getContent());
        }
       //reviewRepository.deleteById(3L);

   }
}
