package restaurant.domain;

import common.MenuItem;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.List;


@Embeddable
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RestaurantMenu {

    @ElementCollection
    private List<MenuItem> menuItems;
}