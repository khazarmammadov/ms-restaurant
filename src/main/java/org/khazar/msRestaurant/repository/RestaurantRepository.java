package org.khazar.msRestaurant.repository;

import org.khazar.msRestaurant.dao.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {


}
