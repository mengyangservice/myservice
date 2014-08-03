<%@ page contentType="text/html; charset=utf-8"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script src="./js/jquery-1.9.1.js" type="text/javascript"></script>
  	<link rel="stylesheet" type="text/css" href="./css/style.css">
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
		function buy(goodid){
			
			 //	alert(goodid);
				
					window.location="ordergoods.action?openid=<%=request.getParameter("openid")%>&handleid=oQoPEs02EdLd4i1tuSqzTYE8xAAA&goodid="+goodid;
			} 
		</script>
		  <style type="text/css">
		 
        #filter
        {
        	width:300px;
        	height:auto;
        	margin-left:auto;
        	margin-right:auto;
        	font-size:12px;
        }
        
        #filter dl
        {
        	padding:0;
        	margin-top:0;
        	margin-bottom:0;
        	clear:both;
        	padding:4px 0;        
        }
        
        #filter dt,dd
        {
        	display:block;
        	float:left;
        	width:auto;
        	padding:0;
        	margin:3px 0;        	       	
        }
        
        #filter dt
        {
        	height:14px;
        	padding-bottom:4px;
        	font-weight:bold;
        	color:#333333;        	
        }
        
        #filter dd
        {
        	color:#005AA0;
        	margin-right:8px;
        }
        
        #filter a
        {
        	cursor:pointer;
        }
   
        .seling
        {
            background-color:#005AA0;
        	color:#FFFFFF;
        }
        
        .seled
        {
        	background-color:#005AA0;
        	color:#FFFFFF;
        }
        .img_border {
BORDER-RIGHT: #d8d8d8 1px solid; 
PADDING-RIGHT: 3px; 
BORDER-TOP: #d8d8d8 1px solid; 
PADDING-LEFT: 3px; 

BACKGROUND: #eaeaea; 

PADDING-BOTTOM: 3px; 
BORDER-LEFT: #d8d8d8 1px solid; 
PADDING-TOP: 3px; 
BORDER-BOTTOM: #d8d8d8 1px solid
}
    </style>
  </head>
  <%
  String diatype=  request.getParameter("diatype");
  String figuer=  request.getParameter("figuer");
  String weight=  request.getParameter("weight");
  String clear=  request.getParameter("clear");
  if(diatype==null||diatype.length()<=0)diatype="全部";
  if(figuer==null ||figuer.length()<=0)figuer="全部";
  
  if(weight==null||weight.length()<=0)weight="全部";
  if(clear==null||clear.length()<=0)clear="全部";
  //usedfor= new String(usedfor.getBytes("ISO8859_1"),"utf-8");
  String thepage=  request.getParameter("thepage");
  String thetotal=  request.getParameter("thetotal");
  if(thepage==null)thepage="1";
  if(thetotal==null)thetotal="1";
  //System.out.println(usedfor);
	 %>
 
 <script type="text/javascript">
    $(function () {
        //选中filter下的所有a标签，为其添加hover方法，该方法有两个参数，分别是鼠标移上和移开所执行的函数。
        $("#filter a[name='di']").hover(
            function () {
                $(this).addClass("seling");
            },
            function () {
                $(this).removeClass("seling");
            }
        );
        $("#filter a[name='fi']").hover(
                function () {
                    $(this).addClass("seling");
                },
                function () {
                    $(this).removeClass("seling");
                }
            );
        
        $("#filter a[name='we']").hover(
                function () {
                    $(this).addClass("seling");
                },
                function () {
                    $(this).removeClass("seling");
                }
            );
        
        $("#filter a[name='cl']").hover(
                function () {
                    $(this).addClass("seling");
                },
                function () {
                    $(this).removeClass("seling");
                }
            );
        
        
      var di=""+'<%=diatype%>';
      var fi=""+'<%=figuer%>';
      var we=""+'<%=weight%>';
      var cl=""+'<%=clear%>';
     //  alert(fi);
        $("#filter a[name='di']").each(function () {
        	 
        		//alert(array[i]);
        	    if(di==$(this).html())
        	    	{
        	    	 $(this).attr("class", "seled");
        	    	// array[i]="";
        	    	// break;
        	    	//alert($(this).html());
        	    	 
        	}
          
           
        });
        
        $("#filter a[name='fi']").each(function () {
       	 
    		//alert(array[i]);
    	    if(fi==$(this).html())
    	    	{
    	    	 $(this).attr("class", "seled");
    	    	// array[i]="";
    	    	// break;
    	    	//alert($(this).html());
    	    	 
    	}
      
       
    });
        
        $("#filter a[name='we']").each(function () {
          	 
    		//alert(array[i]);
    	    if(we==$(this).html())
    	    	{
    	    	 $(this).attr("class", "seled");
    	    	// array[i]="";
    	    	// break;
    	    	//alert($(this).html());
    	    	 
    	}
      
       
    });
        
        $("#filter a[name='cl']").each(function () {
          	 
    		//alert(array[i]);
    	    if(cl==$(this).html())
    	    	{
    	    	 $(this).attr("class", "seled");
    	    	// array[i]="";
    	    	// break;
    	    	//alert($(this).html());
    	    	 
    	}
      
       
    });
        $("#diatype").val(di);
       $("#figuer").val(fi);
       $("#weight").val(we);
       $("#clear").val(cl);
        
        //选中filter下所有的dt标签，并且为dt标签后面的第一个dd标签下的a标签添加样式seled。(感叹jquery的强大)
     //   $("#filter dt+dd a").attr("class", "seled"); /*注意：这儿应该是设置(attr)样式，而不是添加样式(addClass)，
                                           //           不然后面通过$("#filter a[class='seled']")访问不到class样式为seled的a标签。*/       

        //为filter下的所有a标签添加单击事件
        $("#filter a[name='di']").click(function () {
            $(this).parents("dl").children("dd").each(function () {
                $(this).children("div").children("a").removeClass("seled");
            });

            $(this).attr("class", "seled");
            diSelecteds();
    
        });
     
        $("#filter a[name='fi']").click(function () {
            $(this).parents("dl").children("dd").each(function () {
                $(this).children("div").children("a").removeClass("seled");
            });

            $(this).attr("class", "seled");
            fiSelecteds();
      
        });
        
        $("#filter a[name='we']").click(function () {
            $(this).parents("dl").children("dd").each(function () {
                $(this).children("div").children("a").removeClass("seled");
            });

            $(this).attr("class", "seled");
            weSelecteds();
      
        });
        
        $("#filter a[name='cl']").click(function () {
            $(this).parents("dl").children("dd").each(function () {
                $(this).children("div").children("a").removeClass("seled");
            });

            $(this).attr("class", "seled");
            clSelecteds();
      
        });
     
       
    });

    
    function weSelecteds() {
        var result = "";
        $("#filter a[class='seled'][name='we']").each(function () {
            result = $(this).html();
          
           
        });
        $("#weight").val(result);
      // alert(result);
        document.getElementById("myform").submit();   
      
    }
    
    function clSelecteds() {
        var result = "";
        $("#filter a[class='seled'][name='cl']").each(function () {
            result = $(this).html();
          
           
        });
        $("#clear").val(result);
       
        document.getElementById("myform").submit();   
      
    }
    function diSelecteds() {
        var result = "";
        $("#filter a[class='seled'][name='di']").each(function () {
            result = $(this).html();
          
           
        });
        $("#diatype").val(result);
       
        document.getElementById("myform").submit();   
      
    }
    function fiSelecteds() {
        var result = "";
        $("#filter a[class='seled'][name='fi']").each(function () {
            result = $(this).html();
          
           
        });
       //  alert("aa"+result);
        $("#figuer").val(result);
       
        document.getElementById("myform").submit();   
      
    }
