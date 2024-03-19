(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[202],{2178:function(e,t,n){Promise.resolve().then(n.bind(n,7536))},1641:function(e,t,n){"use strict";n.d(t,{R1:function(){return AddWarehouses},N6:function(){return addInboundRecord},_R:function(){return addMaterial},X:function(){return addMaterialRFID},Kk:function(){return addOutboundRecord},tR:function(){return addStocktakingRecord},UT:function(){return addStorageLocation},Gs:function(){return deleteInbound},Gx:function(){return deleteMaterial},jA:function(){return deleteOutbound},Ap:function(){return deleteStocktaking},zf:function(){return deleteStorageLocation},x0:function(){return deleteWarehouse},z2:function(){return fetchInbound},hU:function(){return fetchInboundDetails},nW:function(){return fetchInboundWithFilter},v0:function(){return fetchMaterial},aG:function(){return fetchMaterialRFID},hI:function(){return fetchMaterialWithFilters},eB:function(){return fetchOutbound},NE:function(){return fetchOutboundDetails},Ju:function(){return fetchOutboundWithFilter},eN:function(){return fetchStocktaking},DP:function(){return fetchStocktakingDetails},_b:function(){return fetchStocktakingWithFilter},$_:function(){return fetchStorageLocationsByWId},tV:function(){return fetchWarehouses},_U:function(){return fetchWarehousesWithFilters},VR:function(){return updateMaterial},qL:function(){return updateWarehouse}});var a=n(2173),o=n(1490);n(2601);let s=a.Z.create({baseURL:"/wmsbackendapi",withCredentials:!0,timeout:1e5});function removeLoginInfo(){o.Z.remove("isv_token")}async function fetchWarehouses(e,t){return s.post("/wms/warehouse/get",{},{params:{pageNum:e,pageSize:t}}).then(e=>(console.log(e),e.data.data))}async function fetchWarehousesWithFilters(e){return s.post("/wms/warehouse/get",e).then(e=>(console.log(e),e.data.data))}async function AddWarehouses(e){return s.post("/wms/warehouse/add",e).then(e=>console.log(e))}async function deleteWarehouse(e){return s.post("/wms/warehouse/delete",{id:e}).then(e=>console.log(e))}async function updateWarehouse(e){return s.post("/wms/warehouse/update",e).then(e=>console.log(e))}async function fetchStorageLocationsByWId(e){return s.post("/wms/storagelocation/get",e).then(e=>(console.log(e),e.data.data))}async function addStorageLocation(e){return s.post("/wms/storagelocation/add",e).then(e=>(console.log(e),e.data.data))}async function deleteStorageLocation(e){return s.post("/wms/storagelocation/delete",e).then(e=>(console.log(e),e.data.data))}async function fetchMaterial(){return s.post("/wms/material/get").then(e=>(console.log(e),e.data.data))}async function fetchMaterialWithFilters(e){return s.post("/wms/material/get",e).then(e=>(console.log(e),e.data.data))}async function addMaterial(e){return s.post("/wms/material/add",e).then(e=>(console.log(e),e.data.data))}async function updateMaterial(e){return s.post("/wms/material/update",e).then(e=>(console.log(e),e.data.data))}async function deleteMaterial(e){return s.post("/wms/material/delete",e).then(e=>(console.log(e),e.data.data))}async function fetchMaterialRFID(){return s.post("/wms/rfidmaterial/get").then(e=>(console.log(e),e.data.data))}async function addMaterialRFID(e){return s.post("/wms/rfidmaterial/add",e).then(e=>(console.log(e),e.data.data))}async function addInboundRecord(e){return s.post("/wms/inbound/add",e).then(e=>(console.log(e),e.data.data))}async function fetchInbound(){return s.post("/wms/inbound/get").then(e=>(console.log(e),e.data.data))}async function fetchInboundWithFilter(e){return s.post("/wms/inbound/get",e).then(e=>(console.log(e),e.data.data))}async function deleteInbound(e){return s.post("/wms/inbound/delete",e).then(e=>(console.log(e),e.data.data))}async function fetchInboundDetails(e){return s.post("/wms/inbound/detail/get",e).then(e=>(console.log(e),e.data.data))}async function addOutboundRecord(e){return s.post("/wms/outbound/add",e).then(e=>(console.log(e),e.data.data))}async function fetchOutbound(){return s.post("/wms/outbound/get").then(e=>(console.log(e),e.data.data))}async function fetchOutboundWithFilter(e){return s.post("/wms/outbound/get",e).then(e=>(console.log(e),e.data.data))}async function deleteOutbound(e){return s.post("/wms/outbound/delete",e).then(e=>(console.log(e),e.data.data))}async function fetchOutboundDetails(e){return s.post("/wms/outbound/detail/get",e).then(e=>(console.log(e),e.data.data))}async function addStocktakingRecord(e){return s.post("/wms/stocktaking/add",e).then(e=>(console.log(e),e.data.data))}async function fetchStocktaking(){return s.post("/wms/stocktaking/get").then(e=>(console.log(e),e.data.data))}async function fetchStocktakingWithFilter(e){return s.post("/wms/stocktaking/get",e).then(e=>(console.log(e),e.data.data))}async function deleteStocktaking(e){return s.post("/wms/stocktaking/delete",e).then(e=>(console.log(e),e.data.data))}async function fetchStocktakingDetails(e){return s.post("/wms/stocktaking/detail/get",e).then(e=>(console.log(e),e.data.data))}s.interceptors.request.use(e=>(null!=o.Z.get("isv_token")&&(e.headers.userToken=o.Z.get("isv_token")),e),e=>Promise.reject(e)),s.interceptors.response.use(function(e){return 401===e.data.code?(removeLoginInfo(),Promise.reject()):e},function(e){return(console.log(e),401===e.response.status)?(removeLoginInfo(),Promise.reject()):Promise.reject(e)})},7536:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return create_page}});var a=n(7437),o=n(2265),s=n(5461),r=n(6302),l=n(8108);n(7387);var i=n(528),u=n(1641),d=n(4033);let c=["red","magenta","purple","blue","cyan","teal","green","gray","cool-gray","outline"],h=[{key:"name",header:"Material Name"},{key:"product_code",header:"Material Code"},{key:"unit",header:"Unit"},{key:"quantity",header:"Quantity"}];var InboundCreateForm_InboundCreateForm=function(){let e=(0,d.useRouter)(),[t,n]=(0,o.useState)({sourceInvalid:!1,typeInvalid:!1}),[f,m]=(0,o.useState)({type:"",source:"manual",status:"",note:""}),onFormValueChange=e=>{let{id:t,value:n}=e.target;m(e=>({...e,[t]:n}))},[g,x]=(0,o.useState)([]),[p,j]=(0,o.useState)([]),[b,v]=(0,o.useState)([]),[y,k]=(0,o.useState)(""),[w,F]=(0,o.useState)(""),[I,C]=(0,o.useState)([]),[N,S]=(0,o.useState)(!1);(0,o.useEffect)(()=>{(0,u.tV)().then(e=>{j(e)}),(0,u.v0)().then(e=>{C(e)})},[]),console.log(f,g),(0,o.useEffect)(()=>{console.log(y),""!=y&&(0,u.$_)({warehouse_id:y}).then(e=>v(e))},[y]);let handleMaterialSelection=(e,t,n,a,o)=>{x(s=>{let r=[...s];if(o){let o=I.find(e=>e.id===t),s=r[e].materials.findIndex(e=>e.id===t);-1!==s?r[e].materials[s][n]=a:r[e].materials.push({...o,[n]:a})}else r[e].materials=r[e].materials.filter(e=>e.id!==t);return r})},handleRemoveTask=e=>{x(t=>{let n=[...t];return n.splice(e,1),n})};return(0,a.jsxs)("div",{children:[(0,a.jsxs)("div",{className:" mt-12",children:[(0,a.jsxs)(s.rjZ,{className:"pl-0",children:[(0,a.jsx)(s.sgG,{sm:1,md:3,lg:5,children:(0,a.jsxs)(s.PhF,{className:"mb-10",id:"type",defaultValue:"",labelText:"Inbound Type",invalid:t.typeInvalid,invalidText:"This field cannot be empty",value:f.type,onChange:onFormValueChange,required:!0,children:[(0,a.jsx)(s.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),(0,a.jsx)(s.QlF,{value:"material inbound",text:"Material Inbound"}),(0,a.jsx)(s.QlF,{value:"product inbound",text:"Product Inbound"}),(0,a.jsx)(s.QlF,{value:"mix inbound",text:"Mix Inbound"})]})}),(0,a.jsx)(s.sgG,{sm:1,md:3,lg:5,children:(0,a.jsxs)(s.PhF,{className:"mb-10",id:"source",defaultValue:"",labelText:"Source",invalid:t.sourceInvalid,invalidText:"This field cannot be empty",value:f.source,onChange:onFormValueChange,required:!0,disabled:!0,children:[(0,a.jsx)(s.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),(0,a.jsx)(s.QlF,{value:"PDA",text:"PDA"}),(0,a.jsx)(s.QlF,{value:"manual",text:"Manual"})]})}),(0,a.jsx)(s.sgG,{sm:1,md:3,lg:5,children:(0,a.jsxs)(s.PhF,{className:"mb-10",id:"status",defaultValue:"",labelText:"Status",value:f.status,onChange:onFormValueChange,required:!0,children:[(0,a.jsx)(s.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),(0,a.jsx)(s.QlF,{value:"Done",text:"Done"}),(0,a.jsx)(s.QlF,{value:"Executing",text:"Executing"}),(0,a.jsx)(s.QlF,{value:"To-do",text:"To-do"})]})}),(0,a.jsx)(s.sgG,{sm:1,md:3,lg:4,children:(0,a.jsx)(s.Kx8,{className:"mb-10 w-full",labelText:"Note",rows:4,id:"note",value:f.note,onChange:onFormValueChange,placeholder:"Note Placeholder"})})]}),(0,a.jsx)(s.GQc,{className:"w-full mb-10 pl-0"}),(0,a.jsxs)(s.rjZ,{className:"pl-0",children:[(0,a.jsx)(s.sgG,{sm:4,md:3,lg:4,children:(0,a.jsxs)(s.PhF,{className:"mb-10",id:"warehouse",defaultValue:"",labelText:"Warehouse",value:y,onChange:e=>{k(e.target.value)},required:!0,children:[(0,a.jsx)(s.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),p.map(e=>(0,a.jsx)(s.QlF,{value:e.id,text:e.name},e.id))]})}),(0,a.jsx)(s.sgG,{sm:4,md:3,lg:4,children:(0,a.jsxs)(s.PhF,{className:"mb-10",id:"shelf_location",defaultValue:"",labelText:"Shelf Location",value:w,onChange:e=>{F(e.target.value)},required:!0,children:[(0,a.jsx)(s.QlF,{disabled:!0,hidden:!0,value:"",text:"Choose an option"}),b.map(e=>(0,a.jsx)(s.QlF,{value:e.id,text:e.name},e.id))]})}),(0,a.jsx)(s.sgG,{sm:1,md:1,lg:2,children:(0,a.jsx)(s.hU,{className:"mb-10 ",size:"md",onClick:function(){if(y&&w){let e=function(e,t){let n=p.find(t=>t.id===e),a=b.find(e=>e.id===t);return{warehouse:n,shelf_location:a,materials:[]}}(y,w);x([...g,e]),k(""),F("")}},children:(0,a.jsx)(r.mm,{})})})]}),(0,a.jsx)("div",{className:"mb-10",children:g.map((e,t)=>(0,a.jsx)(s.Vp9,{type:c[t%c.length],children:(0,a.jsxs)("div",{className:"flex ",children:[e.warehouse.name,"-",e.shelf_location.name,(0,a.jsx)(l.x8,{className:"ml-1",size:16,onClick:e=>{e.stopPropagation(),handleRemoveTask(t)}})]})},t))}),g&&g.length>0?(0,a.jsx)(a.Fragment,{children:(0,a.jsxs)(s.mQc,{children:[(0,a.jsx)(s.tdY,{"aria-label":"List of tabs",contained:!0,children:g.map((e,t)=>(0,a.jsxs)(s.OK9,{children:[e.warehouse.name,"-",e.shelf_location.name]},t))}),(0,a.jsx)(s.nPR,{children:g.map((e,t)=>(0,a.jsx)(s.x45,{children:(0,a.jsx)(i.Z,{headers:h,rows:I,onSelectionChange:(e,n,a,o)=>handleMaterialSelection(t,e,n,a,o)})},t))})]})}):null]}),N&&(0,a.jsx)(s.K0D,{className:"w-full",title:"Notice: ",subtitle:"No inbound material"}),(0,a.jsxs)("div",{className:"flex space-x-4 mt-10 justify-center ",children:[(0,a.jsx)(s.zxk,{size:"sm",onClick:t=>{t.preventDefault();let a={sourceInvalid:!f.source||""===f.source,typeInvalid:!f.type||""===f.type};if(n(a),Object.values(a).some(e=>e)){n(a);return}if(0===g.length){S(!0);return}let o={...f,shelf_records:function(e){let t=e.map(e=>{let t=e.materials.map(e=>({material_id:e.id,quantity:parseInt(e.quantity)}));return{storage_location_id:e.shelf_location.id,inventory:t}});return t}(g)};console.log(o),(0,u.N6)(o).then(()=>{n({sourceInvalid:!1,typeInvalid:!1}),m({type:"",source:"",status:"",note:""}),x([]),e.push("/operation/inbound")})},children:"Submit"}),(0,a.jsx)(s.zxk,{size:"sm",kind:"tertiary",href:"/operation/inbound",children:"Cancel"})]})]})},create_page=function(){return(0,a.jsxs)("div",{children:[(0,a.jsxs)(s.aGc,{children:[(0,a.jsx)(s.gN6,{children:(0,a.jsx)("a",{href:"/",children:"Home"})}),(0,a.jsx)(s.gN6,{href:"/operation/inbound",children:"Operation"}),(0,a.jsx)(s.gN6,{href:"/operation/inbound",children:"Inbound"}),(0,a.jsx)(s.gN6,{href:"/operation/inbound/create",children:"Create"})]}),(0,a.jsx)("div",{className:"bx--col-lg-16 flex justify-between items-center",children:(0,a.jsx)(s.X6q,{className:"mt-2 text-[28px] font-normal",children:"Create a Inbound List"})}),(0,a.jsx)(InboundCreateForm_InboundCreateForm,{})]})}},528:function(e,t,n){"use strict";var a=n(7437);n(2265);var o=n(5461);t.Z=function(e){let{headers:t,rows:n,onSelectionChange:s}=e;return(0,a.jsx)(o.wQF,{rows:n,headers:t,render:e=>{let{rows:t,headers:n,getHeaderProps:r,getSelectionProps:l,onInputChange:i}=e;return(0,a.jsxs)(o.xJi,{children:[(0,a.jsx)(o.fjU,{children:(0,a.jsx)(o.Vj0,{children:(0,a.jsx)(o.Ys1,{onChange:i})})}),(0,a.jsxs)(o.iA_,{children:[(0,a.jsx)(o.ssF,{children:(0,a.jsxs)(o.SCH,{children:[(0,a.jsx)(o.elY,{...l()}),n.map(e=>(0,a.jsx)(o.xDH,{...r({header:e}),children:e.header},e.key))]})}),(0,a.jsx)(o.RMI,{children:t.map((e,t)=>(0,a.jsxs)(o.SCH,{children:[(0,a.jsx)(o.wix,{...l({row:e}),onChange:t=>{var n;let a=(null===(n=document.getElementById("quantity-".concat(e.id)))||void 0===n?void 0:n.value)||0;s(e.id,a,t)}}),n.map(t=>{let n=e.cells.find(e=>e.id.split(":")[1]===t.key);return"quantity"===n.id.split(":")[1]?(0,a.jsx)(o.pj1,{children:(0,a.jsx)(o.oil,{className:"w-20",id:"quantity-".concat(e.id),value:n.value,onChange:t=>{let n=l({row:e}).checked;s(e.id,"quantity",t.target.value,n)}})},t.key):(0,a.jsx)(o.pj1,{children:n?n.value:""},t.key)})]},t))})]})]})}})}},7387:function(){},4033:function(e,t,n){e.exports=n(94)}},function(e){e.O(0,[788,668,971,472,744],function(){return e(e.s=2178)}),_N_E=e.O()}]);