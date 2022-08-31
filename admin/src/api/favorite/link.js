import request from '@/utils/request'

// 查询主页链接列表
export function listFavorite(query) {
  return request({
    url: '/fav/link/list',
    method: 'get',
    params: query
  })
}

// 查询主页链接详细
export function getFavorite(id) {
  return request({
    url: '/fav/link/' + id,
    method: 'get'
  })
}

// 新增主页链接
export function addFavorite(data) {
  return request({
    url: '/fav/link',
    method: 'post',
    data: data
  })
}

// 修改主页链接
export function updateFavorite(data) {
  return request({
    url: '/fav/link',
    method: 'put',
    data: data
  })
}

// 删除主页链接
export function delFavorite(id) {
  return request({
    url: '/fav/link/' + id,
    method: 'delete'
  })
}
