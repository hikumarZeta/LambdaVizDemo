
package com.amazonaws.viz.demo.domain;


import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.io.Serializable;


@DynamoDBTable(tableName = "skunkworks2017-wheel1")
public class Data implements Serializable {

    private static final long serialVersionUID = -8243145429438016232L;

    @DynamoDBAttribute(attributeName="Name")
    private String type;

    @DynamoDBAttribute(attributeName="NUM")
    private Long count;


    public Data() { }


    public Data(String type, Long count) {
        super();
        this.type = type;
        this.count = count;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Long getCount() {
        return count;
    }


    public void setCount(Long count) {
        this.count = count;
    }

 
}
