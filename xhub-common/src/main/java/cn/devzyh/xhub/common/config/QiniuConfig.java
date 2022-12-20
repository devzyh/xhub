package cn.devzyh.xhub.common.config;

import cn.devzyh.xhub.common.utils.StringUtils;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 七牛云相关配置
 *
 * @author devzyh
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiniuConfig {

    /**
     * 服务地址
     */
    private String url = "";

    /**
     * 秘钥
     */
    private String accessKey = "";

    /**
     * 密码
     */
    private String secretKey = "";

    /**
     * 地区
     */
    private String zone = "";

    /**
     * 存储桶
     */
    private String bucketName = "";

    private static boolean inited = false;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public static boolean isInited() {
        return inited;
    }

    /**
     * 初始化配置
     */
    @Bean
    public com.qiniu.storage.Configuration configuration() {
        // 初始化验证
        if (StringUtils.isBlank(zone) || StringUtils.isBlank(accessKey) || StringUtils.isBlank(secretKey)) {
            inited = false;
            return null;
        }

        inited = true;
        switch (zone) {
            case "huadong":
                return new com.qiniu.storage.Configuration(Region.huadong());
            case "huabei":
                return new com.qiniu.storage.Configuration(Region.huabei());
            case "huanan":
                return new com.qiniu.storage.Configuration(Region.huanan());
            default:
                inited = false;
                throw new RuntimeException("存储区域配置错误");
        }
    }

    /**
     * 认证信息实例
     *
     * @return
     */
    @Bean
    public Auth auth() {
        if (!isInited()) {
            return null;
        }

        return Auth.create(accessKey, secretKey);
    }

    /**
     * 构建一个七牛上传工具实例
     */
    @Bean
    public UploadManager uploadManager(com.qiniu.storage.Configuration configuration) {
        if (!isInited()) {
            return null;
        }

        return new UploadManager(configuration);
    }

}
