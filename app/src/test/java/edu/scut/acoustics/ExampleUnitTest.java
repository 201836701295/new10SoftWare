package edu.scut.acoustics;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import edu.scut.acoustics.utils.SinWave;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        System.out.println((float) Short.MAX_VALUE / ((int) Short.MAX_VALUE + 1));
    }

    @Test
    public void audio() {
        int length = SinWave.SAMPLE_RATE * 100;
        System.out.println(length);
        float[] data = new float[length];
        int[] freq_list = {250, 500, 1000, 2000, 4000, 8000};
        int[] db_list = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70};
        SinWave sinWave = new SinWave(25, 40);

        for (int f : freq_list) {
            System.out.println(f + "hz: ");
            for (int d : db_list) {
                sinWave.set(f, d);
                sinWave.doFinal(data);
                double sum = 0;
                for (float v : data) {
                    sum += (double) v * v;
                }
                sum /= data.length;
                System.out.println("    " + d + "db: " + 10.0 * Math.log10(sum));
            }

        }

    }

    @Test
    public void mirro() {
        String vec = "M17,20 c-0.29,0 -0.56,-0.06 -0.76,-0.15\n" +
                "       -0.71,-0.37 -1.21,-0.88 -1.71,-2.38\n" +
                "        -0.51,-1.56 -1.47,-2.29 -2.39,-3\n" +
                "         -0.79,-0.61 -1.61,-1.24 -2.32,-2.53\n" +
                "       C9.29,10.98 9,9.93 9,9\n" +
                "       c0,-2.8 2.2,-5 5,-5\n" +
                "       s5,2.2 5,5\n" +
                "       h2c0,-3.93 -3.07,-7 -7,-7S7,5.07 7,9c0,1.26 0.38,2.65 1.07,3.9 0.91,1.65 1.98,2.48 2.85,3.15 0.81,0.62 1.39,1.07 1.71,2.05 0.6,1.82 1.37,2.84 2.73,3.55 0.51,0.23 1.07,0.35 1.64,0.35 2.21,0 4,-1.79 4,-4h-2c0,1.1 -0.9,2 -2,2zM7.64,2.64L6.22,1.22C4.23,3.21 3,5.96 3,9s1.23,5.79 3.22,7.78l1.41,-1.41C6.01,13.74 5,11.49 5,9s1.01,-4.74 2.64,-6.36zM11.5,9c0,1.38 1.12,2.5 2.5,2.5s2.5,-1.12 2.5,-2.5 -1.12,-2.5 -2.5,-2.5 -2.5,1.12 -2.5,2.5z";

        byte[] bytes = vec.getBytes(StandardCharsets.US_ASCII);

        for (int i = 0; i < bytes.length; ++i) {
            if (bytes[i] == ' ' || bytes[i] == '\n') {
                continue;
            }
            switch (bytes[i]) {
                case 'M':

            }
        }
    }
}