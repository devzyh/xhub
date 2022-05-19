import request from '@/utils/request'

// 查询笔记历史列表
export function listHistory(query) {
  return request({
    url: '/notebook/history/list',
    method: 'get',
    params: query
  })
}

// 查询笔记历史详细
export function getHistory(id) {
  return request({
    url: '/notebook/history/' + id,
    method: 'get'
  })
}

// 新增笔记历史
export function addHistory(data) {
  return request({
    url: '/notebook/history',
    method: 'post',
    data: data
  })
}

// 修改笔记历史
export function updateHistory(data) {
  return request({
    url: '/notebook/history',
    method: 'put',
    data: data
  })
}

// 删除笔记历史
export function delHistory(id) {
  return request({
    url: '/notebook/history/' + id,
    method: 'delete'
  })
}
