(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["baseArticle"],{"3e73":function(t,e,i){},5899:function(t,e){t.exports="\t\n\v\f\r                　\u2028\u2029\ufeff"},"58a8":function(t,e,i){var r=i("1d80"),s=i("5899"),a="["+s+"]",n=RegExp("^"+a+a+"*"),o=RegExp(a+a+"*$"),c=function(t){return function(e){var i=String(r(e));return 1&t&&(i=i.replace(n,"")),2&t&&(i=i.replace(o,"")),i}};t.exports={start:c(1),end:c(2),trim:c(3)}},"5e98":function(t,e,i){"use strict";i.r(e);var r=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("transition",{attrs:{name:t.forModeration?"article-moderation":""}},[i("div",{staticClass:"Article",class:[t.className,t.moderateStatusClass]},[i("div",{staticClass:"Article-Header",class:{"ArticlePreview-Header":t.isPreview}},[i("div",{staticClass:"Article-Time",class:{"ArticlePreview-Time":t.isPreview}},[t._v(" "+t._s(t.time)+" ")]),i("div",{staticClass:"Article-Author",class:{"ArticlePreview-Author":t.isPreview}},[t._v(" "+t._s(t.author)+" ")])]),t.isPreview?i("router-link",{staticClass:"ArticlePreview-Title",attrs:{to:{name:"article",params:{id:""+t.id}}}},[t._v(" "+t._s(t.title)+" ")]):i("div",{staticClass:"Article-Title"},[t._v(" "+t._s(t.title)+" ")]),i("div",{staticClass:"Article-Text"},[t.isPreview?[t._v(" "+t._s(t._f("formatText")(t.text))+" ")]:i("span",{domProps:{innerHTML:t._s(t.htmlText)}})],2),t.forModeration||t.myPosts?i("ModerationBlock",{attrs:{className:"ArticlePreview-Moderation",id:t.id,myPosts:t.myPosts},on:{moderated:t.onModerated}}):i("div",{staticClass:"Article-Footer"},[i("SocialBlock",{attrs:{className:"Article-Social ArticlePreview-Social",isPreview:t.isPreview,likeCount:t.likes,dislikeCount:t.dislikes,commentCount:t.commentCount,viewCount:t.viewCount},on:{like:t.onLike,dislike:t.onDislike}}),t.isPreview?t._e():i("div",{staticClass:"Article-Tags"},t._l(t.tags,(function(e,r){return i("div",{key:r,staticClass:"Tag Article-Tag",on:{click:function(i){return t.onSelectTag(e)}}},[t._v(" #"+t._s(e)+" ")])})),0)],1)],1)])},s=[],a=(i("a9e3"),i("d3b7"),i("ac1f"),i("5319"),i("bc3a")),n=i.n(a),o=i("8c89"),c=i("ed08"),l=i("2b0e"),u=function(){return i.e("socialBlock").then(i.bind(null,"4205"))},d=function(){return i.e("moderationBlock").then(i.bind(null,"32d2"))},f={components:{SocialBlock:u,ModerationBlock:d},props:{className:{type:String,required:!1},forModeration:{type:Boolean,required:!1,default:!1},myPosts:{type:Boolean,required:!1,default:!1},isPreview:{type:Boolean,required:!1},id:{type:Number,required:!0,default:0},time:{type:String,required:!0,default:""},author:{type:String,required:!0,default:""},title:{type:String,required:!0,default:""},text:{type:String,required:!0,default:""},likeCount:{type:Number,required:!0,default:0},dislikeCount:{type:Number,required:!0,default:0},commentCount:{type:Number,required:!0,default:0},viewCount:{type:Number,required:!0,default:0},tags:{type:Array,required:!1}},data:function(){return{likes:0,liked:0,dislikes:0,disliked:0,moderateStatus:"notModerated"}},computed:{htmlText:function(){return Object(c["c"])(this.text)},moderateStatusClass:function(){return"Article-moderation-".concat(this.moderateStatus)}},filters:{formatText:function(t){var e=/&lt;.*?&gt;/gi;return t.replace(e,"")}},methods:{onModerated:function(t){var e=this;this.moderateStatus=t,l["default"].nextTick((function(){e.$emit("moderated",{id:e.id,status:t})}))},onLike:function(){var t=this;0===this.liked&&n.a.post("".concat(o["a"],"/api/post/like"),{post_id:this.id}).then((function(e){e.data.result&&(t.likes++,t.liked++,1===t.disliked&&(t.dislikes--,t.disliked=0))})).catch((function(e){return t.$store.dispatch("setHttpError",e)}))},onDislike:function(){var t=this;0===this.disliked&&n.a.post("".concat(o["a"],"/api/post/dislike"),{post_id:this.id}).then((function(e){e.data.result&&(t.dislikes++,t.disliked++,1===t.liked&&(t.likes--,t.liked=0))})).catch((function(e){return t.$store.dispatch("setHttpError",e)}))},onSelectTag:function(t){this.$router.push("/tag/".concat(t))}},mounted:function(){this.likes=this.likeCount,this.dislikes=this.dislikeCount}},p=f,m=(i("8256"),i("2877")),v=Object(m["a"])(p,r,s,!1,null,null,null);e["default"]=v.exports},7156:function(t,e,i){var r=i("861d"),s=i("d2bb");t.exports=function(t,e,i){var a,n;return s&&"function"==typeof(a=e.constructor)&&a!==i&&r(n=a.prototype)&&n!==i.prototype&&s(t,n),t}},8256:function(t,e,i){"use strict";var r=i("3e73"),s=i.n(r);s.a},a9e3:function(t,e,i){"use strict";var r=i("83ab"),s=i("da84"),a=i("94ca"),n=i("6eeb"),o=i("5135"),c=i("c6b6"),l=i("7156"),u=i("c04e"),d=i("d039"),f=i("7c73"),p=i("241c").f,m=i("06cf").f,v=i("9bf2").f,k=i("58a8").trim,h="Number",A=s[h],C=A.prototype,N=c(f(C))==h,_=function(t){var e,i,r,s,a,n,o,c,l=u(t,!1);if("string"==typeof l&&l.length>2)if(l=k(l),e=l.charCodeAt(0),43===e||45===e){if(i=l.charCodeAt(2),88===i||120===i)return NaN}else if(48===e){switch(l.charCodeAt(1)){case 66:case 98:r=2,s=49;break;case 79:case 111:r=8,s=55;break;default:return+l}for(a=l.slice(2),n=a.length,o=0;o<n;o++)if(c=a.charCodeAt(o),c<48||c>s)return NaN;return parseInt(a,r)}return+l};if(a(h,!A(" 0o1")||!A("0b1")||A("+0x1"))){for(var g,w=function(t){var e=arguments.length<1?0:t,i=this;return i instanceof w&&(N?d((function(){C.valueOf.call(i)})):c(i)!=h)?l(new A(_(e)),i,w):_(e)},y=r?p(A):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),b=0;y.length>b;b++)o(A,g=y[b])&&!o(w,g)&&v(w,g,m(A,g));w.prototype=C,C.constructor=w,n(s,h,w)}}}]);
//# sourceMappingURL=baseArticle.687f907c.js.map