(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ef92223c"],{2017:function(e,t,s){"use strict";s("cafe")},"316c":function(e,t,s){"use strict";s("e022")},4127:function(e,t,s){"use strict";var r=s("d233"),n=s("b313"),i={brackets:function(e){return e+"[]"},indices:function(e,t){return e+"["+t+"]"},repeat:function(e){return e}},o=Array.isArray,a=Array.prototype.push,l=function(e,t){a.apply(e,o(t)?t:[t])},c=Date.prototype.toISOString,u={delimiter:"&",encode:!0,encoder:r.encode,encodeValuesOnly:!1,serializeDate:function(e){return c.call(e)},skipNulls:!1,strictNullHandling:!1},d=function e(t,s,n,i,a,c,d,p,f,y,h,b){var m=t;if("function"===typeof d?m=d(s,m):m instanceof Date&&(m=y(m)),null===m){if(i)return c&&!b?c(s,u.encoder):s;m=""}if("string"===typeof m||"number"===typeof m||"boolean"===typeof m||r.isBuffer(m)){if(c){var g=b?s:c(s,u.encoder);return[h(g)+"="+h(c(m,u.encoder))]}return[h(s)+"="+h(String(m))]}var w,v=[];if("undefined"===typeof m)return v;if(o(d))w=d;else{var Q=Object.keys(m);w=p?Q.sort(p):Q}for(var S=0;S<w.length;++S){var k=w[S];a&&null===m[k]||(o(m)?l(v,e(m[k],n(s,k),n,i,a,c,d,p,f,y,h,b)):l(v,e(m[k],s+(f?"."+k:"["+k+"]"),n,i,a,c,d,p,f,y,h,b)))}return v};e.exports=function(e,t){var s=e,a=t?r.assign({},t):{};if(null!==a.encoder&&"undefined"!==typeof a.encoder&&"function"!==typeof a.encoder)throw new TypeError("Encoder has to be a function.");var c="undefined"===typeof a.delimiter?u.delimiter:a.delimiter,p="boolean"===typeof a.strictNullHandling?a.strictNullHandling:u.strictNullHandling,f="boolean"===typeof a.skipNulls?a.skipNulls:u.skipNulls,y="boolean"===typeof a.encode?a.encode:u.encode,h="function"===typeof a.encoder?a.encoder:u.encoder,b="function"===typeof a.sort?a.sort:null,m="undefined"!==typeof a.allowDots&&a.allowDots,g="function"===typeof a.serializeDate?a.serializeDate:u.serializeDate,w="boolean"===typeof a.encodeValuesOnly?a.encodeValuesOnly:u.encodeValuesOnly;if("undefined"===typeof a.format)a.format=n["default"];else if(!Object.prototype.hasOwnProperty.call(n.formatters,a.format))throw new TypeError("Unknown format option provided.");var v,Q,S=n.formatters[a.format];"function"===typeof a.filter?(Q=a.filter,s=Q("",s)):o(a.filter)&&(Q=a.filter,v=Q);var k,O=[];if("object"!==typeof s||null===s)return"";k=a.arrayFormat in i?a.arrayFormat:"indices"in a?a.indices?"indices":"repeat":"indices";var A=i[k];v||(v=Object.keys(s)),b&&v.sort(b);for(var I=0;I<v.length;++I){var P=v[I];f&&null===s[P]||l(O,d(s[P],P,A,p,f,y?h:null,Q,b,m,g,S,w))}var j=O.join(c),x=!0===a.addQueryPrefix?"?":"";return j.length>0?x+j:""}},4328:function(e,t,s){"use strict";var r=s("4127"),n=s("9e6a"),i=s("b313");e.exports={formats:i,parse:n,stringify:r}},"9e6a":function(e,t,s){"use strict";var r=s("d233"),n=Object.prototype.hasOwnProperty,i={allowDots:!1,allowPrototypes:!1,arrayLimit:20,decoder:r.decode,delimiter:"&",depth:5,parameterLimit:1e3,plainObjects:!1,strictNullHandling:!1},o=function(e,t){for(var s={},r=t.ignoreQueryPrefix?e.replace(/^\?/,""):e,o=t.parameterLimit===1/0?void 0:t.parameterLimit,a=r.split(t.delimiter,o),l=0;l<a.length;++l){var c,u,d=a[l],p=d.indexOf("]="),f=-1===p?d.indexOf("="):p+1;-1===f?(c=t.decoder(d,i.decoder),u=t.strictNullHandling?null:""):(c=t.decoder(d.slice(0,f),i.decoder),u=t.decoder(d.slice(f+1),i.decoder)),n.call(s,c)?s[c]=[].concat(s[c]).concat(u):s[c]=u}return s},a=function(e,t,s){for(var r=t,n=e.length-1;n>=0;--n){var i,o=e[n];if("[]"===o&&s.parseArrays)i=[].concat(r);else{i=s.plainObjects?Object.create(null):{};var a="["===o.charAt(0)&&"]"===o.charAt(o.length-1)?o.slice(1,-1):o,l=parseInt(a,10);s.parseArrays||""!==a?!isNaN(l)&&o!==a&&String(l)===a&&l>=0&&s.parseArrays&&l<=s.arrayLimit?(i=[],i[l]=r):"__proto__"!==a&&(i[a]=r):i={0:r}}r=i}return r},l=function(e,t,s){if(e){var r=s.allowDots?e.replace(/\.([^.[]+)/g,"[$1]"):e,i=/(\[[^[\]]*])/,o=/(\[[^[\]]*])/g,l=i.exec(r),c=l?r.slice(0,l.index):r,u=[];if(c){if(!s.plainObjects&&n.call(Object.prototype,c)&&!s.allowPrototypes)return;u.push(c)}var d=0;while(null!==(l=o.exec(r))&&d<s.depth){if(d+=1,!s.plainObjects&&n.call(Object.prototype,l[1].slice(1,-1))&&!s.allowPrototypes)return;u.push(l[1])}return l&&u.push("["+r.slice(l.index)+"]"),a(u,t,s)}};e.exports=function(e,t){var s=t?r.assign({},t):{};if(null!==s.decoder&&void 0!==s.decoder&&"function"!==typeof s.decoder)throw new TypeError("Decoder has to be a function.");if(s.ignoreQueryPrefix=!0===s.ignoreQueryPrefix,s.delimiter="string"===typeof s.delimiter||r.isRegExp(s.delimiter)?s.delimiter:i.delimiter,s.depth="number"===typeof s.depth?s.depth:i.depth,s.arrayLimit="number"===typeof s.arrayLimit?s.arrayLimit:i.arrayLimit,s.parseArrays=!1!==s.parseArrays,s.decoder="function"===typeof s.decoder?s.decoder:i.decoder,s.allowDots="boolean"===typeof s.allowDots?s.allowDots:i.allowDots,s.plainObjects="boolean"===typeof s.plainObjects?s.plainObjects:i.plainObjects,s.allowPrototypes="boolean"===typeof s.allowPrototypes?s.allowPrototypes:i.allowPrototypes,s.parameterLimit="number"===typeof s.parameterLimit?s.parameterLimit:i.parameterLimit,s.strictNullHandling="boolean"===typeof s.strictNullHandling?s.strictNullHandling:i.strictNullHandling,""===e||null===e||"undefined"===typeof e)return s.plainObjects?Object.create(null):{};for(var n="string"===typeof e?o(e,s):e,a=s.plainObjects?Object.create(null):{},c=Object.keys(n),u=0;u<c.length;++u){var d=c[u],p=l(d,n[d],s);a=r.merge(a,p,s)}return r.compact(a)}},"9ed6":function(e,t,s){"use strict";s.r(t);var r=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"login-container"},[r("div",{staticClass:"login-module"},[r("el-row",[r("el-col",{attrs:{span:12}},[r("img",{staticStyle:{"border-top-left-radius":"8px","border-bottom-left-radius":"8px"},attrs:{src:s("b640"),alt:"",srcset:"",width:"400px",height:"400px"}})]),r("el-col",{attrs:{span:12}},[r("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:e.loginForm,rules:e.loginRules,"auto-complete":"on","label-position":"left"}},[r("div",{staticClass:"title-container"},[r("div",{staticClass:"title"},[e._v("Welcome Back!")])]),r("el-form-item",{attrs:{prop:"username"}},[r("span",{staticClass:"svg-container",attrs:{span:""}},[r("svg-icon",{attrs:{"icon-class":"user"}})],1),r("el-input",{ref:"username",attrs:{placeholder:"Username",name:"username",type:"text",tabindex:"1","auto-complete":"on"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),r("el-form-item",{attrs:{prop:"password"}},[r("span",{staticClass:"svg-container"},[r("svg-icon",{attrs:{"icon-class":"password"}})],1),r("el-input",{key:e.passwordType,ref:"password",attrs:{type:e.passwordType,placeholder:"Password",name:"password",tabindex:"2","auto-complete":"on"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleLogin(t)}},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),r("el-button",{staticStyle:{width:"100%","margin-bottom":"30px"},attrs:{loading:e.loading,type:"primary"},nativeOn:{click:function(t){return t.preventDefault(),e.handleLogin(t)}}},[e._v("Sign in")])],1)],1)],1)],1),r("el-dialog",{attrs:{title:"Please fill in security questions",visible:e.centerDialogVisibleFill,width:"30%"},on:{"update:visible":function(t){e.centerDialogVisibleFill=t}}},[r("h4",[e._v("The first security question")]),r("el-select",{staticClass:"securityQuestions",attrs:{filterable:"",placeholder:"Please select"},on:{change:e.selectChange},model:{value:e.firstSecurityQuestionsSelect,callback:function(t){e.firstSecurityQuestionsSelect=t},expression:"firstSecurityQuestionsSelect"}},e._l(e.allOptions,(function(e){return r("el-option",{key:e.bankQuestionId,attrs:{disabled:e.disabled,label:e.question,value:e.bankQuestionId}})})),1),r("el-input",{staticClass:"securityQuestions",attrs:{placeholder:"Please enter"},model:{value:e.firstSecurityQuestionsInput,callback:function(t){e.firstSecurityQuestionsInput=t},expression:"firstSecurityQuestionsInput"}}),r("h4",[e._v("The second security question")]),r("el-select",{staticClass:"securityQuestions",attrs:{filterable:"",placeholder:"Please select"},on:{change:e.selectChange},model:{value:e.secondSecurityQuestionsSelect,callback:function(t){e.secondSecurityQuestionsSelect=t},expression:"secondSecurityQuestionsSelect"}},e._l(e.allOptions,(function(e){return r("el-option",{key:e.bankQuestionId,attrs:{disabled:e.disabled,label:e.question,value:e.bankQuestionId}})})),1),r("el-input",{staticClass:"securityQuestions",attrs:{placeholder:"Please enter"},model:{value:e.secondSecurityQuestionsInput,callback:function(t){e.secondSecurityQuestionsInput=t},expression:"secondSecurityQuestionsInput"}}),r("h4",[e._v("The third security question")]),r("el-select",{staticClass:"securityQuestions",attrs:{filterable:"",placeholder:"Please select"},on:{change:e.selectChange},model:{value:e.thirdSecurityQuestionsSelect,callback:function(t){e.thirdSecurityQuestionsSelect=t},expression:"thirdSecurityQuestionsSelect"}},e._l(e.allOptions,(function(e){return r("el-option",{key:e.bankQuestionId,attrs:{disabled:e.disabled,label:e.question,value:e.bankQuestionId}})})),1),r("el-input",{staticClass:"securityQuestions",attrs:{placeholder:"Please enter"},model:{value:e.thirdSecurityQuestionsInput,callback:function(t){e.thirdSecurityQuestionsInput=t},expression:"thirdSecurityQuestionsInput"}}),r("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.centerDialogVisibleFill=!1}}},[e._v("Cancel")]),r("el-button",{attrs:{type:"primary"},on:{click:e.centerDialogVisibleFillClick}},[e._v("Submit")])],1)],1),r("el-dialog",{attrs:{title:"Please answer security questions",visible:e.centerDialogVisibleAnswer,width:"30%"},on:{"update:visible":function(t){e.centerDialogVisibleAnswer=t}}},[r("el-select",{staticClass:"securityQuestions",attrs:{filterable:"",placeholder:"Please select"},model:{value:e.securityQuestionsAnswerSelect,callback:function(t){e.securityQuestionsAnswerSelect=t},expression:"securityQuestionsAnswerSelect"}},e._l(e.answerOptions,(function(e){return r("el-option",{key:e.questionAnswer,attrs:{label:e.question,value:e.questionAnswer}})})),1),r("el-input",{staticClass:"securityQuestions",attrs:{placeholder:"Please enter"},model:{value:e.securityQuestionsAnswerInput,callback:function(t){e.securityQuestionsAnswerInput=t},expression:"securityQuestionsAnswerInput"}}),r("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.centerDialogVisibleAnswer=!1}}},[e._v("Cancel")]),r("el-button",{attrs:{type:"primary"},on:{click:e.centerDialogVisibleAnswerClick}},[e._v("Submit")])],1)],1),r("el-dialog",{attrs:{title:"Please change your password for first login",visible:e.centerDialogVisiblePassword,width:"30%","close-on-click-modal":!1},on:{"update:visible":function(t){e.centerDialogVisiblePassword=t}}},[r("div",{staticStyle:{color:"#f56c6c"}},[r("div",[e._v("* Must contain a minimum of six characters with no spaces")]),r("div",[e._v("* Must include alphanumeric characters")]),r("div",[e._v(" * Must include one of the special characters {~, !, @, #, $, %, ˆ, &, *, +} ")])]),r("h4",[e._v("please enter your old password")]),r("el-input",{staticClass:"securityQuestions",attrs:{type:"password",placeholder:"Please enter your old password"},model:{value:e.oldPassword,callback:function(t){e.oldPassword=t},expression:"oldPassword"}}),r("h4",[e._v("please enter your new password")]),r("el-input",{staticClass:"securityQuestions",attrs:{type:"password",placeholder:"Please enter your new password"},model:{value:e.newPassword,callback:function(t){e.newPassword=t},expression:"newPassword"}}),r("h4",[e._v("please confirm your new password")]),r("el-input",{staticClass:"securityQuestions",attrs:{type:"password",placeholder:"Please confirm your new password"},model:{value:e.confirmPassword,callback:function(t){e.confirmPassword=t},expression:"confirmPassword"}}),r("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.centerDialogVisiblePassword=!1}}},[e._v("Cancel")]),r("el-button",{attrs:{type:"primary"},on:{click:e.centerDialogVisiblePasswordClick}},[e._v("Submit")])],1)],1)],1)},n=[],i=(s("d3b7"),s("159b"),s("ac1f"),s("00b4"),s("1276"),s("c24f")),o=(s("4328"),{name:"Login",data:function(){var e=function(e,t,s){t.length<6?s(new Error("The password can not be less than 6 digits")):s()};return{userId:"",answerIndex:0,centerDialogVisiblePassword:!1,centerDialogVisibleFill:!1,centerDialogVisibleAnswer:!1,oldPassword:"",newPassword:"",confirmPassword:"",firstSecurityQuestionsSelect:"",firstSecurityQuestionsInput:"",secondSecurityQuestionsSelect:"",secondSecurityQuestionsInput:"",thirdSecurityQuestionsSelect:"",thirdSecurityQuestionsInput:"",securityQuestionsAnswerSelect:"",securityQuestionsAnswerInput:"",loginForm:{username:"",password:""},loginRules:{username:[{required:!0,trigger:"blur"}],password:[{required:!0,trigger:"blur",validator:e}]},loading:!1,passwordType:"password",redirect:void 0,allOptions:[],answerOptions:[]}},watch:{$route:{handler:function(e){this.redirect=e.query&&e.query.redirect},immediate:!0}},created:function(){},methods:{centerDialogVisiblePasswordClick:function(){var e=this;if(this.newPassword===this.confirmPassword){var t={username:this.loginForm.username,password:this.newPassword};Object(i["r"])(t).then((function(t){e.$message({message:t.msg,type:"200"==t.code?"success":"error"}),"200"==t.code&&(e.allQuestions(),e.centerDialogVisibleFill=!0,e.centerDialogVisiblePassword=!1)}))}else this.$message({message:"Confirm password is not the same as your first enter.",type:"error"})},selectChange:function(e){var t=this;this.allOptions.forEach((function(e){e.disabled=!1,t.firstSecurityQuestionsSelect==e.bankQuestionId&&(e.disabled=!0),t.secondSecurityQuestionsSelect==e.bankQuestionId&&(e.disabled=!0),t.thirdSecurityQuestionsSelect==e.bankQuestionId&&(e.disabled=!0)}))},allQuestions:function(){var e=this,t={};Object(i["j"])(t).then((function(t){e.allOptions=t})).catch((function(e){console.log(e)}))},submitQuestions:function(){var e=this,t=this.$store.state.user.userId,s=[{bankQuestionId:this.firstSecurityQuestionsSelect,answer:this.firstSecurityQuestionsInput,userId:t},{bankQuestionId:this.secondSecurityQuestionsSelect,answer:this.secondSecurityQuestionsInput,userId:t},{bankQuestionId:this.thirdSecurityQuestionsSelect,answer:this.thirdSecurityQuestionsInput,userId:t}],r=!0;s.forEach((function(t,s){var n=/^[a-zA-Z]{4,}$/;if(!n.test(t.answer))return r=!1,void e.$message({message:"Answer must be alphanumeric characters at least four characters with no spaces.",type:"error"})})),r&&s.forEach((function(t,s){Object(i["U"])(t).then((function(t){2==s&&(e.centerDialogVisibleFill=!1,e.$router.push({path:e.redirect||"/"}),e.$message({message:t.msg,type:"success"})),e.$store.state.user.roles=[]})).catch((function(e){console.log(e)}))}))},answerQuestions:function(){var e=this,t={userId:this.$store.state.user.userId};Object(i["l"])(t).then((function(t){t.forEach((function(e,t){e.questionAnswer=e.questionId+"|"+e.answer})),e.answerOptions=t,e.securityQuestionsAnswerSelect=t[e.answerIndex].questionAnswer,e.$store.state.user.roles=[]})).catch((function(e){}))},addStaff:function(){var e={};Object(i["g"])({params:e}).then((function(e){})).catch((function(e){}))},centerDialogVisibleFillClick:function(){this.submitQuestions()},centerDialogVisibleAnswerClick:function(){var e=this,t=this.securityQuestionsAnswerSelect.split("|");if(t[1]==this.securityQuestionsAnswerInput)this.answerIndex=0,this.$router.push("/");else if(this.securityQuestionsAnswerInput="",this.answerIndex++,this.answerIndex<this.answerOptions.length)this.securityQuestionsAnswerSelect=this.answerOptions[this.answerIndex].questionAnswer,this.$message({message:"Answer is wrong.",type:"warning"});else{var s={username:this.loginForm.username};Object(i["q"])(s).then((function(){e.centerDialogVisibleAnswer=!1,e.$message({message:"All security questions answered incorrectly, your account has been locked",type:"error"})}))}},showPwd:function(){var e=this;"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((function(){e.$refs.password.focus()}))},handleLogin:function(){var e=this,t=this;this.$refs.loginForm.validate((function(s){if(!s)return console.log("error submit!!"),!1;e.loading=!0,e.$store.dispatch("user/login",e.loginForm).then((function(s){if("200"!==s.code)return s.code,e.$message({message:s.msg,type:"error"}),void(e.loading=!1);t.$store.state.user.username=t.loginForm.username,window.localStorage.setItem("username",t.loginForm.username),t.$store.dispatch("user/getInfo",{username:t.loginForm.username}).then((function(r){t.$nextTick((function(){t.userId=t.$store.state.user.userId}));var n=s.isFirst;"false"==n?(e.answerQuestions(),e.centerDialogVisibleAnswer=!0):"true"==n&&(e.centerDialogVisiblePassword=!0),e.loading=!1}))})).catch((function(){e.loading=!1}))}))}}}),a=o,l=(s("2017"),s("316c"),s("2877")),c=Object(l["a"])(a,r,n,!1,null,"5d7ebc31",null);t["default"]=c.exports},b313:function(e,t,s){"use strict";var r=String.prototype.replace,n=/%20/g;e.exports={default:"RFC3986",formatters:{RFC1738:function(e){return r.call(e,n,"+")},RFC3986:function(e){return String(e)}},RFC1738:"RFC1738",RFC3986:"RFC3986"}},b640:function(e,t,s){e.exports=s.p+"static/img/logo.3355a86f.jpg"},cafe:function(e,t,s){},d233:function(e,t,s){"use strict";var r=Object.prototype.hasOwnProperty,n=function(){for(var e=[],t=0;t<256;++t)e.push("%"+((t<16?"0":"")+t.toString(16)).toUpperCase());return e}(),i=function(e){var t;while(e.length){var s=e.pop();if(t=s.obj[s.prop],Array.isArray(t)){for(var r=[],n=0;n<t.length;++n)"undefined"!==typeof t[n]&&r.push(t[n]);s.obj[s.prop]=r}}return t},o=function(e,t){for(var s=t&&t.plainObjects?Object.create(null):{},r=0;r<e.length;++r)"undefined"!==typeof e[r]&&(s[r]=e[r]);return s},a=function e(t,s,n){if(!s)return t;if("object"!==typeof s){if(Array.isArray(t))t.push(s);else{if(!t||"object"!==typeof t)return[t,s];(n&&(n.plainObjects||n.allowPrototypes)||!r.call(Object.prototype,s))&&(t[s]=!0)}return t}if(!t||"object"!==typeof t)return[t].concat(s);var i=t;return Array.isArray(t)&&!Array.isArray(s)&&(i=o(t,n)),Array.isArray(t)&&Array.isArray(s)?(s.forEach((function(s,i){if(r.call(t,i)){var o=t[i];o&&"object"===typeof o&&s&&"object"===typeof s?t[i]=e(o,s,n):t.push(s)}else t[i]=s})),t):Object.keys(s).reduce((function(t,i){var o=s[i];return r.call(t,i)?t[i]=e(t[i],o,n):t[i]=o,t}),i)},l=function(e,t){return Object.keys(t).reduce((function(e,s){return e[s]=t[s],e}),e)},c=function(e){try{return decodeURIComponent(e.replace(/\+/g," "))}catch(t){return e}},u=function(e){if(0===e.length)return e;for(var t="string"===typeof e?e:String(e),s="",r=0;r<t.length;++r){var i=t.charCodeAt(r);45===i||46===i||95===i||126===i||i>=48&&i<=57||i>=65&&i<=90||i>=97&&i<=122?s+=t.charAt(r):i<128?s+=n[i]:i<2048?s+=n[192|i>>6]+n[128|63&i]:i<55296||i>=57344?s+=n[224|i>>12]+n[128|i>>6&63]+n[128|63&i]:(r+=1,i=65536+((1023&i)<<10|1023&t.charCodeAt(r)),s+=n[240|i>>18]+n[128|i>>12&63]+n[128|i>>6&63]+n[128|63&i])}return s},d=function(e){for(var t=[{obj:{o:e},prop:"o"}],s=[],r=0;r<t.length;++r)for(var n=t[r],o=n.obj[n.prop],a=Object.keys(o),l=0;l<a.length;++l){var c=a[l],u=o[c];"object"===typeof u&&null!==u&&-1===s.indexOf(u)&&(t.push({obj:o,prop:c}),s.push(u))}return i(t)},p=function(e){return"[object RegExp]"===Object.prototype.toString.call(e)},f=function(e){return null!==e&&"undefined"!==typeof e&&!!(e.constructor&&e.constructor.isBuffer&&e.constructor.isBuffer(e))};e.exports={arrayToObject:o,assign:l,compact:d,decode:c,encode:u,isBuffer:f,isRegExp:p,merge:a}},e022:function(e,t,s){}}]);