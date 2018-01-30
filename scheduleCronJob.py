'''
packages required:
pip3 install python-crontab
pip3 install schedule

If you have also installed crontab package then you may see some errors, to uninstall crontab
use following command:
pip3 uninstall crontab

http://webdesignpluscode.blogspot.com/2018/01/how-to-schedule-cron-job-using-python.html
'''
import schedule, sys
from crontab import CronTab
        
def ScheduleNewCronJob(timeSlot):
    
    try:        
        cron = CronTab(user=True)
        # Remove all previous jobs having comment id 'My_Job' 
        cron.remove_all(comment='My_Job')
        # Schedule new job having comment id 'My_Job'
        job  = cron.new(comment='My_Job', command='/usr/bin/python3 /home/root/Schedular/scheduleCronJob.py >> /home/root/Schedular/Logs.txt')
        job.setall(str(timeSlot))        
        cron.write()        
        print("New job scheduled at: ", timeSlot)
    except:
        print("ScheduleNewCronJob Error: ", sys.exc_info()[1])

ScheduleNewCronJob("0 7 * * *")



