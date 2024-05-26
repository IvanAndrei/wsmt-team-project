package restaurant.domain.dto;

import restaurant.domain.RestaurantMenu;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetRestaurantResponseDto {

    private String name;
    private Address address;
    private RestaurantMenu menu;
}
