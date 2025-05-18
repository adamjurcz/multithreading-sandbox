package org.put.lesson3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncrementNonSync {
    private int number;

    public void increment() {
        number++;
    }
}
