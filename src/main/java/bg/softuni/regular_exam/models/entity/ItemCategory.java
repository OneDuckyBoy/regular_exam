package bg.softuni.regular_exam.models.entity;

import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCategory extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoriesEnum category;

    @OneToOne(mappedBy = "category")

    private  ItemEntity item;
}
