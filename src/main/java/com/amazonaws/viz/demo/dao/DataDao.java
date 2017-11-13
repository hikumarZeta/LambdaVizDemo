
package com.amazonaws.viz.demo.dao;


import java.util.List;

import com.amazonaws.viz.demo.domain.Data;


public interface DataDao {

    List<Data> findAll();

    void saveOrUpdate(Data data);

    void delete(String type);

}
