import {ElLoading, ElMessageBox, ElNotification} from 'element-plus'

let loadingInstance;

export default {
    // 消息提示
    msg(content) {
        ElNotification.info(content)
    },
    // 错误消息
    msgError(content) {
        ElNotification.error(content)
    },
    // 成功消息
    msgSuccess(content) {
        ElNotification.success(content)
    },
    // 警告消息
    msgWarning(content) {
        ElNotification.warning(content)
    },
    // 弹出提示
    alert(content) {
        ElMessageBox.alert(content, "系统提示")
    },
    // 错误提示
    alertError(content) {
        ElMessageBox.alert(content, "系统提示", {type: 'error'})
    },
    // 成功提示
    alertSuccess(content) {
        ElMessageBox.alert(content, "系统提示", {type: 'success'})
    },
    // 警告提示
    alertWarning(content) {
        ElMessageBox.alert(content, "系统提示", {type: 'warning'})
    },
    // 确认窗体
    confirm(content) {
        return ElMessageBox.confirm(content, "系统提示", {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: "warning",
        })
    },
    // 提交内容
    prompt(content) {
        return ElMessageBox.prompt(content, "系统提示", {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: "warning",
        })
    },
    // 打开遮罩层
    loading(content) {
        loadingInstance = ElLoading.service({
            lock: true,
            text: content,
            background: "rgba(0, 0, 0, 0.7)",
        })
    },
    // 关闭遮罩层
    closeLoading() {
        loadingInstance.close();
    }
}
