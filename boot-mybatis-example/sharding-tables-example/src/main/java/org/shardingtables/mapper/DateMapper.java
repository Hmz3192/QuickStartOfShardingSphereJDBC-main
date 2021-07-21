package org.shardingtables.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.shardingtables.domain.Tdate;
import org.shardingtables.domain.User;

import java.util.List;

@Mapper
public interface DateMapper {

    /**
     * insert a lone of data
     *
     * @param record message of user
     * @author: Jieker
     **/
    int insert(Tdate record);

    /**
     * select all of data
     *
     * @author: Jieker
     *
     * @param date
     * @param endDate*/
    List<Tdate> showAll(@Param("date") String date, @Param("endDate") String endDate);

    /**
     * delete a user
     *
     * @param id userId
     * @author: Jieker
     **/
    void deleteUser(Long id);
}