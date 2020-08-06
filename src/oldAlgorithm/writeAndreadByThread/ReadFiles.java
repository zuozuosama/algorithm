package oldAlgorithm.writeAndreadByThread;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles implements Runnable{
    private Object o = new Object();
    private List<File> fileList = new ArrayList<File>();
    private int index = 0;
    private long millis1;

    public ReadFiles(long millis){
        this.millis1 = millis;
        File f = new File("d:" + File.separator + "gc2");
        getFileList(f);
    }

    private void getFileList(File f) {
        File[] files = f.listFiles();
        if (files == null){
            System.out.println("没有文件");
            return;
        }
        for (File s : files){
            if (s.isDirectory()){
                getFileList(s);
            }else {
                if (-1 != s.getName().lastIndexOf(".txt")){
                    fileList.add(s);
                }
            }
        }
    }

    @Override
    public void run() {
        File file = null;
        File f2 = null;
        while (index < fileList.size()){
            synchronized (o){
                if (index > fileList.size()){
                    return;
                }
                file = fileList.get(index);
                index++;

                StringBuffer sb = new StringBuffer();

                FileReader fr = null;
                BufferedReader br = null;

                FileWriter fw = null;
                BufferedWriter bw = null;

                File filesFolder = new File("d:" + File.separator + "gc3");
                if (!filesFolder.exists()){
                    filesFolder.mkdirs();
                }

                f2 = new File("d:" + File.separator + "gc3" + File.separator + file.getName());

                try {
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);

                    fw = new FileWriter(f2);
                    bw = new BufferedWriter(fw);

                    String data = "";
                    while ((data = br.readLine()) != null){
                        sb.append(data + "\r");
                        bw.write(data + "\r");
                    }
                    bw.write("---------------" + Thread.currentThread().getName()+"---------------");
                    System.out.println(Thread.currentThread().getName() + " : " + file.getName());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        if (bw!=null && br != null && fr != null && fw != null){
                            bw.close();
                            br.close();
                            fr.close();
                            fw.close();
                            long millis2 = System.currentTimeMillis();
                            System.out.println("共消耗" + (millis2-millis1) + "毫秒");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
