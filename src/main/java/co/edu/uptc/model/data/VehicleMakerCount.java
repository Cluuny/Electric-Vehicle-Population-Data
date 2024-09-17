package co.edu.uptc.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleMakerCount {
    private String fabricante;
    private int conteo;

    @Override
    public String toString() {
        return this.fabricante + ": " + this.conteo;
    }
}
