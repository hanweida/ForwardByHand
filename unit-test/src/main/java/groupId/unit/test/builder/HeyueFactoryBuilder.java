package groupId.unit.test.builder;

import groupId.unit.test.factory.HeyueApiFactory;

public abstract class HeyueFactoryBuilder {
    public static HeyueFactoryBuilder newInstance() {
        return new DefaultApiFactoryBuilder();
    }

    public abstract HeyueApiFactory buildFactory();
}
