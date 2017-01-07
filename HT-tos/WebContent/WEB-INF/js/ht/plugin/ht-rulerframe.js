!function(c,l){"use strict";var S="position",Q="absolute",z="relative",i="px",t="left",H="right",k="top",Y="bottom",d="display",e="none",I="block",x=ht.Default,C=x.getInternal(),g=Math.floor,J=Math.ceil,v=Math.PI,U=null,V=c.parseInt,O=function(b){return b.getContext("2d")},p=function(){return document},A=function(A){return p().createElement(A)},E=function(){return A("div")},a=function(){return A("canvas")},u=function(r,Q,f){r.style.setProperty(Q,f,U)},n=function(z,Q,W){x.def(ht.widget[z],Q,W)},h=function(u,d){u.appendChild(d)},W=function($,L){$.removeChild(L)},s=function(C,k,A,d){C.addEventListener(k,A,!!d)},P=function(X,b,r,s){X.removeEventListener(b,r,!!s)};ht.widget.RulerFrame=function(f){var r=this,D=r._view=E(),l=r.$1k=a(),e=r.$2k=a(),o=r.$3k=a(),j=r.$4k=a();r._defaultRulerConfig={size:20,borderWidth:1,borderStyle:"solid",borderColor:"#888",defaultMajorTickSpacing:50,minMajorTickSpacing:10,minPhysicalMajorTickSpacing:40,maxPhysicalMajorTickSpacing:100,tickSpacingAdaptable:!0,majorTickTextFont:"12px Arial",majorTickTextColor:"#666",majorTickColor:"#888",minorTickColor:"#ccc",background:"rgba(0,0,0,0)",guideColor:"rgb(0, 173, 239)",guideWidth:2,guideVisible:!1,guideTipVisible:!1,guideTipBorderColor:"#666",guideTipTextColor:"#666",guideTipTextFont:"12px Arial",guideTipBackground:"#fff"},r._topRulerConfig={visible:!0},r._rightRulerConfig={visible:!1},r._bottomRulerConfig={visible:!1},r._leftRulerConfig={visible:!0},h(D,l),h(D,o),h(D,e),h(D,j),u(D,S,z),u(D,"box-sizing","border-box"),u(D,"-moz-box-sizing","border-box"),u(l,S,Q),u(e,S,Q),u(o,S,Q),u(j,S,Q),r.$14k=function(){r.$13k=1,r.iv()},r.$15k=function(_){if(r._topRulerConfig.guideVisible||r._rightRulerConfig.guideVisible||r._bottomRulerConfig.guideVisible||r._leftRulerConfig.guideVisible||r._defaultRulerConfig.guideVisible||(r._topRulerConfig.guideTipVisible||r._rightRulerConfig.guideTipVisible||r._bottomRulerConfig.guideTipVisible||r._leftRulerConfig.guideTipVisible||r._defaultRulerConfig.guideTipVisible)&&r._component){var u=D.getBoundingClientRect();r.$16k={x:_.clientX-u.left,y:_.clientY-u.top},r.$5k()}},r.setComponent(f)},n("RulerFrame",l,{ms_v:1,ms_fire:1,ms_ac:["defaultRulerConfig","topRulerConfig","rightRulerConfig","bottomRulerConfig","leftRulerConfig","component"],setComponent:function(q){var $=this,G=$._component,J=$.getView();if(J){if($._component=q,$.fp("component",G,q),G){var d=$.getComponentView(G);W(J,d),P(J,"mousemove",$.$15k),$.removeComponentPropertyChangeListener(G,$.$14k)}if(q){var V=$.getComponentView(q);h(J,V),u(V,S,Q),s(J,"mousemove",$.$15k),$.addComponentPropertyChangeListener(q,$.$14k)}}},addComponentPropertyChangeListener:function(j,q){j&&j.mp&&j.mp(q)},removeComponentPropertyChangeListener:function(e,V){e&&e.ump&&e.ump(V)},getComponentHZoom:function(t){return t&&t.getZoom?t.getZoom():1},getComponentVZoom:function(z){return z&&z.getZoom?z.getZoom():1},getComponentViewRect:function(H){return H&&H.getViewRect?H.getViewRect():void 0},getComponentView:function(a){return a&&a.getView?a.getView():a},invalidateComponent:function(K){K&&K.iv&&K.iv()},validateComponent:function(X){X&&X.validate&&X.validate()},$7k:function(q,H,m,k,X,s,A,R,y,o,B,J){if(H.visible){var D=this._defaultRulerConfig,a="borderStyle",j="borderColor",Q="borderWidth",n="background",$=H[a]||D[a],p=H[j]||D[j],O=H[Q]||D[Q],E=H.size!=U?H.size:D.size,g=H[n]||D[n],S=E+O,f=this.$6k(O,$,p,q,m,X,S,A,R,y,o,B,J);u(q,X,"0px"),s?C.setCanvas(q,k-f,E):C.setCanvas(q,E,k-f),u(q,"background",g),u(q,d,I)}else u(q,d,e),u(this.getComponentView(this._component),X,"0px")},$6k:function(q,B,Y,w,H,d,K,V,G,J,P,c,m){var h=0;return u(w,H,q+"px "+B+" "+Y),u(this.getComponentView(this._component),d,K+i),V?(u(w,G,J+i),h+=J):u(w,G,"0px"),P?(u(w,c,m+i),h+=m):u(w,c,"0px"),h},validateImpl:function(){var L=this,E=L._component,P=L.$1k,N=L.$2k,d=L.$3k,K=L.$4k,Z=L._view,M=L._defaultRulerConfig,i=L._topRulerConfig,z=L._rightRulerConfig,$=L._bottomRulerConfig,g=L._leftRulerConfig,B=M.size;if(Z&&E){var I=i.size!=U?i.size:B,q=z.size!=U?z.size:B,u=$.size!=U?$.size:B,b=g.size!=U?g.size:B;L.$7k(P,i,"border-bottom",Z.offsetWidth,k,!0,g.visible,t,b,z.visible,H,q),L.$7k(N,z,"border-left",Z.offsetHeight,H,!1,i.visible,k,I,$.visible,Y,u),L.$7k(d,$,"border-top",Z.offsetWidth,Y,!0,g.visible,t,b,z.visible,H,q),L.$7k(K,g,"border-right",Z.offsetHeight,t,!1,i.visible,k,I,$.visible,Y,u),L.$13k?delete L.$13k:L.invalidateComponent(E),L.validateComponent(E),L.$5k()}},$5k:function(){function X(p,c,X,G,t,Y){if(c.visible){var H=O(p),j=c[$]||n,S=c[Z]!=U?c[Z]:L,N=c[y]||W,E=c[d]||q,s=c.size!=U?c.size:D,Xc=c[e]||h,ll=c[l]||r,on=c[R]||P,fl=c[A]!=U?c[A]:a,qq=c[C]!=U?c[C]:M,gn=c[w]!=U?c[w]:K,sb=c[v]!=U?c[v]:B,pp=c[z]!=U?c[z]:V,zs=c[k]!=U?c[k]:g,Kr=c[f]||Ff,ii=c[o]||cr;S&&(j=Q[Y]=Q.$8k(Q[Y]||j,c[F]||I,c[T]||_,G?b:i,ll)),X.call(Q,H,x,u,m,J,s,G?b:i,j,N,E,t,Xc,on);var xm=Q.$16k;(fl||qq)&&xm&&(G?Q.$9k(H,xm.x,s,Kr,ii,fl,qq,gn,sb,pp,zs):Q.$10k(H,xm.y,s,Kr,ii,fl,qq,gn,sb,pp,zs,t))}}var Q=this,s=Q.$1k,j=Q.$2k,Y=Q.$3k,G=Q.$4k,H=Q._topRulerConfig,S=Q._rightRulerConfig,p=Q._bottomRulerConfig,t=Q._leftRulerConfig,N=Q._defaultRulerConfig,E=Q._component,c=Q.getComponentViewRect(E),b=Q.getComponentHZoom(E),i=Q.getComponentVZoom(E),x=c.x*b,m=x+c.width*b,u=c.y*i,J=u+c.height*i,D=Q._defaultRulerConfig.size,$="defaultMajorTickSpacing",F="maxPhysicalMajorTickSpacing",T="minPhysicalMajorTickSpacing",Z="tickSpacingAdaptable",y="majorTickTextFont",d="majorTickTextColor",e="majorTickColor",R="minorTickColor",A="guideVisible",C="guideTipVisible",w="guideTipBorderColor",v="guideTipTextColor",z="guideTipTextFont",k="guideTipBackground",f="guideColor",o="guideWidth",l="minMajorTickSpacing",n=N[$],I=N[F],_=N[T],L=N[Z],W=N[y],q=N[d],h=N[e],r=N[l],P=N[R],a=N[A],M=N[C],K=N[w],B=N[v],V=N[z],g=N[k],Ff=N[f],cr=N[o];Q._view&&E&&(X(s,H,Q.$11k,!0,!1,"_currentTopMajorTickSpacing"),X(j,S,Q.$12k,!1,!0,"_currentRightMajorTickSpacing"),X(Y,p,Q.$11k,!0,!0,"_currentBottomMajorTickSpacing"),X(G,t,Q.$12k,!1,!1,"_currenLeftMajorTickSpacing"))},$8k:function($,p,T,S,G){return T>$*S?$=g(p/S/G)*G:$*S>p&&($=J(T/S/G)*G),$},getHTipText:function(W){var D=this,T=D._component,s=0,m=D._view.getBoundingClientRect();return T.lp?s=V(T.lp({clientX:W.x+m.left,clientY:W.y}).x):s-=V(this.getComponentView(T).style.left)||0,s},$9k:function(p,k,s,y,t,D,Z,w,z,N,U){var J=this,l=J._component;p.save(),C.translateAndScale(p,0,0,1);var $=k-(V(this.getComponentView(l).style.left)||0),W=0;if(k=J.getHTipText(J.$16k),D&&(p.beginPath(),p.fillStyle=y,p.rect($,W,t,s),p.fill()),Z){p.beginPath(),p.textAlign="center",p.textBaseline="middle",p.font=N;var B=p.measureText(k).width+6;p.fillStyle=U,p.rect($-B/2,W,B,s),p.fill(),p.strokeStyle=w,p.stroke(),p.beginPath(),p.fillStyle=z,p.fillText(k,$,W+s/2)}p.restore()},getVTipText:function(I){var M=this,$=M._component,t=0,k=M._view.getBoundingClientRect();return $.lp?t=V($.lp({clientX:I.x,clientY:I.y+k.top}).y):t-=V(this.getComponentView($).style.top)||0,t},formatScaleText:function(K){return Math.round(K)},$10k:function(S,E,h,i,n,W,U,u,e,t,M,b){var I=this,y=I._component;S.save(),C.translateAndScale(S,0,0,1);var r=h/2,N=E-(V(this.getComponentView(y).style.top)||0);if(E=I.getVTipText(I.$16k),W&&(S.beginPath(),S.fillStyle=i,S.rect(r-h/2,N,h,n),S.fill()),U){S.translate(r,N),S.rotate((b?90:-90)*v/180),S.translate(-r,-N),S.beginPath(),S.textAlign="center",S.textBaseline="middle",S.font=t;var L=S.measureText(E).width+6;S.fillStyle=M,S.rect(r-L/2,N-h/2,L,h),S.fill(),S.strokeStyle=u,S.stroke(),S.fillStyle=e,S.fillText(E,r,N)}S.restore()},$11k:function(P,D,O,U,A,Y,F,e,Z,E,r,p,K){P.save(),O=0;var m=D,t=U,_=(m+t)/2;D=0,U=t-m,C.translateAndScale(P,0,0,1);var n=0,Q=0,u=V(Y/2),W=Y-u,X=r?0:u,q=e*F,x=q/10;D-=q,U+=q,P.clearRect(D,0,U-D,Y),P.beginPath(),P.fillStyle=K;var l=g(_/x)*x-m;for(n=l;U>n;n+=x)P.rect(n,O+X,1,W);for(n=l;n>D;n-=x)P.rect(n,O+X,1,W);for(P.fill(),X=r?0:1,P.beginPath(),P.fillStyle=p,l=g(_/q)*q-m,n=l;U>n;n+=q)P.rect(n,O+X,1,Y-1);for(n=l;n>D;n-=q)P.rect(n,O+X,1,Y-1);P.fill();var H=V(/\d+px/.exec(Z)[0]),s=(H||10)/2;P.textBaseline="middle",X=r?Y-s-2:s+2,P.beginPath(),P.fillStyle=E,P.font=Z;var k=g(_/q)*q/F;for(n=l,Q=k;U>n;n+=q,Q+=e){var G=this.getHScaleText?this.getHScaleText(n):Q;P.fillText(this.formatScaleText(G),n+2,O+X)}for(n=l,Q=k;n>D;n-=q,Q-=e){var G=this.getHScaleText?this.getHScaleText(n):Q;P.fillText(this.formatScaleText(G),n+2,O+X)}P.restore()},$12k:function(Q,x,b,r,p,R,u,w,Y,o,W,M,X){function L(j,N,t,D,B,i){B=h.getVScaleText?h.getVScaleText(t):B,B=h.formatScaleText(B),Q.translate(j+N,t),Q.rotate(-D),Q.translate(-j-N,-t),Q.fillText(B,j+N+(i?2:1),t),Q.translate(j+N,t),Q.rotate(D),Q.translate(-j-N,-t)}Q.save(),x=0;var a=b,I=p,f=(a+I)/2;b=0,p=I-a,C.translateAndScale(Q,0,0,1);var A=0,h=this,F=0,z=V(R/2),P=R-z,i=W?0:z,S=w*u,s=S/10;b-=S,p+=S,Q.clearRect(x,0,R,p-b),Q.beginPath(),Q.fillStyle=X;var d=g(f/s)*s-a;for(A=d;p>A;A+=s)Q.rect(x+i,A,P,1);for(A=d;A>b;A-=s)Q.rect(x+i,A,P,1);for(Q.fill(),i=W?0:1,Q.beginPath(),Q.fillStyle=M,d=g(f/S)*S-a,A=d;p>A;A+=S)Q.rect(x+i,A,R-1,1);for(A=d;A>b;A-=S)Q.rect(x+i,A,R-1,1);Q.fill();var J=V(/\d+px/.exec(Y)[0]),Z=(J||10)/2,H=90*v/180;Q.textBaseline="middle",i=W?R-Z:Z+2,H=W?-H:H,Q.beginPath(),Q.fillStyle=o,Q.font=Y;var k=g(f/S)*S/u;for(A=d,F=k;p>A;A+=S,F+=w)L(x,i,A,H,F,W);for(A=d,F=k;A>b;A-=S,F-=w)L(x,i,A,H,F,W);Q.restore()},onPropertyChanged:function(){this.iv()},dispose:function(){var s=this,h=s._component,E=s._view;h&&s.removeComponentPropertyChangeListener(h,s.$14k),E&&(P(E,"mousemove",s.$15k),W(E.parentNode,E),s._view=null)}})}(this,Object);