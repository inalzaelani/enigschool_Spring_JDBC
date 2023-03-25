package com.springCore.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Qualifier("uuid")
public class uuIdGenerator implements IRandomStringGenerator{
    @Override
    public String random() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
