package com.govtech.stepdefs;

import com.govtecg.util.ConfigReader;

import java.util.Properties;

public class BaseStepDef {

    protected Properties prop;

    public BaseStepDef () {
        prop = ConfigReader.initializeProperties();
    }
}
