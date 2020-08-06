package oldAlgorithm;

import java.io.*;

public class SystemOutAndPrintWriter {
    public static void main(String[] args) {
        SystemOutDemo();
        PrintWriterDemo();
    }

    /**
     * 使用标准输出流打印
     */
    private static void SystemOutDemo() {

        System.out.println("=========================================使用标准输出流打印====================================");
        BufferedReader br = null;
        OutputStreamWriter ow = null;
        try {
            br = new BufferedReader(new FileReader("D:\\\\IdeaProjects\\\\Data Structures and Algorithms\\\\DataStructureAndAlgorithmsDemo\\\\七天德汇教育(七天网络)面试题.txt"));
            ow = new OutputStreamWriter(System.out);
            String line = null;
            while ((line = br.readLine())!=null){
                ow.write(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (br !=null && ow!=null){
                    br.close();
                    ow.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * PrintWriter输出流打印
     */
    private static void PrintWriterDemo(){
        System.out.println("=========================================PrintWriter输出流打印====================================");
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new FileReader("D:\\IdeaProjects\\Data Structures and Algorithms\\DataStructureAndAlgorithmsDemo\\七天德汇教育(七天网络)面试题.txt"));
            pw = new PrintWriter(System.out);
            String line = null;
            while ((line = br.readLine())!=null){
                pw.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (br !=null && pw!=null){
                    br.close();
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
