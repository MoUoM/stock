#!/usr/bin/env python
#coding:utf-8

import  httplib

def getBaidu():
    '''对HTTP发送一个GET请求'''
    http_client=httplib.HTTPConnection('baidu.com',80,timeout=20)
    http_client.request('GET','')
    r=http_client.getresponse()
    print  r.status
    print r.read()

getBaidu()