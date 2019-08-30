#!/bin/bash

# Link the app folder
 sudo mkdir /opt/PatientStatusScheduler
 sudo cp ../Patient_State_Schedular/target/Patient_State_Schedular-0.0.1-SNAPSHOT.jar /opt/PatientStatusScheduler
 sudo chmod -R 777 /opt/PatientStatusScheduler
 sudo chown -R bahmni:bahmni /opt/PatientStatusScheduler
 sudo cp PatientStateSchedular /etc/init.d
 sudo chmod 777 PatientStateSchedular

 sudo service PatientStateSchedular restart