(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a5912eb8"],{"06d4":function(e,t,r){e.exports=r.p+"static/img/6.a6c93463.jpg"},"11d9":function(e,t,r){e.exports=r.p+"static/img/3.f3ae46c5.jpg"},"405a":function(e,t,r){e.exports=r.p+"static/img/2.345ae9a9.jpg"},"4d0f":function(e,t,r){e.exports=r.p+"static/img/5.c52d7119.jpg"},6519:function(e,t,r){},8554:function(e,t,r){e.exports=r.p+"static/img/1.6d4ab924.jpg"},a7ef:function(e,t,r){"use strict";r.r(t);var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("div",{staticClass:"top"},[r("el-link",{attrs:{type:"primary"},on:{click:e.goToLogin}},[e._v("Login")]),r("el-link",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary"},on:{click:e.registerClick}},[e._v("CareTakerRegister")])],1),r("div",{staticStyle:{clear:"both"}}),r("el-divider"),r("el-carousel",{attrs:{type:"card",height:"550px",interval:5e3,arrow:"always"}},e._l(e.imgList,(function(e,t){return r("el-carousel-item",{key:t},[r("img",{key:t,attrs:{src:e.imgUrl,width:"100%",height:"100%",alt:""}})])})),1),r("el-divider"),e._l(e.adList,(function(t,a){return r("div",{key:a,staticStyle:{float:"left",padding:"38px"}},[r("el-card",{staticClass:"box-card"},[r("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[r("span",[e._v("Advertisement")]),r("el-button",{staticStyle:{float:"right",padding:"3px 0"},attrs:{type:"text"},on:{click:function(r){return e.applyClick(t)}}},[e._v("Apply")])],1),r("div",{staticClass:"text item"},[e._v(" ServiceType: "),1==t.serviceType?r("span",[e._v("Nurse")]):e._e(),2==t.serviceType?r("span",[e._v("Physiotherapist")]):e._e(),3==t.serviceType?r("span",[e._v("Psychiatrist")]):e._e()]),r("div",{staticClass:"text item"},[e._v(" Education Requirement: "),1==t.educationRequirement?r("span",[e._v("Bachelor")]):e._e(),2==t.educationRequirement?r("span",[e._v("Master")]):e._e(),3==t.educationRequirement?r("span",[e._v("Doctor")]):e._e()]),r("div",{staticClass:"text item"},[e._v("Years of experience: "+e._s(t.experience))]),r("div",{staticClass:"text item"},[e._v("Description: "+e._s(t.description))])])],1)})),r("el-dialog",{attrs:{title:"Apply to the hiring agency",visible:e.dialogAddVisible,width:"50%"},on:{"update:visible":function(t){e.dialogAddVisible=t}}},[r("el-form",{ref:"loginForm",attrs:{rules:e.applyRules,model:e.addForm}},[r("el-form-item",{attrs:{label:"First Name",prop:"firstName","label-width":e.formLabelWidth}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.firstName,callback:function(t){e.$set(e.addForm,"firstName",t)},expression:"addForm.firstName"}})],1),r("el-form-item",{attrs:{label:"Last Name",prop:"lastName","label-width":e.formLabelWidth}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.lastName,callback:function(t){e.$set(e.addForm,"lastName",t)},expression:"addForm.lastName"}})],1),r("el-form-item",{attrs:{label:"Gender",prop:"gender","label-width":e.formLabelWidth}},[r("el-select",{staticClass:"dialog",attrs:{placeholder:"Please select"},model:{value:e.addForm.gender,callback:function(t){e.$set(e.addForm,"gender",t)},expression:"addForm.gender"}},e._l(e.genderOptions,(function(e){return r("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),r("el-form-item",{attrs:{label:"Date of birth",prop:"dateOfBirth","label-width":e.formLabelWidth}},[r("el-date-picker",{staticClass:"dialog",attrs:{type:"date",placeholder:"Select date",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd"},model:{value:e.addForm.dateOfBirth,callback:function(t){e.$set(e.addForm,"dateOfBirth",t)},expression:"addForm.dateOfBirth"}})],1),r("el-form-item",{attrs:{label:"SSN",prop:"ssn","label-width":e.formLabelWidth}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.ssn,callback:function(t){e.$set(e.addForm,"ssn",t)},expression:"addForm.ssn"}}),r("span",{staticStyle:{color:"purple"}},[e._v("Format: #########")])],1),r("el-form-item",{attrs:{label:"Service Type",prop:"serviceType","label-width":e.formLabelWidth}},[r("el-select",{staticClass:"dialog",attrs:{placeholder:"Please select"},on:{change:e.serviceTypeEvent},model:{value:e.addForm.serviceType,callback:function(t){e.$set(e.addForm,"serviceType",t)},expression:"addForm.serviceType"}},e._l(e.options,(function(e){return r("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),r("el-form-item",{attrs:{label:"Degree",prop:"degree","label-width":e.formLabelWidth}},[r("el-select",{staticClass:"dialog",attrs:{placeholder:"Please select"},model:{value:e.addForm.degree,callback:function(t){e.$set(e.addForm,"degree",t)},expression:"addForm.degree"}},e._l(e.degreeOptions,(function(e){return r("el-option",{key:e.value,attrs:{disabled:e.flag,label:e.label,value:e.value}})})),1)],1),r("el-form-item",{attrs:{label:"Education Qualifications",prop:"educationQualifications","label-width":e.formLabelWidth}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.educationQualifications,callback:function(t){e.$set(e.addForm,"educationQualifications",t)},expression:"addForm.educationQualifications"}})],1),r("el-form-item",{attrs:{label:"Years of experience",prop:"yearsExperience","label-width":e.formLabelWidth}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.yearsExperience,callback:function(t){e.$set(e.addForm,"yearsExperience",t)},expression:"addForm.yearsExperience"}})],1),r("el-form-item",{attrs:{label:"Postal Address",prop:"postalAddress","label-width":e.formLabelWidth}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.postalAddress,callback:function(t){e.$set(e.addForm,"postalAddress",t)},expression:"addForm.postalAddress"}})],1),r("el-form-item",{attrs:{label:"Phone Number",prop:"phoneNumber","label-width":e.formLabelWidth}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.phoneNumber,callback:function(t){e.$set(e.addForm,"phoneNumber",t)},expression:"addForm.phoneNumber"}}),r("span",{staticStyle:{color:"purple"}},[e._v("Format: ##########")])],1),r("el-form-item",{attrs:{label:"Email",prop:"email","label-width":e.formLabelWidth}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.addForm.email,callback:function(t){e.$set(e.addForm,"email",t)},expression:"addForm.email"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:e.addCancel}},[e._v("Cancel")]),r("el-button",{attrs:{type:"primary"},on:{click:e.addHP}},[e._v("Confirm")])],1)],1),r("el-dialog",{attrs:{title:"Register as a care taker",visible:e.dialogRegisterVisible,width:"40%"},on:{"update:visible":function(t){e.dialogRegisterVisible=t}}},[r("el-form",{ref:"registerForm",attrs:{rules:e.registerRules,model:e.registerForm}},[r("el-form-item",{attrs:{label:"First Name",prop:"firstName","label-width":e.formLabelWidths}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.registerForm.firstName,callback:function(t){e.$set(e.registerForm,"firstName",t)},expression:"registerForm.firstName"}})],1),r("el-form-item",{attrs:{label:"Last Name",prop:"lastName","label-width":e.formLabelWidths}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.registerForm.lastName,callback:function(t){e.$set(e.registerForm,"lastName",t)},expression:"registerForm.lastName"}})],1),r("el-form-item",{attrs:{label:"Postal Address",prop:"postalAddress","label-width":e.formLabelWidths}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.registerForm.postalAddress,callback:function(t){e.$set(e.registerForm,"postalAddress",t)},expression:"registerForm.postalAddress"}})],1),r("el-form-item",{attrs:{label:"Phone Number",prop:"phoneNumber","label-width":e.formLabelWidths}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.registerForm.phoneNumber,callback:function(t){e.$set(e.registerForm,"phoneNumber",t)},expression:"registerForm.phoneNumber"}}),r("span",{staticStyle:{color:"purple"}},[e._v("Format: ##########")])],1),r("el-form-item",{attrs:{label:"Email",prop:"email","label-width":e.formLabelWidths}},[r("el-input",{attrs:{autocomplete:"off"},model:{value:e.registerForm.email,callback:function(t){e.$set(e.registerForm,"email",t)},expression:"registerForm.email"}}),r("span",{staticStyle:{color:"purple"}},[e._v("Format: email@domain.com")])],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:e.registerCancel}},[e._v("Cancel")]),r("el-button",{attrs:{type:"primary"},on:{click:e.registerCT}},[e._v("Confirm")])],1)],1)],2)},i=[],l=(r("ac1f"),r("5319"),r("00b4"),r("d3b7"),r("159b"),r("c24f")),s={data:function(){var e=function(e,t,r){9!=t.length?r(new Error("The SSN must be 9 digits")):r()},t=function(e,t,r){t.replace(/\d/g,"")?r(new Error("The experience years must be rounded to an integer.")):r()},a=function(e,t,r){10!=t.length?r(new Error("The phone number must be 10 digits")):r()},i=function(e,t,r){var a=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;a.test(t)?r():r(new Error("The email format is incorrect."))},l=function(e,t,r){var a=/^[A-Za-z]+$/;""!=t&&t.length>=2&&a.test(t)?r():r(new Error("Name must be alphabetic at least two characters."))};return{adList:[],dialogAddVisible:!1,dialogRegisterVisible:!1,imgList:[{imgUrl:r("8554")},{imgUrl:r("405a")},{imgUrl:r("11d9")},{imgUrl:r("bafb")},{imgUrl:r("4d0f")},{imgUrl:r("06d4")}],formLabelWidths:"150px",formLabelWidth:"192px",registerForm:{firstName:"",lastName:"",postalAddress:"",phoneNumber:"",email:""},addForm:{firstName:"",lastName:"",gender:"",dateOfBirth:"",ssn:"",serviceType:"",degree:"",educationQualifications:"",yearsExperience:"",postalAddress:"",jobAdvertisementId:"",phoneNumber:"",email:""},options:[{label:"Nurse",value:"1"},{label:"Physiotherapist",value:"2"},{label:"Psychiatrist",value:"3"}],genderOptions:[{label:"Female",value:"1"},{label:"Male",value:"2"},{label:"Other",value:"3"}],degreeOptions:[{label:"Bachelor",value:"1",flag:!1},{label:"Master",value:"2",flag:!1},{label:"Doctor",value:"3",flag:!1}],registerRules:{firstName:[{required:!0,trigger:"blur",validator:l}],lastName:[{required:!0,trigger:"blur",validator:l}],postalAddress:[{required:!0,trigger:"blur"}],phoneNumber:[{required:!0,trigger:"blur",validator:a}],email:[{required:!0,trigger:"blur",validator:i}]},applyRules:{firstName:[{required:!0,trigger:"blur",validator:l}],lastName:[{required:!0,trigger:"blur",validator:l}],gender:[{required:!0,trigger:"blur"}],dateOfBirth:[{required:!0,trigger:"blur"}],ssn:[{required:!0,trigger:"blur",validator:e}],serviceType:[{required:!0,trigger:"blur"}],degree:[{required:!0,trigger:"blur"}],educationQualifications:[{required:!0,trigger:"blur"}],yearsExperience:[{required:!0,trigger:"blur",validator:t}],postalAddress:[{required:!0,trigger:"blur"}],phoneNumber:[{required:!0,trigger:"blur",validator:a}],email:[{required:!0,trigger:"blur",validator:i}]}}},created:function(){this.getAdList()},methods:{serviceTypeEvent:function(e){this.degreeOptions.forEach((function(e){e.flag=!1})),"1"==e||"2"==e?this.degreeOptions[2].flag=!0:this.degreeOptions[0].flag=!0,this.addForm.degree=""},addCancel:function(){this.dialogAddVisible=!1},applyClick:function(e){this.addForm.jobAdvertisementId=e.jobAdvertisementId,this.dialogAddVisible=!0},goToLogin:function(){this.$router.push("/login")},registerClick:function(){this.dialogRegisterVisible=!0},getAdList:function(){var e=this;Object(l["B"])().then((function(t){e.adList=t}))},registerCancel:function(){this.dialogRegisterVisible=!1},registerCT:function(){var e=this,t=this.registerForm;this.loading=!0,Object(l["a"])(t).then((function(t){if(e.dialogRegisterVisible=!1,"200"!==t.code)return t.code,e.$message({message:t.msg,type:"error"}),void(e.loading=!1);e.$message({message:"Register success, please wait for feedback.",type:"success"})}))},addHP:function(){var e=this,t=this.addForm;this.loading=!0,Object(l["d"])(t).then((function(t){if(e.dialogAddVisible=!1,"200"!==t.code)return t.code,e.$message({message:t.msg,type:"error"}),void(e.loading=!1);e.$message({message:"Apply success, please wait for feedback.",type:"success"})}))}}},o=s,d=(r("c037"),r("2877")),n=Object(d["a"])(o,a,i,!1,null,"290cda48",null);t["default"]=n.exports},bafb:function(e,t,r){e.exports=r.p+"static/img/4.5b899413.jpg"},c037:function(e,t,r){"use strict";r("6519")}}]);