import request from '@/utils/request'

export default {
  // 搜索分页查询
  getList(currentPage, pageSize, goodsVo) {
    return request({
      url: `/goods/search/${currentPage}/${pageSize}`, // 反单引号，模板字符串
      method: 'post',
      data: goodsVo
    })
  },
  // 删除
  remove(id){
    return request({
      url: `/goods/${id}`,
      method: 'delete',
    })
  },
// 增加
  add(goods){
    return request({
      url: `/goods`,
      method: 'post',
      data: goods
    })
  },

  // 根据ID查询
  queryById(id){
    return request({
      url: `/goods/${id}`,
      method: 'get',
    })
  },

  // 编辑
  edit(goods){
    return request({
      url: `/goods`,
      method: 'put',
      data: goods
    })
  },

  // 查询所有培训师
  queryAll(){
    return request({
      url: `/goods`,
      method: 'get'
    })
  }
}
