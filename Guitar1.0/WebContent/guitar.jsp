
<%@ page  import="com.guitar.model.*,java.util.*"  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link
	href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
	<link href="bower_components/bootstrap.min.js"
	rel="stylesheet">
	
</head>


<body>

<%									//?????????????
     WebService webService = (WebService) getServletContext().getAttribute("webService");
     Guitar blah = new Guitar();
     List<Guitar> blahs = webService.getGuitars(blah);

     HttpServletRequest req = (HttpServletRequest) request; 
     
    // request.setCharacterEncoding("UTF-8"); 
  //   response.setContentType("text/html;charset=UTF-8");
   //  String con=(String)request.getAttribute("type");
	 %> 

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
		
		<h3 class="text-center">
				吉他销售系统
			</h3>
		</div>
	</div>
	<!-- <div class="row-fluid">
		<div class="span12">
			<form class="form-search">
				<input class="input-medium search-query" type="text" /> <button type="submit" class="btn">查找</button>
			</form>
		</div>
	</div> -->
	<div class="row-fluid">
		<div class="span4">
		
		<form  action="SearchGuitar" method="get">
				<fieldset>
					 <legend>吉他分类</legend> 
					 
				<!--  	 <label>序列号</label><input type="text"  /> -->	
					  <label>类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text"  name="type"  value="<%=request.getAttribute("type") %>"/>
					 <label>制造商&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="builder" value="<%=request.getAttribute("builder") %>"/>
					  <label>尺寸&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="model" value="<%=request.getAttribute("model") %>"/>
 			
					 <br>
	 		 
		<!--  <label>价格&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="price"/> -->	
					 
					 <label>背面材质</label><input type="text" name="backwood"value="<%=request.getAttribute("backwood") %>"/>
					  <label>梢头材质</label><input type="text" name="topwood" value="<%=request.getAttribute("topwood") %>"/>
					  <br>
			            <button type="submit" class="btn">搜索</button>
				</fieldset>
			</form>
		</div>
		<div class="span4">
		</div>
		<div class="span4">
		</div>
	</div>
	
	 <div class="row-fluid">
		<div class="span12">
		
		 <c:forEach var="bh" items="${requestScope.manages}">
		
		<table class="table">
				<thead>
					<tr>
						<th>
							序列号
						</th>
						<th>
							类型
						</th>
						<th>
							制造商
						</th>
						<th>
						   尺寸
						</th>
						
					    <th>
						 价格
						</th>
						<th>
							背面材质
						</th>	
					<th>
							梢头材质
						</th>		
						
					</tr>
				</thead>
				<tbody>
			<%-- 	<%
				List<Guitar> guitarInventory=(List)request.getAttribute("manages");
			//	for (Iterator<Guitar> i = guitarInventory.iterator();i.hasNext(); ) { 
			 //		Guitar bh =(Guitar) i.next();
			 
			 for (int i = 0; i < guitarInventory.size(); i++) { 
			 		Guitar bh = blahs.get(i);
				        %> --%>
					<tr>
					<td>
							<input type="text" name="SerialNumble" value="${bh.serialNumble}"/>
						</td>
						<td>
							<input type="text" name="Type" value="${bh.type }"/>
						</td>
						<td>
							<input type="text" name="Builder" value="${bh.builder}"/>
						</td>
						<td>
							<input type="text" name="Model" value="${bh.model}"/>
						</td>
						
						<td>
							<input type="text" name="Price" value="${bh.price}"/>
						</td>
						
						
					
						<td>
							<input type="text" name="backwood" value="${bh.backWood}"/>
						</td>
						
					<td>
							<input type="text" name="TopWood(" value="${bh.topWood}"/>
						</td>
						
					</tr>
					
		
					
						<%-- <% }
			 %>					 --%>	
					<tr class="error">
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
					<tr class="warning">
						<td>
						
						</td>
						<td>
							
						</td>
						<td>
						
						</td>
						<td>
						
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
					<tr class="info">
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
				</tbody>
			</table>
			
	
	 <!-- <div class="pagination">
				<ul>
					<li>
						<a href="#">上一页</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">下一页</a>
					</li>
				</ul>
			</div> -->
</c:forEach>
		
		</div>
	</div>
</div>
	
</body>
</html>