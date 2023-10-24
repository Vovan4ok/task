package models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Subscription {
    private Integer id;
    private Integer userId;
    private Integer magazineId;
    private Integer monthsNumber;
    private Date subscriptionDate;

    public Subscription(Integer id, Integer userId, Integer magazineId, Integer monthsNumber, Date subscriptionDate) {
        this.id = id;
        this.userId = userId;
        this.magazineId = magazineId;
        this.monthsNumber = monthsNumber;
        this.subscriptionDate = subscriptionDate;
    }

    public Subscription(Integer userId, Integer magazineId, Integer monthsNumber, Date subscriptionDate) {
        this.userId = userId;
        this.magazineId = magazineId;
        this.monthsNumber = monthsNumber;
        this.subscriptionDate = subscriptionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(Integer magazineId) {
        this.magazineId = magazineId;
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
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(magazineId, that.magazineId) && Objects.equals(monthsNumber, that.monthsNumber) && Objects.equals(subscriptionDate, that.subscriptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, magazineId, monthsNumber, subscriptionDate);
    }

    @Override
    public String toString() {
        return "Subscription [" + "id=" + id + ", userId=" + userId + ", magazineId=" + magazineId +
                ", monthsNumber=" + monthsNumber + ", subscriptionDate=" + subscriptionDate + ']';
    }
}
