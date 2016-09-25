!function(_,C,D){"use strict";var f="ht",O=_[f],t=O.Default,S=t.isTouchable,u=O.Color,l="px",j="0",U="innerHTML",x="className",G="position",m="absolute",T="width",K="height",Z="left",y="top",c="right",w="bottom",p="max-width",X="max-height",E=null,M="none",s="",Q=_.parseInt,F=_.setTimeout,B=t.getInternal(),N=t.animate,n=u.titleIconBackground,b=function(){return document},q=function(f){return b().createElement(f)},h=function(){return q("div")},e=function(){return q("canvas")},d=function(w,K,T){w.style.setProperty(K,T,E)},L=function(Q,f){return Q.style.getPropertyValue(f)},J=function(k,T){k.appendChild(T)},Y=function(h,p){h.removeChild(p)},g=function(L){var A=L.scrollWidth,D=L.scrollHeight;return L===b().body&&(A=Math.max(A,b().documentElement.scrollWidth),D=Math.max(D,b().documentElement.scrollHeight)),{width:A,height:D}},V=function(D){var g=D.touches[0];return g?g:D.changedTouches[0]};B.addMethod(t,{panelExpandIcon:{width:16,height:16,comps:[{type:"triangle",rect:[4,4,10,8],background:n,rotation:3.14}]},panelCollapseIcon:{width:16,height:16,comps:[{type:"triangle",rect:[4,4,10,8],background:n}]},panelLockIcon:{width:100,height:100,comps:[{type:"roundRect",rect:[10,50,80,40],borderWidth:10,borderColor:n},{type:"shape",points:[37,45,37,20,37,13,43,13,63,13,69,13,70,19,70,44],segments:[1,2,3,2,3,2],borderWidth:10,borderColor:n}]},panelUnLockIcon:{width:100,height:100,comps:[{type:"roundRect",rect:[10,50,80,40],borderWidth:10,borderColor:n},{type:"shape",points:[37,45,37,20,37,13,43,13,63,13,69,13,70,19,70,26],segments:[1,2,3,2,3,2],borderWidth:10,borderColor:n}]},panelMinimizeIcon:{width:100,height:100,comps:[{type:"shape",points:[10,35,35,35,35,10],segments:[1,2,2],borderWidth:8,borderColor:n},{type:"shape",points:[90,35,65,35,65,10],segments:[1,2,2],borderWidth:8,borderColor:n},{type:"shape",points:[10,65,35,65,35,90],segments:[1,2,2],borderWidth:8,borderColor:n},{type:"shape",points:[65,90,65,65,90,65],segments:[1,2,2],borderWidth:8,borderColor:n}]},panelRestoreIcon:{width:300,height:300,comps:[{type:"rect",rect:[10,24,268,56],background:n},{type:"rect",rect:[10,118,268,56],background:n},{type:"rect",rect:[10,213,268,56],background:n}]},panelTitleLabelColor:t.labelSelectColor,panelTitleLabelFont:t.labelFont,panelContentLabelFont:t.labelFont,panelTitleBackground:u.titleBackground,panelSeparatorWidth:1,panelSeparatorColor:D},!0);var a=O.widget.Panel=function(V){var D=this,N=D._view=h();D.$1i=0,D.$18i=new O.Notifier,D.$2i="leftTop",d(N,y,j),d(N,Z,j),d(N,G,m),d(N,"overflow","hidden"),D._interactor=new o(D),D.setConfig(V),D.addEventListener(function(x){var a=D.getPanelConfig(x.id),j=a.content;("beginRestore"===x.kind||"betweenResize"===x.kind||"endToggle"===x.kind)&&(j&&j.invalidate&&j.invalidate(),a.items&&a.items.forEach(function(E){E&&E.content&&E.content.invalidate&&E.content.invalidate()}))})};t.def(a,C,{ms_v:1,_dragContainment:"parent",setConfig:function(X){function L(F){F.expanded=!F.expanded,n.togglePanel(F.id,!0,!0)}if(X){var n=this;n._view[U]=s,n._config=X,n.$35i=[],X.expanded==E&&(X.expanded=X.expand!=E?X.expand:!0);var D=n._view,u=n.$24i(X,D,!0),y=u[2],t=X.width;n.$35i.push(u[1]),X.items&&X.items.forEach(function(m){m.expanded==E&&(m.expanded=m.expand!=E?m.expand:!0);var M=n.$24i(m,y.children[0]);n.$35i.push(M[1])});var z=h();d(z,T,10+l),d(z,K,10+l),d(z,G,m),d(z,w,j),d(z,c,j),z[x]="resize-area",J(D,z),n.$10i(),X.flowLayout&&d(D,G,"relative"),d(D,"opacity",j),J(b().body,D),t==E&&(t=D.offsetWidth),d(D,T,t+l),d(D,p,t+l),X.items&&X.items.forEach(function(c){L(c)}),X.buttons&&X.buttons.indexOf("toggle")<0||L(X),X.minimized==E&&X.minimize!=E&&(X.minimized=X.minimize),X.minimized&&X.minimizable!==!1&&n.minimize(!0),Y(b().body,D),d(D,"opacity",s),n.iv()}},getPanelConfig:function(H){var s=this,G=s._config,D=G.items;if(G.id===H)return G;if(D)for(var d=0;d<D.length;d++){var p=D[d];if(p.id===H)return p}},getPanelView:function(A){for(var j=this,U=j.$35i,v=0;v<U.length;v++){var C=U[v],H=C.parentNode;if(H.$15i===A)return H}},setDragContainment:function(S){this._dragContainment=S},getDragContainment:function(){return this._dragContainment},$20i:function(){var e=this._config,W=e.restoreIconSize||24;return W},$5i:function(j){var x=j.titleIconSize||16;return S&&(x*=1.2),x},$4i:function(Y){var z=Y.titleHeight||t.widgetTitleHeight;return z},setTitle:function(G,l){if(l==E&&(l=this._config.id),l!=E){var n=this.getPanelConfig(l),q=this.getPanelView(l);n.title=G,q.querySelector(".panel-title span").innerHTML=G}},setInnerPanel:function(r){var D,T,V=this,Z=r.id,S=V.$35i,l=!1;if(r.expanded==E&&(r.expanded=!0),Z!=E){var j=V.getPanelConfig(Z);if(j){l=!0;var e,b=V.getPanelView(Z),y=b.parentNode,w=b.children[0];if(b!==V._view){V.$11i();for(e in j)delete j.key;for(e in r)j[e]=r[e];D=V.$24i(r,y,!1,b),T=D[1],y.removeChild(b);for(var t=0;t<S.length;t++)if(S[t]===w){S.splice(t,1,T);break}V.$12i(),j.expanded=!j.expanded,V.togglePanel(j.id,!0,!0),V.iv()}}}if(!l){V.$11i(),D=V.$24i(r,V._view.children[1]),T=D[1],S.push(T),V._config.items||(V._config.items=[]);var c=V._config.items;if(c.push(r),V.$12i(),c.length>1){var G=c[c.length-2],$=V.getPanelView(G.id).children[0];d($,"border-bottom",V.$55i(G))}r.expanded=!r.expanded,V.togglePanel(r.id,!0,!0),V.iv()}},removeInnerPanel:function(k){var s,U=this,Z=-1,P=U._config.items;if(P)for(s=0;s<P.length;s++){var V=P[s];if(V.id===k){Z=s;break}}if(U.$11i(),Z>=0){var f=U.$35i,N=U.getPanelView(k),J=N.children[0];for(s=0;s<f.length;s++)if(f[s]===J){f.splice(s,1);break}P.splice(Z,1),N.parentNode.removeChild(N)}if(U.$12i(),P.length>0){var w=P[P.length-1],S=U.getPanelView(w.id).children[0];d(S,"border-bottom",U.$55i(w))}},$6i:function(L){d(L,"cursor","pointer"),d(L,"display","inline-block"),d(L,"margin-right",(S?8:4)+l),d(L,"vertical-align",y)},$24i:function(Q,r,o,O){var A=this,Y=A._config.flowLayout,M=o?r:h(),P=A.$50i(Q),p=A.$3i(Q,o);M[x]="ht-widget-panel"+(o?" outer-panel":" inner-panel"),Q.borderWidth==E&&(Q.borderWidth=o?2:0);var y=Q.borderWidth;if(y="0 "+y+l+" "+y+l+" "+y+l+" ",d(M,"padding",y),J(M,p),J(M,P),o||(O?r.insertBefore(M,O):J(r,M)),!Y&&o&&Q.minimizable!==!1){var m=e(),q=A.$20i(),$=Q.restoreToolTip;B.setCanvas(m,q,q),m[x]="control-button button-minimize button-minimize-restore",A.$6i(m),d(m,"display","none"),J(r,m),m.title=$||""}var U=Q.titleBackground||t.panelTitleBackground;if(d(M,"background-color",U),Q.id==E){for(var z=A.$1i++;A.getPanelConfig(z);)z=A.$1i++;Q.id=z}return M.$15i=Q.id,Q.width&&(M.style.width=Q.width+l),[M,p,P]},$9i:function(k){var a=e();a[x]="control-button button-toggle button-toggle-expand",a.title=k.toggleToolTip||"";var Z=this.$4i(k),d=this.$5i(k);return this.$6i(a),B.setCanvas(a,d,Z),a},$8i:function(P){var Y=e(),b="control-button button-independent-switch";Y[x]=P.independent===!0?b+" button-independent-switch-on":b+" button-independent-switch-off",Y.title=P.independentSwitchToolTip||"";var C=this.$4i(P),m=this.$5i(P);return this.$6i(Y),B.setCanvas(Y,m,C),Y},$7i:function(v){var S=e();S[x]="control-button button-minimize button-minimize-minimize",S.title=v.minimizeToolTip||"";var _=this.$4i(v),R=this.$5i(v);return this.$6i(S),B.setCanvas(S,R,_),S},$55i:function(r){var f=this._config,z=f.items,u=r.separatorWidth||t.panelSeparatorWidth,K=r.titleBackground||t.panelTitleBackground,U=r.expanded!==!1?K:r.separatorColor||t.panelSeparatorColor||t.brighter(K);return(f===r||z&&z.indexOf(r)===z.length-1)&&(u=0),u+l+" solid "+U},$3i:function(X,k){var F=this,i=F._config.flowLayout,P=h(),V=h(),v=F.$4i(X),r=X.titleBackground,L=X.titleColor,Y=X.titleIcon,f=X.buttons;if(P[x]="panel-title",d(P,G,"relative"),d(P,"background",r||t.panelTitleBackground),d(P,"color",L||t.panelTitleLabelColor),d(P,y,j),d(P,"box-sizing","border-box"),d(P,"-moz-box-sizing","border-box"),d(P,"padding","0 5px 0 0"),d(P,T,"100%"),d(P,"cursor","default"),d(P,"white-space","nowrap"),d(P,"font",t.panelTitleLabelFont),Y){var W=e();W[x]="control-button panel-title-icon";var M=F.$4i(X),K=F.$5i(X);F.$6i(W),B.setCanvas(W,K,M),J(P,W)}var $=q("span");d($,"display","inline-block"),d($,"margin-left","5px"),$[U]="<span>"+X.title+"</span>",J(P,$),d(P,"line-height",v+l),V[x]="panel-title-controls",d(V,G,m),d(V,Z,j),d(V,c,5+l),d(V,y,j),d(V,w,j),d(V,"text-align",c);var N=function(){var r=F.$9i(X);J(V,r)},p=function(){if(!i&&k&&X.minimizable!==!1){var L=F.$7i(X);J(V,L)}},a=function(){if(!k){var q=F.$8i(X);J(V,q)}},O=function(z){var r=e();r[x]="control-button custombutton-"+z.name,r.title=z.toolTip||"",r._action=z.action;var S=F.$4i(X),o=F.$5i(X);F.$6i(r),B.setCanvas(r,o,S),J(V,r)};if(f)for(var E=0;E<f.length;E++){var D=f[E];"string"==typeof D?"minimize"===D?p():"independentSwitch"===D?a():"toggle"===D&&N():"object"==typeof D&&O(D)}else p(),N();return J(P,V),P},$50i:function(a){var r=h(),V=a.contentHeight,_=h();if(d(_,G,"relative"),r[x]="panel-body",d(r,"overflow","hidden"),d(r,"background","white"),d(r,"font",t.panelContentLabelFont),J(r,_),a.content){var F;a.content.getView?(J(_,a.content.getView()),F=_.children[0]):a.content instanceof Element?(J(_,a.content),F=_.children[0]):_[U]=a.content,F&&(d(F,T,"100%"),d(F,K,"100%")),V&&d(_,K,V+l)}return r},$10i:function(){var y=this,k=y._config,B=y._view,H=B.querySelector(".resize-area").style;H.display=k.flowLayout||k.minimized===!0||k.expanded===!1?M:"block"},$11i:function(){var G=this._view,o=G.children[1];this.$13i>=0?this.$13i++:this.$13i=1,d(o,X,s),d(G,p,s)},$12i:function(){var b=--this.$13i;if(0===b){var N=this._view,Q=N.children[1];d(Q,X,Q.scrollHeight+l),d(N,p,N.offsetWidth+l)}},$14i:function(){var e=this._view,d=e.children[0],i=d.children[1].children,X=this._config,G=0;e.$26i=e.offsetWidth,G+=d.children[0].offsetWidth,X.titleIcon&&(G+=d.children[1].offsetWidth,i=d.children[2].children);for(var u=0;u<i.length;u++){var Y=i[u];G+=Y.offsetWidth+5}e.$51i=G+15},togglePanel:function(n,h,g){function A($){var p=$.target,P=p.parentNode,d=V.getPanelConfig(P.$15i);delete P.$19i,p!==G&&V.$12i(),V.$18i.fire({kind:"endToggle",target:V,id:d.id})}for(var V=this,J=V._view,G=J.children[1],U=E,o=V.$35i,k=o.length,Q=V._config.exclusive,v=V.$2i,b=[],M=V._config.narrowWhenCollapse,t=0;k>t;t++){var y=o[t],c=y.parentNode,C=c.$15i,r=V.getPanelConfig(C);C===n&&(U=c),!h&&Q&&r.expanded&&c!==J&&C!==n&&r.independent!==!0&&b.push(c)}if(U&&!U.$19i){U.$19i=!0;var I=U.children[1],f=U.querySelector(".button-toggle"),_=V.getPanelConfig(U.$15i);if(!f)return;U===J||_.expanded||_.independent===!0||b.forEach(function(J){V.togglePanel(J.$15i,!0)}),U!==J&&V.$11i();var D=200;if(g&&(D=0),V.$18i.fire({kind:"beginToggle",target:V,id:U.$15i}),_.expanded){var i=function(){f[x]="control-button button-toggle",f[x]+=v.indexOf("Bottom")>=0?" button-toggle-expand":" button-toggle-collapse",d(I,T,I.clientWidth+l),_.expanded=!1,d(U.children[0],"border-bottom",V.$55i(_)),N(I).duration(D).set("opacity",j).set(X,j).end(A),M&&U===J&&N(U).duration(D).set(p,U.$51i+l).end(),U[x]+=" panel-collapse",N(U).duration(D).set("padding-bottom",j).end(),V.$28i(_,!0),V.$10i()};M&&U===J&&V.$14i(),i()}else f[x]="control-button button-toggle",f[x]+=v.indexOf("Bottom")>=0?" button-toggle-collapse":" button-toggle-expand",d(I,T,s),_.expanded=!0,d(U.children[0],"border-bottom",V.$55i(_)),N(I).duration(D).set("opacity","1").set(X,I.scrollHeight+l).end(A),M&&U===J&&N(U).duration(D).set(p,(U.$26i||U.offsetWidth)+l).end(),U[x]=U[x].replace(" panel-collapse",s),N(U).duration(D).set("padding-bottom",_.borderWidth+l).end(),V.$28i(_,!0),V.$10i()}},$16i:function(){var h=this._view,I=h.$22i,g=h.$23i,b=this.$2i;return I==E&&(b.indexOf(Z)>=0?I=h.$22i=0:b.indexOf(c)>=0&&(I=h.$22i=100)),g==E&&(b.indexOf("Top")>=0?g=h.$23i=0:b.indexOf("Bottom")>=0&&(g=h.$23i=100)),[I,g]},$25i:function(){var F=this,r=F._view,h=r.$21i,S=F.$20i(),A=F.$16i(),g=A[0],J=A[1],H=F.$2i;r.children[0].style.display=M,r.children[1].style.display=M,r.children[2].style.display=s,d(r,"padding",j),d(r,p,S+l),"leftTop"===H?(d(r,Z,Q(L(r,Z))+(h.width-S)*g/100+l),d(r,y,Q(L(r,y))+(h.height-S)*J/100+l)):"leftBottom"===H?(d(r,Z,Q(L(r,Z))+(h.width-S)*g/100+l),d(r,w,Q(L(r,w))+(h.height-S)*(1-J/100)+l)):"rightTop"===H?(d(r,c,Q(L(r,c))+(h.width-S)*(1-g/100)+l),d(r,y,Q(L(r,y))+(h.height-S)*J/100+l)):"rightBottom"===H&&(d(r,c,Q(L(r,c))+(h.width-S)*(1-g/100)+l),d(r,w,Q(L(r,w))+(h.height-S)*(1-J/100)+l)),r[x]+=" panel-minimized",F.$18i.fire({kind:"endMinimize",target:F,id:r.$15i})},$17i:function(){var c=this,H=c._config,X=c._view;d(X,"-webkit-transform",s),d(X,"-ms-transform",s),d(X,"transform",s),H.minimized?c.$25i():(c.$18i.fire({kind:"endRestore",target:c,id:H.id}),X[x]=X[x].replace(" panel-minimized",s)),delete X.$19i},minimize:function(S){var v=this,t=v._view;if(!t.$19i&&t.children[0].style.display!==M){var P=v._config,H=t.getBoundingClientRect(),p=v.$20i(),E=H.width,l=H.height,n=p/E,B=p/l,b=v.$16i(),y=b[0],R=b[1];t.$52i=n,t.$53i=B,t.$21i=H,v.$18i.fire({kind:"beginMinimize",target:v,id:t.$15i});var m=200;S&&(m=0),P.minimized=!0,t.$19i=!0,P.expanded&&(t.$26i=t.offsetWidth);var L=y+"% "+R+"%";d(t,"-webkit-transform-origin",L),d(t,"-ms-transform-origin",L),d(t,"transform-origin",L),N(t).duration(m).scale(n,B).end(function(){v.$17i()}),v.$10i()}},restore:function(){var X,D,$,r,V,W,q,Y,O,m,S,z,v=this,i=v._view,t=i.parentNode,s=v._config;if(!i.$19i&&s.minimized){var J=i.$21i,H=i.$52i,h=i.$53i,A=s.borderWidth+l,P=A,n=A,U=0,T=v.$20i(),K=g(t),E=v.$2i;"leftTop"===E?(X=Q(L(i,Z)),$=Q(L(i,y)),V=X,q=$,O=X+J.width-K.width,m=$+J.height-K.height,O>0&&(O>=X?X=0:X-=O),m>0&&(m>=$?$=0:$-=m),S=100*((V-X)/(J.width-T)),z=100*((q-$)/(J.height-T)),d(i,Z,X+l),d(i,y,$+l)):"leftBottom"===E?(X=Q(L(i,Z)),r=Q(L(i,w)),V=X,Y=r,O=X+J.width-K.width,m=r+J.height-K.height,O>0&&(O>=X?X=0:X-=O),m>0&&(m>=r?r=0:r-=m),S=100*((V-X)/(J.width-T)),z=100*(1-(Y-r)/(J.height-T)),d(i,Z,X+l),d(i,w,r+l)):"rightTop"===E?(D=Q(L(i,c)),$=Q(L(i,y)),W=D,q=$,O=D+J.width-K.width,m=$+J.height-K.height,O>0&&(O>=D?D=0:D-=O),m>0&&(m>=$?$=0:$-=m),S=100*(1-(W-D)/(J.width-T)),z=100*((q-$)/(J.height-T)),d(i,c,D+l),d(i,y,$+l)):"rightBottom"===E&&(D=Q(L(i,c)),r=Q(L(i,w)),W=D,Y=r,O=D+J.width-K.width,m=r+J.height-K.height,O>0&&(O>=D?D=0:D-=O),m>0&&(m>=r?r=0:r-=m),S=100*(1-(W-D)/(J.width-T)),z=100*(1-(Y-r)/(J.height-T)),d(i,c,D+l),d(i,w,r+l)),i.children[0].style.display="block",i.children[1].style.display="block",i.children[2].style.display=M,d(i,"padding",U+" "+P+" "+n+" "+A),d(i,"-webkit-transform","scale("+H+", "+h+")"),d(i,"-ms-transform","scale("+H+", "+h+")"),d(i,"transform","scale("+H+", "+h+")"),i.$22i=S,i.$23i=z,d(i,"-webkit-transform-origin",S+"% "+z+"%"),d(i,"-ms-transform-origin",S+"% "+z+"%"),d(i,"transform-origin",S+"% "+z+"%"),s.narrowWhenCollapse&&!s.expanded?d(i,p,i.$51i+l):d(i,p,i.$26i+l),v.$18i.fire({kind:"beginRestore",target:v,id:i.$15i}),i.$19i=!0,s.minimized=!1,F(function(){N(i).scale(1,1).end(function(){v.$17i()})},30),v.$10i()}},addEventListener:function(w,M,I){this.$18i.add(w,M,I)},removeEventListener:function(y,r){this.$18i.remove(y,r)},setPosition:function(E,t){var N=this._view,b=this.$2i;"leftTop"===b?(d(N,Z,E+l),d(N,y,t+l),d(N,c,s),d(N,w,s)):"leftBottom"===b?(d(N,Z,E+l),d(N,w,t+l),d(N,c,s),d(N,y,s)):"rightTop"===b?(d(N,c,E+l),d(N,y,t+l),d(N,Z,s),d(N,w,s)):"rightBottom"===b&&(d(N,c,E+l),d(N,w,t+l),d(N,Z,s),d(N,y,s)),delete N.$22i,delete N.$23i},getPosition:function(){var r=this._view,f=this.$2i;return"leftTop"===f?{x:Q(L(r,Z)),y:Q(L(r,y))}:"leftBottom"===f?{x:Q(L(r,Z)),y:Q(L(r,w))}:"rightTop"===f?{x:Q(L(r,c)),y:Q(L(r,y))}:"rightBottom"===f?{x:Q(L(r,c)),y:Q(L(r,w))}:void 0},setPositionRelativeTo:function(b){var V=this,J=V._view.querySelectorAll(".button-toggle"),K="control-button button-toggle",c=V.getPosition();V.$2i=b,V.setPosition(c.x,c.y);for(var u=0;u<J.length;u++){var G=J[u],m=V.getPanelConfig(G.parentNode.parentNode.parentNode.$15i);G[x]=m.expanded?b.indexOf("Bottom")>=0?K+" button-toggle-collapse":K+" button-toggle-expand":b.indexOf("Bottom")>=0?K+" button-toggle-expand":K+" button-toggle-collapse"}V.iv()},getPositionRelativeTo:function(){return this.$2i},invalidate:function(D){var V=this;V._68I||(V._68I=1,t.callLater(V.validate,V,E,D),V.onInvalidated&&V.onInvalidated(),V._41O("invalidate"));var F=this._config,h=F.content;h&&h.invalidate&&h.invalidate(),F.items&&F.items.forEach(function(G){G&&G.content&&G.content.invalidate&&G.content.invalidate()})},$27i:function(p,A,y,u){var m=B.initContext(p);B.translateAndScale(m,0,0,1),m.clearRect(0,0,y,y);var H=(y-u)/2;t.drawStretchImage(m,t.getImage(A),"fill",0,H,u,u),m.restore()},$28i:function(E){var X,Y,p,g=this,f=E.id,b=g.getPanelView(f),W=b.querySelector(".button-toggle"),O=g.$2i.indexOf("Bottom")>=0;if(Y=O?t.panelCollapseIcon:t.panelExpandIcon,p=O?t.panelExpandIcon:t.panelCollapseIcon,W){X=E.expanded?t.getImage(p):t.getImage(Y);var r=g.$4i(E),G=g.$5i(E);g.$27i(W,X,r,G)}},$29i:function(r){var d,_=this,Q=r.id,G=_.getPanelView(Q),h=G.querySelector(".button-independent-switch"),J=t.panelUnLockIcon,q=t.panelLockIcon;if(h){d=r.independent!==!0?t.getImage(q):t.getImage(J);var b=_.$4i(r),f=_.$5i(r);_.$27i(h,d,b,f)}},$30i:function(C){var Z=this,K=C.id,R=Z.getPanelView(K),m=R.querySelector(".button-minimize-minimize"),E=t.panelMinimizeIcon;if(m){var U=Z.$4i(C),q=Z.$5i(C);Z.$27i(m,t.getImage(E),U,q)}},$31i:function(y){var l=this,H=y.id,k=l.getPanelView(H),i=k.querySelector(".button-minimize-restore"),L=y.titleIcon||t.panelRestoreIcon;if(i){var V=l.$20i();l.$27i(i,t.getImage(L),V,V)}},$32i:function(u){var n=this,L=u.id,Y=n.getPanelView(L);if(u.buttons){var R=u.buttons;R.forEach(function(N){var X=N.name,h=N.icon;if(X&&h){var P=Y.querySelector(".custombutton-"+X);if(P){var C=n.$4i(u),b=n.$5i(u)-1;n.$27i(P,t.getImage(h),C,b)}}})}},$33i:function(j){var g=this,o=j.id,J=g.getPanelView(o),u=J.querySelector(".panel-title-icon"),$=j.titleIcon;if(u&&$){var G=g.$4i(j),d=g.$5i(j);g.$27i(u,t.getImage($),G,d)}},validateImpl:function(){var B=this,O=B._config;B.$28i(O),B.$30i(O),B.$31i(O),B.$32i(O),B.$33i(O),O.items&&O.items.forEach(function(C){B.$28i(C),B.$29i(C),B.$32i(C)})}});var o=function(N){var E=this,P=N.getView();E.$34i=N,E.addListeners(),P.addEventListener("dblclick",E.$42i.bind(E))};t.def(o,C,{ms_listener:1,getView:function(){return this.$34i.getView()},clear:function(){delete this.$37i,delete this.$38i,delete this.$36i,delete this.$39i},$42i:function(x){for(var W=this.$34i,F=x.target,h=W.$35i,N=h.length,V=0;N>V;V++){var u=h[V];u.contains(F)&&(x.preventDefault(),W.togglePanel(u.parentNode.$15i))}},handle_touchstart:function(m){var Q=this,H=Q.$34i,x=H._config,L=x.flowLayout,Z=m;if(t.preventDefault(m),t.isLeftButton(m)){var B=m.target,c=H.getView().children[0],F=H.getView().querySelector(".button-minimize-restore");S&&(Z=V(m));var P=Q.$40i={x:Z.pageX,y:Z.pageY};Q.$41i={x:P.x,y:P.y},(!L&&c.contains(B)||F&&F.contains(B))&&(Q.$38i=!0,t.startDragging(Q,m)),!L&&Q.handle_mousemove(m)&&(Q.$37i=!0,t.startDragging(Q,m),H.$11i())}},handle_mousedown:function(k){this.handle_touchstart(k)},handle_touchend:function(D){var F=this,v=F.$34i,A=D.target,J=v.$35i,f=J.length,q=0,s=v.getView(),b=s.querySelector(".button-minimize"),N=s.querySelector(".button-minimize-restore");if(!F.$39i&&!F.$36i){if(b&&b.contains(A)||N&&N.contains(A))D.preventDefault(),v._config.minimized?v.restore():v.minimize();else for(;f>q;q++){var T=J[q],l=T.parentNode,z=l.$15i,e=v.getPanelConfig(z),w=T.querySelector(".button-toggle"),j=T.querySelector(".button-independent-switch");if(w===A)D.preventDefault(),v.togglePanel(z);else if(j===A){D.preventDefault();var c="button-independent-switch-off",U="button-independent-switch-on";e.independent=e.independent==E?!0:!e.independent,j[x]=e.independent?j[x].replace(c,U):j[x].replace(U,c),v.$29i(e)}else A[x]&&A[x].indexOf("control-button custombutton-")>=0&&T.contains(A)&&A._action.call(v,e,v.getPanelView(z),D)}delete F.$40i,delete F.$41i}},handle_mouseup:function(Q){this.handle_touchend(Q)},handleWindowTouchEnd:function(){var X=this,A=X.$34i;X.$37i&&X.$36i?(A.$18i.fire({kind:"endResize",target:A,id:A.getView().$15i}),A.$12i()):X.$38i&&X.$39i&&A.$18i.fire({kind:"endMove",target:A,id:A.getView().$15i}),this.clear()},handleWindowMouseUp:function(F){this.handleWindowTouchEnd(F)},handle_mousemove:function(_){var o=this,X=o.getView(),f=X.querySelector(".resize-area"),N=f.getBoundingClientRect(),v={x:N.left,y:N.top,width:N.width,height:N.height};_=S?V(_):_;var M=_.clientX,q=_.clientY,Q=o.$34i._config;return Q.expanded&&Q.minimized!==!0&&t.containsPoint(v,{x:M,y:q})?(X.style.cursor="nwse-resize",!0):(X.style.cursor=s,void 0)},handleWindowTouchMove:function(n){n.preventDefault();var z=n;S&&(z=V(n));var b=this,s=b.$40i,Y=b.$41i;if(!(Y.x==s.x&&Y.y==s.y&&t.getDistance(Y,{x:z.pageX,y:z.pageY})<=1)){var N=b.$34i,e=b.getView(),m=e.parentNode,W=N._config,F=W.resizeMode||"wh",D=z.pageX-s.x,U=z.pageY-s.y,h=N.$2i;if(b.$37i){var k=e.children[1].children[0],I=k.clientWidth,f=k.clientHeight,J=I+D,i=f+U;J=Math.max(J,100),i=Math.max(i,100),"w"===F?(d(e,T,J+l),W.width=J,s.x+=J-I,h.indexOf(c)>=0&&d(e,c,Q(L(e,c))-(J-I)+l)):"h"===F?(d(k,K,i+l),W.contentHeight=i,s.y+=i-f,h.indexOf("Bottom")>=0&&d(e,w,Q(L(e,w))-(i-f)+l)):"wh"===F&&(d(e,T,J+l),d(k,K,i+l),W.width=J,W.contentHeight=i,s.x+=J-I,s.y+=i-f,h.indexOf("right")>=0&&d(e,c,Q(L(e,c))-(J-I)+l),h.indexOf("Bottom")>=0&&d(e,w,Q(L(e,w))-(i-f)+l)),b.$36i?N.$18i.fire({kind:"betweenResize",target:N,id:N.getView().$15i}):(b.$36i=!0,N.$18i.fire({kind:"beginResize",target:N,id:N.getView().$15i}))}else if(b.$38i){var q,j,P,E,B,O,$,M,o,r,X=e.getBoundingClientRect(),C=X.width,v=X.height,p=g(m),u=p.width,H=p.height,A=N._dragContainment;"leftTop"===h?(q=Q(L(e,Z))||0,P=Q(L(e,y))||0,B=q+D,$=P+U,"parent"===A&&(B+C>u&&(B=u-C),$+v>H&&($=H-v),0>B&&(B=0),0>$&&($=0)),o=B-q,r=$-P,N.setPosition(B,$),s.x+=o,s.y+=r):"rightBottom"===h?(j=Q(L(e,c))||0,E=Q(L(e,w))||0,O=j-D,M=E-U,"parent"===A&&(0>O&&(O=0),0>M&&(M=0),O+C>u&&(O=u-C),M+v>H&&(M=H-v)),o=O-j,r=M-E,N.setPosition(O,M),s.x-=o,s.y-=r):"rightTop"===h?(j=Q(L(e,c))||0,P=Q(L(e,y))||0,O=j-D,$=P+U,"parent"===A&&(0>O&&(O=0),0>$&&($=0),O+C>u&&(O=u-C),$+v>H&&($=H-v)),o=O-j,r=$-P,N.setPosition(O,$),s.x-=o,s.y+=r):"leftBottom"===h&&(q=Q(L(e,Z))||0,E=Q(L(e,w))||0,B=q+D,M=E-U,"parent"===A&&(0>B&&(B=0),0>M&&(M=0),B+C>u&&(B=u-C),M+v>H&&(M=H-v)),o=B-q,r=M-E,N.setPosition(B,M),s.x+=o,s.y-=r),b.$39i?N.$18i.fire({kind:"betweenMove",target:N,id:N.getView().$15i}):(b.$39i=!0,N.$18i.fire({kind:"beginMove",target:N,id:N.getView().$15i}))}}},handleWindowMouseMove:function(L){this.handleWindowTouchMove(L)}});var v=O.widget.PanelGroup=function(_){var b=this,V=b._view=h();V.style.border="1px dashed black",V.style.position="absolute",V.style.background="rgba(120, 120, 120, 0.4)",b.$48i=new O.List,b._tolerance=100,b._config=_||{hGap:0,vGap:0},b.bindHandlePanelMove=b.handlePanelMove.bind(b),b.bindHandlePanelEvent=b.handlePanelEvent.bind(b),b.invalidate()};t.def(v,C,{invalidate:function(){var w=this;w._68I||(w._68I=1,F(function(){w.validate()},50))},validate:function(){if(this._68I){delete this._68I;var S=this.$48i.get(0);if(S){var K=S.getView().parentNode;K&&(this.layoutPanels(K,"leftTop"),this.layoutPanels(K,"rightTop"),this.layoutPanels(K,"leftBottom"),this.layoutPanels(K,"rightBottom"))}}},setLeftTopPanels:function(){var V=this,v=V.$43i,x=V.$48i;v==E&&(v=V.$43i=new O.List);for(var g=0;g<arguments.length;g++){var G=arguments[g];if("string"==typeof G)v.$49i=G;else{if(G._config.flowLayout)continue;G.setPositionRelativeTo("leftTop"),v.contains(G)||v.add(G),x.contains(G)||V.add(G)}}},setRightTopPanels:function(){var f=this,U=f.$44i,x=f.$48i;U==E&&(U=f.$44i=new O.List);for(var M=0;M<arguments.length;M++){var t=arguments[M];if("string"==typeof t)U.$49i=t;else{if(t._config.flowLayout)continue;t.setPositionRelativeTo("rightTop"),U.contains(t)||U.add(t),x.contains(t)||f.add(t)}}},setLeftBottomPanels:function(){var v=this,$=v.$45i,w=v.$48i;$==E&&($=v.$45i=new O.List);for(var N=0;N<arguments.length;N++){var j=arguments[N];if("string"==typeof j)$.$49i=j;else{if(j._config.flowLayout)continue;j.setPositionRelativeTo("leftBottom"),$.contains(j)||$.add(j),w.contains(j)||v.add(j)}}},setRightBottomPanels:function(){var r=this,j=r.$46i,w=r.$48i;j==E&&(j=r.$46i=new O.List);for(var e=0;e<arguments.length;e++){var d=arguments[e];if("string"==typeof d)j.$49i=d;else{if(d._config.flowLayout)continue;d.setPositionRelativeTo("rightBottom"),j.contains(d)||j.add(d),w.contains(d)||r.add(d)}}},add:function(H){if(!H._config.flowLayout){var g=this,z=g.$48i;z.contains(H)||(H.addEventListener(g.bindHandlePanelMove),H.addEventListener(g.bindHandlePanelEvent),z.add(H))}},remove:function(c){var d=this,D=d.$48i;D.contains(c)&&(c.removeEventListener(d.bindHandlePanelMove),c.removeEventListener(d.bindHandlePanelEvent),D.remove(c),d.$43i.contains(c)&&d.$43i.remove(c),d.$44i.contains(c)&&d.$44i.remove(c),d.$45i.contains(c)&&d.$45i.remove(c),d.$46i.contains(c)&&d.$46i.remove(c))},layoutPanels:function(U,Z,W){var F=this,K=F._config,i=K.hGap||0,P=K.vGap||0;if(U){var L=F.$43i;if("leftBottom"===Z?L=F.$45i:"rightTop"===Z?L=F.$44i:"rightBottom"===Z&&(L=F.$46i),!L)return;var n=L.$49i,S=i,Y=P;if(U.contains(F._view)&&U.removeChild(F._view),L&&L.size()>0)for(var m=0;m<L.size();m++){var f=L.get(m),B=f.getView();U=U||B.parentNode,W!==m?f.setPosition(S,Y):("leftTop"===Z?(F._view.style.right="",F._view.style.bottom="",F._view.style.left=S+l,F._view.style.top=Y+l):"leftBottom"===Z?(F._view.style.right="",F._view.style.top="",F._view.style.left=S+l,F._view.style.bottom=Y+l):"rightTop"===Z?(F._view.style.left="",F._view.style.bottom="",F._view.style.right=S+l,F._view.style.top=Y+l):"rightBottom"===Z&&(F._view.style.left="",F._view.style.top="",F._view.style.right=S+l,F._view.style.bottom=Y+l),F._view.style.width=B.offsetWidth+l,F._view.style.height=B.offsetHeight+l,U.insertBefore(F._view,B)),"h"===n?S+=B.offsetWidth+i:"v"===n&&(Y+=B.offsetHeight+P)}}},handlePanelEvent:function(O){if("beginToggle"===O.kind||"endToggle"===O.kind||"beginRestore"===O.kind||"endMinimize"===O.kind||"endResize"===O.kind){var i=this,y=O.target,s=y.getView(),p=s.parentNode,N=i.$43i,u=i.$44i,G=i.$45i,S=i.$46i,d=i._config,H=E,I=E,a=y.$47i;if(a==E&&(a=y.$47i=0),"beginToggle"===O.kind?a=y.$47i=a+1:"endToggle"===O.kind&&(a=y.$47i=a-1),N&&N.contains(y)?(H="leftTop",I=N):G&&G.contains(y)?(H="leftBottom",I=G):u&&u.contains(y)?(H="rightTop",I=u):S&&S.contains(y)&&(H="rightBottom",I=S),"beginToggle"===O.kind&&H&&1===a){var $=h(),Y=$.style,e=I.$49i,m="each";Y.fontSize="0",Y.position="absolute",Y.width="100%","leftTop"===H?(Y.left=0,Y.top=0):"leftBottom"===H?(Y.left=0,Y.bottom=0,"v"===e&&(m="reverseEach")):"rightTop"===H?(Y.right=0,Y.top=0,Y.textAlign="right","h"===e&&(m="reverseEach")):"rightBottom"===H&&(Y.right=0,Y.bottom=0,Y.textAlign="right",m="reverseEach"),I[m](function(v){var V=v.getView(),F=V.style,s=h();F.position="static",s.style.textAlign="left",s.style.position="relative",s.style.display="inline-block","leftTop"===H?(s.style.marginLeft=d.hGap+l,s.style.marginTop=d.vGap+l):"leftBottom"===H?(s.style.marginLeft=d.hGap+l,s.style.marginBottom=d.vGap+l):"rightTop"===H?(s.style.marginRight=d.hGap+l,s.style.marginTop=d.vGap+l):"rightBottom"===H&&(s.style.marginRight=d.hGap+l,s.style.marginBottom=d.vGap+l),s.appendChild(V),$.appendChild(s),"h"===e?s.style.verticalAlign="leftTop"===H||"rightTop"===H?"top":"bottom":$.appendChild(q("br"))}),i.$54i=$,p.appendChild($)}else"endToggle"===O.kind&&H&&0===a?F(function(){p=p.parentNode.parentNode,p.removeChild(i.$54i),delete i.$54i,I.each(function(V){var l=V.getView(),g=l.style;g.position="absolute",p.appendChild(l)}),i.layoutPanels(p,H)},30):("beginRestore"===O.kind||"endMinimize"===O.kind||"endResize"===O.kind)&&H&&i.layoutPanels(p,H)}},handlePanelMove:function(N){if(!(N.kind.indexOf("Move")<0)){var D=this,T=D._config,t=T.hGap||0,U=T.vGap||0,f=N.target,r=f._view,Z=r.getBoundingClientRect(),o=Z.width,C=Z.height,l=o/2,A=C/2,K=r.parentNode,w=D.$43i,S=D.$44i,g=D.$45i,i=D.$46i,W=K.getBoundingClientRect(),p=D._tolerance;if("endMove"===N.kind){var a=D._corner;a&&(f.setPositionRelativeTo(a),D.layoutPanels(K,a)),delete D._corner}if("betweenMove"===N.kind){var c=W.left,m=W.top,V=W.width,P=W.height,H=Z.left+o/2,k=Z.top+C/2;w==E&&(w=D.$43i=new O.List),g==E&&(g=D.$45i=new O.List),S==E&&(S=D.$44i=new O.List),i==E&&(i=D.$46i=new O.List),delete D._corner,w.contains(f)?(w.remove(f),D.layoutPanels(K,"leftTop")):g.contains(f)?(g.remove(f),D.layoutPanels(K,"leftBottom")):S.contains(f)?(S.remove(f),D.layoutPanels(K,"rightTop")):i.contains(f)&&(i.remove(f),D.layoutPanels(K,"rightBottom"));var q=function(d,M){var Z=c+t,B=m+U;if(0===M.size()){var R=Z+l,o=B+A;"leftBottom"===d?o=m+P-U-A:"rightTop"===d?R=c+V-t-l:"rightBottom"===d&&(R=c+V-t-l,o=m+P-U-A);var T=H-R,i=k-o,W=Math.sqrt(T*T+i*i);if(p>W)return D._corner=d,M.add(f),D.layoutPanels(K,d,0),!0}else if(1===M.size()){var S=M.get(0),J=S.getView().getBoundingClientRect(),$=J.left+l,q=J.top+A,L=J.left+J.width+t+l,z=B+A,x=Z+l,G=J.top+J.height+U+A;"leftBottom"===d?(q=J.top+J.height-A,z=m+P-U-A,G=J.top-U-A):"rightTop"===d?($=J.left+J.width-l,L=J.left-t-l,x=c+V-t-l):"rightBottom"===d&&($=J.left+J.width-l,q=J.top+J.height-A,L=J.left-t-l,z=m+P-U-A,x=c+V-t-l,G=J.top-U-A);var n=H-$,Y=k-q,b=H-L,X=k-z,u=H-x,g=k-G,a=Q(Math.sqrt(n*n+Y*Y)),r=Q(Math.sqrt(b*b+X*X)),h=Q(Math.sqrt(u*u+g*g)),w=[a,r,h];w.sort(function(P,L){return P-L});var N=w[0];if(p>N){if(D._corner=d,N===a)return M.add(f,0),D.layoutPanels(K,d,0),!0;if(N===r)return M.add(f),M.$49i="h",D.layoutPanels(K,d,1),!0;if(N===h)return M.add(f),M.$49i="v",D.layoutPanels(K,d,1),!0}}else if(M.size()>1){for(var s=E,e={},_=[],O=M.$49i,v=0;v<M.size();v++){var F=M.get(v),I=F.getView(),C=I.getBoundingClientRect(),y=C.left+l,j=C.top+A;"leftBottom"===d?j=C.top+C.height-A:"rightTop"===d?y=C.left+C.width-l:"rightBottom"===d&&(y=C.left+C.width-l,j=C.top+C.height-A),v===M.size()-1&&(s=C);var T=H-y,i=k-j,W=Q(Math.sqrt(T*T+i*i));e[W]=v,_.push(W)}"leftTop"===d&&"h"===O?(R=s.left+s.width+t+l,o=B+A):"leftTop"===d&&"v"===O?(R=Z+l,o=s.top+s.height+U+A):"leftBottom"===d&&"h"===O?(R=s.left+s.width+t+l,o=m+P-U-A):"leftBottom"===d&&"v"===O?(R=Z+l,o=s.top-U-A):"rightTop"===d&&"h"===O?(R=s.left-t-l,o=B+A):"rightTop"===d&&"v"===O?(R=c+V-t-l,o=s.top+s.height+U+A):"rightBottom"===d&&"h"===O?(R=s.left-t-l,o=m+P-U-A):"rightBottom"===d&&"v"===O&&(R=c+V-t-l,o=s.top-U-A),T=H-R,i=k-o,W=Q(Math.sqrt(T*T+i*i)),e[W]=v,_.push(W),_.sort(function(r,F){return r-F});var N=_[0];if(p>N)return D._corner=d,M.add(f,e[N]),D.layoutPanels(K,d,e[N]),!0}};q("leftTop",w)||q("leftBottom",g)||q("rightTop",S)||q("rightBottom",i)}}}})}(this,Object);