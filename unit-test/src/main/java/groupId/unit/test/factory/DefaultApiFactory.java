package groupId.unit.test.factory;

/**
 * 默认工厂
 */
public class DefaultApiFactory implements HeyueApiFactory{
    @Override
    public <T> T createApi(Class<T> apiClass) {
        return null;
    }
}
