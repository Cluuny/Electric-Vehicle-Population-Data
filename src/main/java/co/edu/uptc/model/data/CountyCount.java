package co.edu.uptc.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CountyCount {
    private String state;
    private String county;
    private int count;

    @Override
    public String toString() {
        return this.state + ": " + this.count;
    }
}
