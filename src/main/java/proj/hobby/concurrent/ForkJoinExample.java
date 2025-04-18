package proj.hobby.concurrent;

import java.util.concurrent.*;

public class ForkJoinExample {

    public static void main(String[] args) {
        ForkJoinPool forkPool = new ForkJoinPool(); // parallelism

        //Use Case 1: using invoke for blocking execution
        Integer result = forkPool.invoke(new SumTask(1,20));
        System.out.println("Result: "+result);

        // Use Case 2: using submit to execute asynchronous
        try {
            Future<Integer> future = forkPool.submit(new SumTask(1, 20));
            System.out.println("Result: " + future.get());// blocks for result
            forkPool.shutdown();
            forkPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
}

class SumTask extends RecursiveTask<Integer> {

    private final int start;
    private final int end;

    SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end-start <= 3) {
            int sum = 0;
            for(int i = start; i <= end ; i++) {
                sum += i;
            }
            return sum;
        }

        int mid = start + (end - start)/2 ;
        SumTask left = new SumTask(start, mid);
        SumTask right = new SumTask(mid+1, end);

        left.fork(); // asynchronously execute left
        int rightSum = right.compute(); // compute right

        return left.join() + rightSum; // combine results
    }

}