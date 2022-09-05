/************************
 *  File: FeedbackApiApplication.java
 */
package com.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeedbackApiApplication
{
    @Autowired
    private FeedbackRepository feedbackRepository ;

    public static void main(String[] args)
    {
        SpringApplication.run(FeedbackApiApplication.class, args);
    }
    /*    @Bean
    public CommandLineRunner run(FeedbackRepository feedbackRepository) throws Exception {
        return (String[] args) -> {
            Feedback comment1 = new Feedback() ;//= new Feedback( "john@domain.com");
            Feedback comment2 = new Feedback() ;//= new Feedback( "julie@domain.com");
            comment1.setUserComment("Comment1") ;
            comment2.setUserComment("Comment2") ;
            feedbackRepository.save( (Feedback)comment1 );
            feedbackRepository.save( (Feedback)comment2 );
            feedbackRepository.findAll().forEach(System.out::println);

        };     */
}
