package cn.hjblogs.hjblogs.admin.model.vo.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JUHE
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadFileRspVO {

    /**
     * 文件的访问链接
     */
    private String url;

}

