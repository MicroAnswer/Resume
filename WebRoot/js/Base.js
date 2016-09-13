// JavaScript Document
//基本Javascript代码集合文件

/*
 *该工具类用于获取页面元素和修改页面元素
 */ 
var tool = function(){
		return new Tool();
	}
function Tool(){
		this.elements = [];
		this.getId=function(id){
			var node = document.getElementById(id);
			this.elements.push(node);
			return this;
			}
		this.getName = function(name){
			var nodes = document.getElementsByName(name);
			for(var i=0;i<nodes.length;i++){
					this.elements.push(nodes[i]);
				}
			return this;
			}
		this.getTag = function(tag){
			var nodes = document.getElementsByTagName(tag);
			for(var i=0;i<nodes.length;i++){
					this.elements.push(nodes[i]);
				}
			return this;
			}
		this.addelement = function(obj){		
			this.elements.push(obj);
			return this;
			}
	}
Tool.prototype.getClass = function(cname){
		var allclassnode = document.getElementsByTagName('*');
		for(var i=0;i<allclassnode.length;i++){
				if(allclassnode[i].className.match(new RegExp('(\\s|^)'+cname+'(\\s|$)'))){
						this.elements.push(allclassnode[i]);
					}
			}
			return this;
	}
Tool.prototype.addClass = function(cname){
		for(var i=0;i<this.elements.length;i++){
				if(!this.elements[i].className.match(new RegExp('(\\s|^)'+cname+'(\\s|$)'))){
					this.elements[i].className += ' '+cname;
					}
			}
		return this;
	}
Tool.prototype.removeClass = function(cname){
		for(var i=0;i<this.elements.length;i++){
				if(this.elements[i].className.match(new RegExp('(\\s|^)'+cname+'(\\s|$)'))){
					this.elements[i].className = this.elements[i].className.replace(new RegExp('(\\s|^)'+cname+'(\\s|$)'),'');
					}
			}
		return this;
	}
Tool.prototype.css = function(attr,value){
		for(var i=0;i<this.elements.length;i++){
				if(arguments.length<2){
					//return this.elements[i].style[attr];
					if(typeof window.getComputedStyle != 'undefined'){//w3c的
							return window.getComputedStyle(this.elements[i],null)[attr]
					}else if( typeof this.elements[i].currentStyle != 'undefined'){//IE的
							return this.elements[i].currentStyle[attr];
					}
				}
				this.elements[i].style[attr] = value;
			}
			return this;
	}
Tool.prototype.html = function(text){
		for(var i=0;i<this.elements.length;i++){
				if(arguments.length<1){
					return this.elements[i].innerHTML;	
				}
				this.elements[i].innerHTML = text;
			}
			return this;
	}
Tool.prototype.onclick = function(function_){
		for(var i=0;i<this.elements.length;i++){
				this.elements[i].onclick = function_;
			}
			return this;
	}
//设置鼠标移入移除方法
Tool.prototype.hover = function(over , out){
	for(var a=0;a<this.elements.length;a++){
			this.elements[a].onmouseover = over;
			this.elements[a].onmouseout = out;
		}
	return this;
	}
//显示元素方法
Tool.prototype.show = function(){
	for(var i=0;i<this.elements.length;i++){
			this.elements[i].style['display'] = 'block';
		}
	return this;
	}
//隐藏元素方法
Tool.prototype.hide = function(){
	for(var i=0;i<this.elements.length;i++){
			this.elements[i].style['display'] = 'none';
		}
	return this;
	}
//使元素居中
Tool.prototype.center = function(width,height){
	var top = (document.documentElement.clientHeight-height)/2;	
	var left = (document.documentElement.clientWidth-width)/2;
		for(var i=0;i<this.elements.length;i++){
				this.elements[i].style.top = top+'px';
				this.elements[i].style.left = left+'px';
			}
			return this;
	}
Tool.prototype.resize = function(function_){
	window.onresize = function_;
	return this;
	}
//锁屏
Tool.prototype.lock = function(){
	for(var i=0;i<this.elements.length;i++){
		if(document.documentElement.clientWidth>=1010)
			this.elements[i].style.width =document.documentElement.clientWidth+0+'px';
		else
			this.elements[i].style.width ='1010px';
		this.elements[i].style.height =document.documentElement.clientHeight+'px';
		this.elements[i].style['display'] = 'block';
		}
		return this;
	}
//解锁屏
Tool.prototype.unlock = function(){
	for(var i=0;i<this.elements.length;i++){
		this.elements[i].style.display = 'none';
		}
		return this;
	}
//使某个组建可以拖动
Tool.prototype.move = function(obj){
	var x=0,y=0,nx=0,ny=0,mx=0,my=0;
	var sx=0,sy=0;
	for(var i=0;i<this.elements.length;i++){
		var t=this.elements[i];
		t.onmousedown = function(e){
			x = e.clientX;
			y = e.clientY;		
		  document.onmousemove = function(e){
			nx = x;
			ny = y;
  		  	x = e.clientX;
			y = e.clientY;
			
			mx=x-nx;
			my=y-ny;
			
			sy=parseInt(tool().addelement(obj).css('top'));
			sx=parseInt(tool().addelement(obj).css('left'));
			
			if(sy>=document.documentElement.clientHeight-280){
				my=0;
				sy -= 1;
				}else if(sy<=10){
					my=0;
				sy += 1;
					}
			if(sx>=document.documentElement.clientWidth-480){
				mx = 0;
				sx-=1;
				}else if(sx<=10){
					mx=0;
				sx += 1;
					}
			sx+=mx;
			sy+=my;
			obj.style.top = sy+'px';
			obj.style.left = sx+'px';
			//alert(mx+","+my);
			};
		   document.onmouseup = function(){
			   document.onmousemove = null;
			   document.onmouseup = null;
			  x=0;
			  y=0;
			  nx=0;
			  ny=0;
			  mx=0;
			  my=0;
			  sx=0;
			  sy=0;
			   //alert(s);
			   };
		    };
		}	
	return this;
	}
/*平移动画，传入移动参数*/
Tool.prototype.Translation = function(value){
	var speed = value['speed'];
	var end = value['end'];
	var towhere = value['towhere']; 
	for(var o=0;o<this.elements.length;o++){
		var element = tool().addelement(this.elements[o]);
		var start = parseInt(element.css(towhere));//起始位置
			distance =(end - start);//起始位置到目标位置的距离
			if(distance< 0 ){//如果距离小于0，那么则应该是向逆向运动，速度为负
					speed*=-1;
				}
		var odistance = distance;
		var timer=setInterval(function(){
				//拿到当前元素在该方向上的值parseInt(element.css(towhere));
				element.css(towhere,start+speed);
				start = Math.abs(parseInt(element.css(towhere)));
			//	distance = Math.abs(end - start);
				//element.html(distance+","+start+","+end+','+speed);
				
				/*已经走到了全程的2/3，开始减速*/
				/*if(distance <= odistance/3){
					speed  = speed - 0.01;
					}*/
				
				if(start >= end){
					element.css(towhere,end);
					element.show();
				//	start = Math.abs(parseInt(element.css(towhere)));
				//	distance = Math.abs(end - start);
					//element.html(distance+","+start+","+end+','+speed);
					clearInterval(timer);
					}
				},20);
		}
	return this;
	};



































































