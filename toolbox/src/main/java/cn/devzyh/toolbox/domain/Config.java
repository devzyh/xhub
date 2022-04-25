package cn.devzyh.toolbox.domain;

/**
 * 配置表
 */
public class Config {

    private String item; // 分类
    private String name; // 名称
    private String value; // 数值
    private Integer seq; // 排序

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
