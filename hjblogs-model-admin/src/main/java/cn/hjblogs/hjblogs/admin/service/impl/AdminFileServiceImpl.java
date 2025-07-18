package cn.hjblogs.hjblogs.admin.service.impl;

import cn.hjblogs.hjblogs.admin.model.vo.file.UploadFileRspVO;
import cn.hjblogs.hjblogs.admin.service.AdminFileService;
import cn.hjblogs.hjblogs.admin.utils.MinioUtil;
import cn.hjblogs.hjblogs.common.enums.ResponseCodeEnum;
import cn.hjblogs.hjblogs.common.exception.BizException;
import cn.hjblogs.hjblogs.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author JUHE
 * @version
 * 文件服务
 */
@Service
@Slf4j
public class AdminFileServiceImpl implements AdminFileService {

    @Autowired
    private MinioUtil minioUtil;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public Response uploadFile(MultipartFile file) {
        try {
            // 上传文件
            String url = minioUtil.uploadFile(file);

            // 构建成功返参，将图片的访问链接返回
            return Response.success(UploadFileRspVO.builder().url(url).build());
        } catch (Exception e) {
            log.error("==> 上传文件至 Minio 错误: ", e);
            // 手动抛出业务异常，提示 “文件上传失败”
            throw new BizException(ResponseCodeEnum.FILE_UPLOAD_FAILED);
        }
    }
}

