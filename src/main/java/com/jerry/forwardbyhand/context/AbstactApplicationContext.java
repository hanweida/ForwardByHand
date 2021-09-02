package com.jerry.forwardbyhand.context;

import java.util.HashMap;
import java.util.Map;

public class AbstactApplicationContext {
    Map<String, Object> singletonObjects = new HashMap<>();
    Map<String, Object> beanDefinitionMap = new HashMap<>();
}
