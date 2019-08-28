package org.openmrs.module.Patient_State_Schedular.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openmrs.module.Patient_State_Schedular.service.PatientStateSchedularService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    static final String chronValue="${scheduler.cron.format}";
    @Autowired
    private PatientStateSchedularService patientStateSchedularService;
    
    
    @Scheduled(cron = chronValue)
    public void scheduleTaskWithCronExpression() {
    	int id=patientStateSchedularService.getStartTreatmentDate();
    	logger.info("Last Patient State Updated :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    	logger.info("Updated Rows.."+id);
    }
}