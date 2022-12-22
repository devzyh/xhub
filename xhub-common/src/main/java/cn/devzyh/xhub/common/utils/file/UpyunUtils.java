package cn.devzyh.xhub.common.utils.file;

import cn.devzyh.xhub.common.config.UpyunConfig;
import com.upyun.UpException;
import okhttp3.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 又拍云上传工具类
 *
 * @author devzyh
 */
public class UpyunUtils {

    /**
     * 上传实现
     *
     * @param baseDir 基础目录
     * @param file    文件对象
     * @return
     * @throws IOException
     */
    public static final String upload(String baseDir, MultipartFile file) throws UpException, IOException {
        if (UpyunConfig.isDisable()) {
            return null;
        }

        String filePath = baseDir + "/" + FileUploadUtils.extractFilename(file);
        Response resp = UpyunConfig.getManagerInstance().writeFile(filePath, file.getInputStream(), null);
        if (!resp.isSuccessful()) {
            throw new UpException(resp.message());
        }

        return UpyunConfig.getConfigInstance().getUrl() + filePath;
    }

}
