(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[532],{1919:function(e,t,n){Promise.resolve().then(n.bind(n,4356))},2196:function(e,t,n){"use strict";n.d(t,{R1:function(){return c},N6:function(){return k},_R:function(){return x},X:function(){return w},Kk:function(){return F},tR:function(){return I},UT:function(){return m},Gs:function(){return S},Gx:function(){return y},zf:function(){return p},x0:function(){return u},z2:function(){return N},hU:function(){return _},nW:function(){return C},v0:function(){return f},aG:function(){return v},hI:function(){return g},eB:function(){return P},NE:function(){return q},Ju:function(){return T},Wk:function(){return R},eN:function(){return z},DP:function(){return E},_b:function(){return G},$_:function(){return h},tu:function(){return D},lK:function(){return O},tV:function(){return r},_U:function(){return i},Gb:function(){return b},VR:function(){return j},Mf:function(){return Q},qL:function(){return d}});var a=n(5953),s=n(1712);n(2040);let o=a.Z.create({baseURL:"/",withCredentials:!0,timeout:1e5});function l(){s.Z.remove("isv_token")}async function r(e){return o.post("/wms/warehouse/get",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function i(e,t){return o.post("/wms/warehouse/get",e,{params:t}).then(e=>(console.log(e),e.data.data))}async function c(e){return o.post("/wms/warehouse/add",e).then(e=>console.log(e))}async function u(e){return o.post("/wms/warehouse/delete",{id:e}).then(e=>console.log(e))}async function d(e){return o.post("/wms/warehouse/update",e).then(e=>console.log(e))}async function h(e,t){return o.post("/wms/storagelocation/get",e,{params:t}).then(e=>(console.log(e),e.data.data))}async function m(e){return o.post("/wms/storagelocation/add",e).then(e=>(console.log(e),e.data.data))}async function p(e){return o.post("/wms/storagelocation/delete",e).then(e=>(console.log(e),e.data.data))}async function f(e,t){return o.post("/wms/material/get",t,{params:e}).then(e=>(console.log(e),e.data.data))}async function g(e){return o.post("/wms/material/get",e).then(e=>(console.log(e),e.data.data))}async function x(e){return o.post("/wms/material/add",e).then(e=>(console.log(e),e.data.data))}async function j(e){return o.post("/wms/material/update",e).then(e=>(console.log(e),e.data.data))}async function y(e){return o.post("/wms/material/delete",e).then(e=>(console.log(e),e.data.data))}async function v(){return o.post("/wms/rfidmaterial/get").then(e=>(console.log(e),e.data.data))}async function w(e){return o.post("/wms/rfidmaterial/add",e).then(e=>(console.log(e),e.data.data))}async function k(e){return o.post("/wms/inbound/add",e).then(e=>(console.log(e),e.data.data))}async function b(e){return o.post("/wms/inbound/update",e).then(e=>(console.log(e),e.data.data))}async function N(e){return o.post("/wms/inbound/get",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function C(e,t){return o.post("/wms/inbound/get",e,{params:t}).then(e=>(console.log(e),e.data.data))}async function S(e){return o.post("/wms/inbound/delete",e).then(e=>(console.log(e),e.data.data))}async function _(e){return o.post("/wms/inbound/detail",e).then(e=>(console.log(e),e.data.data))}async function F(e){return o.post("/wms/outbound/add",e).then(e=>(console.log(e),e.data.data))}async function P(e){return o.post("/wms/outbound/get",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function T(e){return o.post("/wms/outbound/get",e).then(e=>(console.log(e),e.data.data))}async function Q(e){return o.post("/wms/outbound/update",e).then(e=>(console.log(e),e.data.data))}async function q(e){return o.post("/wms/outbound/detail",e).then(e=>(console.log(e),e.data.data))}async function I(e){return o.post("/wms/stocktaking/add",e).then(e=>(console.log(e),e.data.data))}async function z(e){return o.post("/wms/stocktaking/get",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function G(e,t){return o.post("/wms/stocktaking/get",e,{params:t}).then(e=>(console.log(e),e.data.data))}async function E(e){return o.post("/wms/stocktaking/detail",e).then(e=>(console.log(e),e.data.data))}async function D(e){return o.post("/wms/warehouse/namemap",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function R(e){return o.post("/wms/storagelocation/namemap",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function O(e){return o.post("/wms/warehousestoragelocation/idmap",{},{params:e}).then(e=>(console.log(e),e.data.data))}o.interceptors.request.use(e=>(null!=s.Z.get("isv_token")&&(e.headers.userToken=s.Z.get("isv_token")),e),e=>Promise.reject(e)),o.interceptors.response.use(function(e){return 401===e.data.code?(l(),Promise.reject()):e},function(e){return(console.log(e),401===e.response.status)?(l(),Promise.reject()):Promise.reject(e)})},4356:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return p}});var a=n(9268),s=n(6006),o=n(9698),l=n(1466),r=n(7221);n(690);var i=n(2196),c=function(e){let{headers:t,onSelectionChange:n}=e,[l,r]=(0,s.useState)(1),[c,u]=(0,s.useState)(10),[d,h]=(0,s.useState)(0),[m,p]=(0,s.useState)([]);return(0,s.useEffect)(()=>{(0,i.v0)({pageNum:l,pageSize:c},{}).then(e=>{console.log(e),p(e.list),h(e.total)})},[l,c]),(0,a.jsxs)(a.Fragment,{children:[(0,a.jsx)(o.wQF,{rows:m,headers:t,render:e=>{let{rows:t,headers:s,getHeaderProps:l,getSelectionProps:r,onInputChange:i}=e;return(0,a.jsxs)(o.xJi,{children:[(0,a.jsx)(o.fjU,{children:(0,a.jsx)(o.Vj0,{children:(0,a.jsx)(o.Ys1,{onChange:i})})}),(0,a.jsxs)(o.iA_,{children:[(0,a.jsx)(o.ssF,{children:(0,a.jsxs)(o.SCH,{children:[(0,a.jsx)(o.elY,{...r()}),s.map(e=>(0,a.jsx)(o.xDH,{...l({header:e}),children:e.header},e.key))]})}),(0,a.jsx)(o.RMI,{children:t.map((e,t)=>(0,a.jsxs)(o.SCH,{children:[(0,a.jsx)(o.wix,{...r({row:e}),onChange:t=>{var a;let s=(null===(a=document.getElementById("quantity-".concat(e.id)))||void 0===a?void 0:a.value)||0;n(e.cells.find(e=>"product_code"===e.id.split(":")[1]).value,e.cells.find(e=>"name"===e.id.split(":")[1]).value,"quantity",s,t)}}),s.map(t=>{let s=e.cells.find(e=>e.id.split(":")[1]===t.key);return"quantity"===s.id.split(":")[1]?(0,a.jsx)(o.pj1,{children:(0,a.jsx)(o.oil,{className:"w-20",id:"quantity-".concat(e.id),value:s.value,onChange:t=>{let a=r({row:e}).checked;n(e.cells.find(e=>"product_code"===e.id.split(":")[1]).value,e.cells.find(e=>"name"===e.id.split(":")[1]).value,"quantity",t.target.value,a)}})},t.key):(0,a.jsx)(o.pj1,{children:s?s.value:""},t.key)})]},t))})]})]})}}),(0,a.jsx)(o.tlE,{backwardText:"Previous page",forwardText:"Next page",itemsPerPageText:"Items per page:",page:l,pageNumberText:"Page Number",pageSize:c,pageSizes:[5,10,20,30,40,50],totalItems:d,onChange:e=>{let{page:t,pageSize:n}=e;r(t),u(n)}})]})},u=n(6008);let d=["red","magenta","purple","blue","cyan","teal","green","gray","cool-gray","outline"],h=[{key:"name",header:"Material Name"},{key:"product_code",header:"Material Code"},{key:"specification",header:"Specification"},{key:"quantity",header:"Quantity"},{key:"unit",header:"Unit"}];var m=function(){let e=(0,u.useRouter)(),[t,n]=(0,s.useState)({sourceInvalid:!1,typeInvalid:!1}),[m,p]=(0,s.useState)({type:"",source:"manual",status:"Done",note:""}),f=e=>{let{id:t,value:n}=e.target;p(e=>({...e,[t]:n}))},[g,x]=(0,s.useState)([]),[j,y]=(0,s.useState)({}),[v,w]=(0,s.useState)({}),[k,b]=(0,s.useState)([]);(0,s.useEffect)(()=>{(0,i.tu)({pageNum:1,pageSize:999999}).then(e=>{let t=e.list.reduce((e,t)=>(e[t.id]=t.name,e),{});y(t)}).catch(e=>{console.error("Failed to fetch WH name map:",e)}),(0,i.Wk)({pageNum:1,pageSize:999999}).then(e=>{let t=e.list.reduce((e,t)=>(e[t.id]=t.name,e),{});w(t)}).catch(e=>{console.error("Failed to fetch SL name map:",e)}),(0,i.lK)({pageNum:1,pageSize:999999}).then(e=>{b(e.list)}).catch(e=>{console.error("Error fetching warehouse data:",e)})},[]);let N=Object.entries(j).map(e=>{let[t,n]=e;return{id:t,name:n}});console.log(k);let[C,S]=(0,s.useState)([]),[_,F]=(0,s.useState)(""),[P,T]=(0,s.useState)(""),[Q,q]=(0,s.useState)(!1);console.log(m,g),(0,s.useEffect)(()=>{if(""!=_){let e=k.filter(e=>e.id===_);console.log(e,_),S(e[0].warehouseNamemap)}},[_,k]);let I=(e,t,n,a,s,o)=>{x(l=>{let r=[...l];if(o){let o=r[e].materials.findIndex(e=>e.material_code===t);-1!==o?r[e].materials[o][a]=s:r[e].materials.push({material_code:t,material_name:n,[a]:s})}else r[e].materials=r[e].materials.filter(e=>e.id!==t);return r})},z=e=>{x(t=>{let n=[...t];return n.splice(e,1),n})};return j&&v&&k?(0,a.jsxs)("div",{children:[(0,a.jsxs)("div",{className:" mt-12",children:[(0,a.jsxs)(o.rjZ,{className:"pl-0",children:[(0,a.jsx)(o.sgG,{sm:1,md:3,lg:5,children:(0,a.jsxs)(o.PhF,{className:"mb-10",id:"type",defaultValue:"",labelText:"Stocktaking Type",invalid:t.typeInvalid,invalidText:"This field cannot be empty",value:m.type,onChange:f,required:!0,children:[(0,a.jsx)(o.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),(0,a.jsx)(o.QlF,{value:"Dynamic",text:"Dynamic"}),(0,a.jsx)(o.QlF,{value:"Static",text:"Static"})]})}),(0,a.jsx)(o.sgG,{sm:1,md:3,lg:5,children:(0,a.jsxs)(o.PhF,{className:"mb-10",id:"source",defaultValue:"",labelText:"Source",invalid:t.sourceInvalid,invalidText:"This field cannot be empty",value:m.source,onChange:f,required:!0,readOnly:!0,children:[(0,a.jsx)(o.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),(0,a.jsx)(o.QlF,{value:"PDA",text:"PDA"}),(0,a.jsx)(o.QlF,{value:"manual",text:"Manual"})]})}),(0,a.jsx)(o.sgG,{sm:1,md:3,lg:5,children:(0,a.jsxs)(o.PhF,{className:"mb-10",id:"status",defaultValue:"",labelText:"Status",readOnly:!0,value:m.status,onChange:f,required:!0,children:[(0,a.jsx)(o.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),(0,a.jsx)(o.QlF,{value:"Done",text:"Done"}),(0,a.jsx)(o.QlF,{value:"Executing",text:"Executing"}),(0,a.jsx)(o.QlF,{value:"To-do",text:"To-do"})]})}),(0,a.jsx)(o.sgG,{sm:1,md:3,lg:5,children:(0,a.jsx)(o.Kx8,{className:"mb-10 w-full",labelText:"Note",rows:4,id:"note",value:m.note,onChange:f,placeholder:"Note Placeholder"})})]}),(0,a.jsx)(o.GQc,{className:"w-full mb-10 pl-0"}),(0,a.jsxs)(o.rjZ,{className:"pl-0",children:[(0,a.jsx)(o.sgG,{sm:4,md:3,lg:4,children:(0,a.jsxs)(o.PhF,{className:"mb-10",id:"warehouse",defaultValue:"",labelText:"Warehouse",value:_,onChange:e=>{F(e.target.value)},required:!0,children:[(0,a.jsx)(o.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),N.map(e=>(0,a.jsx)(o.QlF,{value:e.id,text:e.name},e.id))]})}),(0,a.jsx)(o.sgG,{sm:4,md:3,lg:4,children:(0,a.jsxs)(o.PhF,{className:"mb-10",id:"shelf_location",defaultValue:"",labelText:"Shelf Location",value:P,onChange:e=>{T(e.target.value)},required:!0,children:[(0,a.jsx)(o.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),C.map(e=>(0,a.jsx)(o.QlF,{value:e.id,text:e.name},e.id))]})}),(0,a.jsx)(o.sgG,{sm:1,md:1,lg:2,children:(0,a.jsx)(o.hU,{className:"mb-10 ",size:"md",onClick:function(){if(_&&P){let e={warehouse:{id:_,name:j[_]},shelf_location:{id:P,name:v[P]},materials:[]};x([...g,e]),F(""),T("")}},children:(0,a.jsx)(l.mm,{})})})]}),(0,a.jsx)("div",{className:"mb-10",children:g.map((e,t)=>(0,a.jsx)(o.Vp9,{type:d[t%d.length],children:(0,a.jsxs)("div",{className:"flex ",children:[e.warehouse.name,"-",e.shelf_location.name,(0,a.jsx)(r.x8,{className:"ml-1",size:16,onClick:e=>{e.stopPropagation(),z(t)}})]})},t))}),g&&g.length>0?(0,a.jsx)(a.Fragment,{children:(0,a.jsxs)(o.mQc,{children:[(0,a.jsx)(o.tdY,{"aria-label":"List of tabs",contained:!0,children:g.map((e,t)=>(0,a.jsxs)(o.OK9,{children:[e.warehouse.name,"-",e.shelf_location.name]},t))}),(0,a.jsx)(o.nPR,{children:g.map((e,t)=>(0,a.jsx)(o.x45,{children:(0,a.jsx)(c,{headers:h,onSelectionChange:(e,n,a,s,o)=>I(t,e,n,a,s,o)})},t))})]})}):null]}),Q&&(0,a.jsx)(o.K0D,{className:"w-full",title:"Notice: ",subtitle:"No outbound material"}),(0,a.jsxs)("div",{className:"flex space-x-4 mt-10 justify-center ",children:[(0,a.jsx)(o.zxk,{size:"sm",onClick:t=>{t.preventDefault();let a={sourceInvalid:!m.source||""===m.source,typeInvalid:!m.type||""===m.type};if(n(a),Object.values(a).some(e=>e)){n(a);return}if(0===g.length){q(!0);return}q(!1);let s={...m,shelf_records:function(e){let t=e.map(e=>{let t=e.materials.map(e=>({material_code:e.material_code,material_name:e.material_name,quantity:parseInt(e.quantity)}));return{storage_location_id:e.shelf_location.id,inventory:t}});return t}(g)};console.log(s),(0,i.tR)(s).then(()=>{n({sourceInvalid:!1,typeInvalid:!1}),p({type:"",source:"",status:"",note:""}),x([]),e.push("".concat("/apps/wenhao-javaw","/operation/stocktaking"))})},children:"Submit"}),(0,a.jsx)(o.zxk,{size:"sm",kind:"tertiary",onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/operation/stocktaking"))},children:"Cancel"})]})]}):(0,a.jsx)("div",{children:"Loading..."})},p=function(){let e=(0,u.useRouter)();return(0,a.jsxs)("div",{children:[(0,a.jsxs)(o.aGc,{children:[(0,a.jsx)(o.gN6,{children:(0,a.jsx)("a",{onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/"))},children:"Home"})}),(0,a.jsx)(o.gN6,{onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/operation/inbound"))},children:"Operation"}),(0,a.jsx)(o.gN6,{onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/operation/stocktaking"))},children:"Stocktaking"}),(0,a.jsx)(o.gN6,{onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/operation/stocktaking/create"))},children:"Create"})]}),(0,a.jsx)("div",{className:"bx--col-lg-16 flex justify-between items-center",children:(0,a.jsx)(o.X6q,{className:"mt-2 text-[28px] font-normal",children:"Create a Stocktaking Order"})}),(0,a.jsx)(m,{})]})}},690:function(){}},function(e){e.O(0,[313,307,531,698,744],function(){return e(e.s=1919)}),_N_E=e.O()}]);