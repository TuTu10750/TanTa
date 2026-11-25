#!/usr/bin/env python3
# PHASE16 BATCH 04: offline parser/state validation against MOCK data only
# 复刻 03_TANTA_REX_ARCHITECTURE.md 的解析/状态层设计，不连接任何网络
import json, sys

CASES = json.load(open('/var/minis/workspace/PHASE16_REX_INTEGRATION_PREPARATION/MOCK_TEST_CASES.json'))
results = []

def parse_list(resp):
    """返回 (rooms, status) — 容错解析，CLI ENT_EXPECTED_MODEL"""
    if not isinstance(resp, dict):
        return [], 'ERROR_TYPE'
    code = resp.get('code')
    info = resp.get('info')
    if code not in (0, '0'):
        return [], 'ERROR_CODE_%s' % code
    if info is None:
        return [], 'EMPTY_NULL'
    if not isinstance(info, list):
        return [], 'ERROR_TYPE'
    rooms = []
    for item in info:
        if not isinstance(item, dict):
            continue
        rid = item.get('id')
        if rid is None:
            continue
        viewers = item.get('viewers', 0)
        if not isinstance(viewers, (int, float)):
            viewers = 0
        rooms.append({
            'id': str(rid),
            'username': item.get('username') or 'UNKNOWN',
            'title': item.get('title') or 'UNKNOWN',
            'isLive': 1 if item.get('isLive') in (1, '1', True) else 0,
            'viewers': viewers,
            'status': item.get('status') or 'UNKNOWN',
        })
    return rooms, ('OK' if rooms else 'EMPTY')

def parse_detail(resp):
    if not isinstance(resp, dict): return None, 'ERROR_TYPE'
    info = resp.get('info')
    if not isinstance(info, dict): return None, 'ERROR_INFO'
    d = {
        'id': str(info.get('id')) if info.get('id') is not None else 'UNKNOWN',
        'title': info.get('title') or 'UNKNOWN',
        'stream_name': info.get('stream_name') or 'UNKNOWN',
        'status': info.get('status') or 'UNKNOWN',
    }
    return d, 'OK'

def make_lines(rooms, endpoint_configured):
    """loadResource 等价：返回 [{name,url,desc}]"""
    if not endpoint_configured:
        return [{'name': '探他·未配置', 'url': '', 'desc': 'NO_ENDPOINT: 未配置接入地址'}]
    lines = []
    for r in rooms:
        if r['isLive']:
            lines.append({
                'name': '探他·直播 %s' % r['username'],
                'url': 'CONFIGURED_HOST/appapi/Detail/index?id=%s' % r['id'],  # 占位，非真实
                'desc': 'status=%s viewers=%s' % (r['status'], r['viewers'])
            })
    if not lines:
        lines.append({'name': '探他·空', 'url': '', 'desc': '暂无可播线路 (MOCK)'})
    return lines

def check(name, cond, detail):
    results.append((name, 'PASS' if cond else 'FAIL', detail))

# --- 解析测试 ---
rooms, st = parse_list(CASES['MOCK_LIST_NORMAL'])
check('T01 正常列表解析', st=='OK' and len(rooms)==2 and rooms[0]['id']=='1001', 'status=%s rooms=%d' % (st,len(rooms)))
check('T02 在线状态映射', rooms[0]['isLive']==1 and rooms[1]['isLive']==0, 'online=%s offline=%s' % (rooms[0]['isLive'],rooms[1]['isLive']))

rooms2, st2 = parse_list(CASES['MOCK_LIST_EMPTY'])
check('T03 空列表处理', st2=='EMPTY' and len(rooms2)==0, 'status=%s' % st2)

rooms3, st3 = parse_list(CASES['MOCK_LIST_NULL_INFO'])
check('T04 info=null 处理', st3=='EMPTY_NULL' and len(rooms3)==0, 'status=%s' % st3)

rooms4, st4 = parse_list(CASES['MOCK_LIST_MISSING_FIELDS'])
check('T05 缺失字段容错', st4=='OK' and len(rooms4)==2 and rooms4[0]['username']=='UNKNOWN', 'status=%s rooms=%d' % (st4,len(rooms4)))
check('T06 view ers 类型异常归零', len(rooms4)>1 and rooms4[1]['viewers']==0, 'viewers=%s' % (rooms4[1]['viewers'] if len(rooms4)>1 else 'n/a'))
check('T07 无 id 条目跳过', all(r['id']!='UNKNOWN' for r in rooms4), 'ids=%s' % [r['id'] for r in rooms4])

rooms5, st5 = parse_list(CASES['MOCK_LIST_TYPE_ERROR'])
check('T08 类型异常整体处理', st5=='ERROR_TYPE' and len(rooms5)==0, 'status=%s' % st5)

rooms6, st6 = parse_list(CASES['MOCK_ERROR_RESPONSE'])
check('T09 错误码处理', st6=='ERROR_CODE_1001', 'status=%s' % st6)

d, dst = parse_detail(CASES['MOCK_DETAIL_NORMAL'])
check('T10 详情解析', dst=='OK' and d['stream_name']=='mock_stream_1001', 'status=%s' % dst)

# --- 线路/状态层测试 ---
lines = make_lines(rooms, True)
check('T11 线路生成（有 endpoint）', len(lines)==1 and lines[0]['url']!='', 'lines=%d' % len(lines))
lines0 = make_lines(rooms, False)
check('T12 NO_ENDPOINT 状态', lines0[0]['url']=='' and 'NO_ENDPOINT' in lines0[0]['desc'], lines0[0]['desc'])
lines_empty = make_lines([], True)
check('T13 空线路兜底', lines_empty[0]['url']=='' and '暂无' in lines_empty[0]['desc'], lines_empty[0]['desc'])

v = CASES['MOCK_VIDEO_ITEM']
check('T14 视频模型字段只读', all(k in v for k in ('id','title','cover','duration','accessMode','cost')), 'fields ok (MOCK)')

# --- 输出 ---
print('=== MOCK VALIDATION RESULTS ===')
for name, res, detail in results:
    print('%-4s %-28s %s' % (res, name, detail))
passed = sum(1 for _,r,_ in results if r=='PASS')
failed = sum(1 for _,r,_ in results if r=='FAIL')
print('\nTOTAL=%d PASS=%d FAIL=%d' % (len(results), passed, failed))
sys.exit(1 if failed else 0)
