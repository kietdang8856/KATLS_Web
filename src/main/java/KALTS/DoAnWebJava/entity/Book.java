package KALTS.DoAnWebJava.entity;

import KALTS.DoAnWebJava.Validator.annotation.ValidCategoryId;
import KALTS.DoAnWebJava.Validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title không được để trống")
    @Column(name="title")
    private String title;

    @NotBlank(message = "Tên tác giả không được để trống")
    @Column(name="author")
    private String author;

    @NotNull(message = "Giá sách không được để trống")
    @Column(name="price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}
