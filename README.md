# CloudXplor
<pre>
A monitoring system for on premise non-manageable environments. 
This project took me and my 2 partners 1 year of coding to complete.
Technologies Used:
Java Springboot Maven
Python
ReactJS
Java
Linux Scripting
MySQL

Features:
-Simutaneous and Live hardware monitoring of n user systems. (RAM Usage, CPU Usage, Disk Usage, IO Devices). 
 Done using Java Process Builder to exec Linux sysstats functions and
 collect machine data. 
-Live Monitoring of n connected MySQL DBs to CloudXplor. (Done using scripiting Sys_Schema queries). 
 DB monitoring includes identification of most frequent queries being run on
 the MySQL server along with its latencies etc.
-Code Profiling (Very Naive Approach). Used Javas Jstack, Heap Dump, and Thread Dump files to gather relevant 
 data related to Users code and present it onto the dashboard. Also wrote easy to use calling functions so that 
 the user does not need to understand functioning of the code profiler. 
-Anomlay Detection. On memory usage. A modified version of DBSCAN was used to identify outliers in current batch of 
 memory usage history. Sliding window approach was used to constantly detect anomalies for n number of collected instances
 of Memory usage.   
 
 NOTE! - SNAPSHOTS OF WORKING APP IN PICTURES FOLDER

<pre>
