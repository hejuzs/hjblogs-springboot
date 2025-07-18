package cn.hjblogs.hjblogs.admin.service;

import cn.hjblogs.hjblogs.common.utils.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author JUHE
 * @version 1.0
 */
public interface AdminFileService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    Response uploadFile(MultipartFile file);
}

