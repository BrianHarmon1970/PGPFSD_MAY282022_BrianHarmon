/****************************************
 *  File: Feedback.java
 */
package com.ecommerce.entity;
import javax.persistence.*;
@Entity
@Table( name="user_feedback" )
public class Feedback
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="ID")
    private Long id;

    @Column( name="user_comment")
    private String  userComment ;

    public Feedback() {}

    public Long getId() { return id; }
    public void setId(Long ID) { this.id = ID; }

    public String getUser_comment() {return userComment;}
    public void setUserComment(String userComment ) {this.userComment = userComment; }
}
