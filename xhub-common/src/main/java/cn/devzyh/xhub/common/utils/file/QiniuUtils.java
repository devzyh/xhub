package cn.devzyh.xhub.common.utils.file;

import cn.devzyh.xhub.common.config.QiniuConfig;
import cn.devzyh.xhub.common.utils.spring.SpringUtils;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 七牛云上传工具类
 *
 * @author ruoyi
 */
public class QiniuUtils {

    private static boolean loaded = false;
    private static QiniuConfig config;
    private static Auth auth;
    private static UploadManager uploadManager;

    /**
     * 加载相关对象
     */
    private static void loadBean() {
        if (loaded) {
            return;
        }
        if (!QiniuConfig.isInited()) {
            return;
        }

        loaded = true;
        config = SpringUtils.getBean(QiniuConfig.class);
        auth = SpringUtils.getBean(Auth.class);
        uploadManager = SpringUtils.getBean(UploadManager.class);
    }

    /**
     * 是否使用七牛上传
     *
     * @return
     */
    public static boolean useQiniu() {
        loadBean();
        return QiniuConfig.isInited();
    }

    /**
     * 上传实现
     *
     * @param baseDir 基础目录
     * @param file    文件对象
     * @return
     * @throws IOException
     */
    public static final String upload(String baseDir, MultipartFile file) throws IOException {
        if (!useQiniu()) {
            return null;
        }

        String uploadToken = auth.uploadToken(config.getBucketName());
        String fileName = baseDir + "/" + FileUploadUtils.extractFilename(file);
        uploadManager.put(file.getInputStream(), fileName, uploadToken, null, null);
        return config.getUrl() + "/" + fileName;
    }

}
