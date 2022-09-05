package com.harmonengineering.entity;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
@EnableTransactionManagement
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="id")
    private Long id ;
    @Column( name="description" )
    private String description ;
    @Column( name="published" )
    private Integer published ;
    @Column( name="title" )
    private String title ;

    public Book() {}

    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setPublished( Integer published) { this.published = published; }
    public void setTitle(String title) { this.title = title; }

    public Long getId() { return id; }
    public String getDescription() {  return description; }
    public Integer getPublished() {  return published; }
    public String getTitle() { return title; }
}
