package com.ww.ResearchOnTheTimingOfVirtualMachineExit16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

    /**
     * 问题：如果try代码块部分抛出I0异常，是否finally一定不会被执行呢?
     * 答：是
     * <p>
     * // TODO: 2019-11-29 搞清楚问题之后再去寻找结论
     * 问题：如果要阻止finally代码块执行，除了在第2处添加System.exit(2)，可不可以在第1处添加代码来阻止finally代码块执行?
     * 答：
     *
     * @param args
     */
    public static void main(String[] args) {
        // 省略一些代码 (第1处)

        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            System.out.println(br.readLine());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            // (第2处)
            System.exit(2);
        } finally {
            System.out.println("Exiting the program");
        }
    }
}