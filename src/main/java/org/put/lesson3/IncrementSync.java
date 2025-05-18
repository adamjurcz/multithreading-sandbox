package org.put.lesson3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncrementSync {
    private int number;
    private static int staticNumber;

    public synchronized void synchronizedMethodIncrement() {
        number++;
    }

    public void synchronizedBlockIncrement() {
        synchronized (this) {
            number++;
        }
    }

    public static void synchronizedStaticBlockIncrement() {
        synchronized (IncrementSync.class) {
            staticNumber++;
        }
    }

    public static synchronized void synchronizedStaticMethodIncrement() {
        staticNumber++;
    }
}
