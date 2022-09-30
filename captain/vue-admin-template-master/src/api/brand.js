import request from '@/utils/request'

export default {
  // 搜索分页查询
  getList(currentPage, pageSize, brandVo) {
    return request({
      url: `/brand/search/${currentPage}/${pageSize}`, // 反单引号，模板字符串
      method: 'post',
      data: brandVo
    })
  },
  // 删除
  remove(id){
    return request({
      url: `/brand/${id}`,
      method: 'delete',
    })
  },
// 增加
  add(brand){
    return request({
      url: `/brand`,
      method: 'post',
      data: brand
    })
  },

  // 根据ID查询
  queryById(id){
    return request({
      url: `/brand/${id}`,
      method: 'get',
    })
  },

  // 编辑
  edit(brand){
    return request({
      url: `/brand`,
      method: 'put',
      data: brand
    })
  },

  // 查询所有培训师
  queryAll(){
    return request({
      url: `/brand`,
      method: 'get'
    })
  }
}
