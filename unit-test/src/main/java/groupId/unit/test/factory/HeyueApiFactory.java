package groupId.unit.test.factory;

public interface HeyueApiFactory {
    <T> T createApi(Class<T> apiClass);
}
