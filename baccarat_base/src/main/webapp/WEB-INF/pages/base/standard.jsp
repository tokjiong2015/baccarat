<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收排标准</title>
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
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-en.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doAdd(){
		//manually clear
		$('#sn1').val('');
		$('#ifn2').numberbox('setValue',null);
		$('#erpg3').numberbox('setValue',null);
		$('#ccs4').val('');
		$('#ltqpg5').numberbox('setValue',null);
		$('#id').val('');
		//alert("增加...");
		$('#addStandardWindow').window("open");
	}
	
	function doView(){
		alert("查看...");
	}
	
	function doDelete(){
		
		var array = $('#grid').datagrid('getSelections');
		
		if(array.length==0)
		{
			$.messager.alert('warning','plz select','warning');
			return;
		}
		
		$('#delForm').submit();
	}
	//工具栏
	var toolbar = [{
		id : 'button-view',	
		text : 'Look Up',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : 'Add',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-delete',
		text : 'Delete',
		iconCls : 'icon-cancel',
		handler : doDelete
	}];
	// 定义列
	var columns = [ [ 
		{
		field : 'strId',
		checkbox : true ,
	}, {
		field : 'initFund',
		title : 'Init Fund',
		width : 120,
		align : 'center'
	}, {
		field : 'expRevPerGame',
		title : 'Expected Rev Per Game',
		width : 120,
		align : 'center'
	}, {
		field : 'lossToQuitPer',
		title : 'Quit Amt Per Game',
		width : 120,
		align : 'center',
	}, {
		field : 'CC',
		title : 'C-Standard',
		width : 100,
		align : 'center'
	},
	{
		field : 'expRev',
		title : 'Total Expected Rev',
		width : 100,
		align : 'center'
	},
	{
		field : 'updatetime',
		title : '操作时间',
		width : 160,
		align : 'center'
	}
	
	 ] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		
		// 收派标准数据表格
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			pageList: [30,50,100],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath}/strategy_processPagination.action",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});
		
		// 添加收派标准窗口
		$('#addStandardWindow').window({
            title: '添加收派标准',
            width: 400,
            modal: true,
            shadow: true,
            closed: true,
            height: 400,
            resizable:false
        });
		
	});
	
	function doDblClickRow(rowIndex,rowData){
		//form callback
		$('#sn1').val(rowData.strName);
		$('#ifn2').numberbox('setValue',rowData.initFund);
		$('#erpg3').numberbox('setValue',rowData.expRevPerGame);
		$('#ccs4').val(rowData.CC);
		$('#ltqpg5').numberbox('setValue',rowData.lossToQuitPer);
		$('#id').val('edit');
		//pop up the window
		$('#addStandardWindow').window('open');
	}
	
	function commitStandardForm(){
		// 先判断form 是否通过校验，如果通过 ，提交表单  
		var ltqpg = $("#ltqpg5").val();
		var ifn   = $("#ifn2").val();
		var erpg  = $("#erpg3").val();
		
		if(eval(ltqpg-ifn)>0){
			$.messager.alert('Warn','Loss amt should be smaller than init amt','warning');
		}
		if(eval(erpg*2)>ifn){
			$.messager.alert('Warn','You cannot win so much','warning');
		}
		
		if($('#standardForm').form('validate')){// 执行EasyUI 校验方法
			// 通过校验 
			$('#standardForm').submit();
		}else{
			// 没通过校验
			$.messager.alert('警告','表单存在非法数据，请重新输入','warning');
		}
	}
	
		
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
    <form id="delForm" action="${pageContext.request.contextPath}/strategy_delBatch.action" method="post">
    	<div region="center" border="false">
    		<table id="grid"></table>
		</div>
	</form>
	
	<div class="easyui-window" title="Add a Strategy" id="addStandardWindow" collapsible="false" minimizable="false" maximizable="false" style="top:100px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="javascript:commitStandardForm();" class="easyui-linkbutton" plain="true" >SAVE</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="standardForm" action="${pageContext.request.contextPath }/strategy_addStr.action" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">Please Add a Strategy
						<input type="hidden" name="id" id="id" />
						</td>
					</tr>
					<tr>
						<td>Strategy Name</td>
						<td><input id="sn1" name="strName" type="text" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>Initial Fund</td>
						<td><input id="ifn2" name="initFund" type="text" class="easyui-numberbox"  data-options="required:true"/></td>
					</tr>
					<tr>
						<td>Expected Revenue Per Game</td>
						<td><input id="erpg3" name="expRevPerGame" type="text" class="easyui-numberbox" data-options="required:true"/></td>
					</tr>
					<tr>
						<td>CC Strategy</td>
						<td><input id="ccs4"  name="CC" type="text" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>Loss To Quit Per Game</td>
						<td><input id="ltqpg5" name="lossToQuitPer" type="text" class="easyui-numberbox" data-options="required:true"/></td>
					</tr>
					
					</table>
			</form>
		</div>
	</div>
</body>
</html>