import request from '@/utils/request'

// 批量上传文件
export function uploads(files) {
    let formData = new FormData();
    files = Array.from(files);
    files.forEach((file) => {
        formData.append("files", file);
    });
    return request.post(
        '/common/uploads',
        formData,
        {headers: {'Content-Type': 'application/x-www-form-urlencoded'}}
    )
}
