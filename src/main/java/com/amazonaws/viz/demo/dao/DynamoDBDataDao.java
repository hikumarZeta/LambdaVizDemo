

package com.amazonaws.viz.demo.dao;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.viz.demo.domain.Data;
import com.amazonaws.viz.demo.manager.DynamoDBManager;

import org.apache.log4j.Logger;

import java.util.*;


public class DynamoDBDataDao implements DataDao {

    private static final Logger log = Logger.getLogger(DynamoDBDataDao.class);

    private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

    private static volatile DynamoDBDataDao instance;


    private DynamoDBDataDao() { }

    public static DynamoDBDataDao instance() {

        if (instance == null) {
            synchronized(DynamoDBDataDao.class) {
                if (instance == null)
                    instance = new DynamoDBDataDao();
            }
        }
        return instance;
    }

    @Override
    public List<Data> findAll() {
        return mapper.scan(Data.class, new DynamoDBScanExpression());
    }

    @Override
    public void saveOrUpdate(Data event) {

        mapper.save(event);
    }

    @Override
    public void delete(String type) {
        //todo
    }
}
