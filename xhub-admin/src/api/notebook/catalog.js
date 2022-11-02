import request from '@/utils/request'

// 查询笔记目录列表
export function listCatalog(query) {
  return request({
    url: '/notebook/catalog/list',
    method: 'get',
    params: query
  })
}

// 查询笔记目录详细
export function getCatalog(id) {
  return request({
    url: '/notebook/catalog/' + id,
    method: 'get'
  })
}

// 新增笔记目录
export function addCatalog(data) {
  return request({
    url: '/notebook/catalog',
    method: 'post',
    data: data
  })
}

// 修改笔记目录
export function updateCatalog(data) {
  return request({
    url: '/notebook/catalog',
    method: 'put',
    data: data
  })
}

// 删除笔记目录
export function delCatalog(id) {
  return request({
    url: '/notebook/catalog/' + id,
    method: 'delete'
  })
}

// 查询目录下拉树结构
export function treeSelect() {
  return request({
    url: '/notebook/catalog/treeSelect',
    method: 'get'
  })
}
