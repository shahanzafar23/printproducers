package com.printer.producer;

import java.util.List;
import java.util.Random;

public class FiveSumSeqProducer extends Producer {
    public FiveSumSeqProducer(List<Integer> s) {
        super(s);
    }

    @Override
    public int produceNum(int num) {
        System.out.println("Produced number: " + (num + 5));
        return num + 5;
    }

    @Override
    public int getInternal() {
        return new Random().nextInt(3000);
    }
}
