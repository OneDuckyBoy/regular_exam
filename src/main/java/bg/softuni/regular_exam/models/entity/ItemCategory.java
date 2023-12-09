package bg.softuni.regular_exam.models.entity;

import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class ItemCategory extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private UserRoleEnum category;

    @OneToOne(mappedBy = "category")

    private  ItemEntity item;
}
