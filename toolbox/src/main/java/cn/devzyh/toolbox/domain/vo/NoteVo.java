package cn.devzyh.toolbox.domain.vo;

import cn.devzyh.toolbox.domain.Note;

import java.io.Serializable;

/**
 * 笔记视图实体
 */
public class NoteVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Boolean success; // 是否成功
    private Boolean showDialog; // 是否弹窗
    private String message; // 错误消息
    private Note note; // 笔记数据

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void setSuccess(Note note) {
        this.success = true;
        this.message = "";
        this.note = note;
    }

    public void setError(String message) {
        this.success = false;
        this.message = message;
        Note n = new Note();
        n.setTitle(message);
        this.note = n;
    }

    public void setErrorWithDialog(String message) {
        setError(message);
        this.showDialog = true;
    }

    @Override
    public String toString() {
        return "NoteVo{" +
                "success=" + success +
                ", showDialog=" + showDialog +
                ", message='" + message + '\'' +
                ", note=" + note +
                '}';
    }
}
