# patient-status-scheduler

This is a Linux(CentOS) based service that runs in the background and updates the Patient Status at a particular time for the POC
Project.

By default the Scheduler will execute the task at `00:00` everyday and this schedule is configurable.
The scheduler can take in any cron expression as its parameter and run the task at that particular moment. 
`scheduler.cron.format` in the `application.properties` file can be configured.

Build the .`jar` using `mvn clean install`

After building the `.jar` file , run the `deploy.sh` file to deploy it to on your CentOS env. If you are running Bahmni on a vagrant 
env, then make changes to the `deploy.sh` so as to point to the appropriate directories in the vagrant machine
