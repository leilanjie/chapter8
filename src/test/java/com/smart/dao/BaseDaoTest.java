package com.smart.dao;

import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;

import java.sql.SQLOutput;

@SpringApplicationContext({"xiaochun-dao.xml"})
public class BaseDaoTest extends UnitilsTestNG {

    public static void main(String[] args){
        System.out.println("lalala");
    }

}
