<template>
  <div id="app-container">
    <!--条件查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="goodsVo.name" placeholder="商品名"/>
      </el-form-item>
      <!-- <el-form-item>
          <el-select v-model="trainerQuery.level" clearable placeholder="讲师头衔">
              <el-option :value="1" label="高级讲师"/>
              <el-option :value="2" label="首席讲师"/>
          </el-select>
      </el-form-item> -->
      <el-form-item>
        <el-input v-model="goodsVo.num" placeholder="商品数目"/>
      </el-form-item>
      <el-form-item>
        <el-input v-model="goodsVo.status" placeholder="商品状态"/>
      </el-form-item>
      <el-button type="primary" icon="el-icon-search" @click="getList(-1)">查询</el-button>
      <el-button type="default" @click="resetData()">清空</el-button>

      <!--当我们点击添加培训师的按钮时，应该要跳转到 /trainer/add 这个路由地址-->
      <router-link to="/goods/add">
        <el-button type="primary">添加商品</el-button>
      </router-link>
    </el-form>

    <!--数据显示列表-->
    <el-table :data="dataList" fit highlight-current-row>
      <el-table-column type="index" label="序号" width="70">
        <template slot-scope="scope">
          {{pageSize * (currentPage - 1) + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="name" label="商品名称" width="80" ></el-table-column>
      <el-table-column prop="price" label="商品价格" width="80" ></el-table-column>
      <el-table-column prop="num" label="商品数目" ></el-table-column>
      <el-table-column prop="createTime" label="创建时间" width="160"></el-table-column>
      <el-table-column prop="updateTime" label="修改时间" width="160"></el-table-column>

      <el-table-column prop="status" label="商品状态" width="60" >
        <template slot-scope="scope">
          <span v-if="1" >正常</span>
          <span v-else>下架</span>
        </template>
      </el-table-column>

      <el-table-column prop="brandId" label="所属品牌" width="160"></el-table-column>
      <el-table-column prop="brandParentId" label="所属品牌的父品牌" width="160"></el-table-column>

      <el-table-column label="操作" width="200">
        <template slot-scope="scope">

          <router-link :to="'/goods/edit/' + scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>

          <el-button type="danger" size="mini" icon="el-icon-delete" @click="handleRemove(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[1, 2, 3, 5]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>

  </div>
</template>
<script>
// 导入goods api
import goods from '../../api/goods'
  export default {
    // 必须使用方法，需要给返回值
    data(){
      return {
        goodsVo: {},             // 搜索的数据模型对象
        currentPage: 1,                 // 当前页
        pageSize: 2,                    // 每页记录数
        dataList: [],                   // 分页数据
        total: 0,                       // 总记录数
      }
    },
    created(){
      this.getList();
    },
    methods:{
      // 页面初始化查询数据
      getList(value){

        if(value == -1){
          // 点击搜索之后应该从第一页开始查询
          this.currentPage = 1;
        }

        // 此处应该调用api里面的相关方法 getList
        goods.getList(this.currentPage, this.pageSize, this.goodsVo).then(res => {
          // 以前要获取响应的数据  res.data  拿到的此时result对象
          // 此处 res就是result对象
          console.log(res);
          // 将查询出来的分页数据赋值给数据模型
          this.dataList = res.data.data;
          this.total = res.data.total;
        });
      },
      // 每页记录数发生变化
      handleSizeChange(size){
        this.pageSize = size;
        this.getList();
      },
      // 当前页发生变化
      handleCurrentChange(current){
        this.currentPage = current;
        this.getList();
      },
      // 清空数据
      resetData(){
        // 清空搜索的内容
        this.goodsVo = {};
        // 重新查询数据
        this.getList();
      },
      // 删除数据
      handleRemove(id){
        this.$confirm("是否确定删除数据？", "提示", {type: 'warning'})
          .then(() => {
            // 表示点击了确定
            goods.remove(id).then(res => {
              // 此处我要不要考虑失败的情况
              // 弹出成功的提示信息
              this.$message.success(res.message);
              // 重新加载数据
              this.getList();
            });
          })
          .catch(() => {
            // 表示点击了取消
            this.$message.info("取消删除操作");
          });
      },

    }
  }
</script>
