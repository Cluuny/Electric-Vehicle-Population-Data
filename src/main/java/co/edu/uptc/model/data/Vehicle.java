package co.edu.uptc.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String vin;
    private String county;
    private String state;
    private String city;
    private String manufacturer;
    private String model;
    private String electricRange;
}
