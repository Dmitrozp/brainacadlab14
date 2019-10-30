package com.brainacad.laba22thread;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class RaceCarRunnable extends Car implements Runnable {
    private double passedDistance;
    private double distance;
    private boolean isFinish;

    private long finishTime;

    private CountDownLatch countDownLatch;

    public RaceCarRunnable(String name, int maxSpeed, double distance) {
        super(name, maxSpeed);
        this.distance = distance;
    }


    public RaceCarRunnable(String name, int maxSpeed, double distance, CountDownLatch countDownLatch) {
        super(name, maxSpeed);
        this.distance = distance;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        while (!isFinish){
            try {
                Race.startRaceTime = System.currentTimeMillis();;
                Thread.sleep(1000);
                passedDistance = passedDistance +  getRandomSpeed()*1000/3600;
                System.out.println(getName() + passedDistance);
                if(passedDistance >= distance){
                    setFinish(true);
                    countDownLatch.countDown();
                    countDownLatch.await();
                    System.out.println(getName() + " FINISHED!" + "Time = " + finishTime);
                    finishTime = System.currentTimeMillis() - Race.startRaceTime;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int getRandomSpeed(){
        int speed = getMaxSpeed() - getMaxSpeed()/2;
        return (int) ((Math.random() * ++speed) + getMaxSpeed()/2);

    }

    public void showAllInfo(){
        System.out.println("carName :" + getName() + " speed: " + getRandomSpeed()
                + " progress: " + getPassedDistance() + "/" + getDistance());
    }


    public double getPassedDistance() {
        return passedDistance;
    }

    public void setPassedDistance(double passedDistance) {
        this.passedDistance = passedDistance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }
}
