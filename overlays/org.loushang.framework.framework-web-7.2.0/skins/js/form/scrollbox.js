!function(a,b){'object'==typeof exports?module.exports=b(a,require('jquery')):'function'==typeof define&&define.amd?define(['jquery'],function(c){return b(a,c)}):b(a,a.jQuery)}(this,function(a,b,c){b.fn.scrollbox=function(a){var c={linear:!1,startDelay:2,delay:3,step:5,speed:32,switchItems:1,direction:'vertical',distance:'auto',autoPlay:!0,onMouseOverPause:!0,paused:!1,queue:null};return a=b.extend(c,a),a.scrollOffset='vertical'===a.direction?'scrollTop':'scrollLeft',a.queue&&(a.queue=b('#'+a.queue)),this.each(function(){var c,d,e,f,g,h,i=b(this),j=null,k=null,l=!1;a.onMouseOverPause&&(i.bind('mouseover',function(){l=!0}),i.bind('mouseout',function(){l=!1})),c=i.children('ul:first-child'),g=function(){if(!l){var b,d,f,g,h;if(b=c.children('li:first-child'),g='auto'!==a.distance?a.distance:'vertical'===a.direction?b.height():b.width(),a.linear?f=Math.min(i[0][a.scrollOffset]+a.step,g):(h=Math.max(3,parseInt(.3*(g-i[0][a.scrollOffset]),10)),f=Math.min(i[0][a.scrollOffset]+h,g)),i[0][a.scrollOffset]=f,f>=g){for(d=0;d<a.switchItems;d++)a.queue&&a.queue.hasChildNodes()&&a.queue.getElementsByTagName('li').length>0?(c.append(a.queue.getElementsByTagName('li')[0]),c.remove(c.children('li:first-child'))):c.append(c.children('li:first-child'));i[0][a.scrollOffset]=0,clearInterval(j),a.autoPlay&&(k=setTimeout(e,1e3*a.delay))}}},h=function(){if(!l){var b,d,f,g,h,m;if(0===i[0][a.scrollOffset]){for(f=c.children('li').length,d=0;d<a.switchItems;d++)c.children('li:last-child').insertBefore(c.children('li:first-child'));b=i.children('li:first-child'),h='auto'!==a.distance?a.distance:'vertical'===a.direction?b.height():b.width(),i[0][a.scrollOffset]=h}a.linear?g=Math.max(i[0][a.scrollOffset]-a.step,0):(m=Math.max(3,parseInt(.3*i[0][a.scrollOffset],10)),g=Math.max(i[0][a.scrollOffset]-m,0)),i[0][a.scrollOffset]=g,0===g&&(clearInterval(j),a.autoPlay&&(k=setTimeout(e,1e3*a.delay)))}},e=function(){clearInterval(j),j=setInterval(g,a.speed)},d=function(){clearInterval(j),j=setInterval(h,a.speed)},f=function(b){a.delay=b||a.delay,clearTimeout(k),a.autoPlay&&(k=setTimeout(e,1e3*a.delay))},a.autoPlay&&(k=setTimeout(e,1e3*a.startDelay)),i.bind('resetClock',function(a){f(a)}),i.bind('forward',function(){clearTimeout(k),e()}),i.bind('backward',function(){clearTimeout(k),d()}),i.bind('speedUp',function(b){'undefined'==typeof b&&(b=Math.max(1,parseInt(a.speed/2,10))),a.speed=b}),i.bind('speedDown',function(b){'undefined'==typeof b&&(b=2*a.speed),a.speed=b})})}});