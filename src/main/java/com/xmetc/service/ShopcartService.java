package com.xmetc.service;

import com.xmetc.entity.Shopcart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ShopcartService {

    int addShopcart(@Param("uid") int uid,
                    @Param("cid") int cid,
                    @Param("cnum") int cnum);

    int updateShopcartCnum(@Param("sid") int sid,
                           @Param("cnum") int cnum);

    int deleteShopcartById(int sid);

    List<Shopcart> findShopcart(int uid);

    int deleteShopcartByUid(int uid);


}
