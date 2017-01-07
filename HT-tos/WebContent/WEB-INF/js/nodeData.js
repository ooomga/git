/**
 * edgeType: 1-直线连接  2-直角折线  3-倾斜折线 4-？
 * nodeType: 1-小圆点   2-横向圆角矩形  3-纵向圆角矩形 4-叶节点
 */

var line1, line2;
line1 = [
             {'position':{'x':600,'y':100},'name_ch':'清湖','name_en':'qinghu','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'4','index':'0'},
             {'position':{'x':550,'y':150},'name_ch':'龙华','name_en':'longhua','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'1'},
             {'position':{'x':480,'y':200},'name_ch':'龙胜','name_en':'longsheng','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'2'},
             {'position':{'x':450,'y':300},'name_ch':'上塘','name_en':'shangtang','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'3'},
             {'position':{'x':450,'y':400},'name_ch':'红山','name_en':'hongshan','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'4'},
             {'position':{'x':450,'y':500},'name_ch':'深圳北站','name_en':'shenzhenbeizhan','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'5'},
             {'position':{'x':450,'y':600},'name_ch':'白龙山','name_en':'bailongshan','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'6'},
             {'position':{'x':450,'y':700},'name_ch':'民乐','name_en':'minyue','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'7'},
             {'position':{'x':450,'y':800},'name_ch':'上梅林','name_en':'shangmeilin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'8'},
             {'position':{'x':450,'y':850},'name_ch':'莲花北','name_en':'lianhuabei','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'9'},
             {'position':{'x':450,'y':925},'name_ch':'少年宫','name_en':'shaoniangong','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'10'},
             {'position':{'x':450,'y':1000},'name_ch':'市民中心','name_en':'shiminzhongxin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'11'},
             {'position':{'x':450,'y':1100},'name_ch':'会展中心','name_en':'huizhanzhongxin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'12'},
             {'position':{'x':450,'y':1150},'name_ch':'福民','name_en':'fumin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'13'},
             {'position':{'x':450,'y':1200},'name_ch':'福田口岸','name_en':'futiankouan','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'14'}
             ]
line2 = [
             {'position':{'x':150,'y':500},'name_ch':'大学城','name_en':'daxuecheng','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'0'},
             {'position':{'x':250,'y':500},'name_ch':'塘朗','name_en':'tanglang','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'1'},
             {'position':{'x':350,'y':500},'name_ch':'长岭坡','name_en':'changlingpo','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'2'},
             {'position':{'x':450,'y':500},'name_ch':'深圳北站','name_en':'shenzhenbeilu','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'3'},
             {'position':{'x':550,'y':500},'name_ch':'民治','name_en':'minzhi','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'4'},
             {'position':{'x':650,'y':500},'name_ch':'五和','name_en':'wuhe','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'5'},
             {'position':{'x':750,'y':500},'name_ch':'坂田','name_en':'bantian','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'6'},
             {'position':{'x':850,'y':500},'name_ch':'杨美','name_en':'yangmei','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'7'}
             ]
line3 = [
         {'position':{'x':250,'y':1100},'name_ch':'车公庙','name_en':'tanglang','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'1'},
         {'position':{'x':250,'y':1050},'name_ch':'香梅','name_en':'daxuecheng','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'0'},
         {'position':{'x':250,'y':1000},'name_ch':'景田','name_en':'changlingpo','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'2'},
         {'position':{'x':250,'y':850},'name_ch':'梅景','name_en':'shenzhenbeilu','flow':0,'edgeType':'1','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'3'},
         {'position':{'x':350,'y':800},'name_ch':'下梅林','name_en':'minzhi','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'4'},
         {'position':{'x':400,'y':800},'name_ch':'梅村','name_en':'wuhe','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'5'},
         {'position':{'x':450,'y':800},'name_ch':'上梅林','name_en':'shangmeilin','flow':0,'edgeType':'3','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'8'},
         {'position':{'x':540,'y':750},'name_ch':'子陵','name_en':'shangmeilin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'8'},
         {'position':{'x':640,'y':700},'name_ch':'银湖','name_en':'shangmeilin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'8'},
         {'position':{'x':700,'y':700},'name_ch':'泥岗','name_en':'shangmeilin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'8'},
         {'position':{'x':750,'y':800},'name_ch':'杨美','name_en':'yangmei','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'7'}
         ]
line4 = [
         {'position':{'x':60,'y':1000},'name_ch':'安托山','name_en':'tanglang','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'1'},
         {'position':{'x':100,'y':1000},'name_ch':'侨香','name_en':'tanglang','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'1'},
         {'position':{'x':150,'y':1000},'name_ch':'香蜜','name_en':'tanglang','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'1'},
         {'position':{'x':200,'y':1000},'name_ch':'香梅北路','name_en':'daxuecheng','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'0'},
         {'position':{'x':250,'y':1000},'name_ch':'景田','name_en':'changlingpo','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'2'},
         {'position':{'x':350,'y':1000},'name_ch':'莲花西','name_en':'shenzhenbeilu','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'3'},
         {'position':{'x':400,'y':1000},'name_ch':'福田','name_en':'minzhi','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'4'},
         {'position':{'x':450,'y':1000},'name_ch':'市民中心','name_en':'shiminzhongxin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'11'},
         {'position':{'x':500,'y':1000},'name_ch':'岗厦北','name_en':'shangmeilin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'2','index':'8'},
         {'position':{'x':550,'y':1000},'name_ch':'华强北','name_en':'shangmeilin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'8'},
         {'position':{'x':600,'y':1000},'name_ch':'燕南','name_en':'shangmeilin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'8'},
         {'position':{'x':650,'y':1000},'name_ch':'大剧院','name_en':'shangmeilin','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'8'},
         {'position':{'x':700,'y':1000},'name_ch':'湖贝','name_en':'yangmei','flow':0,'edgeType':'0','color':{'up':'#00ebb3','down':'#00ebb3'},'line':'line1','nodeType':'1','index':'7'}
         ]
var map = [ line1, line2,line3 ];




















