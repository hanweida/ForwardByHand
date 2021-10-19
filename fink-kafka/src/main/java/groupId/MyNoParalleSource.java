package groupId;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyNoParalleSource implements SourceFunction<String> {
    //private long count = 1L;
    private boolean isRunning = true;
    @Override
    public void run(SourceContext<String> ctx) throws Exception {
        while(isRunning){
            //图书的排行榜
            List<String> books = new ArrayList<>();
            books.add("Pyhton从入门到放弃");//10
            books.add("Java从入门到放弃");//8
            books.add("Php从入门到放弃");//5
            books.add("C++从入门到放弃");//3
            books.add("Scala从入门到放弃");//0-4
            int i = new Random().nextInt(5);
            ctx.collect(books.get(i));

            //每2秒产生一条数据
            Thread.sleep(2000);
        }
    }
    //取消一个cancel的时候会调用的方法

    @Override
    public void cancel() {
        isRunning = false;
    }
}
