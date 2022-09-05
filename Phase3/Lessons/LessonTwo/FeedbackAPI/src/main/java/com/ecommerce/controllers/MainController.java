/***************************************
 *  File: MainController.java
 */
package com.ecommerce.controllers;

import com.ecommerce.FeedbackRepository ;
import com.ecommerce.entity.Feedback ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
@RestController
public class MainController
{
    private final FeedbackRepository feedbackRepository ;
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    public MainController( FeedbackRepository repository )
    {
        this.feedbackRepository = repository ;
    }

    @PostMapping("/feedback")
    Feedback AddFeedback(@RequestParam(name="new_comment")   String newComment)
    {
        System.out.println("Add User comment from html RequestParam" ) ;
        Feedback feedback = new Feedback() ;
        if( newComment != null &&!newComment.isBlank() ) {
            feedback.setUserComment(newComment);
            log.info("new comment: " + newComment);
            if (feedbackRepository != null) {
                log.debug("feedback repository is not null");
                log.info("Inserting " + feedbackRepository.save(feedback));
            }
        }
        return feedback ;
    }
    @PostMapping("/feedback2")
   Feedback AddFeedback2(@RequestBody Feedback newFeedback )
    {
        log.debug( "AddFeedback-from JSON" ) ;
        if ( feedbackRepository != null ) {
            log.debug("feedback repository is not null" );
            log.info("Inserting " + feedbackRepository.save( newFeedback ));
        }
        return newFeedback ;
    }
}
