package co.edu.uptc.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ElectricRangeCount {
    private String rangoElectrico;
    private int conteo;

    @Override
    public String toString() {
        return this.rangoElectrico + ": " + this.conteo;
    }
}
