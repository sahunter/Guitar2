
<%@ page  import="com.guitar.model.*,java.util.List"  language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
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
     //List<Guitar> guitarInventory=(List)request.getAttribute("manages");
    request.setCharacterEncoding("UTF-8"); 
     
    
    
    
	 %> 

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
		
		<h3 class="text-center">
				��������ϵͳ
			</h3>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<form class="form-search">
				<input class="input-medium search-query" type="text" /> <button type="submit" class="btn">����</button>
			</form>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
		
		<form  action="DeleteGuitar" method="get">
				<fieldset>
					 <legend>��������</legend> 
					 
				<!--  	 <label>���к�</label><input type="text"  /> -->	
					 
					 <label>������&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text"name="serialNumble" />
					  <button type="submit" class="btn">����</button>
					  <label>�ߴ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="model"/>
					 
					 <label>����</label><input type="text" name="type"/>
					 <br>
					 
					 
		<!--  <label>�۸�&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="price"/> -->	
					 
					 <label>�������</label><input type="text" name="backwood"value="<% request.getAttribute("manages"); %>"/>
					  <label>��ͷ����</label><input type="text" name="topwood"/>
					  <br>
			           
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
		
		
		
	<!--	<table class="table">
				<thead>
					<tr>
						<th>
							���к�
						</th>
						<th>
							������
						</th>
						<th>
						   �ߴ�
						</th>
						<th>
							����
						</th>
					    <th>
						 �۸�
						</th>
						<th>
							�������
						</th>	
					<th>
							��ͷ����
						</th>		
						
					</tr>
				</thead>
				<tbody>
				
				-->	<tr class="error">
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
					</tr>
				</tbody>
			</table>
			<div class="pagination">
				<ul>
					<li>
						<a href="#">��һҳ</a>
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
						<a href="#">��һҳ</a>
					</li>
				</ul>
			</div>
<table class="table">
				<thead>
					<tr>
						<th>
							���к�
						</th>
						<th>
							������
						</th>
						<th>
						   �ߴ�
						</th>
						<th>
							����
						</th>
					    <th>
						 �۸�
						</th>
						<th>
							�������
						</th>	
					<th>
							��ͷ����
						</th>		
						
					</tr>
				</thead>
				<tbody>
				<%
				for (int i = 0; i < blahs.size(); i++) { 
			 		Guitar bh = blahs.get(i);
			 %>
				 
					<tr>
					<td>
							<input type="text" name="SerialNumble" value="<%=bh.getSerialNumble() %>"/>
						</td>
						<td>
							<input type="text" name="Type" value="<%=bh.getType() %>"/>
						</td>
						<td>
							<input type="text" name="Builder" value="<%=bh.getBuilder() %>"/>
						</td>
						<td>
							<input type="text" name="Model" value="<%=bh.getModel() %>"/>
						</td>
						
						<td>
							<input type="text" name="Price" value="<%=bh.getPrice() %>"/>
						</td>
						
						
					
						<td>
							<input type="text" name="backwood" value="<%=bh.getBackWood() %>"/>
						</td>
						
					<td>
							<input type="text" name="TopWood(" value="<%=bh.getTopWood() %>"/>
						</td>
						
					</tr>
					
						<% }
			 %>						
					<tr class="error">
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
					</tr>
				</tbody>
			</table>
			<div class="pagination">
				<ul>
					<li>
						<a href="#">��һҳ</a>
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
						<a href="#">��һҳ</a>
					</li>
				</ul>
			</div>

		
		
		</div>
	</div>
</div>
</body>
</html>