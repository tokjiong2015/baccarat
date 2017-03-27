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

	
	function doDelete(){
		
		var array = $('#grid').datagrid('getSelections');
		if(array.length == 0){
			// 一行也没选
			$.messager.alert('warning','You have to check！','warning');
			return ;
		}
		$('#batchDel').submit();
	}
	
	function doSearch(){
		$('#searchGameWindowId').window("open");
	}
	
	function doExport(){
		location.href="${pageContext.request.contextPath}/game_exportXls.action";
	}
	
	function doRestore(){
		alert("将取派员还原...");
	}
	//工具栏
	var toolbar = [ {
		id : 'button-search',	
		text : 'search',
		iconCls : 'icon-search',
		handler : doSearch
	},{
		id : 'button-delete',
		text : 'delete',
		iconCls : 'icon-cancel',
		handler : doDelete
	},{
		id : 'button-save',
		text : 'save',
		iconCls : 'icon-save',
		handler : doRestore
	},{
		id : 'button-download',
		text : 'download',
		iconCls : 'icon-print',
		handler : doExport
	}];

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
			pageList: [5,10,15],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath}/game_processPagination.action",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});
		
		// 添加取派员窗口
		$('#searchGameWindowId').window({
	        title: 'muti conditions',
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
		$('#isMutiConditionId').val("Y");
		var param = $('#gameSearchFormId').serializeJson();
		$('#grid').datagrid('load',param);
		$('#searchGameWindowId').window("close");
	}
	
	$.fn.serializeJson=function(){  
	    var serializeObj={};  // 目标对象 
	    var array=this.serializeArray(); 
	    $(array).each(function(){
	        if(serializeObj[this.name]){
	            if($.isArray(serializeObj[this.name])){
	                serializeObj[this.name].push(this.value);
	            }else{
	                serializeObj[this.name]=[serializeObj[this.name],this.value];
	            }  
	        }else{  
	            serializeObj[this.name]=this.value;
	        }  
	    });  
	    return serializeObj;  
	}; 
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<form id="batchDel" action="${pageContext.request.contextPath}/player_batchDeletion.action" method="post">
		<div region="center" border="false">
    		<table id="grid"></table>
		</div>
	</form>
	<div class="easyui-window" title="Mutiple Conditions Search" id="searchGameWindowId" collapsible="false" minimizable="false" maximizable="false" style="height:300px;top:30px;left:200px">
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="gameSearchFormId" action="${pageContext.request.contextPath}/game_processPagination.action" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">Game Info</td>
					</tr>

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
						<td>Dealer Name</td>
						<td><input id="dealerNameId" type="text" class="easyui-validatebox" name="tabt.dealerName"  required="true"/></td>
					</tr>
					
					<tr>
					<td><input id="isMutiConditionId" type="hidden" name="isMutiCondition"/></td>
					</tr>
					
					</table>
			</form>
		</div>
		
		<div region="south" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-search" href="javascript:commitGameForm();" class="easyui-linkbutton" plain="true" >Search</a>
			</div>
		</div>
		
	</div>
</body>
</html>	