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
		$('#addStaffWindow').window("open");
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
		id : 'button-upload',
		text : 'upload',
		iconCls : 'icon-tip',
		handler : doUploading
	},{
		id : 'button-save',
		text : '还原',
		iconCls : 'icon-save',
		handler : doRestore
	}];
	// 定义列
	var columns = [ [ 
		{
			title : 'Game Set',
			field : 'gameKey.gameSet',
			width : 60,
			align : 'center',
			formatter:function(value,rowData,rowIndex){
				if(rowData.gameKey!=null){
					return rowData.gameKey.gameSet;
				}
			}
			
		},{
		title : 'Game No.',
		field : 'gameKey.gameNo',
		width : 60,
		align : 'center',
		formatter:function(value,rowData,rowIndex){
			if(rowData.gameKey!=null){
				return rowData.gameKey.gameNo;
			}
		}
		
	},  
	{
		title : 'Player Amount',
		field : 'pamt',
		width : 120,
		align : 'center'
		
	}, 
	{
		title : 'Result Desc',
		field : 'resultDesc',
		width : 120,
		align : 'center'
		
	}, 
	{
		title : 'Revenue (Dealer)',
		field : 'revenueDealer',
		width : 120,
		align : 'center'
		
	}, 
	{
		field : 'totIn',
		title : 'Total In (Dealer)',
		width : 120,
		align : 'center',
		formatter:function(value,rowData,rowIndex){
			return rowData.playerName;
		}
	},
	{
		field : 'totOut',
		title : 'Total Out (Dealer)',
		width : 120,
		align : 'center'
	}, {
		title : 'Revenue (Player)',
		field : 'revenuePlayer',
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
			url : "${pageContext.request.contextPath}/game_processPagination.action",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});
		
		// 添加取派员窗口
		$('#addStaffWindow').window({
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
		
		$.post("${pageContext.request.contextPath}/strategy_listStrategySelection.action",function(data){
			$(data).each(function(index) {
				var option = $("<option value='"+this.strategyName+"'>"+this.strategyName+"</option>")
				$('#strategyListId').append(option);
			});
		});
		
		
		
	});

	function doDblClickRow(rowIndex,rowData){
		$('#playerNameId').val(rowData.playerName);
		$('#initFundId').numberbox('setValue',rowData.initialFund);
		if(rowData.strategies.length>0)
		{
			$('#strategyListId').val(rowData.strategies[0].strategyName);
		}
		
		$('#addStaffWindow').window("open");
	}
	
	function editGameForm(){
		$('#tmpOrSaveId').val("N");
		$('#gameFormId').submit();
	}
	
	function commitGameForm(){
		$('#tmpOrSaveId').val("Y");
		$('#gameFormId').submit();
	}
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<form id="batchDel" action="${pageContext.request.contextPath}/player_batchDeletion.action" method="post">
		<div region="center" border="false">
    		<table id="grid"></table>
		</div>
	</form>
	<div class="easyui-window" title="对收派员进行添加或者修改" id="addStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="height:100px;top:20px;left:200px">

		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="gameFormId" action="${pageContext.request.contextPath}/game_saveOrUpdate.action" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">Game Info</td>
					</tr>
					<!-- TODO List All the player related info -->
					<tr><td>
					<input class="easyui-combobox" name="tabt.uuid"  data-options="
         		    url:'${pageContext.request.contextPath}/game_getTabtList.action',
           		    valueField:'uuid',
         		    textField:'uuid',
           		    panelHeight:'auto',
            		">
					</td></tr>

					<tr>
						<td>Pools - Player</td>
						<td><input id="poolsPlayerId" type="text" class="easyui-numberbox" name="pamt"  required="true"/></td>
					</tr>
					<tr>
						<td>Pools - Banker</td>
						<td><input id="poolsBankerId" type="text" class="easyui-numberbox" name="bamt"  required="true"/></td>
					</tr>
					<tr>
						<td>Pools - Tie</td>
						<td><input id="poolsTieId" type="text" class="easyui-numberbox" name="tamt"  required="true"/></td>
					</tr>
					
					<tr>
						<td>Card 1</td>
						<td><input id="card1Id" type="text" name="card1" class="easyui-validatebox" required="true"/></td>
					</tr>
					
					<tr>
						<td>Card 2</td>
						<td><input id="card2Id" type="text" name="card2" class="easyui-validatebox" required="true"/></td>
					</tr>
					
					<tr>
						<td>Card 3</td>
						<td><input id="card3Id" type="text" name="card3" class="easyui-validatebox" required="true"/></td>
					</tr>
					
					<tr>
						<td>Card 4</td>
						<td><input id="card4Id" type="text" name="card4" class="easyui-validatebox" required="true"/></td>
					</tr>
					
					<tr>
						<td>Card 5</td>
						<td><input id="card5Id" type="text" name="card5" class="easyui-validatebox"/></td>
					</tr>
					
					<tr>
						<td>Card 6</td>
						<td><input id="card6Id" type="text" name="card6" class="easyui-validatebox"/></td>
					</tr>
					
						<td><input id="tmpOrSaveId" type="hidden" name="tmpOrSave"/></td>
					
				<!-- 
					<tr>
						<td>
							<select id="strategyListId" name="strategies[0].strategyName">
						
							</select>
						</td>
					</tr>
				 -->	
					</table>
			</form>
		</div>
		
		<div region="south" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-edit" href="javascript:editGameForm();" class="easyui-linkbutton" plain="true" >Update</a>
				<a id="save" icon="icon-save" href="javascript:commitGameForm();" class="easyui-linkbutton" plain="true" >Save</a>
			</div>
		</div>
		
	</div>
</body>
</html>	