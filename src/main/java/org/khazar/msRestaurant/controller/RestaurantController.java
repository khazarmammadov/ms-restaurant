package org.khazar.msRestaurant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.khazar.msRestaurant.model.request.CreateRestaurantRequest;
import org.khazar.msRestaurant.model.response.RestaurantResponse;
import org.khazar.msRestaurant.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody @Valid CreateRestaurantRequest createRestaurantRequest) {
        System.out.println("slm");
        restaurantService.createRestaurant(createRestaurantRequest);
    }

    @GetMapping()
    public Page<RestaurantResponse> getAllRestaurants(Pageable pageable) {
        return restaurantService.getAllRestaurants(pageable);
    }

    @GetMapping("/{id}")
    public RestaurantResponse getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurantById(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
    }

}
