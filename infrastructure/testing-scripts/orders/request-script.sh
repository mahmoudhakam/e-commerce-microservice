TIMES=3
for i in $(eval echo "{1..$TIMES}")
do
    siege -c 1 -r 10 http://localhost:8051/
    siege -c 3 -r 5 http://localhost:8051/io_task
    siege -c 2 -r 5 http://localhost:8051/cpu_task
    siege -c 5 -r 3 http://localhost:8051/random_sleep
    siege -c 2 -r 10 http://localhost:8051/random_status
    siege -c 2 -r 3 http://localhost:8051/chain
    siege -c 1 -r 1 http://localhost:8051/error_test
    sleep 5
done
