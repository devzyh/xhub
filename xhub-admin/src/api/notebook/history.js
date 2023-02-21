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