/**
 * 选项卡的右键菜单
 */
$(function(){
	var p = $('#tabs').tabs().tabs('tabs')[0]; // 获取指定索引的选项卡
	var mb = p.panel('options').tab.find('a.tabs-inner'); // 查找选项卡的内部tabs-inner样式的a标签
	mb.menubutton({ // 给选项卡添加右键菜单，tab-menu，单独的一个div
		menu:'#tab-menu',
		iconCls:'icon-help'
	}).click(function(){
		$('#tabs').tabs('select',0); // 当前选项卡设置为选中状态
	});
	//*************************
	//以下鼠标经过的方法只能适用于直接在tabs页中固定的选项卡
	// 选项卡的鼠标经过事件，一旦鼠标经过，则选中此选项卡
	var tabs = $('#tabs').tabs().tabs('tabs');
	for(var i=0; i<tabs.length; i++){
		// 给每一个选项卡绑定mouseenter事件
		tabs[i].panel('options').tab.unbind().bind('mouseenter',{index:i},function(e){
			$('#tabs').tabs('select', e.data.index); // 选中鼠标进入的选项卡
		});
	}
	
});