
package com.amazonaws.viz.demo.function;


import java.util.List;

import com.amazonaws.viz.demo.dao.DynamoDBDataDao;
import com.amazonaws.viz.demo.domain.Data;

import org.apache.log4j.Logger;


public class DataFunctions {

    private static final Logger log = Logger.getLogger(DataFunctions.class);

    private static final DynamoDBDataDao dataDao = DynamoDBDataDao.instance();


    public List<Data> getAllDatasHandler() {

        log.info("GetAllDatas invoked to scan table for ALL datas");
        List<Data> datas = dataDao.findAll();
        log.info("Found " + datas.size() + " total datas.");
        return datas;
    }


    public void saveOrUpdateData(Data data) {

        if (null == data) {
            log.error("SaveData received null input");
            throw new IllegalArgumentException("Cannot save null object");
        }

        log.info("Saving or updating data for");
        dataDao.saveOrUpdate(data);
        log.info("Successfully saved/updated data");
    }

    public void deleteData(Data data) {

      //to do
    }

}
