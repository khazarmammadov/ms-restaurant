package org.khazar.msRestaurant.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.khazar.msRestaurant.mapper.RestaurantMapper;
import org.khazar.msRestaurant.model.enums.CategoryType;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotNull(message = "Can not be null")
    private CategoryType category;

}
