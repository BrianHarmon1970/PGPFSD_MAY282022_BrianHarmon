/******************************************
 *  File: FeedbackRepository.java
 */
package com.ecommerce;

import com.ecommerce.entity.Feedback ;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository
        extends CrudRepository< Feedback ,Long>
{
    Feedback save( Feedback feedback ) ;
    List<Feedback> findAll() ;

}

@EnableJpaRepositories
class Config {
    private FeedbackRepository feedbackRepository;
}

