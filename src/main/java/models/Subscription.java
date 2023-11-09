package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@jakarta.persistence.Entity
@Entity
@Table(name="subscription")
public class Subscription {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Id
    @Column(name="id")
    @GeneratedValue
    @jakarta.persistence.Column(name = "id", nullable = false, length = 255)
    private String id;
    @jakarta.persistence.Basic
    @Column(name="months_number")
    @jakarta.persistence.Column(name = "months_number", nullable = false)
    private Integer monthsNumber;
    @jakarta.persistence.Basic
    @Column(name="subscription_date")
    @jakarta.persistence.Column(name = "subscription_date", nullable = false)
    private Date subscriptionDate;
    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "user_id", nullable = false)
    private int userId;
    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "magazine_id", nullable = false)
    private int magazineId;

    public Subscription() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMonthsNumber() {
        return monthsNumber;
    }

    public void setMonthsNumber(int monthsNumber) {
        this.monthsNumber = monthsNumber;
    }

    public void setMonthsNumber(Integer monthsNumber) {
        this.monthsNumber = monthsNumber;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Timestamp subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(magazineId, that.magazineId) && Objects.equals(monthsNumber, that.monthsNumber) && Objects.equals(subscriptionDate, that.subscriptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, magazineId, monthsNumber, subscriptionDate);
    }

    @Override
    public String toString() {
        return "Subscription [" + "id=" + id + ", user=" + userId + ", magazine=" + magazineId +
                ", monthsNumber=" + monthsNumber + ", subscriptionDate=" + subscriptionDate + ']';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(int magazineId) {
        this.magazineId = magazineId;
    }
}
