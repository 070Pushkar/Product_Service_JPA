package com.example.ProductService.services;

import com.example.ProductService.models.Booking;
import com.example.ProductService.models.Driver;
import com.example.ProductService.models.Review;
import com.example.ProductService.repositories.BookingRepository;
import com.example.ProductService.repositories.DriverRepository;
import com.example.ProductService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner  {

   private ReviewRepository reviewRepository ;

   private BookingRepository bookingRepository ;

   private DriverRepository driverRepository ;

   public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository , DriverRepository driverRepository){
       this.reviewRepository =reviewRepository ;
       this.bookingRepository =bookingRepository ;
       this.driverRepository = driverRepository ;
   }
    @Override
    public void run(String... args) throws Exception {
     System.out.println("***********");

       /*  Review r = Review.builder().
                content("Amazing ride quality").
                rating(5.0).build();
        // plain java object:

        Booking b = Booking
                .builder()
                .review(r)
                .endTime(new Date())
                .build() ; */


      //  System.out.println(r);
       // reviewRepository.save(r);
        // this code execute sql queries:
       // bookingRepository.save(b);

       /* List<Review> reviews = reviewRepository.findAll();

        for(Review review : reviews){
            System.out.println(review.getContent());
        }*/
       //reviewRepository.deleteById(3L);


      // Optional < Driver> driver = driverRepository.findByIdAndLicenseNumber(1L, "DL121212");

       //if(driver.isPresent()){
          // System.out.println(driver.get().getName());
           //List<Booking > b = driver.get().getBookings();
          // for(Booking booking : b ){
        //       System.out.println(booking.getId());
      //     }
       //}

   Optional<Driver> d = driverRepository.hqlFindByIdAndLicense(1L, "DL121212");
    System.out.println(d.get().getName());
   }
}
