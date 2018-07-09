package com.nader.aria.assistant.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {

    private PageInfo pageInfo;

    public PageInfo getPageInfo(){

        if( pageInfo == null ){
            pageInfo = new PageInfo();
        }
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo){
        this.pageInfo = pageInfo;
    }
}
