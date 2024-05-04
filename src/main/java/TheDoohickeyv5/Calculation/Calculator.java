package TheDoohickeyv5.Calculation;

import java.util.Collection;

public abstract class Calculator<T> {
    Collection<T> data;

    public Calculator(Collection<T> data){
        this.data = data;
    }

    abstract double calculate();
}
