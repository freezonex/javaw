(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[536],{5810:function(n,t,e){Promise.resolve().then(e.bind(e,8376))},2196:function(n,t,e){"use strict";e.d(t,{R1:function(){return i},N6:function(){return b},_R:function(){return w},X:function(){return k},Kk:function(){return P},tR:function(){return F},UT:function(){return f},Gs:function(){return C},Gx:function(){return x},zf:function(){return m},x0:function(){return d},z2:function(){return N},hU:function(){return I},nW:function(){return _},v0:function(){return g},aG:function(){return j},hI:function(){return p},eB:function(){return R},NE:function(){return E},Ju:function(){return T},Wk:function(){return U},eN:function(){return S},DP:function(){return G},_b:function(){return z},$_:function(){return h},tu:function(){return q},lK:function(){return Z},tV:function(){return c},_U:function(){return u},Gb:function(){return v},VR:function(){return y},Mf:function(){return D},qL:function(){return l}});var a=e(5953),o=e(1712);e(2040);let s=a.Z.create({baseURL:"/",withCredentials:!0,timeout:1e5});function r(){o.Z.remove("isv_token")}async function c(n){return s.post("/wms/warehouse/get",{},{params:n}).then(n=>(console.log(n),n.data.data))}async function u(n,t){return s.post("/wms/warehouse/get",n,{params:t}).then(n=>(console.log(n),n.data.data))}async function i(n){return s.post("/wms/warehouse/add",n).then(n=>console.log(n))}async function d(n){return s.post("/wms/warehouse/delete",{id:n}).then(n=>console.log(n))}async function l(n){return s.post("/wms/warehouse/update",n).then(n=>console.log(n))}async function h(n,t){return s.post("/wms/storagelocation/get",n,{params:t}).then(n=>(console.log(n),n.data.data))}async function f(n){return s.post("/wms/storagelocation/add",n).then(n=>(console.log(n),n.data.data))}async function m(n){return s.post("/wms/storagelocation/delete",n).then(n=>(console.log(n),n.data.data))}async function g(n,t){return s.post("/wms/material/get",t,{params:n}).then(n=>(console.log(n),n.data.data))}async function p(n){return s.post("/wms/material/get",n).then(n=>(console.log(n),n.data.data))}async function w(n){return s.post("/wms/material/add",n).then(n=>(console.log(n),n.data.data))}async function y(n){return s.post("/wms/material/update",n).then(n=>(console.log(n),n.data.data))}async function x(n){return s.post("/wms/material/delete",n).then(n=>(console.log(n),n.data.data))}async function j(){return s.post("/wms/rfidmaterial/get").then(n=>(console.log(n),n.data.data))}async function k(n){return s.post("/wms/rfidmaterial/add",n).then(n=>(console.log(n),n.data.data))}async function b(n){return s.post("/wms/inbound/add",n).then(n=>(console.log(n),n.data.data))}async function v(n){return s.post("/wms/inbound/update",n).then(n=>(console.log(n),n.data.data))}async function N(n){return s.post("/wms/inbound/get",{},{params:n}).then(n=>(console.log(n),n.data.data))}async function _(n,t){return s.post("/wms/inbound/get",n,{params:t}).then(n=>(console.log(n),n.data.data))}async function C(n){return s.post("/wms/inbound/delete",n).then(n=>(console.log(n),n.data.data))}async function I(n){return s.post("/wms/inbound/detail",n).then(n=>(console.log(n),n.data.data))}async function P(n){return s.post("/wms/outbound/add",n).then(n=>(console.log(n),n.data.data))}async function R(n){return s.post("/wms/outbound/get",{},{params:n}).then(n=>(console.log(n),n.data.data))}async function T(n){return s.post("/wms/outbound/get",n).then(n=>(console.log(n),n.data.data))}async function D(n){return s.post("/wms/outbound/update",n).then(n=>(console.log(n),n.data.data))}async function E(n){return s.post("/wms/outbound/detail",n).then(n=>(console.log(n),n.data.data))}async function F(n){return s.post("/wms/stocktaking/add",n).then(n=>(console.log(n),n.data.data))}async function S(n){return s.post("/wms/stocktaking/get",{},{params:n}).then(n=>(console.log(n),n.data.data))}async function z(n,t){return s.post("/wms/stocktaking/get",n,{params:t}).then(n=>(console.log(n),n.data.data))}async function G(n){return s.post("/wms/stocktaking/detail",n).then(n=>(console.log(n),n.data.data))}async function q(n){return s.post("/wms/warehouse/namemap",{},{params:n}).then(n=>(console.log(n),n.data.data))}async function U(n){return s.post("/wms/storagelocation/namemap",{},{params:n}).then(n=>(console.log(n),n.data.data))}async function Z(n){return s.post("/wms/warehousestoragelocation/idmap",{},{params:n}).then(n=>(console.log(n),n.data.data))}s.interceptors.request.use(n=>(null!=o.Z.get("isv_token")&&(n.headers.userToken=o.Z.get("isv_token")),n),n=>Promise.reject(n)),s.interceptors.response.use(function(n){return 401===n.data.code?(r(),Promise.reject()):n},function(n){return(console.log(n),401===n.response.status)?(r(),Promise.reject()):Promise.reject(n)})},8376:function(n,t,e){"use strict";e.r(t),e.d(t,{default:function(){return l}});var a=e(9268),o=e(6006),s=e(9698),r=e(2196),c=e(1466);e(4177);var u=function(n){let{headers:t,rows:e}=n,[r,c]=(0,o.useState)(1),[u,i]=(0,o.useState)(10),d=e.slice((r-1)*u,r*u);return(0,a.jsxs)("div",{children:[(0,a.jsxs)(s.x4x,{isCondensed:!0,children:[(0,a.jsx)(s.SmK,{children:(0,a.jsx)(s.s1N,{head:!0,children:t.map((n,t)=>(0,a.jsx)(s.agF,{head:!0,children:n.header},n.key))})}),(0,a.jsx)(s.FxI,{children:d.map((n,e)=>(0,a.jsx)(s.s1N,{children:t.map(t=>(0,a.jsx)(s.agF,{children:n[t.key]},t.key))},n.id))})]}),(0,a.jsx)(s.tlE,{backwardText:"Previous page",forwardText:"Next page",itemsPerPageText:"Items per page:",page:r,pageNumberText:"Page Number",pageSize:u,pageSizes:[5,10,20,30,40,50],totalItems:e.length,onChange:n=>{let{page:t,pageSize:e}=n;c(t),i(e)}})]})},i=e(6008);let d=[{key:"material_id",header:"Material ID"},{key:"rfid",header:"RFID"},{key:"quantity",header:"Quantity"}];var l=function(){let n=(0,i.useRouter)(),[t,e]=(0,o.useState)([]),[l,h]=(0,o.useState)({});return(0,o.useEffect)(()=>{(0,r.aG)().then(n=>e(n))},[l]),(0,a.jsxs)("div",{children:[(0,a.jsxs)(s.aGc,{children:[(0,a.jsx)(s.gN6,{children:(0,a.jsx)("a",{onClick:()=>{n.push("".concat("/apps/wenhao-javaw","/home"))},children:"Home"})}),(0,a.jsx)(s.gN6,{onClick:()=>{n.push("".concat("/apps/wenhao-javaw","/warehouse"))},children:"Warehouse"}),(0,a.jsx)(s.gN6,{onClick:()=>{n.push("".concat("/apps/wenhao-javaw","/warehouse/material"))},children:"Material"}),(0,a.jsx)(s.gN6,{onClick:()=>{n.push("".concat("/apps/wenhao-javaw","/warehouse/material/rfid"))},children:"RFID"})]}),(0,a.jsxs)("div",{className:"bx--col-lg-16 flex justify-between items-center",children:[(0,a.jsxs)("div",{children:[(0,a.jsx)(s.X6q,{className:"mt-12 text-[28px] font-normal",children:"RFID Tag"}),(0,a.jsx)(s.X6q,{className:"mt-1 text-sm",children:"Description of Labeling view goes here."})]}),(0,a.jsx)(s.zxk,{onClick:()=>{n.push("".concat("/apps/wenhao-javaw","/warehouse/material/rfid/create"))},isExpressive:!0,size:"sm",renderIcon:c.mm,children:"Create a RFID Tag"})]}),(0,a.jsx)("div",{className:"mt-12",children:(0,a.jsx)(u,{headers:d,rows:t})})]})}},4177:function(){}},function(n){n.O(0,[313,307,531,698,744],function(){return n(n.s=5810)}),_N_E=n.O()}]);