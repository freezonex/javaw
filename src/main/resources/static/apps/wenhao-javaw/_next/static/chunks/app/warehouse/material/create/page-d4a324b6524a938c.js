(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[576],{7137:function(e,t,n){Promise.resolve().then(n.bind(n,2613))},2196:function(e,t,n){"use strict";n.d(t,{R1:function(){return r},N6:function(){return b},_R:function(){return x},X:function(){return y},Kk:function(){return I},tR:function(){return E},UT:function(){return h},Gs:function(){return C},Gx:function(){return j},zf:function(){return p},x0:function(){return u},z2:function(){return k},hU:function(){return T},nW:function(){return N},v0:function(){return f},aG:function(){return v},hI:function(){return g},eB:function(){return S},NE:function(){return z},Ju:function(){return G},Wk:function(){return W},eN:function(){return R},DP:function(){return U},_b:function(){return P},$_:function(){return m},tu:function(){return Z},lK:function(){return q},tV:function(){return i},_U:function(){return l},Gb:function(){return _},VR:function(){return w},Mf:function(){return M},qL:function(){return d}});var a=n(5953),o=n(1712);n(2040);let s=a.Z.create({baseURL:"/apps/wenhao-javaw",withCredentials:!0,timeout:1e5});function c(){o.Z.remove("isv_token")}async function i(e){return s.post("/wms/warehouse/get",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function l(e,t){return s.post("/wms/warehouse/get",e,{params:t}).then(e=>(console.log(e),e.data.data))}async function r(e){return s.post("/wms/warehouse/add",e).then(e=>console.log(e))}async function u(e){return s.post("/wms/warehouse/delete",{id:e}).then(e=>console.log(e))}async function d(e){return s.post("/wms/warehouse/update",e).then(e=>console.log(e))}async function m(e,t){return s.post("/wms/storagelocation/get",e,{params:t}).then(e=>(console.log(e),e.data.data))}async function h(e){return s.post("/wms/storagelocation/add",e).then(e=>(console.log(e),e.data.data))}async function p(e){return s.post("/wms/storagelocation/delete",e).then(e=>(console.log(e),e.data.data))}async function f(e,t){return s.post("/wms/material/get",t,{params:e}).then(e=>(console.log(e),e.data.data))}async function g(e){return s.post("/wms/material/get",e).then(e=>(console.log(e),e.data.data))}async function x(e){return s.post("/wms/material/add",e).then(e=>(console.log(e),e.data.data))}async function w(e){return s.post("/wms/material/update",e).then(e=>(console.log(e),e.data.data))}async function j(e){return s.post("/wms/material/delete",e).then(e=>(console.log(e),e.data.data))}async function v(){return s.post("/wms/rfidmaterial/get").then(e=>(console.log(e),e.data.data))}async function y(e){return s.post("/wms/rfidmaterial/add",e).then(e=>(console.log(e),e.data.data))}async function b(e){return s.post("/wms/inbound/add",e).then(e=>(console.log(e),e.data.data))}async function _(e){return s.post("/wms/inbound/update",e).then(e=>(console.log(e),e.data.data))}async function k(e){return s.post("/wms/inbound/get",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function N(e,t){return s.post("/wms/inbound/get",e,{params:t}).then(e=>(console.log(e),e.data.data))}async function C(e){return s.post("/wms/inbound/delete",e).then(e=>(console.log(e),e.data.data))}async function T(e){return s.post("/wms/inbound/detail",e).then(e=>(console.log(e),e.data.data))}async function I(e){return s.post("/wms/outbound/add",e).then(e=>(console.log(e),e.data.data))}async function S(e){return s.post("/wms/outbound/get",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function G(e){return s.post("/wms/outbound/get",e).then(e=>(console.log(e),e.data.data))}async function M(e){return s.post("/wms/outbound/update",e).then(e=>(console.log(e),e.data.data))}async function z(e){return s.post("/wms/outbound/detail",e).then(e=>(console.log(e),e.data.data))}async function E(e){return s.post("/wms/stocktaking/add",e).then(e=>(console.log(e),e.data.data))}async function R(e){return s.post("/wms/stocktaking/get",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function P(e,t){return s.post("/wms/stocktaking/get",e,{params:t}).then(e=>(console.log(e),e.data.data))}async function U(e){return s.post("/wms/stocktaking/detail",e).then(e=>(console.log(e),e.data.data))}async function Z(e){return s.post("/wms/warehouse/namemap",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function W(e){return s.post("/wms/storagelocation/namemap",{},{params:e}).then(e=>(console.log(e),e.data.data))}async function q(e){return s.post("/wms/warehousestoragelocation/idmap",{},{params:e}).then(e=>(console.log(e),e.data.data))}s.interceptors.request.use(e=>(null!=o.Z.get("isv_token")&&(e.headers.userToken=o.Z.get("isv_token")),e),e=>Promise.reject(e)),s.interceptors.response.use(function(e){return 401===e.data.code?(c(),Promise.reject()):e},function(e){return(console.log(e),401===e.response.status)?(c(),Promise.reject()):Promise.reject(e)})},2613:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return r}});var a=n(9268),o=n(6006),s=n(9698);n(690);var c=n(6008),i=n(2196),l=function(){let e=(0,c.useRouter)(),[t,n]=(0,o.useState)({codeInvalid:!1,nameInvalid:!1}),[l,r]=(0,o.useState)({product_code:"",name:"",product_type:"",unit:"",specification:"",max:"",min:"",status:"",expect_wh_id:"",expact_stock_location_id:"",note:""}),[u,d]=(0,o.useState)([]),[m,h]=(0,o.useState)([]),[p,f]=(0,o.useState)({}),[g,x]=(0,o.useState)({});(0,o.useEffect)(()=>{(0,i.tV)({pageNum:1,pageSize:99999999}).then(e=>{d(e.list)})},[]),console.log(l,p,g,"/apps/wenhao-javaw/warehouse/material"),(0,o.useEffect)(()=>{p.selectedItem?(0,i.$_)({warehouse_id:p.selectedItem.id},{pageNum:1,pageSize:99999999}).then(e=>{h(e.list)}):h([])},[p]);let w=e=>{let{id:t,value:n}=e.target;r(e=>({...e,[t]:n}))},j=async t=>{t.preventDefault();let a={codeInvalid:""===l.product_code,nameInvalid:""===l.name};n(a),console.log(a,l),Object.values(a).some(e=>e)||((0,i._R)(l).then(()=>{r({product_code:"",name:"",product_type:"",unit:"",note:""}),n({codeInvalid:!1,nameInvalid:!1})}),e.push("".concat("/apps/wenhao-javaw","/warehouse/material")))};return(0,a.jsxs)("div",{children:[(0,a.jsx)("div",{className:" mt-8",children:(0,a.jsxs)(s.rjZ,{className:"pl-0",children:[(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.oil,{className:"mb-8",labelText:"Material Code",id:"product_code",placeholder:"Material Code",invalid:t.codeInvalid,invalidText:"This field cannot be empty",value:l.product_code,onChange:w})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.oil,{className:"mb-8",labelText:"Material Name",id:"name",placeholder:"Material Name",invalid:t.nameInvalid,invalidText:"This field cannot be empty",value:l.name,onChange:w})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.oil,{className:"mb-8",labelText:"Material Type",id:"product_type",placeholder:"Material Type",value:l.product_type,onChange:w})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.oil,{className:"mb-8",labelText:"Unit",id:"unit",placeholder:"Unit",value:l.unit,onChange:w})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.oil,{className:"mb-8",labelText:"Specification",id:"specification",placeholder:"Specification",value:l.specification,onChange:w})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.oil,{className:"mb-8",labelText:"Maximum safty stock",id:"max",placeholder:"Maximum safty stock",value:l.max,onChange:w})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.oil,{className:"mb-8",labelText:"Minimum safty stock",id:"min",placeholder:"Minimum safty stock",value:l.min,onChange:w})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.oil,{className:"mb-8",labelText:"Status",id:"status",placeholder:"Status",value:l.status,onChange:w})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.CtY,{className:"mb-8",titleText:"Expect WH",items:u,itemToString:e=>e?e.name:"",placeholder:"Choose a warehouse",onChange:e=>{if(e){var t;f(e),x({}),r({...l,expect_wh_id:e.selectedItem?null===(t=e.selectedItem)||void 0===t?void 0:t.id:"",expact_stock_location_id:""})}else f({}),x({}),r({...l,expect_wh_id:"",expact_stock_location_id:""})}})}),(0,a.jsx)(s.sgG,{sm:2,md:4,lg:4,children:(0,a.jsx)(s.CtY,{className:"mb-8",titleText:"Expect Shelf",items:m,itemToString:e=>e?e.name:"",placeholder:"Choose a Shelf",onChange:e=>{var t;x(e.selectedItem),r({...l,expact_stock_location_id:e.selectedItem?null===(t=e.selectedItem)||void 0===t?void 0:t.id:""})},selectedItem:g})}),(0,a.jsx)(s.sgG,{sm:4,md:8,lg:16,children:(0,a.jsx)(s.Kx8,{className:"mb-8 w-full",labelText:"Note",rows:4,id:"note",value:l.note,onChange:w})})]})}),(0,a.jsxs)("div",{className:"flex space-x-4 mt-4 justify-center ",children:[(0,a.jsx)(s.zxk,{size:"sm",onClick:j,children:"Submit"}),(0,a.jsx)(s.zxk,{size:"sm",kind:"tertiary",onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/warehouse/material"))},children:"Cancel"})]})]})},r=function(){let e=(0,c.useRouter)();return(0,a.jsxs)("div",{children:[(0,a.jsxs)(s.aGc,{children:[(0,a.jsx)(s.gN6,{children:(0,a.jsx)("a",{onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/home"))},children:"Home"})}),(0,a.jsx)(s.gN6,{onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/warehouse"))},children:"Warehouse"}),(0,a.jsx)(s.gN6,{onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/warehouse/material"))},children:"Material"}),(0,a.jsx)(s.gN6,{onClick:()=>{e.push("".concat("/apps/wenhao-javaw","/warehouse/material/create"))},children:"Create"})]}),(0,a.jsx)("div",{className:"bx--col-lg-16 flex justify-between items-center",children:(0,a.jsx)(s.X6q,{className:"mt-2 text-[28px] font-normal",children:"Create a Material"})}),(0,a.jsx)(l,{})]})}},690:function(){}},function(e){e.O(0,[313,307,531,698,744],function(){return e(e.s=7137)}),_N_E=e.O()}]);