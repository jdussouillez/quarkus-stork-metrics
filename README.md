# quarkus-stork-metrics

Project to reproduce issues with metrics with Quarkus Stork extension

See https://github.com/quarkusio/quarkus/issues/49605

## How to run

Start 3 terminals and start both gRPC servers and the gRPC client.

```sh
cd grpc-server
./run-grpc-blue.sh
```

```sh
cd grpc-server
./run-grpc-red.sh
```

```sh
cd grpc-client
./mvnw quarkus:dev
```

## Check the metrics

Check the gRPC client metrics: http://localhost:8080/q/metrics

There is no Stork in there, but there should be.
- https://quarkus.io/guides/telemetry-micrometer#quarkus-extensions-using-micrometer ("quarkus-smallrye-stork")
- https://quarkus.io/guides/stork-reference#enable-metrics
- https://smallrye.io/smallrye-stork/2.7.4/observability/#stork-observability-with-quarkus

<details>
<summary>Metrics</summary>

```ini
# HELP system_cpu_count The number of processors available to the Java virtual machine
# TYPE system_cpu_count gauge
system_cpu_count 8.0
# HELP grpc_client_responses_received_messages_total The total number of responses received
# TYPE grpc_client_responses_received_messages_total counter
grpc_client_responses_received_messages_total{method="SayHello",methodType="UNARY",service="com.github.jdussouillez.hello.HelloGrpcApi",} 17.0
# HELP process_cpu_time_ns_total The "cpu time" used by the Java Virtual Machine process
# TYPE process_cpu_time_ns_total counter
process_cpu_time_ns_total 1.175E10
# HELP worker_pool_completed_total Number of times resources from the pool have been acquired
# TYPE worker_pool_completed_total counter
worker_pool_completed_total{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_completed_total{pool_name="vert.x-worker-thread",pool_type="worker",} 3.0
# HELP worker_pool_queue_size Number of pending elements in the waiting queue
# TYPE worker_pool_queue_size gauge
worker_pool_queue_size{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_queue_size{pool_name="vert.x-worker-thread",pool_type="worker",} 0.0
# HELP worker_pool_ratio Pool usage ratio
# TYPE worker_pool_ratio gauge
worker_pool_ratio{pool_name="vert.x-internal-blocking",pool_type="worker",} NaN
worker_pool_ratio{pool_name="vert.x-worker-thread",pool_type="worker",} 0.005
# HELP system_cpu_usage The "recent cpu usage" of the system the application is running in
# TYPE system_cpu_usage gauge
system_cpu_usage 0.12101801544180726
# HELP jvm_threads_live_threads The current number of live threads including both daemon and non-daemon threads
# TYPE jvm_threads_live_threads gauge
jvm_threads_live_threads 39.0
# HELP jvm_threads_started_threads_total The total number of application threads started in the JVM
# TYPE jvm_threads_started_threads_total counter
jvm_threads_started_threads_total 142.0
# HELP jvm_threads_states_threads The current number of threads
# TYPE jvm_threads_states_threads gauge
jvm_threads_states_threads{state="runnable",} 12.0
jvm_threads_states_threads{state="blocked",} 0.0
jvm_threads_states_threads{state="waiting",} 19.0
jvm_threads_states_threads{state="timed-waiting",} 8.0
jvm_threads_states_threads{state="new",} 0.0
jvm_threads_states_threads{state="terminated",} 0.0
# HELP jvm_gc_max_data_size_bytes Max size of long-lived heap memory pool
# TYPE jvm_gc_max_data_size_bytes gauge
jvm_gc_max_data_size_bytes 8.32569344E9
# HELP worker_pool_active The number of resources from the pool currently used
# TYPE worker_pool_active gauge
worker_pool_active{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_active{pool_name="vert.x-worker-thread",pool_type="worker",} 1.0
# HELP jvm_classes_loaded_classes The number of classes that are currently loaded in the Java virtual machine
# TYPE jvm_classes_loaded_classes gauge
jvm_classes_loaded_classes 13157.0
# HELP jvm_gc_memory_allocated_bytes_total Incremented for an increase in the size of the (young) heap memory pool after one GC to before the next
# TYPE jvm_gc_memory_allocated_bytes_total counter
jvm_gc_memory_allocated_bytes_total 7.130316E7
# HELP jvm_buffer_total_capacity_bytes An estimate of the total capacity of the buffers in this pool
# TYPE jvm_buffer_total_capacity_bytes gauge
jvm_buffer_total_capacity_bytes{id="mapped - 'non-volatile memory'",} 0.0
jvm_buffer_total_capacity_bytes{id="mapped",} 0.0
jvm_buffer_total_capacity_bytes{id="direct",} 347541.0
# HELP process_start_time_seconds Start time of the process since unix epoch.
# TYPE process_start_time_seconds gauge
process_start_time_seconds 1.755601354559E9
# HELP worker_pool_usage_seconds Time spent using resources from the pool
# TYPE worker_pool_usage_seconds summary
worker_pool_usage_seconds_count{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_usage_seconds_sum{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_usage_seconds_count{pool_name="vert.x-worker-thread",pool_type="worker",} 3.0
worker_pool_usage_seconds_sum{pool_name="vert.x-worker-thread",pool_type="worker",} 0.023723561
# HELP worker_pool_usage_seconds_max Time spent using resources from the pool
# TYPE worker_pool_usage_seconds_max gauge
worker_pool_usage_seconds_max{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_usage_seconds_max{pool_name="vert.x-worker-thread",pool_type="worker",} 0.012160483
# HELP grpc_client_requests_sent_messages_total The total number of requests sent
# TYPE grpc_client_requests_sent_messages_total counter
grpc_client_requests_sent_messages_total{method="SayHello",methodType="UNARY",service="com.github.jdussouillez.hello.HelloGrpcApi",} 17.0
# HELP grpc_client_processing_duration_seconds The total time taken for the client to complete the call, including network delay
# TYPE grpc_client_processing_duration_seconds summary
grpc_client_processing_duration_seconds_count{method="SayHello",methodType="UNARY",service="com.github.jdussouillez.hello.HelloGrpcApi",statusCode="OK",} 17.0
grpc_client_processing_duration_seconds_sum{method="SayHello",methodType="UNARY",service="com.github.jdussouillez.hello.HelloGrpcApi",statusCode="OK",} 3.097290003
# HELP grpc_client_processing_duration_seconds_max The total time taken for the client to complete the call, including network delay
# TYPE grpc_client_processing_duration_seconds_max gauge
grpc_client_processing_duration_seconds_max{method="SayHello",methodType="UNARY",service="com.github.jdussouillez.hello.HelloGrpcApi",statusCode="OK",} 1.897628076
# HELP process_files_max_files The maximum file descriptor count
# TYPE process_files_max_files gauge
process_files_max_files 1048576.0
# HELP jvm_gc_pause_seconds Time spent in GC pause
# TYPE jvm_gc_pause_seconds summary
jvm_gc_pause_seconds_count{action="end of minor GC",cause="G1 Evacuation Pause",gc="G1 Young Generation",} 1.0
jvm_gc_pause_seconds_sum{action="end of minor GC",cause="G1 Evacuation Pause",gc="G1 Young Generation",} 0.015
# HELP jvm_gc_pause_seconds_max Time spent in GC pause
# TYPE jvm_gc_pause_seconds_max gauge
jvm_gc_pause_seconds_max{action="end of minor GC",cause="G1 Evacuation Pause",gc="G1 Young Generation",} 0.015
# HELP jvm_memory_max_bytes The maximum amount of memory in bytes that can be used for memory management
# TYPE jvm_memory_max_bytes gauge
jvm_memory_max_bytes{area="heap",id="G1 Survivor Space",} -1.0
jvm_memory_max_bytes{area="heap",id="G1 Old Gen",} 8.32569344E9
jvm_memory_max_bytes{area="nonheap",id="Metaspace",} -1.0
jvm_memory_max_bytes{area="nonheap",id="CodeCache",} 5.0331648E7
jvm_memory_max_bytes{area="heap",id="G1 Eden Space",} -1.0
jvm_memory_max_bytes{area="nonheap",id="Compressed Class Space",} 1.073741824E9
# HELP worker_pool_idle The number of resources from the pool currently used
# TYPE worker_pool_idle gauge
worker_pool_idle{pool_name="vert.x-internal-blocking",pool_type="worker",} 20.0
worker_pool_idle{pool_name="vert.x-worker-thread",pool_type="worker",} 199.0
# HELP jvm_buffer_count_buffers An estimate of the number of buffers in the pool
# TYPE jvm_buffer_count_buffers gauge
jvm_buffer_count_buffers{id="mapped - 'non-volatile memory'",} 0.0
jvm_buffer_count_buffers{id="mapped",} 0.0
jvm_buffer_count_buffers{id="direct",} 18.0
# HELP process_files_open_files The open file descriptor count
# TYPE process_files_open_files gauge
process_files_open_files 474.0
# HELP jvm_memory_usage_after_gc The percentage of long-lived heap pool used after the last GC event, in the range [0..1]
# TYPE jvm_memory_usage_after_gc gauge
jvm_memory_usage_after_gc{area="heap",pool="long-lived",} 0.007327018757010587
# HELP worker_pool_queue_delay_seconds_max Time spent in the waiting queue before being processed
# TYPE worker_pool_queue_delay_seconds_max gauge
worker_pool_queue_delay_seconds_max{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_queue_delay_seconds_max{pool_name="vert.x-worker-thread",pool_type="worker",} 3.87008E-4
# HELP worker_pool_queue_delay_seconds Time spent in the waiting queue before being processed
# TYPE worker_pool_queue_delay_seconds summary
worker_pool_queue_delay_seconds_count{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_queue_delay_seconds_sum{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_queue_delay_seconds_count{pool_name="vert.x-worker-thread",pool_type="worker",} 4.0
worker_pool_queue_delay_seconds_sum{pool_name="vert.x-worker-thread",pool_type="worker",} 8.77694E-4
# HELP process_cpu_usage The "recent cpu usage" for the Java Virtual Machine process
# TYPE process_cpu_usage gauge
process_cpu_usage 0.002115494568324757
# HELP jvm_threads_peak_threads The peak live thread count since the Java virtual machine started or peak was reset
# TYPE jvm_threads_peak_threads gauge
jvm_threads_peak_threads 119.0
# HELP system_load_average_1m The sum of the number of runnable entities queued to available processors and the number of runnable entities running on the available processors averaged over a period of time
# TYPE system_load_average_1m gauge
system_load_average_1m 4.04345703125
# HELP jvm_info_total JVM version info
# TYPE jvm_info_total counter
jvm_info_total{runtime="OpenJDK Runtime Environment",vendor="Eclipse Adoptium",version="21.0.6+7-LTS",} 1.0
# HELP worker_pool_rejected_total Number of times submissions to the pool have been rejected
# TYPE worker_pool_rejected_total counter
worker_pool_rejected_total{pool_name="vert.x-internal-blocking",pool_type="worker",} 0.0
worker_pool_rejected_total{pool_name="vert.x-worker-thread",pool_type="worker",} 0.0
# HELP jvm_gc_overhead An approximation of the percent of CPU time used by GC activities over the last lookback period or since monitoring began, whichever is shorter, in the range [0..1]
# TYPE jvm_gc_overhead gauge
jvm_gc_overhead 4.3434479279552847E-4
# HELP jvm_buffer_memory_used_bytes An estimate of the memory that the Java virtual machine is using for this buffer pool
# TYPE jvm_buffer_memory_used_bytes gauge
jvm_buffer_memory_used_bytes{id="mapped - 'non-volatile memory'",} 0.0
jvm_buffer_memory_used_bytes{id="mapped",} 0.0
jvm_buffer_memory_used_bytes{id="direct",} 347542.0
# HELP process_uptime_seconds The uptime of the Java virtual machine
# TYPE process_uptime_seconds gauge
process_uptime_seconds 39.232
# HELP jvm_classes_unloaded_classes_total The total number of classes unloaded since the Java virtual machine has started execution
# TYPE jvm_classes_unloaded_classes_total counter
jvm_classes_unloaded_classes_total 41.0
# HELP jvm_memory_committed_bytes The amount of memory in bytes that is committed for the Java virtual machine to use
# TYPE jvm_memory_committed_bytes gauge
jvm_memory_committed_bytes{area="heap",id="G1 Survivor Space",} 8388608.0
jvm_memory_committed_bytes{area="heap",id="G1 Old Gen",} 7.9691776E7
jvm_memory_committed_bytes{area="nonheap",id="Metaspace",} 6.0686336E7
jvm_memory_committed_bytes{area="nonheap",id="CodeCache",} 1.47456E7
jvm_memory_committed_bytes{area="heap",id="G1 Eden Space",} 7.9691776E7
jvm_memory_committed_bytes{area="nonheap",id="Compressed Class Space",} 8585216.0
# HELP jvm_gc_live_data_size_bytes Size of long-lived heap memory pool after reclamation
# TYPE jvm_gc_live_data_size_bytes gauge
jvm_gc_live_data_size_bytes 0.0
# HELP jvm_memory_used_bytes The amount of used memory
# TYPE jvm_memory_used_bytes gauge
jvm_memory_used_bytes{area="heap",id="G1 Survivor Space",} 4448368.0
jvm_memory_used_bytes{area="heap",id="G1 Old Gen",} 6.1002512E7
jvm_memory_used_bytes{area="nonheap",id="Metaspace",} 5.92286E7
jvm_memory_used_bytes{area="nonheap",id="CodeCache",} 1.4157696E7
jvm_memory_used_bytes{area="heap",id="G1 Eden Space",} 4194304.0
jvm_memory_used_bytes{area="nonheap",id="Compressed Class Space",} 7904416.0
# HELP jvm_gc_memory_promoted_bytes_total Count of positive increases in the size of the old generation memory pool before GC to after GC
# TYPE jvm_gc_memory_promoted_bytes_total counter
jvm_gc_memory_promoted_bytes_total 1.3257408E7
# HELP jvm_threads_daemon_threads The current number of live daemon threads
# TYPE jvm_threads_daemon_threads gauge
jvm_threads_daemon_threads 17.0
```
</details>
