class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0;
        long waitingTime = 0;

        for(int []customer:customers){
            int arrival = customer[0];
            int cook = customer[1];

            if(arrival>currentTime){
                currentTime=arrival;
            }
            currentTime +=cook;
            waitingTime += currentTime-arrival;
        }
        return (double) waitingTime/customers.length;
    }
}