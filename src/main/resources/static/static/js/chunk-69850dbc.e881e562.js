(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-69850dbc"],{5054:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticStyle:{height:"10px"}}),a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,border:""}},[a("el-table-column",{attrs:{width:"100px","show-overflow-tooltip":!0,prop:"serviceId",label:"Service ID"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text"},on:{click:function(a){return t.clickRecords(e.row)}}},[t._v(t._s(e.row.serviceId))])]}}])}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"ctFirstName",label:"Care Taker First Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"ctLastName",label:"Care Taker Last Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"patientFirstName",label:"Patient First Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"patientLastName",label:"Patient Last Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"hourlyRate",label:"Service Hourly Rate"}}),a("el-table-column",{attrs:{width:"120px","show-overflow-tooltip":!0,prop:"paidAmount",label:"Paid Amount"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"amountYetToPay",label:"Amount yet to Pay"}}),a("el-table-column",{attrs:{width:"120px",fixed:"right",label:"Payment"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){return t.handlePay(e.$index,e.row)}}},[t._v("Pay")])]}}])})],1),a("el-dialog",{attrs:{title:"Payment",visible:t.dialogPaymentVisible,width:"33%"},on:{"update:visible":function(e){t.dialogPaymentVisible=e}}},[a("el-form",{ref:"addForm",attrs:{rules:t.addRules,model:t.addForm}},[a("el-form-item",{attrs:{label:"Amount",prop:"amount","label-width":t.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:t.addForm.amount,callback:function(e){t.$set(t.addForm,"amount",e)},expression:"addForm.amount"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogPaymentVisible=!1}}},[t._v("Cancel")]),a("el-button",{attrs:{type:"primary"},on:{click:t.payConfirm}},[t._v("Confirm")])],1)],1),a("el-drawer",{attrs:{title:"Payment Records",visible:t.records,direction:"rtl",size:"30%"},on:{"update:visible":function(e){t.records=e}}},[a("div",{staticStyle:{"padding-left":"20px"}},[a("el-table",{attrs:{data:t.gridData}},[a("el-table-column",{attrs:{property:"date",label:"Date"}}),a("el-table-column",{attrs:{property:"amount",label:"Paid Amount"}})],1)],1)])],1)},l=[],i=(a("ac1f"),a("5319"),a("c24f")),n={data:function(){var t=function(t,e,a){e.replace(/^(\-?)\d+(\.\d+)?$/,"")?a(new Error("The amount must be a double number.")):a()};return{tableData:[],records:!1,gridData:[],addForm:{amount:""},dialogPaymentVisible:!1,formLabelWidth:"120px",addRules:{amount:[{required:!0,trigger:"blur",validator:t}]}}},mounted:function(){this.getDatatList()},methods:{getDatatList:function(){var t=this,e=this.$loading({lock:!0,text:"Loading",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)"}),a={};Object(i["p"])(a).then((function(a){t.tableData=a,e.close()})).catch((function(t){console.log(t)}))},clickRecords:function(t){var e=this;this.records=!0;var a={billingId:t.billingId};Object(i["P"])(a).then((function(t){e.gridData=t}))},handlePay:function(t,e){this.dialogPaymentVisible=!0,this.billingId=e.billingId},payConfirm:function(){var t=this,e={billingId:this.billingId,amount:this.addForm.amount};Object(i["N"])(e).then((function(e){"200"==e.code?(t.$message({message:"Pay for the service success!",type:"success"}),t.dialogPaymentVisible=!1,t.getDatatList()):t.$message({message:"Amount cannot be less than 0.",type:"warning"})}))}}},r=n,s=(a("aa9a"),a("2877")),c=Object(s["a"])(r,o,l,!1,null,"7dffddc6",null);e["default"]=c.exports},aa9a:function(t,e,a){"use strict";a("e6ae")},e6ae:function(t,e,a){}}]);