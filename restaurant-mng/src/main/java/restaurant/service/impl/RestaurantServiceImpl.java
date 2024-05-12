package restaurant.service.impl;

import restaurant.domain.Restaurant;
import restaurant.domain.dto.CreateRestaurantRequestDto;
import restaurant.domain.dto.CreateRestaurantResponsetDto;
import restaurant.domain.dto.GetRestaurantResponseDto;
import restaurant.repository.RestaurantRepository;
import restaurant.service.RestaurantService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import restaurant.service.converter.RestaurantConverter;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurantRepository restaurantRepository;

  @Override
  public GetRestaurantResponseDto findById(long restaurantId) {
    log.info("Received request for get restarant details with id" + restaurantId);
    var restaurant =
        restaurantRepository
            .findById(restaurantId)
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        "Restaurant does not exists for given id: " + restaurantId));
    return RestaurantConverter.mapEntityToDto(restaurant);
  }

  @Override
  @Transactional
  public CreateRestaurantResponsetDto createRestaurant(CreateRestaurantRequestDto requestDto) {
    log.info("Received request for create restaurant");

    Restaurant restaurant = RestaurantConverter.mapCreateRestaurantDtoToEntity(requestDto);
    var savedRestaurant = restaurantRepository.save(restaurant);
    return RestaurantConverter.mapEntityToCreateRestaurantResponseDto(savedRestaurant);
  }
}
