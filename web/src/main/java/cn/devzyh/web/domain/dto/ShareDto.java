package cn.devzyh.web.domain.dto;

import cn.devzyh.notebook.domain.NoteContent;

import java.io.Serializable;

/**
 * 分享内容数据传输对象
 */
public class ShareDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean success; // 验证成功
    private boolean showInput; // 显示输入框
    private String inputSecret; // 输入的密码
    private String message; // 错误消息
    private NoteContent note; // 笔记数据

    public Boolean isSuccess() {
        return success;
    }

    public Boolean getShowInput() {
        return showInput;
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

    public NoteContent getNote() {
        return note;
    }

    public static ShareDto success(NoteContent note) {
        ShareDto dto = new ShareDto();
        dto.success = true;
        dto.note = note;
        return dto;
    }

    public static ShareDto error(String message) {
        ShareDto dto = new ShareDto();
        dto.message = message;
        return dto;
    }

    public static ShareDto errorWithInput(String message) {
        return errorWithInput(message, null);
    }

    public static ShareDto errorWithInput(String message, String inputSecret) {
        ShareDto dto = new ShareDto();
        dto.message = message;
        dto.showInput = true;
        dto.inputSecret = inputSecret;
        return dto;
    }
}
