package com.example.bookreview.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "writer")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Novel> novels;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Novel> getNovels() {
        return novels;
    }

    public void setNovels(List<Novel> novels) {
        this.novels = novels;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", novels=" + getNovelTitle(this.novels) +
                '}';
    }

    private String getNovelTitle(List<Novel> novels)
    {
        for (Novel novel: novels) {
            return novel.getName().toString();
        }
        return null;
    }


}
