(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-374c0e4b"],{"3bae":function(e,t,a){},"830b":function(e,t,a){"use strict";a("3bae")},b97d:function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app"},[a("div",{staticClass:"main"},[a("el-button",{attrs:{type:"primary"},on:{click:e.addClick}},[e._v("Add Staff Member")]),a("div",{staticStyle:{height:"10px"}}),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:""}},[a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"firstName",label:"First Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"lastName",label:"Last Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"username",label:"Username"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"postalAddress",label:"Postal Address"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"phoneNumber",label:"Phone Number"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"email",label:"Email"}}),a("el-table-column",{attrs:{label:"Is Blocked",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-switch",{attrs:{"active-color":"#ff4949","inactive-color":"#13ce66"},on:{change:function(a){return e.changeBlocked(t.row)}},model:{value:t.row.isBlocked,callback:function(a){e.$set(t.row,"isBlocked",a)},expression:"scope.row.isBlocked"}})]}}])}),a("el-table-column",{attrs:{label:"Operation"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.handleDelete(t.$index,t.row)}}},[e._v("Delete")])]}}])})],1)],1),a("el-dialog",{attrs:{title:"Add Staff Member",visible:e.dialogAddVisible,width:"50%"},on:{"update:visible":function(t){e.dialogAddVisible=t}}},[a("el-form",{ref:"loginForm",attrs:{rules:e.addRules,model:e.addForm}},[a("el-form-item",{attrs:{label:"First Name",prop:"FirstName","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.FirstName,callback:function(t){e.$set(e.addForm,"FirstName",t)},expression:"addForm.FirstName"}})],1),a("el-form-item",{attrs:{label:"Last Name",prop:"LastName","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.LastName,callback:function(t){e.$set(e.addForm,"LastName",t)},expression:"addForm.LastName"}})],1),a("el-form-item",{attrs:{label:"PostalAddress",prop:"PostalAddress","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.PostalAddress,callback:function(t){e.$set(e.addForm,"PostalAddress",t)},expression:"addForm.PostalAddress"}})],1),a("el-form-item",{attrs:{label:"PhoneNumber",prop:"PhoneNumber","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.PhoneNumber,callback:function(t){e.$set(e.addForm,"PhoneNumber",t)},expression:"addForm.PhoneNumber"}})],1),a("el-form-item",{attrs:{label:"Email",prop:"Email","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.Email,callback:function(t){e.$set(e.addForm,"Email",t)},expression:"addForm.Email"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.addCancel}},[e._v("Cancel")]),a("el-button",{attrs:{type:"primary"},on:{click:e.addSure}},[e._v("Confirm")])],1)],1)],1)},l=[],s=a("c24f"),r={components:{},data:function(){return{username:"",dialogAddVisible:!1,formLabelWidth:"120px",addForm:{FirstName:"",LastName:"",PostalAddress:"",PhoneNumber:"",Email:""},addRules:{FirstName:[{required:!0,trigger:"blur"}],LastName:[{required:!0,trigger:"blur"}],PostalAddress:[{required:!0,trigger:"blur"}],PhoneNumber:[{required:!0,trigger:"blur"}],Email:[{required:!0,trigger:"blur"}]},tableData:[]}},created:function(){this.getDatatList()},mounted:function(){},methods:{handleDelete:function(e,t){var a=this,o={username:t.username};Object(s["y"])(o).then((function(e){a.$message({message:"Delete the staff success!",type:"success"}),a.getDatatList()}))},changeBlocked:function(e){var t=this,a={username:e.username};e.isBlocked?Object(s["q"])(a).then((function(){t.$message({message:"The staff account has been blocked",type:"success"})})):Object(s["b"])(a).then((function(){t.$message({message:"The staff account has been unblocked",type:"success"})}))},getDatatList:function(){var e=this,t=this.$loading({lock:!0,text:"Loading",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)"}),a={};Object(s["N"])(a).then((function(a){e.tableData=a,t.close()})).catch((function(e){console.log(e)}))},addClick:function(){this.dialogAddVisible=!0},addCancel:function(){this.dialogAddVisible=!1},addSure:function(){var e=this,t=this;this.$refs.loginForm.validate((function(a){if(a){var o=t.$loading({lock:!0,text:"Loading",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)"}),l=e.addForm;e.loading=!0,Object(s["g"])(l).then((function(a){if(o.close(),t.dialogAddVisible=!1,t.getDatatList(),"200"!==a.code)return a.code,e.$message({message:a.msg,type:"error"}),void(e.loading=!1);t.$message({message:"Add the staff success!",type:"success"}),o.close()})).catch((function(a){console.log(a),o.close(),t.dialogAddVisible=!1,e.$message.error("Add in failed.")}))}}))}}},i=r,d=(a("830b"),a("2877")),n=Object(d["a"])(i,o,l,!1,null,"6af07d76",null);t["default"]=n.exports}}]);