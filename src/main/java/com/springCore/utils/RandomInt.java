package com.springCore.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
@Qualifier("int")
public class RandomInt implements IRandomStringGenerator{
    @Override
    public String random() {
        Random random = new Random();
        int upperbound = 1000000;
        int intrandom =  random.nextInt(upperbound);
        return  String.valueOf(intrandom);
    }
}
