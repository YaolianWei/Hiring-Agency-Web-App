(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6f0e0150"],{1148:function(t,e,a){"use strict";var o=a("a691"),l=a("1d80");t.exports="".repeat||function(t){var e=String(l(this)),a="",i=o(t);if(i<0||i==1/0)throw RangeError("Wrong number of repetitions");for(;i>0;(i>>>=1)&&(e+=e))1&i&&(a+=e);return a}},"408a":function(t,e,a){var o=a("c6b6");t.exports=function(t){if("number"!=typeof t&&"Number"!=o(t))throw TypeError("Incorrect invocation");return+t}},"48cc":function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticStyle:{height:"10px"}}),a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,border:""}},[a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"serviceId",label:"Service ID"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text"},on:{click:function(a){return t.clickRecords(e.row)}}},[t._v(t._s(e.row.serviceId))])]}}])}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"careRequestId",label:"Service Request ID"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"patientFirstName",label:"Patient First Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"patientLastName",label:"Patient Last Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"hourlyRate",label:"Service Hourly Rate"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticClass:"money"},[t._v(" $ "+t._s(t._f("numFilter")(e.row.hourlyRate)))])]}}])}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"paidAmount",label:"Paid Amount"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticClass:"money"},[t._v(" $ "+t._s(t._f("numFilter")(e.row.paidAmount)))])]}}])}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"amountYetToPay",label:"Amount yet to Pay"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticClass:"money"},[t._v(" $ "+t._s(t._f("numFilter")(e.row.amountYetToPay)))])]}}])}),a("el-table-column",{attrs:{width:"140px",fixed:"right",label:"Billing Detail"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){return t.handleDetail(e.$index,e.row)}}},[t._v("Detail")])]}}])}),a("el-table-column",{attrs:{width:"140px",fixed:"right",label:"Payment"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){return t.handlePay(e.$index,e.row)}}},[t._v("Pay")])]}}])})],1),a("el-dialog",{attrs:{title:"Payment",visible:t.dialogPaymentVisible,width:"33%"},on:{"update:visible":function(e){t.dialogPaymentVisible=e}}},[a("el-form",{ref:"addForm",attrs:{rules:t.addRules,model:t.addForm}},[a("el-form-item",{attrs:{label:"Amount",prop:"amount","label-width":t.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:t.addForm.amount,callback:function(e){t.$set(t.addForm,"amount",e)},expression:"addForm.amount"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogPaymentVisible=!1}}},[t._v("Cancel")]),a("el-button",{attrs:{type:"primary"},on:{click:t.payConfirm}},[t._v("Confirm")])],1)],1),a("el-dialog",{attrs:{title:"Billing Account Details",visible:t.dialogBillingVisible,width:"75%"},on:{"update:visible":function(e){t.dialogBillingVisible=e}}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.billingData}},[a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"patientFirstName",label:"Patient First Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"patientLastName",label:"Patient Last Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"hpFirstName",label:"HCP First Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"hpLastName",label:"HCP Last Name"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"date",label:"Date"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"startTime",label:"Start Time"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"endTime",label:"End Time"}}),a("el-table-column",{attrs:{"show-overflow-tooltip":!0,prop:"amount",label:"Amount"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticClass:"money"},[t._v(" $ "+t._s(t._f("numFilter")(e.row.amount)))])]}}])})],1)],1),a("el-drawer",{attrs:{title:"Payment Records",visible:t.table,direction:"rtl",size:"30%"},on:{"update:visible":function(e){t.table=e}}},[a("div",{staticStyle:{"padding-left":"20px"}},[a("el-table",{attrs:{data:t.gridData}},[a("el-table-column",{attrs:{property:"date",label:"Date"}}),a("el-table-column",{attrs:{property:"amount",label:"Paid Amount"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticClass:"money"},[t._v(" $ "+t._s(t._f("numFilter")(e.row.amount)))])]}}])})],1)],1)])],1)},l=[],i=(a("ac1f"),a("5319"),a("b680"),a("c24f")),n={data:function(){var t=function(t,e,a){e.replace(/^(\-?)\d+(\.\d+)?$/,"")?a(new Error("The amount must be a double number.")):a()};return{table:!1,tableData:[],billingData:[],addForm:{amount:""},dialogPaymentVisible:!1,dialogBillingVisible:!1,formLabelWidth:"120px",addRules:{amount:[{required:!0,trigger:"blur",validator:t}]},gridData:[]}},mounted:function(){this.getDatatList()},methods:{clickRecords:function(t){var e=this;this.table=!0;var a={billingId:t.billingId};Object(i["P"])(a).then((function(t){e.gridData=t}))},getDatatList:function(){var t=this,e=this.$loading({lock:!0,text:"Loading",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)"}),a={careTakerId:this.$store.state.user.userId};Object(i["s"])(a).then((function(a){t.tableData=a,e.close()})).catch((function(t){console.log(t)}))},handlePay:function(t,e){this.dialogPaymentVisible=!0,this.billingId=e.billingId},payConfirm:function(){var t=this,e={billingId:this.billingId,amount:this.addForm.amount};Object(i["N"])(e).then((function(e){"200"==e.code?(t.$message({message:"Pay for the service success!",type:"success"}),t.dialogPaymentVisible=!1,t.getDatatList()):t.$message({message:"Amount cannot be less than 0.",type:"warning"})}))},handleDetail:function(t,e){var a=this;this.dialogBillingVisible=!0,this.careRequestId=e.careRequestId;var o={careRequestId:this.careRequestId};Object(i["o"])(o).then((function(t){a.billingData=t})).catch((function(t){console.log(t)}))}},filters:{numFilter:function(t){var e="";return e=isNaN(t)||""===t?"--":parseFloat(t).toFixed(2),e}}},r=n,s=(a("d815"),a("2877")),u=Object(s["a"])(r,o,l,!1,null,"5a4e47a5",null);e["default"]=u.exports},b680:function(t,e,a){"use strict";var o=a("23e7"),l=a("a691"),i=a("408a"),n=a("1148"),r=a("d039"),s=1..toFixed,u=Math.floor,c=function(t,e,a){return 0===e?a:e%2===1?c(t,e-1,a*t):c(t*t,e/2,a)},d=function(t){var e=0,a=t;while(a>=4096)e+=12,a/=4096;while(a>=2)e+=1,a/=2;return e},f=s&&("0.000"!==8e-5.toFixed(3)||"1"!==.9.toFixed(0)||"1.25"!==1.255.toFixed(2)||"1000000000000000128"!==(0xde0b6b3a7640080).toFixed(0))||!r((function(){s.call({})}));o({target:"Number",proto:!0,forced:f},{toFixed:function(t){var e,a,o,r,s=i(this),f=l(t),m=[0,0,0,0,0,0],p="",b="0",h=function(t,e){var a=-1,o=e;while(++a<6)o+=t*m[a],m[a]=o%1e7,o=u(o/1e7)},w=function(t){var e=6,a=0;while(--e>=0)a+=m[e],m[e]=u(a/t),a=a%t*1e7},v=function(){var t=6,e="";while(--t>=0)if(""!==e||0===t||0!==m[t]){var a=String(m[t]);e=""===e?a:e+n.call("0",7-a.length)+a}return e};if(f<0||f>20)throw RangeError("Incorrect fraction digits");if(s!=s)return"NaN";if(s<=-1e21||s>=1e21)return String(s);if(s<0&&(p="-",s=-s),s>1e-21)if(e=d(s*c(2,69,1))-69,a=e<0?s*c(2,-e,1):s/c(2,e,1),a*=4503599627370496,e=52-e,e>0){h(0,a),o=f;while(o>=7)h(1e7,0),o-=7;h(c(10,o,1),0),o=e-1;while(o>=23)w(1<<23),o-=23;w(1<<o),h(1,1),w(2),b=v()}else h(0,a),h(1<<-e,0),b=v()+n.call("0",f);return f>0?(r=b.length,b=p+(r<=f?"0."+n.call("0",f-r)+b:b.slice(0,r-f)+"."+b.slice(r-f))):b=p+b,b}})},d815:function(t,e,a){"use strict";a("e2a5")},e2a5:function(t,e,a){}}]);