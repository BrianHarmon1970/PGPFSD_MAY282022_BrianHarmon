package com.harmonengineering.beans;

import org.springframework.beans.factory.annotation.Value;

public class ConfiguredPortNumberBean
{
    @Value("${server.port}")
    public int serverPort ;
    public ConfiguredPortNumberBean() {} ;
    public String toString() {
        return "ConfiguredPortNumberBean"+this.hashCode();
    }
}

