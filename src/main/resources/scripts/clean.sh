#! /bin/sh
 cd /home/azureuser/logs/
 path="/home/azureuser/logs/"
 if [ $? -ne 0 ]; then
   dateStr=$(date "+%Y-%m-%d %H:%M:%S")
   echo $dateStr "no /home/azureuser/logs path" >> /home/h3coasis/cronjob/scripts/crontab.log
   exit 1
 fi

 result_all=`ls *.*`
 result_log=`ls | grep -v  tar.gz`
 for file in $result_all
 do
        time=`stat $path$file|awk 'NR==7'|awk -F"[-：:. ]+" '{print $2$3$4}'`
        time_15=`date -d "15 days ago" +%Y%m%d`
        if [ "$time" -lt "$time_15" ];then
                #echo "name:"$file
                rm -rf $file
        fi
 done
for file in $result_log
do
        #echo "file"$file
        time=`stat $path$file|awk 'NR==7'|awk -F"[-：:. ]+" ' {print $2$3$4}'`
        time_last=`date -d last-day +%Y%m%d`
        if [ "$time" -lt "$time_last" ];then
                tar -zcvf ${file}.tar.gz  $file
                rm -rf $file
                #echo "tar name:"$file
        fi
done
