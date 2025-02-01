package dev.scaler.service;

import dev.scaler.model.User;

import java.util.*;

public class SplitExpenses {
    public void splitExpenses(List<User> users) {

        PriorityQueue<User> maxHeap = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<User> minHeap = new PriorityQueue();

        for(User user : users){
            if(user.getCurrentPendingAmount() > 0){
                maxHeap.add(user);
            }
            else if(user.getCurrentPendingAmount() < 0){
                minHeap.add(user);
            }
        }
        calculateTheAmount(maxHeap,minHeap);
    }

    private void calculateTheAmount(PriorityQueue<User> maxHeap, PriorityQueue<User> minHeap) {
       while(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
           User maxUser = maxHeap.poll();
           User minUser = minHeap.poll();
           //calculate the min between both
           double transactionAmount = Math.min(maxUser.getCurrentPendingAmount(), -minUser.getCurrentPendingAmount());
           // make the transaction from min user to max User and print
            System.out.println(minUser.getName() +" have to pay " + transactionAmount +" to the " + maxUser.getName());
           // one user get settled then make currentAmount as 0
            maxUser.setCurrentPendingAmount(maxUser.getCurrentPendingAmount() - transactionAmount);
            minUser.setCurrentPendingAmount(minUser.getCurrentPendingAmount() + transactionAmount);
           // add the user back in the heap with the remaining amount.
            if(minUser.getCurrentPendingAmount() < 0){
                minHeap.add(minUser);
            }
            else if(maxUser.getCurrentPendingAmount() > 0){
                maxHeap.add(maxUser);
            }
       }
    }
}
