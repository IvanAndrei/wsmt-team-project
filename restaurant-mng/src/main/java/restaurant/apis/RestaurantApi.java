package restaurant.apis;

import restaurant.domain.dto.CreateRestaurantRequestDto;
import restaurant.domain.dto.CreateRestaurantResponsetDto;
import restaurant.domain.dto.GetRestaurantResponseDto;
import restaurant.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class RestaurantApi {

  public static final String RESTAURANT_MANAGEMENT = "/restaurant-management/";
  private final RestaurantService restaurantService;

  @GetMapping(RESTAURANT_MANAGEMENT + "{restaurantId}")
  @ResponseStatus(HttpStatus.OK)
  public GetRestaurantResponseDto getRestaurantDetailsById(@PathVariable Long restaurantId) {
    log.info("Received request for get restarant details with id" + restaurantId);
    return restaurantService.findById(restaurantId);
  }

  @PostMapping(RESTAURANT_MANAGEMENT + "create-restaurant")
  @ResponseStatus(HttpStatus.CREATED)
  public CreateRestaurantResponsetDto createRestaurant(
      @Valid @RequestBody CreateRestaurantRequestDto createRestaurantRequestDto) {
    log.info("Received request for create restaurant {}", createRestaurantRequestDto);
    return restaurantService.createRestaurant(createRestaurantRequestDto);
  }
}
