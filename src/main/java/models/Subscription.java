package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="subscription")
public class Subscription {
    @Id
    @Column(name="id")
    @GeneratedValue
    private String id;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    @ManyToOne
    @JoinColumn(name="magazine_id", referencedColumnName="id")
    private Magazine magazine;
    @Column(name="months_number")
    private Integer monthsNumber;
    @Column(name="subscription_date")
    private Date subscriptionDate;
    public Subscription() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public Integer getMonthsNumber() {
        return monthsNumber;
    }

    public void setMonthsNumber(Integer monthsNumber) {
        this.monthsNumber = monthsNumber;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(magazine, that.magazine) && Objects.equals(monthsNumber, that.monthsNumber) && Objects.equals(subscriptionDate, that.subscriptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, magazine, monthsNumber, subscriptionDate);
    }

    @Override
    public String toString() {
        return "Subscription [" + "id=" + id + ", user=" + user + ", magazine=" + magazine +
                ", monthsNumber=" + monthsNumber + ", subscriptionDate=" + subscriptionDate + ']';
    }
}
