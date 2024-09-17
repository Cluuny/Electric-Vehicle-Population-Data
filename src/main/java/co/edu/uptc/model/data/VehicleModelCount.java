package co.edu.uptc.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleModelCount {
    private String modelo;
    private int conteo;

    @Override
    public String toString() {
        return this.modelo + ": " + this.conteo;
    }
}
