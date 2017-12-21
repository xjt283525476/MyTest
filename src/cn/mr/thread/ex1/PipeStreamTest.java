package cn.mr.thread.ex1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PipeStreamTest {
    /**
     * I/O过滤器，从is中读取数据，然后将数据写加到os中。
     */
    interface IOFilter {
        void filter(InputStream is, OutputStream os) throws IOException;
    }

    private static void transfer(InputStream is, OutputStream os) throws IOException {
        while (true) {
            int b = is.read();
            if (b == -1)
                break;
            os.write(b);
            os.flush();
        }
    }

    /** 从标准输入中读取然后将它写入os中 */
    static class StdinReadFilter implements IOFilter {
        public void filter(InputStream is, OutputStream os) throws IOException {
            transfer(System.in, os);
        }
    }

    /** 从is中读取然后将它写入标准输出中 */
    static class StdoutWriteFilter implements IOFilter {
        public void filter(InputStream is, OutputStream os) throws IOException {
            transfer(is, System.out);
        }
    }

    /** 从is中读取然后将它写入os中 */
    static class EchoFilter implements IOFilter {
        public void filter(InputStream is, OutputStream os) throws IOException {
            transfer(is, os);
        }
    }

    /** 将输入流转换成大写，然后定出到输出流中 */
    static class UppcaseFilter implements IOFilter {
        public void filter(InputStream is, OutputStream os) throws IOException {
            while (true) {
                int b = is.read();
                if (b == -1)
                    break;
                b = Character.toUpperCase(b);
                os.write(b);
                os.flush();
            }
        }
    }

    static class PipeThread extends Thread {
        private IOFilter filter;
        private PipedInputStream pis;
        private PipedOutputStream pos;

        public PipeThread(IOFilter filter, PipedInputStream pis, PipedOutputStream pos) {
            this.filter = filter;
            this.pis = pis;
            this.pos = pos;
        }

        public void run() {
            try {
                filter.filter(pis, pos);
                pis.close();
                pos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 将IOFilter使用管道流进行连接
    private static PipedInputStream concatFilterUsingPipeThread(PipedOutputStream pos, List<IOFilter> filters)
            throws IOException {
        PipedInputStream pis = new PipedInputStream(pos);
        for (IOFilter filter : filters) {
            pos = new PipedOutputStream();
            new PipeThread(filter, pis, pos).start();
            pis = new PipedInputStream(pos);
        }
        return pis;
    }

    public static void main(String[] args) throws IOException {
        List<IOFilter> filters = new ArrayList<IOFilter>();
        filters.add(new StdinReadFilter());
        filters.add(new EchoFilter());
        filters.add(new UppcaseFilter());
        filters.add(new StdoutWriteFilter());

        PipedInputStream pis = concatFilterUsingPipeThread(new PipedOutputStream(), filters);
    }
}
