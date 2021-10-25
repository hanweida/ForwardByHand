package groupId.unit.test.builder;

import groupId.unit.test.factory.DefaultApiFactory;
import groupId.unit.test.factory.HeyueApiFactory;

/**
 * 默认API 工厂实例
 */
public class DefaultApiFactoryBuilder extends HeyueFactoryBuilder {
    @Override
    public HeyueApiFactory buildFactory() {
        return new DefaultApiFactory();
    }
}
