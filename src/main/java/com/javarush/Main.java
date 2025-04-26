package com.javarush;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.RedisClient;
import org.hibernate.SessionFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gut
public class Main {

    private final SessionFactory sessionFactory;
    private final RedisClient redisClient;

    private final ObjectMapper mapper;

    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;

    public Main() {
        sessionFactory = prepareRelationalDb();
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);

        redisClient = prepareRedisClient();
        mapper = new ObjectMapper();
    }




    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.



    }
}