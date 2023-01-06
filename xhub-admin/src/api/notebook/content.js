import request from '@/utils/request'

// 查询笔记内容列表
export function listContent(query) {
  return request({
    url: '/notebook/content/list',
    method: 'get',
    params: query
  })
}

// 查询笔记内容详细
export function getContent(id) {
  return request({
    url: '/notebook/content/' + id,
    method: 'get'
  })
}

// 新增笔记内容
export function addContent(data) {
  return request({
    url: '/notebook/content',
    method: 'post',
    data: data
  })
}

// 修改基本信息
export function updateContent(data) {
  return request({
    url: '/notebook/content',
    method: 'put',
    data: data
  })
}

// 修改编辑内容
export function updateEditor(data) {
  return request({
    url: '/notebook/content/editor',
    method: 'put',
    data: data
  })
}

// 删除笔记内容
export function delContent(id) {
  return request({
    url: '/notebook/content/' + id,
    method: 'delete'
  })
}

// 生成访问Token
export function generateToken(id) {
  return request({
    url: '/notebook/content/generateToken',
    method: 'get'
  })
}
