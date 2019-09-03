#!/bin/bash

# Link the app folder
 sudo mkdir /opt/PatientStatusState
 sudo cp ../Patient_State_Schedular/target/Patient_State_Schedular-0.0.1-SNAPSHOT.jar /opt/PatientStatusState
 sudo chmod -R 777 /opt/PatientStatusState
 sudo chown -R root:root /opt/PatientStatusState
 sudo cp PatientStateSchedular /etc/init.d
 sudo chmod 777 /etc/init.d/PatientStateSchedular

 sudo  /etc/init.d/PatientStateSchedular start