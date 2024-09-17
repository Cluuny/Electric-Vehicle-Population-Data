package co.edu.uptc.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StateCount {
    String state;
    int count;

    public void incrementCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return this.state + ": " + this.count;
    }
}