package za.ac.nwu.logic.flow.impl;

public class Modulo {
    public Integer doMod(int dividend, int divisor){
        if (divisor == 0) {
            throw  new RuntimeException("Some reason for this?????");
        }
        return dividend % divisor;

    }
}
