<%@ page contentType="text/html; charset=utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="./js/jquery-1.9.1.js" type="text/javascript"></script>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
		function test()
		{
		//var intHot = $("input[name='Fruit']:checked").val();
		//alert(intHot);
			document.getElementById("myform").submit();    
		}
		</script>

</head>
<%
  String diatype=  request.getParameter("diatype");
  String figuer=  request.getParameter("figuer");
  String weight=  request.getParameter("weight");
  String clear=  request.getParameter("clear");
  if(diatype==null)diatype="";
  if(figuer==null)figuer="";
  
  if(weight==null)weight="";
  if(clear==null)clear="";
  //diatype= new String(diatype.getBytes("ISO8859_1"),"utf-8");
 
  //System.out.println(diatype);
	 %>

<body>

	<form id="myform" action="goodfilter.action" method="get">
		<input name="openid" type="hidden"
			value="<%=request.getParameter("openid")%>" /> 宝石类型<br />
		<br /> <label><input name="diatype" type="radio" value="蓝宝石"
			onclick="test();" <%if(diatype.equals("蓝宝石")) {%> checked <%} %> />蓝宝石</label>
		<label><input name="diatype" type="radio" value="尖晶石"
			onclick="test();" <%if(diatype.equals("尖晶石")) {%> checked <%} %> />尖晶石
		</label> <label><input name="diatype" type="radio" value="红宝石"
			onclick="test();" <%if(diatype.equals("红宝石")) {%> checked <%} %> />红宝石
		</label> <label><input name="diatype" type="radio" value="沙弗莱"
			onclick="test();" <%if(diatype.equals("沙弗莱")) {%> checked <%} %> />沙弗莱</label>
		<label><input name="diatype" type="radio" value="祖母绿"
			onclick="test();" <%if(diatype.equals("祖母绿")) {%> checked <%} %> />祖母绿</label>
		<label><input name="diatype" type="radio" value="猫眼石"
			onclick="test();" <%if(diatype.equals("猫眼石")) {%> checked <%} %> />猫眼石</label>
		<label><input name="diatype" type="radio" value="碧玺"
			onclick="test();" <%if(diatype.equals("碧玺")) {%> checked <%} %> />碧玺</label>
		<label><input name="diatype" type="radio" value="尖晶"
			onclick="test();" <%if(diatype.equals("尖晶")) {%> checked <%} %> />尖晶</label>
		<label><input name="diatype" type="radio" value="欧泊"
			onclick="test();" <%if(diatype.equals("欧泊")) {%> checked <%} %> />欧泊</label>
		<label><input name="diatype" type="radio" value="石榴石"
			onclick="test();" <%if(diatype.equals("石榴石")) {%> checked <%} %> />石榴石</label>
		<label><input name="diatype" type="radio" value="锂辉石"
			onclick="test();" <%if(diatype.equals("锂辉石")) {%> checked <%} %> />锂辉石</label>
		<label><input name="diatype" type="radio" value="珍珠"
			onclick="test();" <%if(diatype.equals("珍珠")) {%> checked <%} %> />珍珠</label>


		<label><input name="diatype" type="radio" value=""
			onclick="test();" <%if(diatype.equals("")) {%> checked <%} %> />全部</label> <br />
		形状<br />
		<br /> <label><input name="figuer" type="radio" value="圆形"
			onclick="test();" <%if(figuer.equals("圆形")) {%> checked <%} %> />圆形</label>
		<label><input name="figuer" type="radio" value="椭圆形"
			onclick="test();" <%if(figuer.equals("椭圆形")) {%> checked <%} %> />椭圆形
		</label> <label><input name="figuer" type="radio" value="心形"
			onclick="test();" <%if(figuer.equals("心形")) {%> checked <%} %> />心形 </label>
		<label><input name="figuer" type="radio" value="正方形"
			onclick="test();" <%if(figuer.equals("正方形")) {%> checked <%} %> />正方形</label>
		<label><input name="figuer" type="radio" value=""
			onclick="test();" <%if(figuer.equals("")) {%> checked <%} %> />全部</label> <br />
		重量<br />
		<br /> <label><input name="weight" type="radio" value="1"
			onclick="test();" <%if(weight.equals("1")) {%> checked <%} %> />小于1</label>
		<label><input name="weight" type="radio" value="2"
			onclick="test();" <%if(weight.equals("2")) {%> checked <%} %> />1-2</label> <label><input
			name="weight" type="radio" value="3" onclick="test();"
			<%if(weight.equals("3")) {%> checked <%} %> />2-3 </label> <label><input
			name="weight" type="radio" value="4" onclick="test();"
			<%if(weight.equals("4")) {%> checked <%} %> />3-4</label> <label><input
			name="weight" type="radio" value="5" onclick="test();"
			<%if(weight.equals("5")) {%> checked <%} %> />4-5</label> <label><input
			name="weight" type="radio" value="6" onclick="test();"
			<%if(weight.equals("6")) {%> checked <%} %> />大于5</label> <label><input
			name="weight" type="radio" value="" onclick="test();"
			<%if(weight.equals("")) {%> checked <%} %> />全部</label> <br /> 净度<br />
		<br /> <label><input name="clear" type="radio" value="SI"
			onclick="test();" <%if(clear.equals("SI")) {%> checked <%} %> />SI(微瑕)</label>
		<label><input name="clear" type="radio" value="VS"
			onclick="test();" <%if(clear.equals("VS")) {%> checked <%} %> />VS(极微瑕)</label>
		<label><input name="clear" type="radio" value="VVS"
			onclick="test();" <%if(clear.equals("VVS")) {%> checked <%} %> />VVS(全净无瑕)</label>

		<label><input name="clear" type="radio" value=""
			onclick="test();" <%if(clear.equals("")) {%> checked <%} %> />全部</label>

	</form>

	<%
   
 int total= Integer.parseInt(request.getParameter("total"));
  
  
  for(int j=0;j<total;j++)
	  {%>

	<table>
		<tr>
			<td><img src="<%=request.getParameter(j+"pic1")%>" width="150"
				height="150" /></td>
			<td><img src="<%=request.getParameter(j+"pic2")%>" width="150"
				height="150" /></td>
		</tr>
		<tr>
			<td><img src="<%=request.getParameter(j+"pic3")%>" width="150"
				height="150" /></td>
			<td><img src="<%=request.getParameter(j+"pic4")%>" width="150"
				height="150" /></td>
		</tr>


	</table>

	<br>
	<%
 
  for(int i=0;i<255;i=i+2)
  {
	String mypara=  request.getParameter(j+"p"+i);
	String mypara1=  request.getParameter(j+"p"+(i+1));
	if(mypara==null ||mypara1==null )continue;
	mypara =new String(mypara.getBytes("ISO8859_1"),"utf-8");

	mypara1 =new String(mypara1.getBytes("ISO8859_1"),"utf-8");
	out.print(mypara+":"+mypara1+"<br>");
  }
   
   
   
   %>


	<br>
	<a
		href="ordergoods.action?openid=<%=request.getParameter("openid")%>&handleid=oBKxlty8HYxzSpYautGOMAKY4ock&goodid=<%=request.getParameter(j+"p6")%>">预订该商品</a>

	<%} %>
</body>
</html>
