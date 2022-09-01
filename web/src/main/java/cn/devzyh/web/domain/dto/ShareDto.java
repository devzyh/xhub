package cn.devzyh.web.domain.dto;

import cn.devzyh.notebook.domain.NoteContent;

import java.io.Serializable;

/**
 * 笔记视图实体
 */
public class ShareDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Boolean success; // 是否成功
    private Boolean showDialog; // 是否弹窗
    private String inputSecret; // 输入的密码
    private String message; // 错误消息
    private NoteContent note; // 笔记数据

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

    public NoteContent getNote() {
        return note;
    }

    public void setNote(NoteContent note) {
        this.note = note;
    }

    public void setSuccess(NoteContent note) {
        this.success = true;
        this.message = "";
        this.note = note;
    }

    public void setError(String message) {
        this.success = false;
        this.message = message;
        NoteContent n = new NoteContent();
        n.setTitle(message);
        this.note = n;
    }

    public void setSuccessWithDialog(String message) {
        this.success = true;
        this.message = message;
        NoteContent n = new NoteContent();
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
