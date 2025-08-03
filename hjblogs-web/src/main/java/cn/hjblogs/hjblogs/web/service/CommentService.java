package cn.hjblogs.hjblogs.web.service;

import cn.hjblogs.hjblogs.common.utils.Response;
import cn.hjblogs.hjblogs.web.model.vo.comment.FindQQUserInfoReqVO;

/**
 * @author JUHE
 * @version 1.0
 */
public interface CommentService {

    /**
     * 根据 QQ 号获取用户信息
     * @param findQQUserInfoReqVO
     * @return
     */
    Response findQQUserInfo(FindQQUserInfoReqVO findQQUserInfoReqVO);

}

