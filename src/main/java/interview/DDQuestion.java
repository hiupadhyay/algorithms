package interview;


// Given a list of (positive integer) latencies, a number of buckets and bucket width, calculate how frequently each range of latencies occurs

// Buckets always start at 0. For instance, the ranges for 11 buckets of width 10 are: 0-9, 10-19, 20-29, 30-39, 40-49, 50-59, 60-69, 70-79, 80-89, 90-99, >=100
// >>> latencies = [90, 11, 3, 35, 17, 28, 64, 53, 52, 87, 63, 46, 40, 50, 31, 92, 45, 32, 22, 54, 87, 108, 62, 33, 87, 12, 67, 56, 94, 119, 96, 23, 21, 25, 86, 5, 32, 77, 3, 16, 8, 61, 105, 88, 49, 57, 114, 118, 20, 79, 44, 55, 113, 23, 13, 86, 16, 81, 1, 111, 84, 76, 24, 54, 110, 7, 100, 40, 3, 37, 96, 37, 67, 48, 79, 47, 108, 36, 15, 112, 37, 13, 40, 66, 39, 110, 47, 87, 34, 50, 55, 112, 70, 88, 2, 86, 110, 20, 2, 57]
// >>> number_of_buckets = 20
// >>> bucket_width = 10
// >>> calc_buckets(latencies, number_of_buckets, bucket_width)
//   0- 9: 9
//  10-19: 8
//  20-29: 9
//  30-39: 11
//  40-49: 10
//  50-59: 11
//  60-69: 7
//  70-79: 5
//  80-89: 11
//  90-99: 5
//  100+ : 14
//Bucket start, end [0--9] isInRange(l1) if l1 between 0-9 +1 Map(Bucket, count)
//90 --- [ b1, b2]
//58/10 5th*10 --50&10+9 n -- 50 --- 59


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class DDQuestion {
    //static int[] latencies = {90, 11, 3, 35, 17, 28, 64, 53, 52, 87, 63, 46, 40, 50, 31, 92, 45, 32, 22, 54, 87, 108, 62, 33, 87, 12, 67, 56, 94, 119, 96, 23, 21, 25, 86, 5, 32, 77, 3, 16, 8, 61, 105, 88, 49, 57, 114, 118, 20, 79, 44, 55, 113, 23, 13, 86, 16, 81, 1, 111, 84, 76, 24, 54, 110, 7, 100, 40, 3, 37, 96, 37, 67, 48, 79, 47, 108, 36, 15, 112, 37, 13, 40, 66, 39, 110, 47, 87, 34, 50, 55, 112, 70, 88, 2, 86, 110, 20, 2, 57};
    static int[] latencies = {90, 11, 3, 35, 17, 28, 64, 53, 52, 87, 63, 46, 40, 50, 31, 92, 45, 32, 22, 54, 87, 108, 62, 33, 87, 12, 67, 56, 94, 119, 96, 23, 21, 25, 86, 5, 32, 77, 3, 16, 8, 61, 105, 88, 49, 57, 114, 118, 20, 79, 44, 55, 113, 23, 13, 86, 16, 81, 1, 111, 84, 76, 24, 54, 110, 7, 100, 40, 3, 37, 96, 37, 67, 48, 79, 47, 108, 36, 15, 112, 37, 13, 40, 66, 39, 110, 47, 87, 34, 50, 55, 112, 70, 88, 2, 86, 200, 20, 2, 57};
    static int noOfBuckets = 11;
    static int width = 10;

    static void calBucket() {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int latencie : latencies) {
            int q = latencie / width;
            if (q < noOfBuckets - 1) {
                String bucket = "(" + q * width + ", " + (q * width + width - 1) + ")";
                if (map.containsKey(bucket)) {
                    map.put(bucket, map.get(bucket) + 1);
                } else {
                    map.put(bucket, 1);
                }
            } else {
                String val = "(" + noOfBuckets * width + "+)";
                if (map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);

                }
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {

        calBucket();
    }
}

