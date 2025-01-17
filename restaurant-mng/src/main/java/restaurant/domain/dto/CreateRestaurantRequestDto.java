package restaurant.domain.dto;

import restaurant.domain.RestaurantMenu;
import common.Address;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantRequestDto {

    private String name;
    private Address address;
    private RestaurantMenu menu;
}
