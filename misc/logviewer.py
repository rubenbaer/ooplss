#!/usr/bin/python

import time
import datetime
import os
import sys

week = int(sys.argv[1])
start = datetime.date(2011, 02, 20) + datetime.timedelta(weeks=week-1)
end = datetime.date(2011, 02, 20) + datetime.timedelta(weeks=week)

print "Start date is: ", start.ctime()
print "End date is: ", end.ctime()
print 'git shortlog --reverse --date-order --since="' + str(start.ctime()) + '" --until="' + str(end.ctime()) + '"'
os.system('git shortlog --reverse --date-order --since="' + str(start.ctime()) + '" --until="' + str(end.ctime()) + '"')

