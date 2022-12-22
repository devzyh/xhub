package cn.devzyh.xhub.common.config;

import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.common.utils.spring.SpringUtils;
import com.upyun.RestManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 又拍云相关配置
 *
 * @author devzyh
 */
@Component
@ConfigurationProperties(prefix = "upyun")
public class UpyunConfig {

    /**
     * 地址
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
     * 存储桶
     */
    private String bucketName = "";

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

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * 单例配置对象
     */
    private static UpyunConfig config;

    public static UpyunConfig getConfigInstance() {
        if (config == null) {
            synchronized (UpyunConfig.class) {
                if (config == null) {
                    synchronized (UpyunConfig.class) {
                        config = SpringUtils.getBean(UpyunConfig.class);
                    }
                }
            }
        }
        return config;
    }

    /**
     * 是否禁用
     *
     * @return
     */
    public static boolean isDisable() {
        getConfigInstance();

        return StringUtils.isBlank(config.accessKey) ||
                StringUtils.isBlank(config.secretKey) ||
                StringUtils.isBlank(config.bucketName);
    }

    /**
     * 是否启用
     *
     * @return
     */
    public static boolean isEnable() {
        return !isDisable();
    }

    /**
     * 单例上传对象
     */
    private static RestManager manager;

    public static RestManager getManagerInstance() {
        if (isDisable()) {
            return null;
        }

        if (manager == null) {
            synchronized (RestManager.class) {
                if (manager == null) {
                    manager = new RestManager(config.bucketName, config.accessKey, config.secretKey);
                }
            }
        }
        return manager;
    }

}
