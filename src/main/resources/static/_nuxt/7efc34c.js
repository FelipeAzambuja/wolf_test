(window.webpackJsonp=window.webpackJsonp||[]).push([[3],{357:function(t,e,n){"use strict";n.r(e);var o=n(7),r=(n(60),n(0).default.extend({data:function(){return{state:null,imc:null,obsity:null,blood_type:null,qtd_blood_type:null}},mounted:function(){var t=this;return Object(o.a)(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,t.$axios.get("http://localhost:8080/api/report/state");case 2:return t.state=e.sent,e.next=5,t.$axios.get("http://localhost:8080/api/report/imc");case 5:return t.imc=e.sent,e.next=8,t.$axios.get("http://localhost:8080/api/report/obsity");case 8:return t.obsity=e.sent,e.next=11,t.$axios.get("http://localhost:8080/api/report/blood_type");case 11:return t.blood_type=e.sent,e.next=14,t.$axios.get("http://localhost:8080/api/report/qtd_blood_type");case 14:t.qtd_blood_type=e.sent;case 15:case"end":return e.stop()}}),e)})))()}})),l=n(58),component=Object(l.a)(r,(function(){var t=this,e=t.$createElement,n=t._self._c||e;return t.state&&t.imc&&t.obsity&&t.blood_type&&t.qtd_blood_type?n("div",{staticClass:"container"},[n("h1",{staticClass:"text-center mt-4"},[t._v("Candidatos")]),t._v(" "),n("h3",{staticClass:"mt-4"},[t._v("Por estado")]),t._v(" "),n("table",{staticClass:"table table-bordered"},[n("thead",[n("tr",t._l(t.state.data,(function(e){return n("th",{key:e[0]},[t._v("\n                    "+t._s(e[0])+"\n                ")])})),0)]),t._v(" "),n("tbody",[n("tr",t._l(t.state.data,(function(e){return n("td",{key:e[0]},[t._v("\n                    "+t._s(e[1])+"\n                ")])})),0)])]),t._v(" "),n("h3",{staticClass:"mt-4"},[t._v("IMC médio por faixa de idade")]),t._v(" "),n("table",{staticClass:"table table-bordered"},[n("thead",[n("tr",[n("th",[t._v("Anos")]),t._v(" "),t._l(t.imc.data,(function(e){return n("th",{key:e[0]},[t._v("\n                    "+t._s(e[0][1])+" - "+t._s(e[0][2])+"\n                ")])}))],2)]),t._v(" "),n("tbody",[n("tr",[t._m(0),t._v(" "),t._l(t.imc.data,(function(e){return n("td",{key:e[0]},[e[0][0]>0?n("span",[t._v("\n                        "+t._s(e[0][0])+"\n                    ")]):n("span",[t._v(" - ")])])}))],2)])]),t._v(" "),n("h3",{staticClass:"mt-4"},[t._v("Percentual Obsidade por sexo")]),t._v(" "),n("ul",[n("li",[t._v("Homens: "+t._s(t.obsity.data[1][0])+"%")]),t._v(" "),n("li",[t._v("Mulheres: "+t._s(t.obsity.data[0][0])+"%")])]),t._v(" "),n("h3",{staticClass:"mt-4"},[t._v("Média de Idade tipo sanguíneo")]),t._v(" "),n("table",{staticClass:"table table-bordered"},[n("thead",[n("tr",t._l(t.blood_type.data,(function(e){return n("th",{key:e[0]},[t._v("\n                    "+t._s(e[0])+"\n                ")])})),0)]),t._v(" "),n("tbody",[n("tr",t._l(t.blood_type.data,(function(e){return n("td",{key:e[0]},[t._v("\n                    "+t._s(e[1])+"\n                ")])})),0)])]),t._v(" "),n("h3",{staticClass:"mt-4"},[t._v("Doadores por tipo sanguíneo")]),t._v(" "),n("table",{staticClass:"table table-bordered"},[n("thead",[n("tr",t._l(t.qtd_blood_type.data,(function(e){return n("th",{key:e[0]},[t._v("\n                    "+t._s(e[0])+"\n                ")])})),0)]),t._v(" "),n("tbody",[n("tr",t._l(t.qtd_blood_type.data,(function(e){return n("td",{key:e[0]},[t._v("\n                    "+t._s(e[1])+"\n                ")])})),0)])])]):t._e()}),[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("td",[n("b",[t._v("IMC")])])}],!1,null,null,null);e.default=component.exports}}]);