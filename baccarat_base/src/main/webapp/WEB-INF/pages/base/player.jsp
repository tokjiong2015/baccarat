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
<script type="text/javascript">
	function doAdd(){
		//alert("增加...");
		$('#addStaffWindow').window("open");
	}
	
	function doView(){
		alert("查看...");
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
		title : 'id',
		field : 'playerName',
		checkbox : true,
		width : 120
		
	}, 
	{
		field : 'p',
		title : 'Player\'s Name',
		width : 100,
		align : 'center',
		formatter:function(value,rowData,rowIndex){
			return rowData.playerName;
		}
	},
	{
		field : 'currFund',
		title : 'Current Fund',
		width : 120,
		align : 'center'
	}, {
		field : 'initialFund',
		title : 'Initial Fund',
		width : 120,
		align : 'center',
	}, {
		field : 'strategyTendency',
		title : 'Strategy Tendency',
		width : 120,
		align : 'center',
	}, {
		field : 'strategyTendencyDesc',
		title : 'Strategy Tendency Desc',
		width : 150,
		align : 'center',
	}, {
		field : 'totalGame',
		title : 'Total Played Games',
		width : 150,
		align : 'center',
	}, {
		field : 'totalWin',
		title : 'Total Win',
		width : 150,
		align : 'center',
	}, {
		field : 'totalLose',
		title : 'Total Lose',
		width : 150,
		align : 'center',
	}, {
		field : 'totalTie',
		title : 'Total Tie',
		width : 150,
		align : 'center',
	}, {
		field : 'uspf.userName',
		title : 'User Profile Name',
		width : 150,
		align : 'center',
		formatter:function(value,rowData,rowIndex){
			if(rowData.uspf!=null){
				return rowData.uspf.userName;
			}
		}
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
			url : "${pageContext.request.contextPath}/player_processPagination.action",
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
		
		$('#lbbyListId').on('change',function(){
			var currGetSelected = $('#lbbyListId').find(":selected").val();
			$.post("${pageContext.request.contextPath}/tabt_listTabtSelection.action",currGetSelected,function(data){
				$(data).each(function(index) {
					var option = $("<option value='"+this.tabtUuid+"'>"+this.tabtUuid+" "+this.tabtName+"</option>")
					$('#tabtListId').append(option);
				});
			});
			
		});
		
		$.post("${pageContext.request.contextPath}/lbby_listLbbySelection.action",function(data){
			var optionBlank = $("<option value= > </option>")
			$('#lbbyListId').append(optionBlank);
			$(data).each(function(index) {
				var option = $("<option value='"+this.lbbyUuid+"'>"+this.lbbyUuid+" "+this.casinoName+"</option>")
				$('#lbbyListId').append(option);
			});
		});
		
		$.post("${pageContext.request.contextPath}/strategy_listStrategySelection.action",function(data){
			$(data).each(function(index) {
				var option = $(" <tr><td><input type= checkbox  name= '"+this.strategyName+"' value= '"+this.strategyName+"'></td>" +"<td>"+this.strategyName+" "+this.strategyDesc+"</td>"+"</tr>")
				$('#test').append(option);
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
	
	function commitPlayerForm(){
		$('#playerForm').submit();
	}

</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<form id="batchDel" action="${pageContext.request.contextPath}/player_batchDeletion.action" method="post">
		<div region="center" border="false">
    		<table id="grid"></table>
		</div>
	</form>
	<div class="easyui-window" title="对收派员进行添加或者修改" id="addStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="javascript:commitPlayerForm();" class="easyui-linkbutton" plain="true" >Save</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="playerForm" action="${pageContext.request.contextPath}/player_saveOrUpdate.action" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">Player Info</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<tr>
						<td>Player Name</td>
						<td><input id="playerNameId" type="text" name="playerName" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>Initial Fund</td>
						<td><input id="initFundId" type="text" class="easyui-numberbox" name="initialFund"  required="true"/></td>
					</tr>
					<tr>
						<td>Select your lobby</td>
						<td>
							<select id="lbbyListId" name="lbbys[0].uuid">
							</select>
						</td>
					</tr>
					<tr>
						<td>Table to access</td>
						<td>
							<select id="tabtListId" name="lbbys[0].tabts[0].tabtUuid">
							</select>
						</td>
					</tr>
					
					</table>
					
					<table id="test" class="table-edit" width="80%" align="center">
					
					</table>
					
			</form>
		</div>
	</div>
</body>
</html>	