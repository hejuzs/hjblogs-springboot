package cn.hjblogs.hjblogs.web.controller;

import cn.hjblogs.hjblogs.common.aspect.ApiOperationLog;
import cn.hjblogs.hjblogs.common.utils.Response;
import cn.hjblogs.hjblogs.web.model.vo.archive.FindArchiveArticlePageListReqVO;
import cn.hjblogs.hjblogs.web.service.ArchiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JUHE
 * @version 1.0
 */
@RestController
@Api(tags = "文章归档")
public class ArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @PostMapping("/archive/list")
    @ApiOperation(value = "获取文章归档分页数据")
    @ApiOperationLog(description = "获取文章归档分页数据")
    public Response findArchivePageList(@RequestBody FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO) {
        return archiveService.findArchivePageList(findArchiveArticlePageListReqVO);
    }

}

