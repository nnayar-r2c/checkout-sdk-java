"use strict";(self.webpackChunkcheckout_sdk_java_docs=self.webpackChunkcheckout_sdk_java_docs||[]).push([[471],{3905:function(e,t,a){a.d(t,{Zo:function(){return u},kt:function(){return f}});var n=a(7294);function r(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}function o(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,n)}return a}function i(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?o(Object(a),!0).forEach((function(t){r(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):o(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}function c(e,t){if(null==e)return{};var a,n,r=function(e,t){if(null==e)return{};var a,n,r={},o=Object.keys(e);for(n=0;n<o.length;n++)a=o[n],t.indexOf(a)>=0||(r[a]=e[a]);return r}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(n=0;n<o.length;n++)a=o[n],t.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(e,a)&&(r[a]=e[a])}return r}var l=n.createContext({}),p=function(e){var t=n.useContext(l),a=t;return e&&(a="function"==typeof e?e(t):i(i({},t),e)),a},u=function(e){var t=p(e.components);return n.createElement(l.Provider,{value:t},e.children)},s={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},d=n.forwardRef((function(e,t){var a=e.components,r=e.mdxType,o=e.originalType,l=e.parentName,u=c(e,["components","mdxType","originalType","parentName"]),d=p(a),f=r,m=d["".concat(l,".").concat(f)]||d[f]||s[f]||o;return a?n.createElement(m,i(i({ref:t},u),{},{components:a})):n.createElement(m,i({ref:t},u))}));function f(e,t){var a=arguments,r=t&&t.mdxType;if("string"==typeof e||r){var o=a.length,i=new Array(o);i[0]=d;var c={};for(var l in t)hasOwnProperty.call(t,l)&&(c[l]=t[l]);c.originalType=e,c.mdxType="string"==typeof e?e:r,i[1]=c;for(var p=2;p<o;p++)i[p]=a[p];return n.createElement.apply(null,i)}return n.createElement.apply(null,a)}d.displayName="MDXCreateElement"},8616:function(e,t,a){a.r(t),a.d(t,{frontMatter:function(){return c},contentTitle:function(){return l},metadata:function(){return p},toc:function(){return u},default:function(){return d}});var n=a(7462),r=a(3366),o=(a(7294),a(3905)),i=["components"],c={id:"pagofacil",title:"Pago Facil"},l=void 0,p={unversionedId:"default_api/alternative-payments/pagofacil",id:"default_api/alternative-payments/pagofacil",isDocsHomePage:!1,title:"Pago Facil",description:"The full list of request body parameters and possible outcomes can be found here.",source:"@site/docs/default_api/alternative-payments/pagofacil.md",sourceDirName:"default_api/alternative-payments",slug:"/default_api/alternative-payments/pagofacil",permalink:"/checkout-sdk-java/docs/default_api/alternative-payments/pagofacil",version:"current",frontMatter:{id:"pagofacil",title:"Pago Facil"},sidebar:"tutorialSidebar",previous:{title:"Oxxo",permalink:"/checkout-sdk-java/docs/default_api/alternative-payments/oxxo"},next:{title:"Rapi Pago",permalink:"/checkout-sdk-java/docs/default_api/alternative-payments/rapipago"}},u=[{value:"Request a &quot;Redirect&quot; Oxxo payment",id:"request-a-redirect-oxxo-payment",children:[]},{value:"Succeed a Pago facil payment",id:"succeed-a-pago-facil-payment",children:[]},{value:"Expire a Pago facil payment",id:"expire-a-pago-facil-payment",children:[]}],s={toc:u};function d(e){var t=e.components,a=(0,r.Z)(e,i);return(0,o.kt)("wrapper",(0,n.Z)({},s,a,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("p",null,"The full list of request body parameters and possible outcomes can be found ",(0,o.kt)("a",{parentName:"p",href:"https://docs.checkout.com/payments/payment-methods/cash-and-atm-payment/pago-facil"},"here"),"."),(0,o.kt)("h2",{id:"request-a-redirect-oxxo-payment"},'Request a "Redirect" Oxxo payment'),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},"PagoFacilSource source = PagoFacilSource.builder()\n        .country()\n        .description()\n        .payer(Payer.builder().build())\n        .build();\n\nPaymentRequest<PagoFacilSource> request = PaymentRequest.pagoFacil(source, Currency.ARS, 1000L);\n\nPaymentResponse response = api.paymentsClient().requestAsync(request).get();\n\nString redirectURL = response.getPending().getRedirectLink().getHref()\n")),(0,o.kt)("h2",{id:"succeed-a-pago-facil-payment"},"Succeed a Pago facil payment"),(0,o.kt)("p",null,"This functionality only works in sandbox environment."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},'api.pagoFacilClient().succeed("payment_id");\n')),(0,o.kt)("h2",{id:"expire-a-pago-facil-payment"},"Expire a Pago facil payment"),(0,o.kt)("p",null,"This functionality only works in sandbox environment."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-java"},'api.pagoFacilClient().expire("payment_id");\n')))}d.isMDXComponent=!0}}]);