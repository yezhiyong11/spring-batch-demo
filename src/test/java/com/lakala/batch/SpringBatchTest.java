package com.lakala.batch;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SyncTaskExecutor;

/**
 ************************************************************
 * @绫诲悕 : SpringBatchTest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : liaopin
 * @DATE : 2018骞�5鏈�7鏃�
 ************************************************************
 */
public class SpringBatchTest {
    public static final String RUN_MONTH_KEY = "run.month";

    /**
     * 鍔熻兘鎻忚堪锛�
     * 
     * @param args void
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("message_job.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) c.getBean("jobRepository"));
        launcher.setTaskExecutor(new SyncTaskExecutor());
        try {
            Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
            parameters.put(RUN_MONTH_KEY, new JobParameter("2018-05"));
            long begin = System.currentTimeMillis();
            JobExecution je = launcher.run((Job) c.getBean("messageJob"), new JobParameters(parameters));
            long end = System.currentTimeMillis();

            System.out.println("cost time:" + (end - begin));

            System.out.println(je);
            System.out.println(je.getJobInstance());
            System.out.println(je.getStepExecutions());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
