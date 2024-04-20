package bg.softuni.regular_exam.models.entity;

import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCategory extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoriesEnum category;

    @OneToMany(mappedBy = "category")

    private List<ItemEntity> item;

    public CategoriesEnum getCategory() {
        return category;
    }

    public void setCategory(CategoriesEnum category) {
        this.category = category;
    }

    public List<ItemEntity> getItem() {
        return item;
    }

    public void setItem(List<ItemEntity> item) {
        this.item = item;
    }
}
