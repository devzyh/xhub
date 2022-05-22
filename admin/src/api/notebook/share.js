import request from '@/utils/request'

// 查询笔记分享列表
export function listShare(query) {
  return request({
    url: '/notebook/share/list',
    method: 'get',
    params: query
  })
}

// 查询笔记分享详细
export function getShare(contentId) {
  return request({
    url: '/notebook/share/' + contentId,
    method: 'get'
  })
}

// 新增笔记分享
export function saveShare(data) {
  return request({
    url: '/notebook/share',
    method: 'post',
    data: data
  })
}

// 修改笔记分享
export function updateShare(data) {
  return request({
    url: '/notebook/share',
    method: 'put',
    data: data
  })
}

// 删除笔记分享
export function delShare(contentId) {
  return request({
    url: '/notebook/share/' + contentId,
    method: 'delete'
  })
}
