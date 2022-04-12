(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a3ff161a"],{"88c1":function(e,t,i){"use strict";i.r(t);var o=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container"},[i("el-button",{attrs:{type:"primary"},on:{click:e.addClick}},[e._v("Post new Advertisement")]),i("div",{staticStyle:{height:"10px"}}),i("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:""}},[i("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"jobAdvertisementId",label:"Job Advertisement Id"}}),i("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"serviceType",label:"Service Type"},scopedSlots:e._u([{key:"default",fn:function(t){return[1==t.row.serviceType?i("span",[e._v("Nurse")]):e._e(),2==t.row.serviceType?i("span",[e._v("Physiotherapist")]):e._e(),3==t.row.serviceType?i("span",[e._v("Psychiatrist")]):e._e()]}}])}),i("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"educationRequirement",label:"Education Requirement"},scopedSlots:e._u([{key:"default",fn:function(t){return[1==t.row.educationRequirement?i("span",[e._v("Bachelor")]):e._e(),2==t.row.educationRequirement?i("span",[e._v("Master")]):e._e(),3==t.row.educationRequirement?i("span",[e._v("Doctor")]):e._e()]}}])}),i("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"experience",label:"Years of Experience"}}),i("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"description",label:"Description"}}),i("el-table-column",{attrs:{label:"Operation"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(i){return e.handleDelete(t.$index,t.row)}}},[e._v("Delete")])]}}])})],1),i("el-dialog",{attrs:{title:"Add new advertisement",visible:e.dialogAddVisible,width:"50%"},on:{"update:visible":function(t){e.dialogAddVisible=t}}},[i("el-form",{ref:"loginForm",attrs:{rules:e.loginRules,model:e.addForm}},[i("el-form-item",{attrs:{label:"Service Type",prop:"serviceType","label-width":e.formLabelWidth}},[i("el-select",{staticClass:"dialog",attrs:{placeholder:"Please select"},on:{change:e.serviceTypeEvent},model:{value:e.addForm.serviceType,callback:function(t){e.$set(e.addForm,"serviceType",t)},expression:"addForm.serviceType"}},e._l(e.options,(function(e){return i("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),i("el-form-item",{attrs:{label:"Education Requirement",prop:"educationRequirement","label-width":e.formLabelWidth}},[i("el-select",{staticClass:"dialog",attrs:{placeholder:"Please select"},model:{value:e.addForm.educationRequirement,callback:function(t){e.$set(e.addForm,"educationRequirement",t)},expression:"addForm.educationRequirement"}},e._l(e.degreeOptions,(function(e){return i("el-option",{key:e.value,attrs:{disabled:e.flag,label:e.label,value:e.value}})})),1)],1),i("el-form-item",{attrs:{label:"Experience (years)",prop:"experience","label-width":e.formLabelWidth}},[i("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.experience,callback:function(t){e.$set(e.addForm,"experience",t)},expression:"addForm.experience"}})],1),i("el-form-item",{attrs:{label:"Job Description",prop:"description","label-width":e.formLabelWidth}},[i("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.description,callback:function(t){e.$set(e.addForm,"description",t)},expression:"addForm.description"}})],1)],1),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:e.addCancel}},[e._v("Cancel")]),i("el-button",{attrs:{type:"primary"},on:{click:e.addSure}},[e._v("Confirm")])],1)],1)],1)},a=[],l=(i("d3b7"),i("159b"),i("c24f")),r={data:function(){return{tableData:[],options:[{label:"Nurse",value:"1"},{label:"Physiotherapist",value:"2"},{label:"Psychiatrist",value:"3"}],degreeOptions:[{label:"Bachelor",value:"1",flag:!1},{label:"Master",value:"2",flag:!1},{label:"Doctor",value:"3",flag:!1}],dialogAddVisible:!1,formLabelWidth:"180px",addForm:{serviceType:"",educationRequirement:"",experience:"",description:""},loginRules:{serviceType:[{required:!0,trigger:"blur"}],educationRequirement:[{required:!0,trigger:"blur"}],description:[{required:!0,trigger:"blur"}]}}},mounted:function(){this.getDatatList()},methods:{serviceTypeEvent:function(e){this.degreeOptions.forEach((function(e){e.flag=!1})),"1"==e||"2"==e?this.degreeOptions[2].flag=!0:this.degreeOptions[0].flag=!0,this.addForm.educationRequirement=""},getDatatList:function(){var e=this,t=this.$loading({lock:!0,text:"Loading",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)"}),i={};Object(l["B"])(i).then((function(i){e.tableData=i,t.close()})).catch((function(e){console.log(e)}))},addClick:function(){this.dialogAddVisible=!0},addCancel:function(){this.dialogAddVisible=!1},addSure:function(){var e=this,t=this;this.$refs.loginForm.validate((function(i){if(i){var o=t.$loading({lock:!0,text:"Loading",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)"}),a=e.addForm;Object(l["S"])(a).then((function(e){o.close(),t.dialogAddVisible=!1,t.getDatatList(),t.$message({message:"Add new advertisement success!",type:"success"}),o.close()})).catch((function(i){console.log(i),o.close(),t.dialogAddVisible=!1,e.$message.error("Add in failed.")}))}}))},handleDelete:function(e,t){var i=this,o={jobAdvertisementId:t.jobAdvertisementId};Object(l["v"])(o).then((function(e){i.$message({message:"Delete the advertisement success!",type:"success"}),i.getDatatList()}))}}},n=r,s=(i("bc95"),i("2877")),d=Object(s["a"])(n,o,a,!1,null,"96230d72",null);t["default"]=d.exports},bc95:function(e,t,i){"use strict";i("cf0b")},cf0b:function(e,t,i){}}]);