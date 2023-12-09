package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "news")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsEntity extends BaseEntity{
    private String name;
}
