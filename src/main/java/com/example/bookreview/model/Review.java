package com.example.bookreview.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    @EmbeddedId
    ReviewedKey id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @MapsId("reviewer_id")
    @JoinColumn(name="reviewer_id")
    private Reviewer reviewer;

    @ManyToOne
    @MapsId("novelId")
    @JoinColumn(name = "novel_id")
    private Novel novel;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReviewedKey getId() {
        return id;
    }

    public void setId(ReviewedKey id) {
        this.id = id;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }
}
