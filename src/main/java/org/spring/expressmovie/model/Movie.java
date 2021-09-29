package org.spring.expressmovie.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    @Column(columnDefinition = "text")
    private String descrition;
    @Temporal(TemporalType.DATE)
    private Date release;
    @Temporal(TemporalType.TIME)
    private Date runningTime;
    @ManyToMany(targetEntity = Director.class, cascade = CascadeType.ALL)
    private List<Director> directors;

    public Movie() {
    }

    public Movie(String title, String descrition, Date release, Date runningTime, List<Director> directors) {
        this.title = title;
        this.descrition = descrition;
        this.release = release;
        this.runningTime = runningTime;
        this.directors = directors;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the descrition
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     * @param descrition the descrition to set
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    /**
     * @return Date return the release
     */
    public Date getRelease() {
        return release;
    }

    /**
     * @param release the release to set
     */
    public void setRelease(Date release) {
        this.release = release;
    }

    /**
     * @return Date return the runningTime
     */
    public Date getRunningTime() {
        return runningTime;
    }

    /**
     * @param runningTime the runningTime to set
     */
    public void setRunningTime(Date runningTime) {
        this.runningTime = runningTime;
    }

    /**
     * @return List<Director> return the directors
     */
    public List<Director> getDirectors() {
        return directors;
    }

    /**
     * @param directors the directors to set
     */
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, descrition, release, runningTime, directors);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", descrition='" + getDescrition() + "'" +
            ", release='" + getRelease() + "'" +
            ", runningTime='" + getRunningTime() + "'" +
            ", directors='" + getDirectors() + "'" +
            "}";
    }

}