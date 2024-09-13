package com.wip.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wip.constant.LogActions;
import com.wip.constant.Types;
import com.wip.controller.BaseController;
import com.wip.dto.cond.ContentCond;
import com.wip.dto.cond.MetaCond;
import com.wip.dto.cond.TeachCond;
import com.wip.model.ContentDomain;
import com.wip.model.MetaDomain;
import com.wip.model.TeachDomain;
import com.wip.service.article.ContentService;
import com.wip.service.log.LogService;
import com.wip.service.meta.MetaService;
import com.wip.service.teach.TeachService;
import com.wip.utils.APIResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api("教程管理")
@Controller
@RequestMapping("/admin/teach")
public class TeachController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeachController.class);

    @Autowired
    private MetaService metaService;

    @Autowired
    private TeachService teachService;

    @Autowired
    private LogService logService;

    @ApiOperation("教程页")
    @GetMapping(value = "")
    public String index(
            HttpServletRequest request,
            @ApiParam(name = "page", value = "页数", required = false)
            @RequestParam(name = "page", required = false, defaultValue = "1")
            int page,
            @ApiParam(name = "limit", value = "每页数量", required = false)
            @RequestParam(name = "limit", required = false, defaultValue = "15")
            int limit
    ) {
        PageInfo<TeachDomain> articles = teachService.getTeachsByCond(new TeachCond(), page, limit);
        request.setAttribute("articles",articles);
        return "admin/teach_list";
    }

    @ApiOperation("发布新教程页")
    @GetMapping(value = "/teach_publish")
    public String newArticle(HttpServletRequest request) {
        MetaCond metaCond = new MetaCond();
        metaCond.setType(Types.CATEGORY.getType());
        //List<MetaDomain> metas = metaService.getMetas(“category”);

//        MetaCond metaCond = new MetaCond();
//        metaCond.setType(Types.CATEGORY.getType());
//        List<MetaDomain> metas = metaService.getMetas(metaCond);

        List<MetaDomain> metas = metaService.getMetas(metaCond);
        request.setAttribute("categories",metas);
        return "admin/teach_edit";
    }

    @ApiOperation("教程编辑页")
    @GetMapping(value = "/{tid}")
    public String editArticle(
            @ApiParam(name = "tid", value = "教程编号", required = true)
            @PathVariable
            Integer tid,
            HttpServletRequest request
    ) {
        TeachDomain teach = teachService.getTeachById(tid);
        request.setAttribute("teachs", teach);
        MetaCond metaCond = new MetaCond();
        metaCond.setType(Types.CATEGORY.getType());
        List<MetaDomain> categories = metaService.getMetas(metaCond);
        request.setAttribute("categories", categories);
        request.setAttribute("active", "teach");
        return "admin/teach_edit";
    }

    @ApiOperation("编辑保存教程")
    @PostMapping("/modify")
    @ResponseBody
    public APIResponse modifyArticle(
            HttpServletRequest request,
            @ApiParam(name = "tid", value = "教程主键", required = true)
            @RequestParam(name = "tid", required = true)
            Integer tid,
            @ApiParam(name = "title", value = "标题", required = true)
            @RequestParam(name = "title", required = true)
            String title,
            @ApiParam(name = "titlePic", value = "标题图片", required = false)
            @RequestParam(name = "titlePic", required = false)
            String titlePic,
            @ApiParam(name = "slug", value = "内容缩略名", required = false)
            @RequestParam(name = "slug", required = false)
            String slug,
            @ApiParam(name = "content", value = "内容", required = true)
            @RequestParam(name = "content", required = true)
            String content,
            @ApiParam(name = "type", value = "教程类型", required = true)
            @RequestParam(name = "type", required = true)
            String type,
            @ApiParam(name = "status", value = "教程状态", required = true)
            @RequestParam(name = "status", required = true)
            String status,
            @ApiParam(name = "tags", value = "标签", required = false)
            @RequestParam(name = "tags", required = false)
            String tags,
            @ApiParam(name = "categories", value = "分类", required = false)
            @RequestParam(name = "categories", required = false, defaultValue = "默认分类")
            String categories,
            @ApiParam(name = "allowComment", value = "是否允许评论", required = true)
            @RequestParam(name = "allowComment", required = true)
            Boolean allowComment
    ) {
        TeachDomain teachDomain = new TeachDomain();
        teachDomain.setTitle(title);
        teachDomain.setTid(tid);
        teachDomain.setTitlePic(titlePic);
        teachDomain.setSlug(slug);
        teachDomain.setContent(content);
        teachDomain.setType(type);
        teachDomain.setStatus(status);
        teachDomain.setTags(tags);
        teachDomain.setCategories(categories);
        teachDomain.setAllowComment(allowComment ? 1: 0);
        teachService.updateTeachById(teachDomain);

        return APIResponse.success();
    }


    @ApiOperation("发布新教程")
    @PostMapping(value = "/publish")
    @ResponseBody
    public APIResponse publishArticle(
            @ApiParam(name = "title", value = "标题", required = true)
            @RequestParam(name = "title", required = true)
            String title,
            @ApiParam(name = "titlePic", value = "标题图片", required = false)
            @RequestParam(name = "titlePic", required = false)
            String titlePic,
            @ApiParam(name = "slug", value = "内容缩略名", required = false)
            @RequestParam(name = "slug", required = false)
            String slug,
            @ApiParam(name = "content", value = "内容", required = true)
            @RequestParam(name = "content", required = true)
            String content,
            @ApiParam(name = "type", value = "教程类型", required = true)
            @RequestParam(name = "type", required = true)
            String type,
            @ApiParam(name = "status", value = "教程状态", required = true)
            @RequestParam(name = "status", required = true)
            String status,
            @ApiParam(name = "categories", value = "教程分类", required = false)
            @RequestParam(name = "categories", required = false, defaultValue = "默认分类")
            String categories,
            @ApiParam(name = "tags", value = "教程标签", required = false)
            @RequestParam(name = "tags", required = false)
            String tags,
            @ApiParam(name = "allowComment", value = "是否允许评论", required = true)
            @RequestParam(name = "allowComment", required = true)
            Boolean allowComment
    ) {
        TeachDomain teachDomain = new TeachDomain();
        teachDomain.setTitle(title);
        teachDomain.setTitlePic(titlePic);
        teachDomain.setSlug(slug);
        teachDomain.setContent(content);
        teachDomain.setType(type);
        teachDomain.setStatus(status);
        teachDomain.setHits(1);
        teachDomain.setCommentsNum(0);
        // 只允许博客教程有分类，防止作品被收入分类
        teachDomain.setTags(type.equals(Types.ARTICLE.getType()) ? tags : null);
        teachDomain.setCategories(type.equals(Types.ARTICLE.getType()) ? categories : null);
        teachDomain.setAllowComment(allowComment ? 1 : 0);

        // 添加教程
        teachService.addTeach(teachDomain);

        return APIResponse.success();
    }
    //jp1
    //jobcenter
    @ApiOperation("删除教程")
    @PostMapping("/delete")
    @ResponseBody
    public APIResponse deleteArticle(
            @ApiParam(name = "tid", value = "教程ID", required = true)
            @RequestParam(name = "tid", required = true)
            Integer tid,
            HttpServletRequest request
    ) {
        // 删除教程
        teachService.deleteTeachById(tid);
        // 写入日志
        logService.addLog(LogActions.DEL_ARTICLE.getAction(), tid+"",request.getRemoteAddr(),this.getUid(request));
        return APIResponse.success();
    }


}
