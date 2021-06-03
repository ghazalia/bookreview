package com.example.bookreview.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "novel")
public class Novel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "writer_id", referencedColumnName = "id")
  private Author author;

  @ManyToMany
  private List<Reviewer> reviewerList;

  @OneToMany(mappedBy = "novel")
  private List<Review> reviews;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Novel [author=" + author + ", id=" + id + ", name=" + name + "]";
  }

}
