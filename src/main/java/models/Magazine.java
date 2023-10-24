package models;

import java.util.Objects;

public class Magazine {
    private Integer id;
    private String name;
    private String description;
    private String author;
    private Integer price;

    public Magazine(Integer id, String name, String description, String author, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.price = price;
    }

    public Magazine(String name, String description, String author, Integer price) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(id, magazine.id) && Objects.equals(name, magazine.name) && Objects.equals(description, magazine.description) && Objects.equals(author, magazine.author) && Objects.equals(price, magazine.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, author, price);
    }

    @Override
    public String toString() {
        return "Magazine [" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' +
                ", author='" + author + '\'' + ", price=" + price + ']';
    }
}
