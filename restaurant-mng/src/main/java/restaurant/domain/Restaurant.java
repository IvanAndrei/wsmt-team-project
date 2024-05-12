package restaurant.domain;

import common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurant")
@Access(AccessType.FIELD)
@Getter
@Setter
@EqualsAndHashCode
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Embedded
    private RestaurantMenu menu;
}


