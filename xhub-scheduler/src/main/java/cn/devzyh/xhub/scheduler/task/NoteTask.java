package cn.devzyh.xhub.scheduler.task;

import cn.devzyh.xhub.notebook.domain.NoteContent;
import cn.devzyh.xhub.notebook.service.INoteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Web模块任务
 *
 * @author devzyh
 */
@Component("noteTask")
public class NoteTask {

    @Autowired
    INoteContentService contentService;

    /**
     * 保存昨天更新的笔记内容
     */
    public void saveYesterdayContents() {
        List<NoteContent> contentList = contentService.selectYesterdayContents();
        for (NoteContent content : contentList) {
            contentService.updateNoteContent(content, false);
        }
    }
}
