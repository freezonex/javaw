(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[358],{2756:function(e,a,t){Promise.resolve().then(t.bind(t,5880))},5880:function(e,a,t){"use strict";t.r(a);var s=t(9268);t(6006);var n=t(9698),o=t(7320),i=t(6008);a.default=function(){let e=(0,i.useSearchParams)(),a=(0,i.useRouter)(),t=e.get("id");return(0,s.jsxs)("div",{children:[(0,s.jsxs)(n.aGc,{children:[(0,s.jsx)(n.gN6,{children:(0,s.jsx)("a",{onClick:()=>{a.push("".concat("/apps/wenhao-javaw","/"))},children:"Home"})}),(0,s.jsx)(n.gN6,{onClick:()=>{a.push("".concat("/apps/wenhao-javaw","/operation/inbound"))},children:"Operation"}),(0,s.jsx)(n.gN6,{onClick:()=>{a.push("".concat("/apps/wenhao-javaw","/operation/inbound"))},children:"Inbound"}),(0,s.jsx)(n.gN6,{onClick:()=>{a.push("".concat("/apps/wenhao-javaw","/operation/inbound/operate"))},children:"Operate"})]}),(0,s.jsx)("div",{className:"bx--col-lg-16 flex justify-between items-center",children:(0,s.jsx)(n.X6q,{className:"mt-2 text-[28px] font-normal",children:"Operate"})}),(0,s.jsx)(o.Z,{id:t})]})}},7320:function(e,a,t){"use strict";var s=t(9268),n=t(6006),o=t(9698);t(690);var i=t(7905),r=t(2196),l=t(6008),c=t(5326),d=t.n(c),u=t(4566);let p=[{key:"name",header:"Material Name"},{key:"product_code",header:"Material Code"},{key:"specification",header:"Specification"},{key:"quantity",header:"Quantity"},{key:"unit",header:"Unit"},{key:"expect_wh_id",header:"WH"},{key:"expact_stock_location_id",header:"Shelf"}];a.Z=function(e){let{id:a}=e,t=(0,l.useRouter)(),c=(0,l.usePathname)(),[h,_]=(0,n.useState)([]),[m,x]=(0,n.useState)(!1),[j,f]=(0,n.useState)({creator:"",purchase_order_no:"",supplier:"",delivery_date:"",delivery_date_show:""}),[v,b]=(0,n.useState)(""),y=e=>{let{id:a,value:t}=e.target;f(e=>({...e,[a]:t}))};return console.log(j,h,"id",a),(0,n.useEffect)(()=>{a&&(0,r.hU)({id:a}).then(e=>{console.log(e),f({creator:e.list[0].inbound_creator,purchase_order_no:e.list[0].inbound_purchase_order_no,supplier:e.list[0].inbound_supplier,delivery_date:e.list[0].inbound_delivery_date}),b(d()(e.list[0].inbound_delivery_date).format(u.U.shortDate));let a=e.list.map(e=>({name:e.name,product_code:e.product_code,specification:e.specification,quantity:e.quantity,unit:e.unit,expect_wh_id:e.warehouse_id,expact_stock_location_id:e.stock_location_id}));_(a)}).catch(e=>{console.error("Failed to fetch inbound details:",e)})},[a]),(0,s.jsxs)("div",{children:[(0,s.jsxs)(o.rjZ,{className:"p-0 mt-[50px] gap-[9px]",children:[(0,s.jsx)(o.sgG,{className:"ml-0",sm:2,md:4,lg:4,children:(0,s.jsx)(o.oil,{className:"flex-auto ",labelText:"Creator",id:"creator",placeholder:"Creator",value:j.creator,onChange:y})}),(0,s.jsx)(o.sgG,{className:"ml-0",sm:2,md:4,lg:4,children:(0,s.jsx)(o.oil,{className:"flex-auto ",labelText:"Purchase order No.",id:"purchase_order_no",placeholder:"Purchase order No.",value:j.purchase_order_no,onChange:y})}),(0,s.jsx)(o.sgG,{className:"ml-0",sm:2,md:4,lg:4,children:(0,s.jsx)(o.oil,{className:"flex-auto ",labelText:"Supplier",id:"supplier",placeholder:"Supplier",value:j.supplier,onChange:y})}),(0,s.jsx)(o.sgG,{className:"ml-0",sm:2,md:4,lg:4,children:(0,s.jsx)(o.Mtg,{datePickerType:"single",id:"delivery_date",onChange:e=>{e&&(f(a=>({...a,delivery_date:d()(e[0]).format()})),b(d()(e[0]).format(u.U.shortDate)))},children:(0,s.jsx)(o.aj6,{placeholder:"dd/mm/yyyy",labelText:"Delivery Date",value:v})})}),(0,s.jsx)(o.sgG,{sm:2,md:4,lg:4,children:(0,s.jsx)(o.oil,{readOnly:!0,className:"flex-auto",labelText:"Status",id:"status",placeholder:"Status",value:c==="".concat("/apps/wenhao-javaw","/operation/inbound/create")?"Pending":"Inbound"})})]}),(0,s.jsx)(o.GQc,{className:"w-full mt-10 mb-10 pl-0"}),(0,s.jsxs)("div",{className:"mb-10",children:[(0,s.jsx)(o.lXp,{className:"mb-2",children:"Material List"}),(0,s.jsx)(i.Z,{headers:p,rows:h,setRows:_})]}),m&&(0,s.jsx)(o.K0D,{className:"w-full",title:"Notice: ",subtitle:"No inbound material"}),(0,s.jsxs)("div",{className:"flex space-x-4 mt-10 justify-center ",children:[(0,s.jsx)(o.zxk,{size:"sm",onClick:e=>{if(e.preventDefault(),0===h.length){x(!0);return}if(c==="".concat("/apps/wenhao-javaw","/operation/inbound/create")){let e={...j,source:"manual",request_detail:function(e){let a=e.map(e=>({material_code:e.product_code,quantity:e.quantity,stock_location_id:e.expact_stock_location_id,wh_id:e.expect_wh_id}));return a}(h)};(0,r.N6)(e).then(()=>{f({creator:"",purchase_order_no:"",supplier:"",delivery_date:""}),_([]),t.push("".concat("/apps/wenhao-javaw","/operation/inbound"))})}else{let e={...j,source:"manual",status:"done",id:a};console.log(e),(0,r.Gb)(e).then(()=>{f({creator:"",purchase_order_no:"",supplier:"",delivery_date:""}),_([]),t.push("".concat("/apps/wenhao-javaw","/operation/inbound"))})}},children:"Submit"}),(0,s.jsx)(o.zxk,{size:"sm",kind:"tertiary",onClick:()=>{t.push("".concat("/apps/wenhao-javaw","/operation/inbound"))},children:"Cancel"})]})]})}}},function(e){e.O(0,[550,313,307,846,866,531,698,744],function(){return e(e.s=2756)}),_N_E=e.O()}]);