</script>
 
  <body>
  <div id="filter">
        <dl>
            <dt>类型：</dt>
            <dd><div><a name="di">全部</a></div></dd>
            <dd><div><a name="di">耳饰</a></div></dd>
            <dd><div><a name="di">戒指</a></div></dd>
            <dd><div><a name="di">吊坠</a></div></dd>
           
        </dl>
        <dl>
            <dt>形状：</dt>
           <dd><div><a  name="fi">全部</a></div></dd>
            <dd><div><a  name="fi">圆形</a></div></dd>
            <dd><div><a name="fi">椭圆形</a></div></dd>
            <dd><div><a name="fi">心形</a></div></dd>
            <dd><div><a name="fi">正方形</a></div></dd>
             
       
        <dl>
            <dt>价格：</dt>
             <dd><div><a name="we">全部</a></div></dd>
            <dd><div><a name="we">0-1000</a></div></dd>
            <dd><div><a name="we">1000-2000</a></div></dd>
            <dd><div><a name="we">2000-3000</a></div></dd>
            <dd><div><a name="we">3000-4000</a></div></dd>
            <dd><div><a name="we">4000-5000</a></div></dd>
            <dd><div><a name="we">5000以上</a></div></dd>
            
        </dl>
        <dl>
            <dt>适合性格：</dt>
            <dd><div><a name="cl">全部</a></div></dd>
            <dd><div><a name="cl">高调</a></div></dd>
            <dd><div><a name="cl">抢眼</a></div></dd>
            <dd><div><a name="cl">低调</a></div></dd>
                    
        </dl>
    </div>	
      <form  id="myform" action="stylefilter.action" method="get"> 
      <input name="openid" type="hidden" value="<%=request.getParameter("openid")%>"  />
  <input id="diatype" name="diatype" type="hidden" value="" />
	<input id="figuer" name="figuer" type="hidden" value="" />
	<input id="weight" name="weight" type="hidden" value="" />
	<input id="clear" name="clear" type="hidden" value="" />
	</form>
  
  <%
   
 int total= Integer.parseInt(request.getParameter("total"));
  
  
  for(int j=0;j<total;j++)
	  {%>
  <img src="<%=request.getParameter(j+"pic1")%>" class="img_border" width="300" height="300"/>
  <br>
  	<table>
   <%
 
  for(int i=2;i<255;i=i+2)
  {
	String mypara=  request.getParameter(j+"p"+i);
	String mypara1=  request.getParameter(j+"p"+(i+1));
	if(mypara==null ||mypara1==null )continue;
	mypara =new String(mypara.getBytes("ISO8859_1"),"utf-8");

	mypara1 =new String(mypara1.getBytes("ISO8859_1"),"utf-8");
	%>
	<tr>	<td><span class="merfield"  ><%=mypara%>:</span><%=mypara1%><br></td></tr>
	<% 
  }
   
   
   
   %> 
   
   </table>
   <br>
   
  <div  class="merfield">我要购买: <img src="./img/icon_buy.gif" style="vertical-align:left;cursor:pointer" onclick="buy('<%=request.getParameter(j+"p3")%>')"/></div>	

 
<HR style="float:left;FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
     <%} %>
     
     
     <%
	
	String theurl="stylefilter.action?";
	theurl=theurl+"diatype="+diatype;
	theurl=theurl+"&figuer="+figuer;
	theurl=theurl+"&weight="+weight;
	theurl=theurl+"&clear="+clear;
	 theurl=theurl+"&total="+request.getParameter("total");;
	
	theurl=theurl+"&openid="+request.getParameter("openid");
	String firstpage="&thepage=1";
	String lastpage="&thepage="+(Integer.parseInt(thetotal));
	int intpage=Integer.parseInt(thepage);
	String nextpage="";
	nextpage="&thepage="+(intpage+1);
	String prepage="&thepage="+(intpage-1);
	 
	%>
<div>当前第[<%=thepage%>/<%=thetotal%>]页 [<a target="_self" href="<%=theurl%><%=firstpage%>">首页</a>] [<a target="_self" href="<%=theurl%><%=prepage%>">上一页</a>] [<a target="_self" href="<%=theurl%><%=nextpage%>">下一页</a>] [<a target="_self" href="<%=theurl%><%=lastpage%>">尾页</a>]</div>	
     
     
  </body>
</html>
