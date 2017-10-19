// JavaScript Document
mydtree = new dTree('mydtree', '/static/jQuerySelectTree/images/', 'no', 'no');
mydtree.add(0, -1, "根目录", "javascript:setvalue('0','根目录')", "根目录", "_self", false);
mydtree.add(37, 0, 'PDA消息管理', "javascript:setvalue('37','PDA消息管理')", 'PDA消息管理', '_self', false);
mydtree.add(40, 0, '法律法规管理', "javascript:setvalue('40','法律法规管理')", '法律法规管理', '_self', false);
document.write(mydtree);