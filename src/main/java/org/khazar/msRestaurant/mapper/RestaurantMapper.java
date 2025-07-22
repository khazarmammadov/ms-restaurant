package org.khazar.msRestaurant.mapper;

import lombok.experimental.UtilityClass;
import org.khazar.msRestaurant.dao.entity.RestaurantEntity;
import org.khazar.msRestaurant.model.request.CreateRestaurantRequest;
import org.khazar.msRestaurant.model.response.RestaurantResponse;

@UtilityClass
public class RestaurantMapper {

    public RestaurantEntity toRestaurantEntity(CreateRestaurantRequest createRestaurantRequest) {
        return RestaurantEntity.builder()
                .name(createRestaurantRequest.getName())
                .address(createRestaurantRequest.getAddress())
                .city(createRestaurantRequest.getCity())
                .category(createRestaurantRequest.getCategory())
                .isOpen(Boolean.TRUE)
                .build();
    }

    public RestaurantResponse toRestaurantResponse(RestaurantEntity restaurantEntity) {
        return RestaurantResponse.builder()
                .id(restaurantEntity.getId().toString())
                .name(restaurantEntity.getName())
                .address(restaurantEntity.getAddress())
                .city(restaurantEntity.getCity())
                .isOpen(restaurantEntity.getIsOpen())
                .category(restaurantEntity.getCategory().toString())
                .build();
    }

}
