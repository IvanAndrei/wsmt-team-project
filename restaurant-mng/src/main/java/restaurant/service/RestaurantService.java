package restaurant.service;

import restaurant.domain.dto.CreateRestaurantRequestDto;
import restaurant.domain.dto.CreateRestaurantResponsetDto;
import restaurant.domain.dto.GetRestaurantResponseDto;

public interface RestaurantService {

    GetRestaurantResponseDto findById(long restaurantId);
    CreateRestaurantResponsetDto createRestaurant(CreateRestaurantRequestDto requestDto);
}
