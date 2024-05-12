package restaurant.service.converter;

import restaurant.domain.Restaurant;
import restaurant.domain.dto.CreateRestaurantRequestDto;
import restaurant.domain.dto.CreateRestaurantResponsetDto;
import restaurant.domain.dto.GetRestaurantResponseDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RestaurantConverter {
  public static Restaurant mapCreateRestaurantDtoToEntity(
      CreateRestaurantRequestDto createRestaurantRequestDto) {
    var restaurant = new Restaurant();
    restaurant.setName(createRestaurantRequestDto.getName());
    restaurant.setMenu(createRestaurantRequestDto.getMenu());
    return restaurant;
  }

  public static GetRestaurantResponseDto mapEntityToDto(Restaurant restaurant) {
    var restaurantMenu = restaurant.getMenu();
    restaurantMenu.setMenuItems(restaurant.getMenu().getMenuItems());
    return GetRestaurantResponseDto.builder()
        .name(restaurant.getName())
        .menu(restaurantMenu)
        .build();
  }

  public static CreateRestaurantResponsetDto mapEntityToCreateRestaurantResponseDto(
      Restaurant restaurant) {
    return CreateRestaurantResponsetDto.builder()
        .restaurantId(restaurant.getId())
        .name(restaurant.getName())
        .build();
  }
}
