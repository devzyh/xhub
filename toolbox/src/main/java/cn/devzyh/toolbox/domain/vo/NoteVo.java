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
    private String inputSecret; // 输入的密码
    private String message; // 错误消息
    private Note note; // 笔记数据

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getShowDialog() {
        return showDialog;
    }

    public void setShowDialog(Boolean showDialog) {
        this.showDialog = showDialog;
    }

    public String getInputSecret() {
        return inputSecret;
    }

    public void setInputSecret(String inputSecret) {
        this.inputSecret = inputSecret;
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

    public void setSuccessWithDialog(String message) {
        this.success = true;
        this.message = message;
        Note n = new Note();
        n.setTitle(message);
        this.note = n;
        this.showDialog = true;
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
                ", inputSecret='" + inputSecret + '\'' +
                ", message='" + message + '\'' +
                ", note=" + note +
                '}';
    }
}
