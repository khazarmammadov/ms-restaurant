package org.khazar.msRestaurant.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.khazar.msRestaurant.dao.entity.RestaurantEntity;
import org.khazar.msRestaurant.exception.NotFoundException;
import org.khazar.msRestaurant.mapper.RestaurantMapper;
import org.khazar.msRestaurant.model.request.CreateRestaurantRequest;
import org.khazar.msRestaurant.model.response.RestaurantResponse;
import org.khazar.msRestaurant.repository.RestaurantRepository;
import org.khazar.msRestaurant.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public void createRestaurant(CreateRestaurantRequest request) {

        log.info("Action.createRestaurant.start - request: = {}", request);
        var entity = RestaurantMapper.toRestaurantEntity(request);
        restaurantRepository.save(entity);
        log.info("Action.createRestaurant.end - restaurantId: = {}", entity.getId());

    }

    @Override
    public RestaurantResponse getRestaurantById(Long id) {
        System.out.println("slm");
        log.info("Action.getRestaurantById.start - id: = {}", id);
        var entity = restaurantRepository.findById(id)
                .orElseThrow(
                        () -> {
                            log.info("Action.getRestaurantById.error - id: = {}", id);
                            return new NotFoundException("Restaurant not found with id:" + id);
                        }
                );

        log.info("Action.getRestaurant.end - restaurantId: = {}", entity.getId());

        System.out.println("slm");

        return RestaurantMapper.toRestaurantResponse(entity);
    }

    @Override
    public void deleteRestaurantById(Long id) {
        log.info("Action.deleteRestaurant.start - id: = {}", id);
        var entity = restaurantRepository.findById(id)
                .orElseThrow(
                        () -> {
                            log.info("Action.getRestaurantById.error - id: = {}", id);
                            return new NotFoundException("Restaurant not found with id:" + id);
                        }
                );
        restaurantRepository.delete(entity);
        log.info("Action.deleteRestaurant.end - restaurantId: = {}", entity.getId());
    }

    @Override
    public Page<RestaurantResponse> getAllRestaurants(Pageable pageable) {
        log.info("Action.getAllRestaurants.start");
        var allRestaurants = restaurantRepository.findAll(pageable);
        log.info("Action.getAllRestaurants.end");
        return allRestaurants.map(RestaurantMapper::toRestaurantResponse);
    }

}
