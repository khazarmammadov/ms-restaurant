package org.khazar.msRestaurant.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantResponse {

    private String id;
    private String name;
    private String address;
    private String city;
    private String category;
    private Boolean isOpen;
}
