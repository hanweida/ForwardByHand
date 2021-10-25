package groupId;

import static org.junit.Assert.assertTrue;

import groupId.unit.test.HeyueApi;
import groupId.unit.test.builder.HeyueFactoryBuilder;
import groupId.unit.test.factory.HeyueApiFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    HeyueApi api;

    @Before
    public void init(){
        {
            //工厂模式 有点类似Mybatis
            HeyueApiFactory factory = HeyueFactoryBuilder.newInstance()
                    .buildFactory();
            //创建
//            this.api = factory.createApi(HeyueApi.class, HeyueConfig.create(HeyueApi.class));
        }
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );

        {
            System.out.println("1");
        }

        {
            System.out.println("2");
        }
    }
}
