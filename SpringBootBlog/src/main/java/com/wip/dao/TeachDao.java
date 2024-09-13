/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/25 16:50
 **/
package com.wip.dao;

import com.wip.dto.cond.TeachCond;
import com.wip.model.RelationShipDomain;
import com.wip.model.TeachDomain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 教程相关Dao接口
 */
@Mapper
public interface TeachDao {

    /**
     * 添加教程
     * @param TeachDomain
     */
    void addTeach(TeachDomain teachDomain);

    /**
     * 根据编号获取教程
     * @param tid
     * @return
     */
    TeachDomain getTeachById(Integer tid);

    /**
     * 更新教程
     * @param teachDomain
     */
    void updateTeachById(TeachDomain teachDomain);

    /**
     * 根据条件获取教程列表
     * @param TeachCond
     * @return
     */
    List<TeachDomain> getTeachByCond(TeachCond teachCond);

    /**
     * 删除教程
     * @param tid
     */
    void deleteTeachById(Integer tid);

    /**
     * 获取教程总数
     * @return
     */
    Long getTeachCount();

    /**
     * 通过分类名获取教程
     * @param category
     * @return
     */
    List<TeachDomain> getTeachByCategory(@Param("category") String category);

    /**
     * 通过标签获取教程
     * @param cid
     * @return
     */
    List<TeachDomain> getTeachByTags(List<RelationShipDomain> tid);
}
