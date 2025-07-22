package org.khazar.msRestaurant.service;

import org.khazar.msRestaurant.model.request.CreateRestaurantRequest;
import org.khazar.msRestaurant.model.response.RestaurantResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface RestaurantService {

    void createRestaurant(CreateRestaurantRequest createRestaurantRequest);

    RestaurantResponse getRestaurantById(Long id);

    void deleteRestaurantById(Long id);

    Page<RestaurantResponse> getAllRestaurants(Pageable pageable);
}
