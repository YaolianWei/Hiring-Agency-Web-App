<!-- admin登录后的首页 -->
<template>
  <div class="app">
    <div class="main">
      <el-button type="primary" @click="addClick">Add Staff Member</el-button>
      <div style="height:10px"></div>
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column
          :show-overflow-tooltip="true"
          prop="firstName"
          label="firstName"
        ></el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="lastName"
          label="lastName"
        ></el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="username"
          label="userName"
        ></el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="postalAddress"
          label="postalAddress"
        ></el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="phoneNumber"
          label="phoneNumber"
        ></el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="email"
          label="email"
        ></el-table-column>
        <!-- <el-table-column fixed="right" label="operation" width="100">
          <template slot-scope="scope">
            <el-button type="text" size="small" @click="updateClick(scope)"
              >update</el-button
            >
          </template>
        </el-table-column> -->
      </el-table>
    </div>
    <!-- 添加弹框 -->
    <el-dialog title="Add Staff Member" :visible.sync="dialogAddVisible" width="50%">
      <el-form :rules="loginRules" :model="addForm" ref="loginForm">
        <el-form-item label="firstName" prop="FirstName" :label-width="formLabelWidth">
          <el-input v-model="addForm.FirstName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="lastName" prop="LastName" :label-width="formLabelWidth">
          <el-input v-model="addForm.LastName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="postalAddress" prop="PostalAddress" :label-width="formLabelWidth">
          <el-input v-model="addForm.PostalAddress" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="phoneNumber" prop="PhoneNumber" :label-width="formLabelWidth">
          <el-input v-model="addForm.PhoneNumber" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="email" prop="Email" :label-width="formLabelWidth">
          <el-input v-model="addForm.Email" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addCancel">Cancel</el-button>
        <el-button type="primary" @click="addSure">Confirm</el-button>
      </div>
    </el-dialog>
    <!-- 修改弹框 -->
    <el-dialog title="Update Event" :visible.sync="dialogUpdateVisible" width="50%">
      <el-form :model="updateForm">
        <el-form-item label="firstName" :label-width="formLabelWidth">
          <el-input v-model="updateForm.FirstName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="lastName" :label-width="formLabelWidth">
          <el-input v-model="updateForm.LastName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="postalAddress" :label-width="formLabelWidth">
          <el-input v-model="updateForm.PostalAddress" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="phoneNumber" :label-width="formLabelWidth">
          <el-input v-model="updateForm.PhoneNumber" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="email" :label-width="formLabelWidth">
          <el-input v-model="updateForm.Email" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="updateCancel">Cancel</el-button>
        <el-button type="primary" @click="updateSure">Confirm</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { addStaff,staffList } from "@/api/user";
export default {
  //import引入的组件需要注入到对象中才能使用
  components: {},
  data() {
    return {
      userName: "",
      dialogAddVisible: false,
      dialogUpdateVisible: false,
      formLabelWidth: "120px",
      addForm: {
        FirstName: "",
        LastName: "",
        PostalAddress: "",
        PhoneNumber: "",
        Email: "",
      },
      loginRules: {
        FirstName: [{ required: true, trigger: "blur" }],
        LastName: [{ required: true, trigger: "blur" }],
        PostalAddress: [{ required: true, trigger: "blur" }],
        PhoneNumber: [{ required: true, trigger: "blur" }],
        Email: [{ required: true, trigger: "blur" }],
      },
      updateForm: {
        FirstName: "",
        LastName: "",
        PostalAddress: "",
        PhoneNumber: "",
        Email: "",
      },
      tableData: [],
      updateIndex: 0,
    };
  },
  created() {
    this.getDatatList();
  },
  mounted() {},
  //方法集合
  methods: {
    // 获取table数据
    getDatatList() {
      const loading = this.$loading({
        lock: true,
        text: "Loading",
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.7)",
      });
      let params = {};
      staffList(params)
        .then((response) => {
          this.tableData = response;
          loading.close();
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // 添加按钮
    addClick() {
      this.dialogAddVisible = true;
    },
    // 取消添加
    addCancel() {
      this.dialogAddVisible = false;
    },
    // 确认添加
    addSure() {
      let that = this;
     this.$refs.loginForm.validate((valid) => {
        if (valid) {
           const loading = that.$loading({
        lock: true,
        text: "Loading",
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.7)",
      });
      let params = this.addForm;
      addStaff(params)
        .then((response) => {
            loading.close();
            that.dialogAddVisible = false;
            that.getDatatList();
            that.$message({
              message: "Add the event success!",
              type: "success",
            });
           loading.close();
        })
        .catch((error) => {
          console.log(error);
          loading.close();
          that.dialogAddVisible = false;
          this.$message.error("Add in failed.");
        });
     }})
    },
    // 修改按钮
    updateClick(scope) {
      this.updateIndex = scope.$index;
      scope.row.flag = true;
      this.updateForm = JSON.parse(JSON.stringify(scope.row));
      this.dialogUpdateVisible = true;
    },
    // 取消修改
    updateCancel() {
      this.dialogUpdateVisible = false;
    },
    // 确认修改
    updateSure() {
      let that = this;
      const loading = that.$loading({
        lock: true,
        text: "Loading",
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.7)",
      });
      // 修改成功
      setTimeout(() => {
        loading.close();
        that.$store.state.tableList[that.updateIndex] = that.updateForm;
        that.tableData = JSON.parse(JSON.stringify(that.$store.state.tableList));
        that.dialogUpdateVisible = false;
        that.$message({
          message: "Update the event success!",
          type: "success",
        });
      }, 1000);
    },
  },
};
</script>
<style scoped>
.main {
  padding:20px;
}
</style>
