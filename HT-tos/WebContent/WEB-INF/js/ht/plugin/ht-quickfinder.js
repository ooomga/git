!function(n,j){"use strict";var J="ht",L=n[J],N=function(e){return(/ble$/.test(e)||/ed$/.test(e)||L.IsGetter[e]?"is":"get")+e.charAt(0).toUpperCase()+e.slice(1)};L.QuickFinder=function(G,X,e,w,U){var v=this;v.$9j={},v.$1j=G,v.$2j=X,v.$3j=e,v.$4j=w||v.getValue,v.$5j=U||v.$5j,G.each(v.$7j,v),G.mm(v.$11j,v,!0),G.md(v.$12j,v,!0)},L.Default.def(L.QuickFinder,j,{$6j:"__ht__null__",getValueFunc:function(){return this.$4j},getFilterFunc:function(){return this.$5j},$11j:function(E){"add"===E.kind?this.$7j(E.data):"remove"===E.kind?this.$8j(E.data):"clear"===E.kind&&(this.$9j={})},$12j:function(h){var N=this,B=N.$3j,F=N.$2j;if(N.$5j(h.data)){if(null==B&&F===h.property);else if("style"===B&&"s:"+F===h.property);else if("attr"!==B||"a:"+F!==h.property)return;var u=N.$10j(h.oldValue);u&&u.remove(h.data),N.$7j(h.data)}},$10j:function(T){return T=null==T?this.$6j:T,this.$9j[T]},find:function(E){var W=this.$10j(E);return W?W.toList():new L.List},findFirst:function(b){var m=this.$10j(b);return!m||m.isEmpty()?null:m.get(0)},$7j:function(X){var v=this;if(v.$5j(X)){var b=v.$4j(X),y=v.$10j(b);y||(y=new L.List,b=null==b?v.$6j:b,v.$9j[b]=y),y.add(X)}},$8j:function(e){var g=this;if(g.$5j(e)){var J=g.$4j(e),u=g.$10j(J);u&&(u.remove(e),u.isEmpty()&&(J=null==J?g.$6j:J,delete g.$9j[J]))}},dispose:function(){this.$1j.umm(this.$11j,this),this.$1j.umd(this.$12j,this),delete this.$1j},getDataModel:function(){return this.$1j},getAccessType:function(){return this.$3j},getPropertyName:function(){return this.$2j},$5j:function(G){return null!=this.$3j||this.$4j!==this.getValue||G[N(this.$2j)]?!0:!1},getValue:function(A){var d=this,y=d.$3j,q=d.$2j;return null==y?A[N(q)]():"style"===y?A.s(q):"attr"===y?A.a(q):void 0}})}(this,Object);