package com.dasfilm.azzeddine.dasfilm.Entities;

import java.util.Date;
import java.util.List;

/**
 * Created by azeddine on 3/27/18.
 */

public class Actor {

    private int id;
    private String firstName;
    private String lastName;
    private String placeOfBirth;
    private Date birthday;
    private String profileImagePath;
    private List<Movie> movies;
    private List<String> taggedImages;

    public Actor(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<String> getTaggedImages() {
        return taggedImages;
    }

    public void setTaggedImages(List<String> taggedImages) {
        this.taggedImages = taggedImages;
    }
}
