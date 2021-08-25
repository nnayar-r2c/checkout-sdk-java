"use strict";(self.webpackChunkcheckout_sdk_java_docs=self.webpackChunkcheckout_sdk_java_docs||[]).push([[587],{3905:function(e,t,n){n.d(t,{Zo:function(){return c},kt:function(){return d}});var r=n(7294);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function s(e,t){if(null==e)return{};var n,r,a=function(e,t){if(null==e)return{};var n,r,a={},o=Object.keys(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var p=r.createContext({}),l=function(e){var t=r.useContext(p),n=t;return e&&(n="function"==typeof e?e(t):i(i({},t),e)),n},c=function(e){var t=l(e.components);return r.createElement(p.Provider,{value:t},e.children)},u={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},m=r.forwardRef((function(e,t){var n=e.components,a=e.mdxType,o=e.originalType,p=e.parentName,c=s(e,["components","mdxType","originalType","parentName"]),m=l(n),d=a,f=m["".concat(p,".").concat(d)]||m[d]||u[d]||o;return n?r.createElement(f,i(i({ref:t},c),{},{components:n})):r.createElement(f,i({ref:t},c))}));function d(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var o=n.length,i=new Array(o);i[0]=m;var s={};for(var p in t)hasOwnProperty.call(t,p)&&(s[p]=t[p]);s.originalType=e,s.mdxType="string"==typeof e?e:a,i[1]=s;for(var l=2;l<o;l++)i[l]=n[l];return r.createElement.apply(null,i)}return r.createElement.apply(null,n)}m.displayName="MDXCreateElement"},5876:function(e,t,n){n.r(t),n.d(t,{frontMatter:function(){return s},contentTitle:function(){return p},metadata:function(){return l},toc:function(){return c},Highlight:function(){return u},default:function(){return d}});var r=n(7462),a=n(3366),o=(n(7294),n(3905)),i=["components"],s={id:"reconciliation",title:"Reconciliation",sidebar_position:2},p=void 0,l={unversionedId:"api/reconciliation",id:"api/reconciliation",isDocsHomePage:!1,title:"Reconciliation",description:"You can find a list of request body parameters and possible outcomes here.",source:"@site/docs/api/reconciliation.md",sourceDirName:"api",slug:"/api/reconciliation",permalink:"/checkout-sdk-java/docs/api/reconciliation",version:"current",sidebarPosition:2,frontMatter:{id:"reconciliation",title:"Reconciliation",sidebar_position:2},sidebar:"tutorialSidebar",previous:{title:"Disputes",permalink:"/checkout-sdk-java/docs/api/disputes"},next:{title:"Events",permalink:"/checkout-sdk-java/docs/api/events"}},c=[{value:"Get JSON payments report",id:"get-json-payments-report",children:[]},{value:"Get JSON single payment report",id:"get-json-single-payment-report",children:[]},{value:"Get CSV payments report",id:"get-csv-payments-report",children:[]},{value:"Get JSON statements report",id:"get-json-statements-report",children:[]},{value:"Get CSV single statement report",id:"get-csv-single-statement-report",children:[]},{value:"Get CSV statements report",id:"get-csv-statements-report",children:[]}],u=function(e){var t=e.children,n=e.color;return(0,o.kt)("span",{style:{color:n,padding:"0.2rem"}},t)},m={toc:c,Highlight:u};function d(e){var t=e.components,n=(0,a.Z)(e,i);return(0,o.kt)("wrapper",(0,r.Z)({},m,n,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("p",null,"You can find a list of request body parameters and possible outcomes ",(0,o.kt)("a",{parentName:"p",href:"https://api-reference.checkout.com/#tag/Reconciliation"},"here"),"."),(0,o.kt)("p",null,"Quickly find all fees associated with each of your payments, so you can concentrate on the important stuff while streamlining your financial reporting."),(0,o.kt)("h2",{id:"get-json-payments-report"},"Get JSON payments report"),(0,o.kt)("p",null,"Returns a JSON report containing all payments within your specified parameters. You can reconcile the data from this report against your statements (which can be found in the Hub), the list of payments in the Hub (using the Reference field) or your own systems. Note: no payments from before 7 February 2019 at 00.00.00 UTC will appear when using the payments endpoint. To view earlier payments, please contact our support team."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},'//You can use multiple fields in filter object such as a query parameter request\nReconciliationQueryPaymentsFilter filter = ReconciliationQueryPaymentsFilter\n        .builder()\n        .from(2021-08-10T16:48:52Z)\n        .to(2021-08-17T16:48:52Z)\n        .reference("pay_123456789ASDQWEZC")\n        .limit(100)\n        .build();\n\nReconciliationPaymentReportResponse response = api.reconciliationClient().queryPaymentsReport(filter).get();\n')),(0,o.kt)("h2",{id:"get-json-single-payment-report"},"Get JSON single payment report"),(0,o.kt)("p",null,"Returns a JSON payment report containing all of the data related to a specific payment, based on the payment's identifier. Note: no payments from before 7 February 2019 at 00.00.00 UTC will appear when using the payments endpoint. To view earlier payments, please contact our support team."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},'ReconciliationPaymentReportResponse response = api.reconciliationClient().singlePaymentReportAsync("pay_123456789ASDQWEZC").get();\n')),(0,o.kt)("h2",{id:"get-csv-payments-report"},"Get CSV payments report"),(0,o.kt)("p",null,"In addition to the JSON format returned by the reporting/payments endpoint, you can also download a CSV report containing the same data. ",(0,o.kt)("a",{parentName:"p",href:"https://docs.checkout.com/reporting-and-insights/reconciliation-api/payments-endpoint#Paymentsendpoint-HowtoreadtheCSVfile"},"Learn more about how to read your CSV report"),"."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},'//The parameter and the response will be the absolute path for a file\nString file = api.reconciliationClient().retrieveCSVPaymentReport("/etc/foo/payment_report.csv").get();\n')),(0,o.kt)("h2",{id:"get-json-statements-report"},"Get JSON statements report"),(0,o.kt)("p",null,"Returns a JSON report containing all statements within your specified parameters. Please note that the timezone for the request will be UTC."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},"QueryFilterDateRange filter = QueryFilterDateRange\n        .builder()\n        .from(2021-08-10T16:48:52Z)\n        .to(2021-08-17T16:48:52Z)\n        .build();\n\nStatementReportResponse response = api.reconciliationClient().queryStatementsReport(filter).get();\n")),(0,o.kt)("h2",{id:"get-csv-single-statement-report"},"Get CSV single statement report"),(0,o.kt)("p",null,"Downloads a CSV statement report containing all the data related to a specific statement, based on the statement's identifier."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},'//The parameter and the response will be the absolute path for a file\nString file = api.reconciliationClient().retrieveCSVSingleStatementReport("/etc/foo/single_statement_report.csv").get();\n')),(0,o.kt)("h2",{id:"get-csv-statements-report"},"Get CSV statements report"),(0,o.kt)("p",null,"In addition to the JSON format returned by the reporting/statements endpoint, you can also download a CSV report containing the same data."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},'//The parameter and the response will be the absolute path for a file\nString file = api.reconciliationClient().retrieveCSVStatementsReport("/etc/foo/statement_report.csv").get();\n')))}d.isMDXComponent=!0}}]);