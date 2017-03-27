<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/jquery.ocupload-1.1.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doAdd(){
		//alert("增加...");
		$('#addWindow').window("open");
	}
	
	function doView(){
		alert("查看...");
	}
	
	function doUploading(){
		$('#button-upload').upload({
			name : 'uploadFile' ,
			action : '${pageContext.request.contextPath}/game_fileUploading.action',
			onComplete : function(response){
				$.messager.alert('Message','successfully！','info');
			}
		});

		$('#grid').datagrid('reload');
	}
	
	function doDelete(){
		
		var array = $('#grid').datagrid('getSelections');
		if(array.length == 0){
			// 一行也没选
			$.messager.alert('warning','You have to check！','warning');
			return ;
		}
		$('#batchDel').submit();
	}
	
	function doRestore(){
		alert("将取派员还原...");
	}
	//工具栏
	var toolbar = [ {
		id : 'button-view',	
		text : '查询',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : '增加',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-delete',
		text : '作废',
		iconCls : 'icon-cancel',
		handler : doDelete
	},{
		id : 'button-save',
		text : '还原',
		iconCls : 'icon-save',
		handler : doRestore
	}];
	// 定义列
	var columns = [ [ {
		title : 'Table Id',
		field : 'uuid',
		width : 150,
		align : 'center'
		
	}, 
	{
		title : 'Dealer Name',
		field : 'dealerName',
		width : 120,
		align : 'center'
		
	}
	] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		
		// 取派员信息表格
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			pageList: [10,20,30],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath}/tabt_processPagination.action",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});
		
		// 添加取派员窗口
		$('#addWindow').window({
	        title: '添加取派员',
	        width: 400,
	        modal: true,
	        shadow: true,
	        closed: true,
	        height: 400,
	        resizable:false
	    });
		
		$('#save').click(function(){
			$('#playerForm').submit();
		});
		
		<%-- We can implement by using EASYUI input
		$.post("${pageContext.request.contextPath}/strategy_listStrategySelection.action",function(data){
			$(data).each(function(index) {
				var option = $("<option value='"+this.strategyName+"'>"+this.strategyName+"</option>")
				$('#strategyListId').append(option);
			});
		});
		--%>
		
		
	});

	function doDblClickRow(rowIndex,rowData){
		$('#playerNameId').val(rowData.playerName);
		$('#initFundId').numberbox('setValue',rowData.initialFund);
		if(rowData.strategies.length>0)
		{
			$('#strategyListId').val(rowData.strategies[0].strategyName);
		}
		
		$('#addWindow').window("open");
	}
	
	function editGameForm(){
		$('#tmpOrSaveId').val("N");
		$('#gameFormId').submit();
	}
	
	function commitForm(){
		$('#tabtFormId').submit();
	}
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<form id="batchDel" action="${pageContext.request.contextPath}/player_batchDeletion.action" method="post">
		<div region="center" border="false">
    		<table id="grid"></table>
		</div>
	</form>
	<div class="easyui-window" title="Table Management" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="height:100px;top:20px;left:200px">
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="tabtFormId" action="${pageContext.request.contextPath}/tabt_saveOrUpdate.action" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">Table Infomation</td>
					</tr>
					<!-- TODO List All the player related info -->
					<tr>
						<td>Dealer Name</td>
						<td><input id="dealerNameId" type="text" class="easyui-validatebox" name="dealerName"  required="true"/></td>
					</tr>
					</table>
			</form>
		</div>
		
		<div region="south" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="javascript:commitForm();" class="easyui-linkbutton" plain="true" >Save</a>
			</div>
		</div>
		
	</div>
</body>
</html>	