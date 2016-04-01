<%@ page contentType="text/html; charset=utf-8"%>

<%
	String token = (String) session.getAttribute("current.user.token");
	String urlBuf = (String) request.getAttribute("url");
	if (urlBuf == null) {
		urlBuf = "buildSession.action?token=" + token;
	}
	if (!urlBuf.startsWith("/")) {
		urlBuf = "/" + urlBuf;
	}
	urlBuf = request.getContextPath() + urlBuf;
%>

<html>
	<head>
		<TITLE>西安市政府采购</TITLE>
		<script>
		function localComplete(){
			window.location.href = "<%=urlBuf%>";
		}
		</script>
		<SCRIPT language=javascript>
		function showimg()
		{
			imge.filters.alpha.style=2;
			imge.filters.alpha.opacity=1000;
		}
		function hideimg()
		{
			imge.filters.alpha.style=3;
			imge.filters.alpha.opacity=600;
		}
		</script>
	</head>
	<body style="margin: 0; background-color: #5279CE;" scroll="no">
		<table id=lw style="display: block; position: absolute; top: 0; left: 0; z-index: 1; height: ; width: "
			border="0" width="100%" cellspacing="0" cellpadding="0" height="100%">
			<tr>
				<td width="100%" bgcolor="#FFFFFF" align="center" width=100%>
					<img src="resources/login5.jpg" onmousemove="showimg()" onmouseout="hideimg()" name="imge" style="filter: Alpha(opacity = 600, style = 3);">
				</td>
			</tr>
			<tr>
				<td height="10" bgcolor="#3F5FB2">
					<SCRIPT language=jscript>
						elt="0123456789ABCDEF";
						var	sTBHTMLS="";
						var	sTBHTMLE="";
						for(var	i=0;i<0xFF-0x99;i+=1){
							var	cr="";
							var	l;
							var	sTBHTML="";
							l=i+0x99;
							for(var j=0;j<2;j++){
								var	n=l % 16;
								l=l >> 4;
								cr=elt.charAt(n)+cr;
							}
							l=i+0x33;
							for(var j=0;j<2;j++){
								var	n=l % 16;
								l=l >> 4;
								cr=elt.charAt(n)+cr;
							}
							l=i;
							for(var j=0;j<2;j++){
								var	n=l % 16;
								l=l >> 4;
								cr=elt.charAt(n)+cr;
							}
							var	w=i>(0xFF-0xA0)?8:4
							sTBHTML="<span style='height:10;width:"+w+";background-color:#"+cr+";margin:0;padding:0'></span>";
							sTBHTMLS+=sTBHTML;
							sTBHTMLE=sTBHTML+sTBHTMLE;
						}
						var	sTBHTML=sTBHTMLS+sTBHTMLE;
						document.write("<marquee id='loading' scrollamount='30' direction='right' scrolldelay='1' height='4' style='width:100%;height:10; font-size:6px;background-color:#003399'>");
						document.write(sTBHTML);
						document.write("</marquee>");
					</SCRIPT>
				</td>
			</tr>
			<tr>
				<td>
					<div style="position: absolute; top: 86%; left: 45%; font-size: 10pt; color: red" id="abc">
						正在登陆,请您稍候..........
					</div>
				</td>
			</tr>
			<tr>
				<td width="100%" height="20%" bgcolor="#ECF0FF">
					<div style="position: absolute; width: 450; left: 35%; height: 14; border: 1 #707888 solid; overflow: hidden">
						<div style="position: absolute; top: -1; left: 1" id="pimg">
						</div>
					</div>
				</td>
			</tr>
			<script>
				s=new Array();
				s[0]="#000066";
				s[1]="#0a0b44";
				s[2]="#0f1165";
				s[3]="#1a1d95";
				s[4]="#1c1fa7";
				s[5]="#1c20c8";
				s[6]="#060cff";
				s[7]="#2963f8";
				function ls(){
					pimg.innerHTML="";
					for(i=0;i<9;i++){
					pimg.innerHTML+="<input style=\"width:15;height:10;border:0;background:"+s[i]+";margin:1\">";
					}
				}
				function rs(){
					pimg.innerHTML="";
					for(i=9;i>-1;i--){
					pimg.innerHTML+="<input style=\"width:15;height:10;border:0;background:"+s[i]+";margin:1\">";
					}
				}
				ls();
				var g=0;sped=0;
				function str(){
					if(pimg.style.pixelLeft<280&&g==0){
					if(sped==0){
						ls();
						sped=1;
						}
					pimg.style.pixelLeft+=2;
					setTimeout("str()",1);
					return;
					}
					g=1;
					if(pimg.style.pixelLeft>1&&g==1){
					if(sped==1){
						rs();
						sped=0;
						}
					pimg.style.pixelLeft-=2;
					setTimeout("str()",1);
					return;
					}
					g=0;
					str();
				}
				
				function flashs(){
				if(abc.style.color=="red"){
					abc.style.color="#009900";
					setTimeout('flashs()',800);
				}
				else{
					abc.style.color="red";
					setTimeout('flashs()',500);
					}
				}
				flashs();
				str();
			</script>
			<iframe id="localResourceFrame" name="localResourceFrame" width="200px" height="100" style="display: none;" src="/DB/jsp/DB/downzip.jsp?token=<%=token%>">
			</iframe>
		</table>
	</body>
</html>
