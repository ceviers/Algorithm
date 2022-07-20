package com.cevier.algorithm;

/**
 * @Description: 雪花算法
 * @author: cevier.wei
 * @date: 2022/7/20 14:34
 */
public class SnowFlake {
    // 开始时间戳
    private final long startTimeStamp = 1658299101366L;

    // 当前时间戳
    private long currentTimeStamp;

    // 上一次生成ID时的时间戳
    private long previousTimeStamp;

    // 机器ID
    private final long machineID = 1L;

    // 序列号ID
    private long sequence;

    // 时间码位数
    private int timeBits = 41;

    // 机器码位数
    private final int machineBits = 10;

    // 序列号位数
    private final int sequenceBits = 12;

    // 序列号掩码
    private final long maskSequence = -1L ^ (-1L << sequenceBits);

    public synchronized long nextID(){
        currentTimeStamp = System.currentTimeMillis();
        if (previousTimeStamp > currentTimeStamp){
            throw new RuntimeException("时间戳异常，上一次生成ID时间为：" + previousTimeStamp + "， 当前时间戳为：" + currentTimeStamp);
        } else if (previousTimeStamp == currentTimeStamp) {
            sequence = (sequence + 1) & maskSequence;  // 与下一句代码结果相同
//            sequence = sequence + 1 > maskSequence ? 0 : sequence + 1;
            if (sequence == 0L){
                currentTimeStamp = waitForNextMillSecond(currentTimeStamp);
            }
        }else {
            sequence = 0L;
        }

        previousTimeStamp = currentTimeStamp;

        long ID = (currentTimeStamp << (machineBits + sequenceBits)) | (machineID << sequenceBits) | sequence;

        return ID;
    }

    private long waitForNextMillSecond(long preTimeStamp){
        long timeStamp = System.currentTimeMillis();
        while(timeStamp <= preTimeStamp){
            timeStamp = System.currentTimeMillis();
        };
        return timeStamp;
    }

    public static void main(String[] args) {
        System.out.println(new SnowFlake().nextID());
    }
}
