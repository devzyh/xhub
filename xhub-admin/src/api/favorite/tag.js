import request from '@/utils/request'

// 查询文章标签列表
export function listTag(query) {
  return request({
    url: '/fav/tag/list',
    method: 'get',
    params: query
  })
}

// 查询所有文章标签
export function allTag() {
  return request({
    url: '/fav/tag/all',
    method: 'get'
  })
}


// 查询文章标签详细
export function getTag(id) {
  return request({
    url: '/fav/tag/' + id,
    method: 'get'
  })
}

// 新增文章标签
export function addTag(data) {
  return request({
    url: '/fav/tag',
    method: 'post',
    data: data
  })
}

// 修改文章标签
export function updateTag(data) {
  return request({
    url: '/fav/tag',
    method: 'put',
    data: data
  })
}

// 删除文章标签
export function delTag(id) {
  return request({
    url: '/fav/tag/' + id,
    method: 'delete'
  })
}
