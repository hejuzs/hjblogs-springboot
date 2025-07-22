package cn.hjblogs.hjblogs.admin.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author JUHE
 * @version 1.0
 */
@Getter
public class UpdateArticleEvent extends ApplicationEvent {

    /**
     * 文章 ID
     */
    private Long articleId;

    public UpdateArticleEvent(Object source, Long articleId) {
        super(source);
        this.articleId = articleId;
    }
}
