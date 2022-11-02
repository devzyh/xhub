import request from '@/utils/request'

// 查询登录日志列表
export function list(query) {
  return request({
    url: '/system/log/login/list',
    method: 'get',
    params: query
  })
}

// 删除登录日志
export function delLoginLog(infoId) {
  return request({
    url: '/system/log/login/' + infoId,
    method: 'delete'
  })
}

// 解锁用户登录状态
export function unlockLoginLog(userName) {
  return request({
    url: '/system/log/login/unlock/' + userName,
    method: 'get'
  })
}

// 清空登录日志
export function cleanLoginLog() {
  return request({
    url: '/system/log/login/clean',
    method: 'delete'
  })
}
