<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="商品id">
        <el-input v-model="goods.id"/>
      </el-form-item>
      <el-form-item label="商品名称">
        <el-input v-model="goods.name"/>
      </el-form-item>
      <el-form-item label="商品价格">
        <el-input v-model="goods.price"/>
      </el-form-item>
      <el-form-item label="商品数量">h
        <el-input v-model="goods.num"/>
      </el-form-item>
      <el-form-item label="商品状态">
        <el-select v-model="goods.status" clearable placeholder="请选择">
          <el-option :value="1" label="正常"/>
          <el-option :value="2" label="下架"/>
        </el-select>
      </el-form-item>
      <el-form-item label="所属品牌">h
        <el-input v-model="goods.brandId"/>
      </el-form-item>
      <el-form-item label="所属品牌得父品牌">h
        <el-input v-model="goods.brandParentId"/>
      </el-form-item>

      <!-- 讲师头像：TODO -->
      <el-form-item label="商品主图片">
        <el-upload
          name="file"
          class="avatar-uploader"
          action="http://localhost:8080/upload/upload"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="goods.image" :src="'http://rhgilps31.hn-bkt.clouddn.com/' + goods.image" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="handleAddOrEdit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import goods from '../../api/goods'

  export default {
    data(){
      return {
        goods: {                    // 表单数据绑定的数据模型
          image: ""                  // 如果上传的时候，图片没有刷新出来，那么就把这个属性单独的给定义出来
        },
        saveBtnDisabled: false,       // 主要是为了防止表单重复提交
      }
    },
    created(){
      // 获取路由地址里面的参数
      console.log(this.$route)
      if(this.$route.params && this.$route.params.id){
        // 表示: 路由参数里面有值，并且有id这个值，就是进行修改操作
        console.log("进行修改操作")
        // 需要通过培训师的id去查询培训师的数据
        this.queryById(this.$route.params.id);
      }
    },
    methods: {
      // 添加
      handleAddOrEdit(){
        // 把saveBtnDisabled 改为true  表示这按钮不可以被点击
        this.saveBtnDisabled = true;

        if(this.$route.params && this.$route.params.id){
          // 修改操作
          goods.edit(this.goods).then(res => {
            // 弹出提示信息
            this.$message.success(res.message);
            // 添加完成，需要跳转到列表页面
            this.$router.push({ path: '/goods' })
          });
        }else{
          // 增加操作
          goods.add(this.goods).then(res => {
            // 弹出提示信息
            this.$message.success(res.message);
            // 添加完成，需要跳转到列表页面
            this.$router.push({ path: '/goods' })
          });
        }

        this.saveBtnDisabled = false;

      },
      // 根据ID查询
      queryById(id){
        goods.queryById(id).then(res => {
          this.goods = res.data;
        });
      },
      handleAvatarSuccess(res, file){
        console.log("后台返回的图片的名称为：", res.data)
        this.goods.image = res.data;
        console.log("this.goods.image：", this.goods.image)
      },
      beforeAvatarUpload(file){
        const isJPG = file.type === 'image/jpeg' || file.type === 'image/png';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      }
    }
  }
</script>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
