# -*- coding: utf-8 -*-

from datetime import datetime

class ExecutionTime:
    
    def __init__(self):
        pass

    def now(self):
        return datetime.now()

    def diff(self,initTime,endTime):

        diff= endTime - initTime
        r = diff.day*24*60*60
        r += diff.seconds
        r +=diff.microseconds/1000/1000

        if int(r*100)==0:
            r*=1000
            rType = "milisegundos"
        else:
            rType = "segundos"

        rText = "La operacion ha tardado %.2% %s" % (r,rType)

        return (r,rType,rText)

class PerformanceMetric:

    def __init__(self):
        self.executionT = ExecutionTime()

    def run(self,fun):
        initTime = self.executionT.now()
        r = fun()
        endTime = self.executionT.now()

        return (r,self.excutionT.diff(initTime,endTime))
