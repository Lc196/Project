/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/25 16:48
 **/
package com.wip.service.teach;

import com.github.pagehelper.PageInfo;
import com.wip.dto.cond.ContentCond;
import com.wip.dto.cond.TeachCond;
import com.wip.model.ContentDomain;
import com.wip.model.MetaDomain;
import com.wip.model.TeachDomain;

import java.util.List;

/**
 * 教程相关Service接口
 */
public interface TeachService {

    /***
     * 添加教程
     * @param contentDomain
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
     * @param TeachDomain
     */
    void updateTeachById(TeachDomain teachDomain);

    /**
     * 根据条件获取教程列表
     * @param contentCond
     * @param page
     * @param limit
     * @return
     */
    PageInfo<TeachDomain> getTeachsByCond(TeachCond teachCond, int page, int limit);

    /**
     * 删除教程
     * @param tid
     */
    void deleteTeachById(Integer tid);

    /**
     * 添加教程点击量
     * @param content
     */
    void updateContentByTid(TeachDomain teach);

    /**
     * 通过分类获取教程
     * @param category
     * @return
     */
    List<TeachDomain> getTeachByCategory(String category);

    /**
     * 通过标签获取教程
     * @param tags
     * @return
     */
    List<TeachDomain> getTeachByTags(MetaDomain tags);
}
